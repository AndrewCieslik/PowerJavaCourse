public class Ulamek {
    int licznik;
    int mianownik;

    Ulamek(int licznik, int mianownik){
        this.licznik = licznik;
        this.mianownik = mianownik;
    }

    Ulamek dodaj(Ulamek y){
        int iloczynMianownika = mianownik * y.mianownik;
        int licznik = this.licznik*y.mianownik + y.licznik*this.mianownik;
        return new Ulamek(licznik,iloczynMianownika);
    }

    Ulamek minus(Ulamek y){
        int iloczynMianownika = mianownik * y.mianownik;
        int licznik = this.licznik*y.mianownik - y.licznik*this.mianownik;
        return new Ulamek(licznik,iloczynMianownika);
    }

    Ulamek mnozenie(Ulamek y){
        int iloczynMianownika = mianownik * y.mianownik;
        int licznik = this.licznik*y.licznik;
        return new Ulamek(licznik,iloczynMianownika);
    }

    Ulamek obroc(){
        return new Ulamek(mianownik,licznik);
    }

    int gcd(int a, int b)  //greatest common divisor
    {
        if (a == 0) {
            return b;
        } else {
            return gcd(b % a, a);
        }
    }

    Ulamek skrocic(){
        int x = licznik/gcd(licznik,mianownik);
        int y = mianownik/gcd(licznik,mianownik);
        return new Ulamek(x,y);
    }

    double rozwDziesietne(){
        return (double)licznik / mianownik;
    }

    public String toString(){
        return "" + licznik + "/ " + mianownik;
    }
}
