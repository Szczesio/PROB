package uk.po.entities;

public class Category
{
    private String name = " ";

    private Category( String name) {
        try {
            setName(name);
            } catch (Exception e) {
            name = null;
            throw new RuntimeException(e);
        }
    }

    public static Category from(String name)
    {
        return new Category(name);
    }


    @Override
    public String toString() {
        return "uk.po.entities.Category:" +
                "name='" + name + '\'';
    }

    public void setName(String name) {
        // if(name != null && name.length() != 0) this.name = name;
        try{
            this.name = name;
        }catch(IllegalArgumentException e)
        {
            if(name == null) System.out.println("Argument nie może mieć wartości NULL");
            if(name.isEmpty()) System.out.println("Argument nie może być pusty");
        }
    }

    public String getName() {
        return name;
    }

    public static class StringValidator {
        private  StringValidator instance;
        private StringValidator() {}
        public  StringValidator getInstance() {
            return instance;
        }
        public boolean isEmpty(String value) {
            return value.length() == 0;
        }

        public boolean isValid(String value) {
            if(instance == null) {
                instance = new StringValidator();
                throw new IllegalArgumentException("Argument nie może mieć wartości NULL");
            }
            if(isEmpty(value)) {
                instance = new StringValidator();
                throw new IllegalArgumentException("Argument nie może być pusty");
            }
            return value != null && !value.isEmpty();

        }
    }

}
