public enum Currency {
    PLN("Polski Złoty"), USD("Dolar Amerykański");
    private String name;

    private Currency(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
