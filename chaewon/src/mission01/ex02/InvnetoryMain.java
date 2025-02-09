package generic.selfMission.ex02;

import generic.selfMission.ex02.item.*;

public class InvnetoryMain {
    public static void main(String[] args) {
        Inventory<Item> inventory = new Inventory<>();

        inventory.add(new Equipment("갑옷", 50, 3));
        inventory.add(new Weapon("단검", 100, 2));
        inventory.add(new Expendable("포션A", 10, 1));
        inventory.add(new Expendable("포션B", 20, 1));
        inventory.add(new Etc("?", 1, 5));

        printInventoryItems(inventory);

        System.out.println("=========================================");

        inventory.sortByRarity();
        printInventoryItems(inventory);

        System.out.println("inventory.getTotalPrice() = " + inventory.getTotalPrice());
    }

    private static void printInventoryItems(Inventory<Item> inventory) {
        inventory.getItems().forEach(System.out::println);
    }
}
