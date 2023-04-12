package com.torry.demo.project;

public class MQDemo implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnsCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init(){
        //注入接口实现
        rabbitTemplate.setConfirmCallback(this);
        //注入接口实现
        rabbitTemplate.setReturnsCallback(this);
    }

    /**
     * 【重要】实现  ConfirmCallback 是判断消息是否发送到交换机的回调  接口会默认实现confirm方法
     * 共有3个参数
     * 一个是correlationData  存储消息的ID和自己存储的关于该条消息的信息
     * 一个是boolean ack      判断是否发送成功
     * 一个是String cause     发送失败是失败的原因
     *
     * 交换机确认回调方法
     * 1、发消息  交换机接收到了    回调
     *    1.1 correlationData 保存回调消息的ID及相关消息
     *    1.2 交换机收到消息  ack = true
     *    1.3 cause null
     * 2、发消息  交换机接收失败   回调
     *    2.1 correlationData 保存回调消息的ID及相关消息
     *    2.2 交换机收到消息  ack = false
     *    2.3  cause失败原因
     */

    /**交换机发布确认的接口实现的方法
     *
     * @param correlationData
     * @param ack
     * @param cause
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        String ID = correlationData!=null? correlationData.getId() : " ";

        if(ack){
            log.info("交换机已经收到了消息，ID：{}",ID);
        }else {
            log.info("交换机未收到ID：{}的消息，由于{}的原因",ID,cause);
        }
    }

    /**
     * 回退接口实现的方法
     * 消息传递过程中不可达目的地消息返回给生产者
     * 只有不达目的才会进行回退
     * @param returnedMessage
     */
    @Override
    public void returnedMessage(ReturnedMessage returnedMessage) {
        log.error("回退消息{}",returnedMessage);
		//20230412
    }
}
