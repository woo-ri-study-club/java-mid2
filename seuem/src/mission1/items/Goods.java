package mission1.items;

public class Goods extends Item{

    public Goods(int price, String name) {
        super(price, name);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
