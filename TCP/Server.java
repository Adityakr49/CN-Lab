import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket sersock = new ServerSocket(4000);
        System.out.println("Server Connected, waiting for client");
        Socket sock = sersock.accept();
        System.out.println("Connection successful, waiting for filename");
        BufferedReader nameRead = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        PrintWriter pwrite = new PrintWriter(sock.getOutputStream(), true);
        String fname = nameRead.readLine();
        BufferedReader contentRead = new BufferedReader(new FileReader(fname));
        String str;
        while ((str = contentRead.readLine()) != null) {
            pwrite.println(str);
        }
        contentRead.close();
        System.out.println("Closing connection");
        pwrite.close();
        nameRead.close();
        sock.close();
        sersock.close();
    }
 }
