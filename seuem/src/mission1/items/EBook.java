package mission1.items;

public class EBook extends Item{
    String author;
    public EBook(String name, String author,int price) {
        super(price, name);
        this.author = author;
    }

    @Override
    public String toString() {
        return "EBook{" +
                "author='" + author + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
