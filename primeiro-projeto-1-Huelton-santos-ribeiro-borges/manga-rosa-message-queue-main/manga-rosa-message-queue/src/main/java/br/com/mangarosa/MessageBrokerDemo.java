package br.com.mangarosa;

import br.com.mangarosa.consumers.FastDeliveryConsumer;
import br.com.mangarosa.consumers.LongDistanceConsumer;
import br.com.mangarosa.interfaces.MessageRepository;
import br.com.mangarosa.producers.FastDeliveryProducer;
import br.com.mangarosa.producers.FoodDeliveryProducer;
import br.com.mangarosa.producers.PhysicPersonDeliveryProducer;
import br.com.mangarosa.producers.PyMarketPlaceProducer;
import br.com.mangarosa.repositories.InMemoryMessageRepository;

public class MessageBrokerDemo {
    public static void main(String[] args) {
        MessageRepository repository = new InMemoryMessageRepository();

        // Criando produtores
        FoodDeliveryProducer foodProducer = new FoodDeliveryProducer(repository);
        PhysicPersonDeliveryProducer physicPersonProducer = new PhysicPersonDeliveryProducer(repository);
        PyMarketPlaceProducer pyMarketProducer = new PyMarketPlaceProducer(repository);
        FastDeliveryProducer fastDeliveryProducer = new FastDeliveryProducer(repository);

        // Criando consumidores
        FastDeliveryConsumer fastConsumer = new FastDeliveryConsumer(repository);
        LongDistanceConsumer longConsumer = new LongDistanceConsumer(repository);

        // Enviando mensagens
        foodProducer.sendMessage("Pedido de pizza");
        physicPersonProducer.sendMessage("Entrega de documento");
        pyMarketProducer.sendMessage("Compra online internacional");
        fastDeliveryProducer.sendMessage("Entrega rápida de longa distância");

        // Processando mensagens
        System.out.println("Processando mensagens de entrega rápida:");
        fastConsumer.processMessages();

        System.out.println("\nProcessando mensagens de longa distância:");
        longConsumer.processMessages();
    }
}