package mission1.fruits;

public class Apple extends Fruit {

    public Apple(String name, int price, String color, int sweetness) {
        super(name, price, color, sweetness);
    }

    @Override
    public void showInfo() {
        System.out.println(getName() + ": 가격: " + getPrice() + ", 당도: " + getSweetness());

    }

    @Override
    public boolean isRipe() {
        return getColor().equals("red");
    }
}
