import java.util.Scanner;
public class Ascii{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a character: ");
		char ch = sc.next().charAt(0);
		int ascii = (int) ch;
		System.out.println("The Ascii value of "+ch+" is "+ascii);	
	}
}

