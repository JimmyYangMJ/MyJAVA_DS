// INFO BEGIN
//
// User = 201910005304(杨明杰) 
// Group = JAVA 
// Problem = 推荐系统 
// Language = JAVA 
// SubmitTime = 2019-09-15 17:21:17 
//
// INFO END

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Main4 {
	/** m 类   n 个*/
	static int m, n;
	static Scanner cin = new Scanner(System.in);
	
	static class Type {
		HashMap<Integer, Integer> id = new HashMap<>();
		
	}
	public static void main(String[] args) {
		m = cin.nextInt();
		n = cin.nextInt();
		Type[] type = new Type[m];
		for(int i = 0; i < m; i++){
			type[i] = new Type();
		}
		for(int i = 1; i <= n; i++){
			int id = cin.nextInt();
			int score = cin.nextInt();
			for(int j = 0; j < m; j++){
				type[j].id.put(id, score);
			}
		}
		int op = cin.nextInt();
		for(int i = 0; i < op; i++){
			int choice = cin.nextInt();
			int a, b ,c;
			if(choice == 1){  // 增加
				a = cin.nextInt();
				b = cin.nextInt();
				c = cin.nextInt();
				type[a].id.put(b, c);
			}else if(choice == 2){ // 删除
				a = cin.nextInt();
				b = cin.nextInt();
				type[a].id.remove(b);
			}else if(choice == 3){ // 查询
				int sum = cin.nextInt(); // 个数
				int[]maxNum = new int[m];
				int sum2 = 0;
				for(int j = 0; j < m; j++){
					int temp = cin.nextInt();
					sum2 += temp;
					maxNum[j] = temp;
				}
				if(sum2 <= sum){
					for(int k = 0; k < m; k++){
						int[] pp = new int[type[k].id.size()];
						Arrays.fill(pp, -1);
						for(int l = 0; l < maxNum[k]; l++){
							int maxv = 0;
							int maxk = 0;
							for(Map.Entry<Integer, Integer> entry : type[k].id.entrySet()){
								Integer v = entry.getValue();
								Integer kk = entry.getKey();
								if(v > maxv){
									int sd = 1;
									for(int tempp : pp){
										if(kk == tempp){
											sd = 0;
										}
									}
									if(sd == 1){
										maxv = v;
										maxk = kk;
									}
									
								}
							}
							System.out.print(maxk + " ");
							pp[l] = maxk;
							
						}
						System.out.println();
					}
				}else{
					System.out.println(-1);
				}
				
			}
		}
		

	}

}
