package concurrent.capter5.eventQueue;

import java.util.LinkedList;

/**
 * @author ltw
 * on 2019-12-24.
 */
public class EventQueue {
    private final int max;

    private static final int DEFAULT_MAX_EVENT = 15;

    private final LinkedList<Event> list = new LinkedList<>();

    public EventQueue() {
        this(DEFAULT_MAX_EVENT);
    }

    public EventQueue(int max) {
        this.max = max;
    }

    public void offer(Event event) {
        synchronized (list) {
            if (list.size() >= DEFAULT_MAX_EVENT) {
                try {
                    System.out.println("event is full");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                list.add(event);
                list.notify();
            }
        }
    }

    public void take() {
        synchronized (list) {
            if (list.isEmpty()) {
                System.out.println("event is empty");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(list.removeFirst().getMessage());
                list.notify();
            }
        }
    }

    public static void main(String[] args) {
        EventQueue eventQueue = new EventQueue();
        new Thread(() -> {
            while (true) {
                eventQueue.offer(new Event("test"));
            }
        }).start();
        new Thread(() -> {
            while (true) {
                eventQueue.take();
            }
        }).start();
    }

}
