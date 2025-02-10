package mission1.fruits;

public abstract class Fruit {

    private String name;
    private int price;
    private String color;
    private int sweetness;

    public Fruit(String name, int price, String color, int sweetness) {
        this.name = name;
        this.price = price;
        this.color = color;
        this.sweetness = sweetness;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public int getSweetness() {
        return sweetness;
    }

    public abstract void showInfo();

    public abstract boolean isRipe();
}
