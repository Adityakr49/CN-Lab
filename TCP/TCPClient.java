import java.net.*;
import java.io.*;

public class TCPClient {
    public static void main(String[] args) throws Exception {
        final String SERVER_IP = "localhost";
        final int SERVER_PORT = 4000;

        try {
            Socket clientSocket = new Socket(SERVER_IP, SERVER_PORT);

            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

            System.out.print("Enter file name: ");
            String fileName = inFromUser.readLine();

            outToServer.writeBytes(fileName + '\n');

            String fileContent = inFromServer.readLine();
            System.out.println("Server response:\n" + fileContent);

            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
