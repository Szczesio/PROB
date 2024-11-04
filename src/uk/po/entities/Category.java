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
        if(name != null && name.length() != 0) this.name = name;
    }

    public String getName() {
        return name;
    }
}
