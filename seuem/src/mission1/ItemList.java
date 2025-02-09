package mission1;

import mission1.items.Item;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ItemList <T extends Item>{
    private int totalPrice;
    private final List<T> items =new ArrayList<>();

    public void add(T item){
        items.add(item);
        totalPrice += item.getPrice();
    }

    public ItemList<T> filterExpensiveItemsInPairs() {
        ItemList<T> selectedItems = new ItemList<>();
        //가격순으로 정렬
        items.sort(Comparator.comparing(Item::getPrice));
        for (int i=items.size()-1;i>=0;i-=2) {
            selectedItems.add(items.get(i));
        }
        return selectedItems;
    }

    @Override
    public String toString() {
        return "ItemList{" +
                "totalPrice=" + totalPrice +
                ", items=" + items +
                '}'
                ;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
