import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
class Packet{
	int Seqno;
	String data;
	public Packet(int Seqno, String data){
		this.Seqno = Seqno;
		this.data = data;
	}
}
public class FrameSort{
	private static final int Fsize = 3;
	public static Packet[] divide(String msg){
		int msglen = msg.length();
		int noofpacket = (int)Math.ceil((double)msglen/Fsize);
		Packet[] readdata = new Packet[noofpacket];
		for(int i = 0,j = 0;i<noofpacket;i++){
			int end = Math.min(j+Fsize,msglen);
			readdata[i] = new Packet(i+1,msg.substring(j,end));
			j+=Fsize;
		}
		return readdata;
	}
	public static Packet[] Shuffle(Packet[] readdata){
		Random rand = new Random();
		Packet[] transdata = Arrays.copyOf(readdata,readdata.length);
		for(int i = 0; i < transdata.length ; i++){
			int trans = rand.nextInt(transdata.length);
			Packet temp = transdata[i];
			transdata[i] = transdata[trans];
			transdata[trans] = temp;
		}
		return transdata;
	}
	public static void Bubblesort(Packet[] transdata){
		int n = transdata.length;
		boolean swapped;
		do{
			swapped = false;
			for(int i =1;i<n;i++){
				if(transdata[i-1].Seqno>transdata[i].Seqno){
					Packet temp = transdata[i-1];
					transdata[i-1] = transdata[i];
					transdata[i] = temp;
					swapped = true;
				}
			}
			n--;
		}while(swapped);
	}
	public static void receive(Packet[] transdata){
		System.out.println("Packet received in following order\n");
		for(Packet packet:transdata){
			System.out.println(packet.data);
		}

		System.out.println("Packet in order before sorting\n");
                for(Packet packet:transdata){
                        System.out.printf("%d\n",packet.Seqno);
                }


		Bubblesort(transdata);

		System.out.println("Packet in order after sorting\n");
		for(Packet packet:transdata){
                        System.out.printf("%d\n",packet.Seqno);
                }

		System.out.println("Message received");
                for(Packet packet:transdata){
                        System.out.println(packet.data);
                }

	}
	public static void main(String[] args){
		String msg;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the msg to be transmitted");
		msg = sc.nextLine();
		Packet[] readdata = divide(msg);
		Packet[] transdata = Shuffle(readdata);
		receive(transdata);
		sc.close();
	}
}

