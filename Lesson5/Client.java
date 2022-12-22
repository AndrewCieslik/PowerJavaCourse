import java.io.*;
import java.net.*;

public class Client {
    public static final int PORT = 50007;
    public static final String HOST = "127.0.0.1";
    static String str;

    public static void main(String[] args) throws IOException {
        //nawiazanie polaczenia z serwerem

            Socket sock = null;
            try {
                sock = new Socket(HOST, PORT);

                System.out.println("Nawiazalem polaczenie: " + sock);
            } catch (ConnectException e){
                System.out.println("Polaczenie zostalo przerwane");
            } catch (SocketException e){
                System.out.println("Polaczenie zostalo przerwane");
            }

            //tworzenie strumieni danych pobieranych z klawiatury i dostarczanych do socketu
            BufferedReader klaw;
            klaw = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter outp;
            outp = new PrintWriter(sock.getOutputStream());

                    //tworzenie strumienia danych pobieranych z gniazda sieciowego
                    BufferedReader inp;
                    inp = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        do{
            //komunikacja - czytanie danych z klawiatury i przekazywanie ich do strumienia
            System.out.println("<Wysylamy:> ");
            System.out.println("<Write EXIT to close connection>");
            str = klaw.readLine();
            outp.println(str);
            outp.flush();

                    str = inp.readLine();
                    System.out.println("<Nadeszlo:> " + str);

        } while(!str.equalsIgnoreCase("exit"));
        //zamykanie polaczenia
        klaw.close();
        outp.close();
        sock.close();
    }
}