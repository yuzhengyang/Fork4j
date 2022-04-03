package com.yuzhyn.azylee.core.configs.rocketmq;

public class RocketmqBaseConfig {
    private String producerGroup = "SELF_TEST_P_GROUP";
    private String consumerGroup = "";
    private int sendMsgTimeout = 60000;
    /**
     * if this value is empty,use env value rocketmq.config.namesrvAddr  NAMESRV_ADDR | now, you can set it in ops page.default localhost:9876
     */
    private String namesrvAddr = "127.0.0.1:9876";
    /**
     * if you use rocketmq version < 3.5.8, rocketmq.config.isVIPChannel should be false.default true
     */
    private boolean isVIPChannel = false;

    //region Getter And Setter
    public String getProducerGroup() {
        return producerGroup;
    }

    public void setProducerGroup(String producerGroup) {
        this.producerGroup = producerGroup;
    }

    public String getConsumerGroup() {
        return consumerGroup;
    }

    public void setConsumerGroup(String consumerGroup) {
        this.consumerGroup = consumerGroup;
    }

    public int getSendMsgTimeout() {
        return sendMsgTimeout;
    }

    public void setSendMsgTimeout(int sendMsgTimeout) {
        this.sendMsgTimeout = sendMsgTimeout;
    }

    public String getNamesrvAddr() {
        return namesrvAddr;
    }

    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }

    public boolean isVIPChannel() {
        return isVIPChannel;
    }

    public void setVIPChannel(boolean VIPChannel) {
        isVIPChannel = VIPChannel;
    }
    //endregion
}