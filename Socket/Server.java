import java.net.*;
import java.io.*;
import java.util.Scanner;
public class Server {
    public static void main(String[] args)throws Exception {
        DatagramSocket ds = new DatagramSocket();
        InetAddress clientAdd = InetAddress.getByName("127.0.0.1");
        Scanner sc = new Scanner(System.in);
        String msg;
        byte[] arr;
        DatagramPacket dp;
        System.out.println("Enter the message to send");
        while(true){
            msg = sc.nextLine();
            arr = msg.getBytes();
            dp = new DatagramPacket(arr,arr.length,clientAdd,4000);
            ds.send(dp);
            if(msg.equalsIgnoreCase("exit")){
                ds.close();
                break;
            }
        }
    }
}
