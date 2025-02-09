package mission1.fruits;

public abstract class Fruit {

    private int price;
    private String color;
    private int sweetness;

    public Fruit(int price, String color, int sweetness) {
        this.price = price;
        this.color = color;
        this.sweetness = sweetness;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSweetness(int sweetness) {
        this.sweetness = sweetness;
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
