package mission1;

import mission1.items.Book;
import mission1.items.EBook;
import mission1.items.Goods;
import mission1.items.Item;

public class Main {
    public static void main(String[] args) {

        //item 생성- book, ebook, goods 
        Book littlePrince = new Book("어린왕자", "앙투안 드 생텍쥐페리", 25000);
        Book codingPatternInterview = new Book("Coding Pattern Interview", "Alex Xu", 38000);
        Book thePrinciplesOfJava = new Book("자바의 정석", "남궁성", 35000);

        EBook JPA = new EBook("JPA", "김영한", 35000);

        Goods noteBook = new Goods(3000, "Little Prince Notebook.");
        Goods pen = new Goods(2500, "Little Prince pen.");
        
        
        //각 타입의 아이탬마다 아이탬리스트에 추가 ItemList는 제네릭 클래스로 item 자손들을 담을수있다.
        ItemList<Book> books = new ItemList<>();
        books.add(littlePrince);
        books.add(codingPatternInterview);
        books.add(thePrinciplesOfJava);
        
        ItemList<EBook> ebooks = new ItemList<>();
        ebooks.add(JPA);
        //ebooks.add(littlePrince); <-- ebook타입이 아니라 들어가지 않음.

        ItemList<Goods> goodsList = new ItemList<>();
        goodsList.add(noteBook);
        goodsList.add(pen);
        
        //+ 각 아이탬 타입별로 1+1 할인이 적용되서 두개 중 비싼 아이탬이 반환된다.
        // (타입별로만 할인 혜택) 2개중 가장 비싼 item 반환. 3개일 경우 2개 계산, 제네릭 메서드로 타입별 ItemList 반환.
        ItemList<Book> filteredBook=books.filterExpensiveItemsInPairs();

        ItemList<EBook> filteredEBook=ebooks.filterExpensiveItemsInPairs();

        ItemList<Goods> filteredGoods = goodsList.filterExpensiveItemsInPairs();


        // 1+1 할인 적용된 아이탬들 book, ebook, goods 3 모두 한꺼번에 계산하기. 와이드 카드 사용.
        int totalPriceToPay = totalPriceToPay(filteredBook, filteredEBook, filteredGoods);
        System.out.println("총 가격: "+totalPriceToPay); //총 가격: 101000

    }

    private static int totalPriceToPay(ItemList<? extends Item>... itemLists) {
        int totalPrice=0;
        for (ItemList<? extends Item> itemList : itemLists) {
            totalPrice += itemList.getTotalPrice();
            System.out.println(itemList.toString());
//ItemList{totalPrice=63000, items=[Book{author='Alex Xu', price=38000, name='Coding Pattern Interview'}, Book{author='앙투안 드 생텍쥐페리', price=25000, name='어린왕자'}]}
//ItemList{totalPrice=35000, items=[EBook{author='김영한', price=35000, name='JPA'}]}
//ItemList{totalPrice=3000, items=[Goods{name='Little Prince Notebook.', price=3000}]}
        }
        return totalPrice;
    }


}
