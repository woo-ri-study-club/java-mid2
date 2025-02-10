package jaehoon.section03.problem01;

import java.time.LocalDate;

public class Device extends Item {

  private final LocalDate warrantyPeriod;

  public Device(String name, int price, LocalDate warrantyPeriod) {
    super(name, price);
    this.warrantyPeriod = warrantyPeriod;
  }

  @Override
  public String toString() {
    return "Device{" +
        "name=" + super.getName() +
        ", price=" + super.getPrice() +
        "warrantyPeriod=" + warrantyPeriod +
        '}';
  }
}
