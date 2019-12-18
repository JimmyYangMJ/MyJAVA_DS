// INFO BEGIN
//
// User = 201911502203(ÑîÃ÷½Ü) 
// Group = JAVA 
// Problem = Ä§Êý 
// Language = JAVA 
// SubmitTime = 2019-12-15 15:46:35 
//
// INFO END

import java.math.BigInteger;
import java.util.Scanner;

public class Main5 {

	static Scanner cin = new Scanner(System.in);
	
	public static void main(String[] args) {
		BigInteger[] u = {new BigInteger("314882150829468584"),
				new BigInteger("427197303358170108"),
				new BigInteger("1022292690726729920"),
				new BigInteger("1698479428772363217"),
				new BigInteger("2006101093849356424")};
		
		BigInteger a = new BigInteger("2009731336725594113");
		BigInteger m = new BigInteger("2019");
		
		int n, q;
		n= cin.nextInt();
		q =cin.nextInt();
		BigInteger[] A = new BigInteger[n+1];
		for(int i = 1; i <= n; i++) {
			A[i] = new BigInteger(String.valueOf(i));
		}
		for(int i = 0; i < q; i++) {
			int l, r;
			l = cin.nextInt();
			r = cin.nextInt();
			int s = 0;
			for(int j =l; j <= r; j++) {
				//BigInteger temp = new BigInteger(A[j].toString());
				s += A[j].mod(a).mod(m).intValue();
			}
			System.out.print(s);
			int t = 0;
			t = s % 5;
			for(int j =l; j <= r; j++) {
				A[j] = A[j].multiply(u[t]);
			}
			if(i+1 < q){
				System.out.println();
			}
		}

	}

}
