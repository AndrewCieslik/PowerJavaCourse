import java.io.*;
import java.net.*;

public class Server {
    public static final int PORT = 50007;

    public static void main(String args[]) throws IOException {
        ServerSocket serv;
        serv = new ServerSocket(PORT);

        System.out.println("Nasluchuje: " + serv);
        Socket sock;
        sock = serv.accept();
        System.out.println("Jest polaczenie: " + sock);

                    BufferedReader klaw;
                    klaw = new BufferedReader(new InputStreamReader(System.in));
                    PrintWriter outp;
                    outp = new PrintWriter(sock.getOutputStream());

        BufferedReader inp;
        inp = new BufferedReader(new InputStreamReader(sock.getInputStream()));

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
        inp.close();
        sock.close();
        serv.close();
    }
}
