package com.yuzhyn.azylee.ext.web.sshs;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.yuzhyn.azylee.core.datas.exceptions.ExceptionTool;
import com.yuzhyn.azylee.core.logs.Alog;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class SshManager {

    /**
     * 客户端连接列表
     */
    private ConcurrentMap<String, SshClient> sshClientMap;
    /**
     * 线程池
     */
    private ExecutorService executorService = Executors.newCachedThreadPool();

    public Map<String, SshClient> getSshClientMap() {
        return sshClientMap;
    }

    public void setSshClientMap(ConcurrentMap<String, SshClient> sshClientMap) {
        this.sshClientMap = sshClientMap;
    }


    /**
     * 创建ssh客户端连接
     *
     * @param id
     * @param host
     * @param port
     * @param username
     * @param password
     * @return
     */
    public boolean create(String id, String host, int port, String username, String password, Map<String, String> attach) {
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(username, host, port);
            session.setPassword(password); // 设置密码
//            session.setUserInfo(new com.jcraft.jsch.UserInfo() {
//                @Override
//                public String getPassphrase() {
//                    return null;
//                }
//
//                @Override
//                public String getPassword() {
//                    return null;
//                }
//
//                @Override
//                public boolean promptPassword(String s) {
//                    return false;
//                }
//
//                @Override
//                public boolean promptPassphrase(String s) {
//                    return false;
//                }
//
//                @Override
//                public boolean promptYesNo(String s) {
//                    return false;
//                }
//
//                @Override
//                public void showMessage(String s) {
//
//                }
//            }); //需要实现Jsch包中的UserInfo,UIKeyboardInteractive接口，用以保存用户信息，以及进行键盘交互式认证并执行命令。
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");//在代码里需要跳过检测。否则会报错找不到主机
            session.setConfig(config); // 为Session对象设置properties
            int timeout = 30000;
            session.setTimeout(timeout); // 设置timeout时间
            session.connect(); // 通过Session建立与远程服务器的连接回话

            SshClient sshClient = new SshClient();
            sshClient.setCreateTime(LocalDateTime.now());
            sshClient.setHistory(new ArrayList<>());
            sshClient.setAttach(new HashMap<>());
            if (attach != null) sshClient.getAttach().putAll(attach);
            sshClient.setjSch(jsch);
            sshClient.setSession(session);

            if (getSshClientMap() == null) setSshClientMap(new ConcurrentHashMap<>());
            getSshClientMap().put(id, sshClient);

            return true;
        } catch (Exception ex) {
            return false;
        } finally {

        }
    }

    public void close(String id) {
        SshClient client = getSshClientMap().getOrDefault(id, null);
        if (client != null) {
            if (client.getChannel().isConnected()) {
                client.getChannel().disconnect();
                Alog.i("cleanSshConnection: 断开 channel: " + id);
            }
            if (client.getSession().isConnected()) {
                client.getSession().disconnect();
                Alog.i("cleanSshConnection: 关闭 session: " + id);
            }
            Alog.i("cleanSshConnection: 关闭连接: " + id);

            // 如果连接已关闭，则移除连接信息
            if (!client.getSession().isConnected()) {
                getSshClientMap().remove(id);
                Alog.i("cleanSshConnection: 移除连接: " + id);
            }
        }
    }


    /**
     * 打开ssh连接shell通道
     *
     * @param id
     */
    public boolean openChannel(String id) {
        try {
            SshClient sshClient = getSshClientMap().getOrDefault(id, null);
            if (sshClient == null) {
                return false;
            }

            Channel channel = sshClient.getSession().openChannel("shell");

            //连接通道
            channel.connect(3000);
            //读取终端返回的信息流
            InputStream inputStream = channel.getInputStream();
            sshClient.setChannel(channel);
            sshClient.getChannel().setInputStream(inputStream);
            return true;

        } catch (JSchException | IOException ex) {
            Alog.e(ExceptionTool.getStackTrace(ex));
            return false;
        }
    }

    public void readChannel(String id, Consumer<byte[]> consumer) {
        executorService.execute(() -> {
            try {
                SshClient sshClient = getSshClientMap().getOrDefault(id, null);
                if (sshClient == null) {
                }
                //循环读取
                byte[] buffer = new byte[10 * 1024];
                int i = 0;
                //如果没有数据来，线程会一直阻塞在这个地方等待数据。
                while ((i = sshClient.getChannel().getInputStream().read(buffer)) != -1) {
//                    // 完成时候发送结束标志，这里不行哎。。。
//                    sendCommandRun(id, "echo \"[[##hidoc->serverman.run::end.manager//sshmanager_read_end]]\"");

                    String s = new String(buffer, 0, i);
                    sshClient.getHistory().add(new SshHistory(false, s));
                    Alog.i(s);
                    consumer.accept(Arrays.copyOfRange(buffer, 0, i));
                }

                // 这里运行结束了，提供一条特殊消息告诉后续处理，防止长时间占用
                // 这里待定
                String endFlag = "[[##hidoc->serverman.run::end.manager//sshmanager_read_end]]";
//                R.Queues.CmdRunLogQueue.add(new CmdRunLog(id, endFlag.getBytes()));
            } catch (IOException e) {
                Alog.e("SshManager: io exception");
                Alog.e("SshManager: io exception is: " + e.getMessage());
            }
        });
    }

    public void sendCommandRun(String id, String command) throws IOException {
        command += "\n";
        SshClient sshClient = getSshClientMap().getOrDefault(id, null);
        sshClient.getHistory().add(new SshHistory(true, command));
        Channel channel = sshClient.getChannel();
        if (channel != null) {
            OutputStream outputStream = channel.getOutputStream();
            outputStream.write(command.getBytes());
            outputStream.flush();
        }
    }

    public void sendCommand(String id, String command) throws IOException {
        SshClient sshClient = getSshClientMap().getOrDefault(id, null);
        sshClient.getHistory().add(new SshHistory(true, command));
        Channel channel = sshClient.getChannel();
        if (channel != null) {
            OutputStream outputStream = channel.getOutputStream();
            outputStream.write(command.getBytes());
            outputStream.flush();
        }
    }
}
