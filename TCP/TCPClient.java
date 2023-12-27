import java.net.*;
import java.io.*;
import java.util.*;
public class TCPClient {
    public static void main(String[] args) throws Exception {
        Socket clientSocket = new Socket("localhost", 4000);
        Scanner sc = new Scanner(System.in);
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();
        outToServer.writeBytes(fileName + '\n');
        String fileContent = inFromServer.readLine();
        System.out.println("Server response:\n" + fileContent);
        clientSocket.close();
    }
}
