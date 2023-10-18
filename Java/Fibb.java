import java.util.Scanner;
public class Fibb{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Number: ");
		int n = sc.nextInt();
		int a = 0, b = 1, c;
		if(n<=0){
			System.out.println("Invalid range");
			System.exit(0);
		}
		System.out.println("First "+n+" Fibonacci no are:");
		if(n==1){
			System.out.println(a);
		}
		else if(n==2){
			System.out.println(a+" "+b+" ");
		}
		else{
			System.out.print(a+" "+b+" ");
			for(int i=2;i<n;i++){
				c = a + b;
				System.out.print(c+" ");
				a = b;
				b = c;
			}
			System.out.println();
		}
	}
}

