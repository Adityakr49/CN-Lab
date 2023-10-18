import java.util.Scanner;
public class Prime{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no: ");
		int n = sc.nextInt();
		if(n<=1){
			System.out.println("Not a prime");
			System.exit(1);
		}
		int isP=1;
		for(int i=2;i<=n/2;i++)
			if(n%i==0) isP=0;
		if(isP==1) System.out.println("Prime No");
		else System.out.println("Not a prime no");
	}
}

