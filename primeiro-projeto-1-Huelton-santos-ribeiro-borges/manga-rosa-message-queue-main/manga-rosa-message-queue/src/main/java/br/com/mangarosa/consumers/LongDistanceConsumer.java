package br.com.mangarosa.consumers;

import br.com.mangarosa.datastructures.interfaces.Queue;
import br.com.mangarosa.interfaces.MessageRepository;
import br.com.mangarosa.models.Message;

public class LongDistanceConsumer {
    private MessageRepository repository;
    private static final String TOPIC = "queue/long-distance-items";

    public LongDistanceConsumer(MessageRepository repository) {
        this.repository = repository;
    }

    public void processMessages() {
        Queue<Message> queue = repository.getMessages(TOPIC);
        while (!queue.isEmpty()) {
            Message message = queue.dequeue();
            if (!message.isExpired()) {
                System.out.println("Processando mensagem de longa distância: " + message.getContent());
            } else {
                System.out.println("Mensagem de longa distância expirada: " + message.getContent());
            }
        }
    }
}