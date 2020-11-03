package by.tsvirko.countDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Student extends Thread {
    private Integer idStudent;
    private List<Task> taskList;
    private CountDownLatch countDown;

    public Student(Integer idStudent, int numberTasks) {
        this.idStudent = idStudent;
        this.countDown = new CountDownLatch(numberTasks);
        this.taskList = new ArrayList<Task>(numberTasks);
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public CountDownLatch getCountDown() {
        return countDown;
    }

    public void setCountDown(CountDownLatch countDown) {
        this.countDown = countDown;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    @Override
    public void run() {
        int i = 0;
        for (Task inWork : taskList) {
            //время на выполнение
            try {
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //отправка ответа
            inWork.setAnswer("Answer #" + ++i);
            System.out.println("Answer #" + i + " from " + idStudent);
        }
        try {
            countDown.await();//ожидание проверки заданий
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //подсчет средней оценки за все задачи
        int averageMark = 0;
        for (Task inWork : taskList) {
            //выполнение задания
            averageMark += inWork.getMark();//отправка ответа
        }
        averageMark /= taskList.size();
        System.out.println("Student " + idStudent + " : Average mark = " + averageMark);
    }
}
