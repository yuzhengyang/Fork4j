package com.yuzhyn.azylee.ext.web.mqs.rocketmq;

import com.yuzhyn.azylee.core.configs.rocketmq.RockermqProducerConfig;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import javax.annotation.PreDestroy;
import java.util.concurrent.ConcurrentHashMap;

public class RocketmqProducerManager {

    private static ConcurrentHashMap<String, DefaultMQProducer> producerPool = new ConcurrentHashMap<>();

    public static DefaultMQProducer getProducer(String name) {
        return producerPool.get(name);
    }

    public static boolean create(RockermqProducerConfig producerPart) {
        try {
            DefaultMQProducer producer = new DefaultMQProducer(producerPart.getGroup());
            producer.setNamesrvAddr(producerPart.getNamesrvAddr());
            if (producerPart.getSendMsgTimeout() > 0) {
                producer.setSendMsgTimeout(producerPart.getSendMsgTimeout());
            }
            producer.setInstanceName(String.valueOf(System.currentTimeMillis()));
            producerPool.put(producerPart.getName(), producer);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public static boolean createAndStart(RockermqProducerConfig producerPart) {
        if (create(producerPart)) {
            return start(producerPart.getName());
        }
        return false;
    }

    public static boolean start(String name) {
        try {
            getProducer(name).start();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static SendResult send(String name, Message message) {
        SendResult result = null;
        try {
            result = getProducer(name).send(message);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static SendResult send(String name, Message message, long order) {
        SendResult result = null;
        try {
            result = getProducer(name).send(message, (mqs, msg, arg) -> {
                long id = (long) arg;
                long index = id % mqs.size();
                return mqs.get((int) index);
            }, order);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static void shutdown(String name) {
        getProducer(name).shutdown();
    }

    public static void shutdownAll() {
        if (producerPool != null && producerPool.size() > 0) {
            for (String name : producerPool.keySet()) {
                if (producerPool.containsKey(name) && producerPool.get(name) != null) {
                    shutdown(name);
                }
            }
        }
    }

    @PreDestroy
    public void preDestroy() {
        long now = System.currentTimeMillis();
        System.out.println("关闭所有 Rocketmq 连接");
        RocketmqProducerManager.shutdownAll();
        System.out.println("总计用时：" + (System.currentTimeMillis() - now));
    }
}
