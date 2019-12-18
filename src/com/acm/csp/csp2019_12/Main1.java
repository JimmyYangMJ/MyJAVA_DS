// INFO BEGIN
//
// User = 201911502203(ÑîÃ÷½Ü) 
// Group = JAVA 
// Problem = ±¨Êı 
// Language = JAVA 
// SubmitTime = 2019-12-15 13:43:03 
//
// INFO END

import java.util.Scanner;

public class Main1 {

	static Scanner cin = new Scanner(System.in);
	
	public static boolean isSeven(int k) {
		
		String a = Integer.toString(k);
		if(k%7 == 0){
			return true;
		}else if(a.contains("7") == true){
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args) {
		int[] count = {0,0,0,0};
		int num = cin.nextInt();
		int k = 1;
		while(num>0) {
			if(isSeven(k) == true){
				int index = (k-1)%4;
				count[index] ++;
			}else{
				num--;
			}
			k++;
		}
		System.out.println(count[0]);
		System.out.println(count[1]);
		System.out.println(count[2]);
		System.out.print(count[3]);

	}

}
