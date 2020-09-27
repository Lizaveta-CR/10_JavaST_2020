package by.tsvirko.task03.view;

import by.tsvirko.task03.entity.Ball;
import by.tsvirko.task03.entity.Bucket;
import by.tsvirko.task03.service.BucketService;

import java.util.Scanner;

public class MenuView {
    private Scanner scanner;
    private BallView ballView;

    public MenuView() {
        this.scanner = new Scanner(System.in);
        this.ballView = new BallView();
    }

    public void viewTasks() {
        System.out.println("1.Наполнить корзину разными мячиками.\n" +
                "2.Определить вес мячиков в корзине и количество мячиков цвета colour. \n" +
                "3.Количество одинаковых мячиков в каждой корзине.\n" +
                "4.Вывести информацию о мячиках в порядке возрастания их стоимости.\n" +
                "5.Создать несколько корзин. \n" +
                "6.Найти сколько одинаковых по набору мячиков корзин есть в наличии.\n");
        int userNumber = scanner.nextInt();
        switch (userNumber) {
            case 1:
                ballView.fillBallsView();
            case 2:
                ballView.ballWeightAndColourView();
            case 3:
                ballView.sameBallsView();
            case 4:
                ballView.ballsAscPrice();
        }
    }
}
