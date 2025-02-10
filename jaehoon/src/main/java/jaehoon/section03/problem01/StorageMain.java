package jaehoon.section03.problem01;

import java.time.LocalDate;

public class StorageMain {

  public static void main(String[] args) {
    // 책과 디바이스 창고 생성
    Storage<Book> bookStorage = new Storage<>();
    Storage<Device> deviceStorage = new Storage<>();

    Storage<Item> generalStorage = new Storage<>();

    // 아이템 추가
    bookStorage.addItem(new Book("이펙티브 자바", 20_000, "조슈아 블로크"));
    bookStorage.addItem(new Book("클린코드", 30_000, "로버트 C.마틴"));

    deviceStorage.addItem(new Device("아이폰 16 Pro",
                                     1_000_000,
                                     LocalDate.of(2027, 2, 7)));
    deviceStorage.addItem(new Device("아이패드 M4 11 Pro",
                                     2_000_000,
                                     LocalDate.of(2027, 1, 1)));

    // 아이템 출력
    System.out.println("Book 창고:");
    printItems(bookStorage);
    System.out.println();

    System.out.println("Device 창고:");
    printItems(deviceStorage);
    System.out.println();

    // 아이템을 공용 창고로 이동
    System.out.println("아이템을 공용 창고로 이동...");
    System.out.println("공용 창고:");
    // bookStorage.transferItems(deviceStorage); 상위가 아닌 다른 창고로는 이동 불가
    bookStorage.transferItems(generalStorage);
    deviceStorage.transferItems(generalStorage);
    printItems(generalStorage);
    System.out.println();

    System.out.println("Book 창고:");
    printItems(bookStorage);
    System.out.println();

    System.out.println("Device 창고:");
    printItems(deviceStorage);
  }

  // 와일드카드를 활용한 아이템 목록 출력
  public static void printItems(Storage<? extends Item> storage) {
    if (storage.isEmpty()) {
      System.out.println("창고가 비어있습니다.");
    } else {
      for (Item item : storage.getItems()) {
        System.out.println(item);
      }
    }
  }
}
