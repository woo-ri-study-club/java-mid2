package mission1.items;

public abstract class Item {
    protected int price=0;
    protected String name="";

    public Item(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
