import uk.po.entities.Category;
import uk.po.entities.Product;
import uk.po.enums.Currency;

public class Main
{

    public static void main (String[] args)
    {

        Category c = Category.from("meble");
        Currency curr = Currency.USD;

        Product p = new Product.Builder("Fotel")
                .category(c)
                .price(45.67f)
                .currency(curr).build();

        System.out.println(p);
    }

}
