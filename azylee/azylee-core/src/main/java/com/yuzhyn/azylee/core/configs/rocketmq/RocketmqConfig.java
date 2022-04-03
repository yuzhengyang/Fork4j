package com.yuzhyn.azylee.core.configs.rocketmq;


import com.yuzhyn.azylee.core.datas.collections.ListTool;

import java.util.List;
import java.util.Optional;

public class RocketmqConfig {
    private RocketmqBaseConfig config;
    private List<RockermqProducerConfig> producer;
    private List<RockermqConsumerConfig> consumer;

    //region 生产者配置

    /**
     * 根据指定名称获取生产者配置信息
     *
     * @param name
     * @return
     */
    public RockermqProducerConfig getProducer(String name) {
        String upperName = name.toUpperCase();
        RockermqProducerConfig result = getDefaultProducer();
        if (ListTool.ok(this.producer)) {
            Optional<RockermqProducerConfig> data = this.producer.stream().filter(p -> p.getName().toUpperCase().equals(upperName)).findFirst();
            if (data.isPresent()) {
                RockermqProducerConfig record = data.get();
                result.setName(record.getName());
                result.setGroup(record.getGroup());
                result.setTopic(record.getTopic());
                result.setTag(record.getTag());
            }
        }
        return result;
    }

    /**
     * 获取默认生产者配置信息
     *
     * @return
     */
    private RockermqProducerConfig getDefaultProducer() {
        RockermqProducerConfig result = new RockermqProducerConfig();
        if (this.config != null) {
            result.setName(this.config.getNamesrvAddr());
            result.setGroup(this.config.getProducerGroup());
            result.setNamesrvAddr(this.config.getNamesrvAddr());
            result.setSendMsgTimeout(this.config.getSendMsgTimeout());
        }
        return result;
    }
    //endregion

    //region 消费者配置

    /**
     * 根据指定名称获取消费者配置信息
     *
     * @param name
     * @return
     */
    public RockermqConsumerConfig getConsumer(String name) {
        String upperName = name.toUpperCase();
        RockermqConsumerConfig result = getDefaultConsumer();
        if (ListTool.ok(this.consumer)) {
            Optional<RockermqConsumerConfig> data = this.consumer.stream().filter(p -> p.getName().toUpperCase().equals(upperName)).findFirst();
            if (data.isPresent()) {
                RockermqConsumerConfig record = data.get();
                result.setName(record.getName());
                result.setGroup(record.getGroup());
                result.setTopic(record.getTopic());
                result.setTag(record.getTag());
            }
        }
        return result;
    }

    /**
     * 获取默认消费者配置信息
     *
     * @return
     */
    private RockermqConsumerConfig getDefaultConsumer() {
        RockermqConsumerConfig result = new RockermqConsumerConfig();
        if (this.config != null) {
            result.setName(this.config.getNamesrvAddr());
            result.setGroup(this.config.getConsumerGroup());
            result.setNamesrvAddr(this.config.getNamesrvAddr());
        }
        return result;
    }
    //endregion

    //region Getter And Setter
    public RocketmqBaseConfig getConfig() {
        return config;
    }

    public void setConfig(RocketmqBaseConfig config) {
        this.config = config;
    }

    public List<RockermqProducerConfig> getProducer() {
        return producer;
    }

    public void setProducer(List<RockermqProducerConfig> producer) {
        this.producer = producer;
    }

    public List<RockermqConsumerConfig> getConsumer() {
        return consumer;
    }

    public void setConsumer(List<RockermqConsumerConfig> consumer) {
        this.consumer = consumer;
    }
    //endregion
}
