package mission1.fruits;

public class Banana extends Fruit{

    public Banana(int price, String color, int sweetness) {
        super(price, color, sweetness);
    }

    @Override
    public void showInfo() {
        System.out.println("[바나나 정보] 가격: " + getPrice() + ", 당도: " + getSweetness());

    }

    @Override
    public boolean isRipe() {
        return getColor().equals("yellow");
    }
}
