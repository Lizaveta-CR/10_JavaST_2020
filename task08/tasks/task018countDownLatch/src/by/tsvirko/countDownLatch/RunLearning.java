package by.tsvirko.countDownLatch;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class RunLearning {
    public static void main(String[] args) {
        final int NUMBER_TASKS_1 = 5;
        Student student1 = new Student(2321, NUMBER_TASKS_1);
        for (int i = 0; i < NUMBER_TASKS_1; i++) {
            Task task = new Task("Task #" + i);
            student1.addTask(task);
        }
        final int NUMBER_TASKS_2 = 4;
        Student student2 = new Student(32992, NUMBER_TASKS_2);
        for (int i = 0; i < NUMBER_TASKS_2; i++) {
            Task task = new Task("Task #" + i);
            student2.addTask(task);
        }
        ArrayList<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);

        Tutor tutor = new Tutor(list);
        student1.start();
        student2.start();
        try {
            //поток проверки стартует с задержкой
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tutor.start();
    }
}
