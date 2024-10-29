public class Product
{
    private String name = "Produkt";
    private Category category = new Category("kategoria");
    private float price = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product: " + name +  " category: " + category +
                " price: " + price;
    }
}
