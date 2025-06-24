//package com.yuzhyn.azylee.ext.web.mqs.rocketmq;
//
//import com.yuzhyn.azylee.core.configs.rocketmq.RockermqConsumerConfig;
//import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
//import org.apache.rocketmq.client.consumer.listener.MessageListener;
//import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
//
//import javax.annotation.PreDestroy;
//import java.util.concurrent.ConcurrentHashMap;
//
//
//public class RocketmqConsumerManager {
//
//    private static ConcurrentHashMap<String, DefaultMQPushConsumer> consumerPool = new ConcurrentHashMap<>();
//
//    public static DefaultMQPushConsumer getConsumer(String name) {
//        return consumerPool.get(name);
//    }
//
//    public static boolean create(RockermqConsumerConfig consumerPart, MessageListener listener) {
//        try {
//            DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(consumerPart.getGroup());
//            consumer.setNamesrvAddr(consumerPart.getNamesrvAddr());
//            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
//            consumer.subscribe(consumerPart.getTopic(), consumerPart.getTag());
//
//            //注册消费的监听 并在此监听中消费信息，并返回消费的状态信息
//            consumer.registerMessageListener(listener);
//            consumerPool.put(consumerPart.getName(), consumer);
//            return true;
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//        return false;
//    }
//
//    public static boolean createAndStart(RockermqConsumerConfig consumerPart, MessageListener listener) {
//        if (create(consumerPart, listener)) {
//            return start(consumerPart.getName());
//        }
//        return false;
//    }
//
//    public static boolean start(String name) {
//        try {
//            getConsumer(name).start();
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public static void shutdown(String name) {
//        getConsumer(name).shutdown();
//    }
//
//    public static void shutdownAll() {
//        if (consumerPool != null && consumerPool.size() > 0) {
//            for (String name : consumerPool.keySet()) {
//                if (consumerPool.containsKey(name) && consumerPool.get(name) != null) {
//                    shutdown(name);
//                }
//            }
//        }
//    }
//
//    @PreDestroy
//    public void preDestroy() {
//        long now = System.currentTimeMillis();
//        System.out.println("关闭所有 Rocketmq 连接");
//        RocketmqProducerManager.shutdownAll();
//        System.out.println("总计用时：" + (System.currentTimeMillis() - now));
//    }
//}