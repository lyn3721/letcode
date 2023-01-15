package com.letcode.practice.general.queue;

/**
 * @author lyn
 * @since 2022/8/2 19:34
 */
public class CircularQueue {

    private int head;
    private int tail;
    private int capacity;
    private int[] elements;

    public CircularQueue(int k) {
        capacity = k + 1;
        elements = new int[capacity];

    }



    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        elements[tail] = value;
        tail = (tail + 1) % capacity;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % capacity;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return elements[head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return elements[(tail - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return tail == head;
    }

    public boolean isFull() {
        return ((tail + 1) % capacity) == head;
    }


    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(3); // 设置长度为 3
        System.out.println(circularQueue.enQueue(1));
        System.out.println(circularQueue.enQueue(2));
        System.out.println(circularQueue.enQueue(3));
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.isFull());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
    }
}
