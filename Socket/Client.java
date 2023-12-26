import java.net.*;
import  java.io.*;
public class Client {
    public static void main(String[] args)throws Exception {
        DatagramSocket ds = new DatagramSocket(4000);
        DatagramPacket dp;
        byte[] arr;
        System.out.println("Received Msg:");
        while(true){
            arr=new byte[65555];
            dp = new DatagramPacket(arr,arr.length);
            ds.receive(dp);
            String msg = new String(arr).trim();
            System.out.println(msg);
            if(msg.equalsIgnoreCase("exit")){
                ds.close();
                break;
            }
        }
    }
}
