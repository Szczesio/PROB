package uk.po.entities;

import java.math.BigDecimal;
import java.util.regex.Pattern;

import uk.po.enums.Currency;

public class Product
{
    private String name = "Produkt";
    private Category category = Category.from("kategoria");
    private float price = 0;

    private Currency currency = Currency.PLN;

    private Product(Builder builder)
    {
        this.name = builder.name;
        this.category = builder.category;
        this.price = builder.price;
        this.currency = builder.currency;
    }



    public static class Builder
    {
        private final String name;
        private Category category = null;
        private float price = 0;
        private Currency currency = null;

        private static final String NAME_REQUIRED_MESSAGE = "Nazwa produktu wymagana";
        public Builder(String name)
        {
            StringValidator validator = new StringValidator();
            validator.getInstance().isValid(name);
            this.name = name;
        }

        public Builder category(Category category)
        {
            CategoryValidator.getInstance().validate(category);
            this.category = category;
            return this;
        }

        public Builder price(float price)
        {
            this.price = price;
            return this;
        }

        public Builder currency(Currency currency)
        {
            this.currency = currency;
            return this;
        }

        public Product build()
        {
            return new Product(this);
        }

        static class CategoryValidator
        {
            private static final CategoryValidator INSTANCE = new CategoryValidator();
            private static final String VALIDATE_CATEGORY_MESSAGE
                    ="błędny format kategorii";
            public static CategoryValidator getInstance()
            {
                return CategoryValidator.INSTANCE;
            }

            public void validate(Category category)
            {
                CategoryValidator.getInstance().validate(category);
            }

            private CategoryValidator() {}

        }

    }

    public static Product create(String name, Category category, float price)
    {
        return new Product(name, price, category);
    }

    public static Product create(String name, float price)
    {
        return new Product(name, price);
    }

    public static Product create(String name, float price, Category category, Currency currency)
    {
        return new Product(name, price, category, currency);
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
        //if(name != null && name.length() != 0)
        this.name = name;
        StringValidator instance = new StringValidator();
        instance.isValid(name);
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
    //    if(price > 0) {
            this.price = new BigDecimal(price).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
    //                   }
        PriceValidator instance = new PriceValidator();
        instance.isValid(price);
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" ");
        if(category != null)
        {
            sb.append(category);
            sb.append(" ");
        }

        if(price != 0)
        {
            sb.append(price);
            sb.append(" ");
        }

        if(currency != null)
        {
            sb.append(currency);
            sb.append(" ");
        }
        return sb.toString();
        //return "uk.po.entities.Product: " + name +  " category: " + category +
        //        " price: " + price + " currency: " + currency;
    }

    public static class StringValidator {
        private StringValidator instance;
        private StringValidator() {}
        public StringValidator getInstance() {
            return instance;
        }
        public boolean isEmpty(String value) {
            return value.length() == 0;
        }

        public boolean isValid(String value) {
            if(value == null) {
                instance = new StringValidator();
                throw new IllegalArgumentException("Nazwa nie może mieć wartości NULL");
            }
            if(isEmpty(value)) {
                instance = new StringValidator();
                throw new IllegalArgumentException("Nazwa produktu nie może być pusta");
            }
            return value != null && !value.isEmpty();

        }
    }

    public static class PriceValidator {
        private PriceValidator instance;
        private PriceValidator() {}
        public PriceValidator getInstance() {
            return instance;
        }

        public boolean isValid(float value) {
            if(value == 0) {
                instance = new PriceValidator();
                throw new IllegalArgumentException("Produkt nie może być darmowy");
            }
            if(value < 0) {
                instance = new PriceValidator();
                throw new IllegalArgumentException("Cena nie może być ujemna");
            }
            return value>=0;
        }
    }

    public static class CategoryValidator {
        private CategoryValidator instance;
        private CategoryValidator() {}
        public CategoryValidator getInstance() {
            return instance;
        }
        public boolean isValid(Category value) {
            if(value == null) {
                instance = new CategoryValidator();
                throw new IllegalArgumentException("Kategoria nie może mieć wartości null");
            }
            return value != null;

        }
    }

}
