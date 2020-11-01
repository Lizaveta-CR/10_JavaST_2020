package by.tsvirko;

public class BufferThread {
    static int counter = 0;
    static StringBuffer s = new StringBuffer();
//    static StringBuilder s = new StringBuilder();

    public static void main(String[] args) throws InterruptedException {
        new Thread() {
            @Override
            public void run() {
                synchronized (s) {
                    while (BufferThread.counter++ < 3) {
                        s.append("A");
                        System.out.print("> " + counter + " ");
                        System.out.println(s);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();
        Thread.sleep(100);
        while (BufferThread.counter++ < 6) {
            System.out.print("< " + counter + " ");
            //здесь main ждет освобождения блокировки
            s.append("B");
            System.out.println(s);
        }
    }
}
