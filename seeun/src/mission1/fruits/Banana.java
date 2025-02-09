package mission1.fruits;

public class Banana extends Fruit{

    private int length;

    public Banana(String name, int price, String color, int sweetness, int length) {
        super(name, price, color, sweetness);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void showInfo() {
        System.out.println(getName() + ": 가격: " + getPrice() + ", 색: " + getColor() + ", 당도: " + getSweetness() + ", 길이: " + getLength());
    }

    @Override
    public boolean isRipe() {
        return getColor().equals("yellow");
    }
}
