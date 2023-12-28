import java.net.*;
import java.io.*;
import java.util.*;
public class TCPClient {
    public static void main(String[] args) throws Exception {
        Socket clientSocket = new Socket("localhost", 4000);
        Scanner sc = new Scanner(System.in);
        Scanner in = new Scanner(new InputStreamReader(clientSocket.getInputStream()));
        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();
        out.writeBytes(fileName + '\n');
        String fileContent = in.nextLine();
        System.out.println("Server response:\n" + fileContent);
        clientSocket.close();
    }
}
