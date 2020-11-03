package by.tsvirko.blocking;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Пусть объявлена очередь из пяти элементов. Изначально в ней размещены три элемента. В первом потоке производится
 * попытка добавления трех элементов. Два добавятся успешно, а при попытке добавления третьего поток будет остановлен
 * до появления свободного места в очереди. Только когда второй поток извлечет один элемент и освободит место, первый
 * поток получит возможность добавить свой элемент.
 */
public class RunBlocking {
    public static void main(String[] args) {
        final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(2);

        new Thread(() -> {
            for (int i = 1; i < 4; i++) {
                try {
                    queue.put("Java " + i);
                    System.out.println("Element " + i + " added");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);

                System.out.println("Element " + queue.take() + " took");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
