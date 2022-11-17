public class LiczbaZespolona {
    double czescRzecz;
    double czescUrojona;


LiczbaZespolona(double czescRzecz, double czescUrojona){
    this.czescRzecz = czescRzecz;
    this.czescUrojona = czescUrojona;
}

LiczbaZespolona dodaj(LiczbaZespolona liczba){
    return new LiczbaZespolona(czescRzecz + liczba.czescRzecz, czescUrojona + liczba.czescUrojona);
}

LiczbaZespolona minus(LiczbaZespolona liczba){
    return new LiczbaZespolona(czescRzecz - liczba.czescRzecz, czescUrojona - liczba.czescUrojona);
}

LiczbaZespolona mnozenie(LiczbaZespolona liczba){
    return new LiczbaZespolona((czescRzecz * liczba.czescRzecz) + (czescUrojona * liczba.czescUrojona* (-1)),
            (czescRzecz * liczba.czescUrojona) + (czescUrojona * liczba.czescRzecz));
}

LiczbaZespolona dzielenie(LiczbaZespolona liczba){
    LiczbaZespolona odwrotnosc = new LiczbaZespolona(liczba.czescRzecz, - liczba.czescUrojona);
    LiczbaZespolona dzielna = new LiczbaZespolona(czescRzecz, czescUrojona);
    return dzielna.mnozenie(odwrotnosc);
}

public String toString(){
    return "" + czescRzecz + "+ " + czescUrojona + "i";
}




}