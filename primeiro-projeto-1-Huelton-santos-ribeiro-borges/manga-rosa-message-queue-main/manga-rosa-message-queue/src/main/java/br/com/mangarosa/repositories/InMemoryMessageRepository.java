package br.com.mangarosa.repositories;

import br.com.mangarosa.datastructures.interfaces.Queue;
import br.com.mangarosa.datastructures.interfaces.impl.LinkedQueue;
import br.com.mangarosa.interfaces.MessageRepository;
import br.com.mangarosa.models.Message;

import java.util.HashMap;
import java.util.Map;

public class InMemoryMessageRepository implements MessageRepository {
    private Map<String, Queue<Message>> topicQueues = new HashMap<>();

    @Override
    public void saveMessage(String topic, Message message) {
        topicQueues.computeIfAbsent(topic, k -> new LinkedQueue()).enqueue(message);
    }

    @Override
    public Queue<Message> getMessages(String topic) {
        return topicQueues.getOrDefault(topic, new LinkedQueue());
    }
}