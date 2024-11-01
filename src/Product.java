import java.math.BigDecimal;

public class Product
{
    private String name = "Produkt";
    private Category category = new Category("kategoria");
    private float price = 0;

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

    @Override
    public String toString() {
        return "Product: " + name +  " category: " + category +
                " price: " + price;
    }
}
