import java.io.*;
import java.net.*;

public class Server {
    public static final int PORT = 50007;

    public static void main(String args[]) throws IOException {
        //tworzenie gniazda serwerowego
        ServerSocket serv;
        serv = new ServerSocket(PORT);

        //oczekiwanie na polaczenie i tworzenie gniazda sieciowego
        System.out.println("Nasluchuje: " + serv);
        Socket sock;
        sock = serv.accept();
        System.out.println("Jest polaczenie: " + sock);

                    //tworzenie strumieni danych pobieranych z klawiatury i dostarczanych do socketu
                    BufferedReader klaw;
                    klaw = new BufferedReader(new InputStreamReader(System.in));
                    PrintWriter outp;
                    outp = new PrintWriter(sock.getOutputStream());

        //tworzenie strumienia danych pobieranych z gniazda sieciowego
        BufferedReader inp;
        inp = new BufferedReader(new InputStreamReader(sock.getInputStream()));

        //komunikacja - czytanie danych ze strumienia
        String str;
        do {
            str = inp.readLine();
            System.out.println("<Nadeszlo:> " + str);

                    if(!str.equalsIgnoreCase("exit")) {
                        System.out.println("<Wysylamy:> ");
                        System.out.println("<Write EXIT to close connection>");
                        str = klaw.readLine();
                        outp.println(str);
                        outp.flush();
                    } else {
                        outp.println("exit");
                        outp.flush();
                    }

        }while(!str.equalsIgnoreCase("exit"));

        //zamykanie polaczenia

        inp.close();
        sock.close();
        serv.close();
    }
}