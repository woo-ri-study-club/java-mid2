package generic.selfMission.ex02.item;

public abstract class Item {
    private String name;
    private int price;
    private int rarity;

    public Item(String name, int price, int rarity) {
        this.name = name;
        this.price = price;
        this.rarity = rarity;
    }

    public int getPrice() {
        return price;
    }

    public int getRarity() {
        return rarity;
    }

    @Override
    public String toString() {
        return "아이템 명: " + name + " | 가격: " + price + " | 희귀도: " + rarity;
    }
}
