package com.yuzhyn.azylee.core.systems.process;

import java.util.Optional;

/**
 * 进程工具类
 */
public class ProcessTool {
    /**
     * 检查进程是否存在
     *
     * @param pid 进程ID
     * @return 进程存在返回true，不存在返回false
     */
    public static boolean isProcessRunning(long pid) {
        return ProcessHandle.of(pid).isPresent();
    }

    /**
     * 正常终止进程 (相当于kill -15)
     *
     * @param pid 进程ID
     * @return 操作结果：SUCCESS-成功, NOT_FOUND-进程不存在, FAILED-失败
     */
    public static ProcessResult killProcess(long pid) {
        Optional<ProcessHandle> processOpt = ProcessHandle.of(pid);
        if (processOpt.isEmpty()) {
            return ProcessResult.NOT_FOUND;
        }
        return processOpt.get().destroy() ? ProcessResult.SUCCESS : ProcessResult.FAILED;
    }

    /**
     * 强制终止进程 (相当于kill -9)
     *
     * @param pid 进程ID
     * @return 操作结果：SUCCESS-成功, NOT_FOUND-进程不存在, FAILED-失败
     */
    public static ProcessResult killProcessForcibly(long pid) {
        Optional<ProcessHandle> processOpt = ProcessHandle.of(pid);
        if (processOpt.isEmpty()) {
            return ProcessResult.NOT_FOUND;
        }
        return processOpt.get().destroyForcibly() ? ProcessResult.SUCCESS : ProcessResult.FAILED;
    }

    /**
     * 获取进程详细信息
     *
     * @param pid 进程ID
     * @return 进程信息字符串，包含PID、是否运行、命令行等
     */
    public static String getProcessInfo(long pid) {
        return ProcessHandle.of(pid)
                .map(p -> String.format("PID: %d, 运行中: %s, 命令: %s",
                        p.pid(), p.isAlive(), p.info().commandLine().orElse("未知")))
                .orElse("进程不存在");
    }

    /**
     * 获取当前进程ID
     *
     * @return
     */
    public static long getCurrentProcessId() {
        return ProcessHandle.current().pid();
    }

    /**
     * 进程操作结果枚举
     */
    public enum ProcessResult {
        SUCCESS("操作成功"),
        NOT_FOUND("进程不存在"),
        FAILED("操作失败");

        private final String message;

        ProcessResult(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
