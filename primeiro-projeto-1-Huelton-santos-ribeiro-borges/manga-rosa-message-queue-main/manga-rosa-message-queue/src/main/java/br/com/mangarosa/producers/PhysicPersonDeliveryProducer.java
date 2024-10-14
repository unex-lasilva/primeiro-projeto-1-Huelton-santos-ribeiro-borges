package br.com.mangarosa.producers;

import br.com.mangarosa.interfaces.MessageRepository;
import br.com.mangarosa.models.Message;

public class PhysicPersonDeliveryProducer {
    private MessageRepository repository;
    private static final String TOPIC = "queue/fast-delivery-items";

    public PhysicPersonDeliveryProducer(MessageRepository repository) {
        this.repository = repository;
    }

    public void sendMessage(String content) {
        Message message = new Message(content, System.currentTimeMillis() + 60000); // 1 minuto de expiração
        repository.saveMessage(TOPIC, message);
    }
}