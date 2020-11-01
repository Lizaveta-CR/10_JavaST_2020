package by.tsvirko.interrupt;

public class Program {
    public static void main(String[] args) {

        System.out.println("Main thread started...");
        JThread t = new JThread("JThread");
        t.start();
        try {
            Thread.sleep(150);
            t.interrupt();//Вызов этого метода устанавливает у потока статус, что он прерван.
            // Сам метод возвращает true, если поток может быть прерван, в ином случае возвращается false.
            // При этом сам вызов этого метода НЕ завершает поток, он только устанавливает статус: в частности, метод isInterrupted() класса Thread будет возвращать значение true.
            Thread.sleep(150);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }
        System.out.println("Main thread finished...");
    }
}
