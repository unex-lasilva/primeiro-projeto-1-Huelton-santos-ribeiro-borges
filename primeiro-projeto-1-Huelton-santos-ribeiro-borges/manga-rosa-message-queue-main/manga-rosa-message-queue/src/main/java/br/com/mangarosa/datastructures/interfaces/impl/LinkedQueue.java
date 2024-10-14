package br.com.mangarosa.datastructures.interfaces.impl;

import br.com.mangarosa.datastructures.interfaces.Queue;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<T extends Comparable<T>> implements Queue<T> {
    
    private QueueNode head;
    private QueueNode tail;
    private int size;

    private class QueueNode {
        T data;
        QueueNode next;

        QueueNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(T item) {
        QueueNode newNode = new QueueNode(item);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T item = head.data;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) new Comparable[size];
        QueueNode current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.data;
            current = current.next;
        }
        return array;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private QueueNode current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}