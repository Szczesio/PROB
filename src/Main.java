import uk.po.entities.Category;
import uk.po.entities.Product;
import uk.po.enums.Currency;

public class Main
{

    public static void main (String[] args)
    {

        Category c = Category.from("meble");
        Product p = Product.create("fotel", c, 445.59f);
        Currency curr = Currency.USD;
        p.setCurrency(curr);
        System.out.println(p);
    }


}
