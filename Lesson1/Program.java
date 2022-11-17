import static java.lang.Math.*;

class Punkt {
    double x;
    double y;

    Punkt(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void przesun(double dx, double dy) {
        x += dx;
        y += dy;
    }

    public String toString() {
        return "[x: " + x + ", y: " + y + "]";
    }
}

class Prostokat {
    double dlugosc;
    double szerokosc;
    Punkt wierzcholek;

    Prostokat(double dlugosc, double szerokosc) {
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
        this.wierzcholek = new Punkt(0, 0);
    }

    Prostokat(double dlugosc, double szerokosc, Punkt wierzcholek) {
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
        this.wierzcholek = wierzcholek;
    }

    public String toString() {
        return "[dl: " + dlugosc + ", sz: " + szerokosc + "]" + wierzcholek.toString();
    }

    double pole() {
        return dlugosc * szerokosc;
    }

    public void przesun(double dx, double dy) {
        wierzcholek.przesun(dx, dy);
    }

    boolean zawiera(Punkt punkt) {
        boolean contains;
        if (wierzcholek.x <= punkt.x && wierzcholek.x + dlugosc >= punkt.x && wierzcholek.y <= punkt.y && wierzcholek.y + szerokosc >= punkt.y) {
            System.out.println("Prostokat zawiera punkt");
            contains = true;
        } else {
            System.out.println("Prostokat nie zawiera punktu");
            contains = false;
        }
        return contains;
    }

    boolean przecina(Okrag okrag) {
        boolean isTrue;
        if (wierzcholek.x - okrag.promien <= okrag.srodek.x && wierzcholek.x + dlugosc + okrag.promien >= okrag.srodek.x
                && wierzcholek.y - okrag.promien <= okrag.srodek.y && wierzcholek.y + szerokosc >= okrag.srodek.y) {
            System.out.println("Prostokat przecina okrag");
            isTrue = true;
        } else {
            System.out.println("Figury nie przecinaja sie");
            isTrue = false;
        }
        return isTrue;
    }
}

class Okrag {
    double promien;
    Punkt srodek;

    Okrag() {
        this.promien = 0;
        this.srodek = new Punkt(0, 0);
    }

    Okrag(double promien, Punkt punkt) {
        this.promien = promien;
        this.srodek = punkt;
    }

    boolean zawiera(Punkt punkt) {
        double odlPuntuOdSrodkaOkr = sqrt(pow(abs(srodek.x - punkt.x), 2) + pow(abs(srodek.y - punkt.y), 2)); //Pitagoras
        if (promien < odlPuntuOdSrodkaOkr) {
            System.out.println("Okrag nie zawiera punktu");
        } else {
            System.out.println("Okrag zawiera punkt");
        }
        return promien >= odlPuntuOdSrodkaOkr;
    }

    boolean przecina(Okrag obj) {
        boolean isTrue;
        double odlDwochPunktow = sqrt(pow(obj.srodek.y - srodek.x, 2) + pow(obj.srodek.y - srodek.x, 2));
        if (abs(promien - obj.promien) < odlDwochPunktow && odlDwochPunktow < promien + obj.promien) {
            System.out.println("Okregi przecinaja sie");
            isTrue = true;
        } else {
            System.out.println("Okregi nie przecinaja sie");
            isTrue = false;
        }
        return isTrue;
    }
}

public class Program {
    public static void main(String[] args) {
        Punkt obj1;
        obj1 = new Punkt(-1, 1);
        System.out.println("punkt: " + obj1);

        obj1.przesun(10, 30);

        System.out.println("nowe wsp punktu: " + obj1);

        Prostokat obj2;
        obj2 = new Prostokat(3, 4, obj1);
        System.out.println("prostokat: " + obj2);

        obj2.przesun(5, 10);
        System.out.println("nowe wsp prostokata: " + obj2);

        double p = obj2.pole();
        System.out.println("pole: " + p);

        Okrag okr = new Okrag(10, new Punkt(5, 5));

        Punkt nowyPunkt = new Punkt(14, 44);
        okr.zawiera(nowyPunkt);

        obj2.zawiera(nowyPunkt);

        Okrag okrDuzy = new Okrag(10, new Punkt(0, 0));
        Okrag okrMaly = new Okrag(7, new Punkt(5, 5));
        okrDuzy.przecina(okrMaly);

        Prostokat nowyProstokat = new Prostokat(100, 100, new Punkt(0, 0));
        nowyProstokat.przecina(okrDuzy);

    }
}