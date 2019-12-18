// INFO BEGIN
//
// User = 201911502203(杨明杰) 
// Group = JAVA 
// Problem = 回收站选址 
// Language = JAVA 
// SubmitTime = 2019-12-15 14:21:50 
//
// INFO END

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main2 {

	static Scanner cin = new Scanner(System.in);
	static class Index{
		int x;
		int y;
		Index(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int hashCode() {
			return 1;
		}
		@Override
		public boolean equals(Object obj) {
			Index index = (Index) obj;
			if(this.x == index.x && this.y == index.y){
				return true;
			}else{
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
		HashSet<Index> hashSet = new HashSet<Index>();
		int num = cin.nextInt();
		for(int i = 0; i < num; i++) {
			int x, y;
			x = cin.nextInt();
			y = cin.nextInt();
			hashSet.add(new Index(x, y));
		}
		int[] rabbish = {0,0,0,0,0};
		Iterator<Index> iter = hashSet.iterator();
		while(iter.hasNext()) {
			Index temp = iter.next();
			int x = temp.x;
			int y = temp.y;
			if(hashSet.contains(new Index(x, y+1))
					&&hashSet.contains(new Index(x, y-1))
					&&hashSet.contains(new Index(x+1, y))
					&&hashSet.contains(new Index(x-1, y))) { // is station
				int score = 0;
				if(hashSet.contains(new Index(x+1, y+1))){
					score ++;
				}
				if(hashSet.contains(new Index(x+1, y-1))){
					score ++;
				}
				if(hashSet.contains(new Index(x-1, y+1))){
					score ++;
				}
				if(hashSet.contains(new Index(x-1, y-1))){
					score ++;
				}
				rabbish[score]++;
			}
		}
		for(int i = 0; i <= 4; i++){
			System.out.print(rabbish[i]);
			if(i != 4) {
				System.out.println();
			}
		}

	}

}
