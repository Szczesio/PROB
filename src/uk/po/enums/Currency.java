package uk.po.enums;

public enum Currency {
    PLN("Polski Złoty"), USD("Dolar Amerykański");
    private String name;

    private Currency(String name)
    {
        setName(name);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean isEmpty() {
        return this == PLN || this == USD;
    }
}
