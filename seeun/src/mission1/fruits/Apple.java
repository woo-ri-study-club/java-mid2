package mission1.fruits;

public class Apple extends Fruit {

    public Apple(int price, String color, int sweetness) {
        super(price, color, sweetness);
    }

    @Override
    public void showInfo() {
        System.out.println("[사과의 정보] 가격: " + getPrice() + ", 당도: " + getSweetness());

    }

    @Override
    public boolean isRipe() {
        return getColor().equals("red");
    }
}
