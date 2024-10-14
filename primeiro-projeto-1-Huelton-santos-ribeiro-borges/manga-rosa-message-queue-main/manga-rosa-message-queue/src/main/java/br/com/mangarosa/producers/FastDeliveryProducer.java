package br.com.mangarosa.producers;

import br.com.mangarosa.interfaces.MessageRepository;
import br.com.mangarosa.models.Message;

public class FastDeliveryProducer {
    private MessageRepository repository;
    private static final String TOPIC = "queue/long-distance-items";

    public FastDeliveryProducer(MessageRepository repository) {
        this.repository = repository;
    }

    public void sendMessage(String content) {
        Message message = new Message(content, System.currentTimeMillis() + 1800000); // 30 minutos de expiração
        repository.saveMessage(TOPIC, message);
    }
}