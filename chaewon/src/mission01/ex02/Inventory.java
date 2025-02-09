package generic.selfMission.ex02;

import generic.selfMission.ex02.item.Item;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Inventory<T extends Item> {
    private static int CAPACITY = 10;
    private List<T> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public boolean add(T item) {
        if (items.size() >= CAPACITY) {
            return false;
        }

        return items.add(item);
    }

    public void sortByRarity() {
        items.sort(
                Comparator.comparingInt(Item::getRarity).reversed()
        );
    }

    public int getTotalPrice() {
        return items.stream().mapToInt(Item::getPrice).sum();
    }

    public List<T> getItems() {
        return items;
    }
}
