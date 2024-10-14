package br.com.mangarosa.consumers;

import br.com.mangarosa.datastructures.interfaces.Queue;
import br.com.mangarosa.interfaces.MessageRepository;
import br.com.mangarosa.models.Message;

public class FastDeliveryConsumer {
    private MessageRepository repository;
    private static final String TOPIC = "queue/fast-delivery-items";

    public FastDeliveryConsumer(MessageRepository repository) {
        this.repository = repository;
    }

    public void processMessages() {
        Queue<Message> queue = repository.getMessages(TOPIC);
        while (!queue.isEmpty()) {
            Message message = queue.dequeue();
            if (!message.isExpired()) {
                System.out.println("Processando mensagem rápida: " + message.getContent());
            } else {
                System.out.println("Mensagem expirada: " + message.getContent());
            }
        }
    }
}