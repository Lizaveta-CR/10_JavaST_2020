package by.tsvirko.task03.view;

import java.util.Scanner;

public class MenuView {
    private BallView ballView;
    private Scanner scanner;

    public MenuView() {
        this.scanner = new Scanner(System.in);
        this.ballView = new BallView();
    }

    public void start() {
        System.out.println("First of all let's create 1 bucket");
        ballView.fillBallsView();
    }

    public void viewTasks() {
        System.out.println("Наполнить корзину разными мячиками.\n" +
                "2.Определить вес мячиков в корзине и количество мячиков цвета colour. \n" +
                "3.Количество одинаковых мячиков в каждой корзине.\n" +
                "4.Вывести информацию о мячиках в порядке возрастания их стоимости.\n" +
                "5.Создать несколько корзин. \n" +
                "6.Найти сколько одинаковых по набору мячиков корзин есть в наличии.\n" +
                "7.Выйти");
        int userNumber = scanner.nextInt();
        switch (userNumber) {
            case 2:
                ballView.ballWeightAndColourView();
                viewTasks();
            case 3:
                ballView.sameBallsView();
                viewTasks();
            case 4:
                ballView.ballsAscPrice();
                viewTasks();
            case 5:
                ballView.createSeveralBuckets();
                viewTasks();
            case 6:
                ballView.showSameBallsBuckets();
                viewTasks();
            case 7:
                return;
            default:
                viewTasks();
        }
    }
}
