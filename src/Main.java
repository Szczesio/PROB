public class Main
{

    public static void main (String[] args)
    {
        Category c = new Category("1");
        System.out.println("Kategoria 1 utworzona konstruktorem: " + c);
        System.out.println("Nazwa kategorii: " + c.getName());
        System.out.println("Nazwa kategorii: '1' zostaje zmieniona na '2' ");
        c.setName("2");
        System.out.println("Wyświetlanie kategorii po zmianie nazwy: " + c);
    }


}
