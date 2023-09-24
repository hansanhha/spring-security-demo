package study.security.this_will_protect_you.entity;

import jakarta.persistence.*;

@Entity
public class Product {

    protected Product() {
    }

    public Product(String name, int price, Currency currency) {
        this.name = name;
        this.price = price;
        this.currency = currency;
    }

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    Long id;

    private String name;

    private int price;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }
}
