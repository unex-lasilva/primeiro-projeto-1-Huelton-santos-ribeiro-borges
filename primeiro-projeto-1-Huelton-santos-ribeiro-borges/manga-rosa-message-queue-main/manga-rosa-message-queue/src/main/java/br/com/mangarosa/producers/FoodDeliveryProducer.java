package br.com.mangarosa.producers;

import br.com.mangarosa.interfaces.MessageRepository;
import br.com.mangarosa.models.Message;

public class FoodDeliveryProducer {
    private MessageRepository repository;
    private static final String TOPIC = "queue/fast-delivery-items";

    public FoodDeliveryProducer(MessageRepository repository) {
        this.repository = repository;
    }

    public void sendMessage(String content) {
        Message message = new Message(content, System.currentTimeMillis() + 30000); // 30 segundos de expiração
        repository.saveMessage(TOPIC, message);
    }
}