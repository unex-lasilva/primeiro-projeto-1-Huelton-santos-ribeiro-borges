package br.com.mangarosa.producers;

import br.com.mangarosa.interfaces.MessageRepository;
import br.com.mangarosa.models.Message;

public class PyMarketPlaceProducer {
    private MessageRepository repository;
    private static final String TOPIC = "queue/long-distance-items";

    public PyMarketPlaceProducer(MessageRepository repository) {
        this.repository = repository;
    }

    public void sendMessage(String content) {
        Message message = new Message(content, System.currentTimeMillis() + 3600000); // 1 hora de expiração
        repository.saveMessage(TOPIC, message);
    }
}