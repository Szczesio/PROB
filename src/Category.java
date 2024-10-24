public class Category
{
    private String name = " ";

    public Category( String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category:" +
                "name='" + name + '\'';
    }

    public void setName(String name) {
        if(name != null && name.length() != 0) this.name = name;
    }

    public String getName() {
        return name;
    }
}
