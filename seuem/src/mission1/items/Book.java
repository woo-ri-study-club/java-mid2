package mission1.items;

public class Book extends Item {
    String author;

    public Book(String name,String author,int price) {
        super(price,name);
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
