package by.tsvirko.task03.view;

public class MenuView {
    private BallView ballView;

    public MenuView() {
        this.ballView = new BallView();
    }

    public void viewTasks() {
        System.out.println("1.Наполнить корзину разными мячиками.\n" +
                "2.Определить вес мячиков в корзине и количество мячиков цвета colour. \n" +
                "3.Количество одинаковых мячиков в каждой корзине.\n" +
                "4.Вывести информацию о мячиках в порядке возрастания их стоимости.\n" +
                "5.Создать несколько корзин. \n" +
                "6.Найти сколько одинаковых по набору мячиков корзин есть в наличии.\n");
        ballView.fillBallsView();
        ballView.ballWeightAndColourView();
        ballView.sameBallsView();
        ballView.ballsAscPrice();
        ballView.createSeveralBuckets();
        ballView.showSameBallsBuckets();
    }
}
