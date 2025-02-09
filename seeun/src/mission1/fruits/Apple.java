package mission1.fruits;

public class Apple extends Fruit {

    private int size;

    public Apple(String name, int price, String color, int sweetness, int size) {
        super(name, price, color, sweetness);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void showInfo() {
        System.out.println(getName() + ": 가격: " + getPrice() + ", 색: " + getColor() + ", 당도: " + getSweetness() + ", 크기: " + getSize());
    }

    @Override
    public boolean isRipe() {
        return getColor().equals("red");
    }
}
