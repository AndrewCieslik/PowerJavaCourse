public class Power2 {
    public static void main(String[] args) {
        Ulamek liczba1 = new Ulamek(1, 2);
        Ulamek liczba2 = new Ulamek(2, 3);
        Ulamek liczba3 = liczba1.dodaj(liczba2);
        Ulamek liczba4 = liczba1.minus(liczba2);
        Ulamek liczba5 = liczba1.mnozenie(liczba2);
        Ulamek liczba6 = liczba1.obroc();
        Ulamek liczba7 = new Ulamek(27,9);
        Ulamek liczba8 = liczba7.skrocic();

        System.out.println(liczba3);
        System.out.println(liczba4);
        System.out.println(liczba5);
        System.out.println(liczba6);
        System.out.println(liczba8);
        System.out.println(liczba8.rozwDziesietne());

        LiczbaZespolona lz1 = new LiczbaZespolona(3,5);
        LiczbaZespolona lz2 = new LiczbaZespolona(7,11);
        LiczbaZespolona lz3 = lz1.dodaj(lz2);
        LiczbaZespolona lz4 = lz1.mnozenie(lz2);

        System.out.println(lz3);
        System.out.println(lz4);
    }
}
