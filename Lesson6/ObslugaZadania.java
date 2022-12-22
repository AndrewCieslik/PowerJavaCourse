import java.io.*;
import java.net.Socket;

class ObslugaZadania extends Thread {
    Socket sock;

    ObslugaZadania(Socket clientSocket) {
        this.sock = clientSocket;
    }

    public void run() {

        //strumienie danych
        InputStream is = null;
        OutputStream os = null;

        try {
            is = sock.getInputStream();
            os = sock.getOutputStream();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedReader inp = new BufferedReader(new InputStreamReader(is));
        DataOutputStream outp = new DataOutputStream(os);

        try {
            //przyjecie zadania (request)
            String request = inp.readLine();
            //6.2
            System.out.println(request);

            //6.3 wyselekcjonowanie nazwy katalogu
            String[] katalog = request.split(" ");
            System.out.println("Plik: " + katalog[1]);
            //usuniecie "/" z nazwy:
            String plik = katalog[1].substring(1);
            System.out.println("Skrocona nazwa: " + plik);

            //szukanie pliku na serwerze i buforowanie danych przed wysłaniem
            // response
            outp.writeBytes("HTTP/1.0 200 OK\r\n");
            outp.writeBytes("Content-Type: text/html\r\n");

            outp.writeBytes("Content-Length: \r\n");
            outp.writeBytes("\r\n");

            //response body
            FileInputStream fis = new FileInputStream(plik);

            byte[] bufor;
            bufor = new byte[1024];
            int n = 0;

            while ((n = fis.read(bufor)) != -1) {
                outp.write(bufor, 0, n);
            }

        } catch (FileNotFoundException e) {

            //response header
            try {
                outp.writeBytes("HTTP/1.0 200 OK\r\n");
                outp.writeBytes("Content-Type: text/html\r\n");
                outp.writeBytes("Content-Length: \r\n");
                outp.writeBytes("\r\n");

                //response body
                outp.writeBytes("<html>\r\n");
                outp.writeBytes("<H1>Blad 404 Strona nie istnieje</H1>\r\n");
                outp.writeBytes("</html>\r\n");


            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //zamykanie strumieni
        try {
            inp.close();
            outp.close();
            sock.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}