import java.awt.Point;
import java.awt.Rectangle;
import java.io.*;


public class Power3 {     //lesson about Java libraries ready to use

    static double KURS = 3.8;

    public static void main(String[] args) {

        //3.2
        Rectangle obj = new Rectangle(0, 0, 4, 3);
        Rectangle obj2 = new Rectangle(1, 1, 4, 3);
        Rectangle obj3 = obj.intersection(obj2);
        obj.translate(1, -1);

        System.out.println(obj);
        System.out.println(obj2);
        System.out.println(obj3);

        //3.3
        Rectangle obj4 = new Rectangle(1, 1, 4, 5);
        Rectangle obj5 = new Rectangle(2, 0, 2, 3);

        System.out.println("Contains: " + obj4.contains(obj5));

        //3.4
        Rectangle obj6 = new Rectangle(-3, 0, 6, 3);
        System.out.println("Rectangle contains Point: " + obj6.contains(new Point(2, -1)));

        //3.5
        Rectangle obj7 = new Rectangle(1, 1, 4, 5);
        Rectangle obj8 = new Rectangle(4, -3, 4, 3);
        System.out.println("Intersects: " + obj7.intersects(obj8));

        //3.6

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String currency;
            // do {
            System.out.println("Choose currency EU, UAH, $");
            currency = br.readLine();
            // } while (!(currency.contains("EU") || currency.contains("$") || currency.contains("UAH")));

            System.out.print("Write value: ");
            String str = br.readLine();
            double x = Double.parseDouble(str);

            switch (currency) {
                case "EU":
                    System.out.println("EU: " + String.format("%.2f", x * 4.71));
                    break;
                case "UAH":
                    System.out.println("UAH: " + String.format("%.2f", x * 0.12));
                    break;
                case "$":
                    System.out.println("$: " + String.format("%.2f", x * 4.52));
                    break;
                default:
                    System.out.println("Wrong value");
            }
        } catch (IOException e1) {
            System.out.println("wyjatek operacji wejscia/wyjscia");
        } catch (NumberFormatException e2) {
            System.out.println("nieprawidlowy format liczby");
        }

        //3.7
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("imie: ");
            String imie = br.readLine();
            System.out.print("nazwisko: ");
            String nazwisko = br.readLine();

            PrintWriter plik1 = new PrintWriter(new BufferedWriter(new FileWriter("plik.txt", true)));
            plik1.println(imie + " " + nazwisko);
            plik1.close();
        } catch (Exception e) {
            System.out.println(e);
        }


        System.out.println("\n-- z pliku --");

        try {
            BufferedReader plik2 = new BufferedReader(new FileReader("plik.txt"));
            String str;

            while (plik2.ready()) {
                str = plik2.readLine();
                System.out.println(str);
            }

            plik2.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


