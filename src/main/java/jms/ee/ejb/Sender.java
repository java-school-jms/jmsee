package jms.ee.ejb;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;


@Stateless
public class Sender {

    @Inject
    private JMSContext context;

    @Resource(mappedName = "java:/jms/topic/js-topic")
    private Topic topic;

    public void sendMessage(String text) {
        System.out.println("Sending " + text);
        context.createProducer().send(topic, text);
    }

}
