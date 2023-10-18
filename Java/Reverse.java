import java.util.Scanner;
public class Reverse{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the no: ");
		int n = sc.nextInt();
		int temp = n,rem,nn=0;
		while(temp>0){
			rem = temp % 10;
			nn = nn * 10 + rem;
			temp = temp / 10;
		}
		System.out.println("Reverse: "+nn);
	}
}

