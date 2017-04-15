package jms.ee.ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(name = "Listener2", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/topic/js-topic"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class SecondListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println(getClass().getSimpleName() + " >>>>>>>> " + message.getBody(String.class));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
