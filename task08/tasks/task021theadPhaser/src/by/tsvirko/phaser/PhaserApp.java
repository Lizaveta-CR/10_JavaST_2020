package by.tsvirko.phaser;

import java.util.concurrent.Phaser;

public class PhaserApp {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);//при создании объекта Phaser ему передается число
        // 1 - главный поток, а в конструкторе PhaseThread вызывается метод register(). В принципе можно и не
        // использовать метод register, но тогда надо было бы указать Phaser phaser = new Phaser(3),
        // так как у нас три стороны

        new Thread(new PhaseThread(phaser, "PhaseThread 1")).start();
        new Thread(new PhaseThread(phaser, "PhaseThread 2")).start();

        // ждем завершения фазы 0
        int phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        // ждем завершения фазы 1
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        // ждем завершения фазы 2
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        phaser.arriveAndDeregister();

    }
}
