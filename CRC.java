import java.util.Scanner;
class CRC{
	static String CRC(String data,String poly,boolean errchk){
		String rem = data;
		if(!errchk){
			for(int i=0;i<poly.length()-1;i++){
				rem += "0";
			}
		}
		for(int i=0;i<rem.length()-poly.length()+1;i++){
			if(rem.charAt(i)=='1'){
				for(int j=0;j<poly.length();j++){
					char x = rem.charAt(i+j)==poly.charAt(j)?'0':'1';
					rem = rem.substring(0,i+j)+x+rem.substring(i+j+1);
				}
			}
		}
		return rem.substring(rem.length()-poly.length()+1);
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String data;
		String poly = "10000100010001010";
		System.out.println("Enter data to be sent");
		data=sc.nextLine();
		String rem = CRC(data,poly,false);
		String codeword = data+rem;
		System.out.println("Remainder:"+rem);
		System.out.println("Codeword:"+codeword);
		String recvCodeword;
		System.out.println("Enter received codeword:");
		recvCodeword = sc.nextLine();
		String recvRem = CRC(recvCodeword,poly,true);
		if(Integer.parseInt(recvRem)==0){
			System.out.println("No error");
		}else{
			System.out.println("Error Detected");
		}
		sc.close();
	}
}

