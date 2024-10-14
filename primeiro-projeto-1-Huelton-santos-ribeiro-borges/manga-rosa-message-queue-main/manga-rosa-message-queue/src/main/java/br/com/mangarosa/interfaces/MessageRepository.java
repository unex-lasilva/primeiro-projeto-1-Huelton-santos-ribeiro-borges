package br.com.mangarosa.interfaces;

import br.com.mangarosa.datastructures.interfaces.Queue;
import br.com.mangarosa.models.Message;

public interface MessageRepository {
    void saveMessage(String topic, Message message);
    Queue<Message> getMessages(String topic);
}