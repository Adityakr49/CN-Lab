import java.net.*;
import java.io.*;
import java.nio.file.*;
public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket sersock = new ServerSocket(4000);
        System.out.println("Server Connected, waiting for client");
        Socket sock = sersock.accept();
        System.out.println("Connection successful, waiting for filename");
        BufferedReader nameRead = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        PrintWriter pwrite = new PrintWriter(sock.getOutputStream(), true);
        String fname = nameRead.readLine();
        Files.lines(Paths.get(fname)).forEach(pwrite::println);
        System.out.println("Closing connection");
        nameRead.close();
        sock.close();
        sersock.close();
    }
}
