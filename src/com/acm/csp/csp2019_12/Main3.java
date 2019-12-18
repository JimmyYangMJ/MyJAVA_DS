// INFO BEGIN
//
// User = 201911502203(杨明杰) 
// Group = JAVA 
// Problem = 化学方程式 
// Language = JAVA 
// SubmitTime = 2019-12-15 16:49:01 
//
// INFO END

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main3 {

	static Scanner cin = new Scanner(System.in);
	
	public static void add(HashMap<String, Integer> hashMap, String string) {
		
		char[] s = string.toCharArray();
		for(int i =0; i < s.length; i++) {
			if(s[i] <= 'Z' && s[i] >= 'A') {
				String temp = "" + s[i];
				
				if(i+1  <s.length && s[i+1] <= 'z' && s[i+1] >= 'a') { // two
					temp = temp + s[i+1];
				}
				
				if(hashMap.containsKey(temp) == true){
					hashMap.put(temp, hashMap.get(temp)+1);
				}else {
					hashMap.put(temp, 1);
				}
			}
		}
	}
	public static boolean judge(HashMap<String, Integer> hashMapLeft, HashMap<String, Integer> hashMapRight) {
		Iterator<String> iter = hashMapLeft.keySet().iterator();
		if(hashMapLeft.size() != hashMapRight.size()) {
			return false;
		}
		while(iter.hasNext()) {
			String k = iter.next();
			
			if(hashMapRight.containsKey(k) == true 
					&& hashMapLeft.get(k) == hashMapRight.get(k)){
				
			}else{
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int num = 0;
		num = cin.nextInt();
		for(int i = 0; i < num; i++) {
			String string = cin.next();
			String[] item = string.split("=", 2);
			String left = item[0];
			String right = item[1];
			if(left.contains("+") == false && right.contains("+") == false){
				if(left.equals(right)){
					System.out.print("Y");
				}else{
					System.out.print("N");
				}
				if(i+1 < num){
					System.out.println();
				}
				continue;
			}
			HashMap<String, Integer> hashMapLeft = new HashMap<String,Integer>();
			HashMap<String, Integer> hashMapRight = new HashMap<String,Integer>();
			add(hashMapLeft, left);
			add(hashMapRight, right);
			if(judge(hashMapLeft, hashMapRight) == true){
				System.out.print("Y");
			}else{
				System.out.print("N");
			}
			if(i+1 < num){
				System.out.println();
			}
			
		}
		

	}

}
