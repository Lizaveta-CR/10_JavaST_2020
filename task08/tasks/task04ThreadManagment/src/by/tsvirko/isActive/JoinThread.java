package by.tsvirko.isActive;

public class JoinThread extends Thread {
    public JoinThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        String nameT = getName();
        long timeout = 0;

        System.out.println("Thread starting " + nameT);
        try {
            switch (nameT) {
                case "First":
                    timeout = 5000;
                    break;
                case "Second":
                    timeout = 1000;
            }
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
