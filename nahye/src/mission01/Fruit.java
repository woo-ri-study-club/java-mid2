package mission01;

public abstract class Fruit {
    private String origin;
    private int price;

    public Fruit(String origin, int price) {
        this.origin = origin;
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " (Origin: " + origin + ", Price: " + price + ")";
    }

}


