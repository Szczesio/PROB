package uk.po.entities;

import java.math.BigDecimal;
import uk.po.enums.Currency;

public class Product
{
    private String name = "Produkt";
    private Category category = Category.from("kategoria");
    private float price = 0;

    private Currency currency = Currency.PLN;

    public static Product create(String name, Category category, float price)
    {
        return new Product(name, price, category);
    }

    private Product (String name, float price)
    {
        try {
            setName(name);
            setPrice(price);
            } catch (Exception e) {
            name = null;
            price = 0;
            throw new RuntimeException(e);
        }
    }

    private Product (String name, float price, Category category)
    {
        try {
            setName(name);
            setPrice(price);
            setCategory(category);
            } catch (Exception e) {
            name = null;
            price = 0;
            category = null;
            throw new RuntimeException(e);
        }
    }

    private Product (String name, float price, Category category, Currency currency)
    {
        try {
            setName(name);
            setPrice(price);
            setCategory(category);
            setCurrency(currency);
        } catch (Exception e) {
            name = null;
            price = 0;
            category = null;
            currency = null;
            throw new RuntimeException(e);
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null && name.length() != 0) this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if(price > 0) {
            this.price = new BigDecimal(price).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
                       }
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "uk.po.entities.Product: " + name +  " category: " + category +
                " price: " + price + " currency: " + currency;
    }
}
