import uk.po.entities.Category;
import uk.po.entities.Product;
import uk.po.enums.Currency;

public class Main
{

    public static void main (String[] args)
    {
        Category c = Category.from("Firanki");
        Currency curr = Currency.USD;
        Product p = new Product("Produkt", 1.578f, c, curr);
        System.out.println(p);
    }


}
