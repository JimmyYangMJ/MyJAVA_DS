package com.acm.PTA;

import java.util.Scanner;
import java.util.Stack;

public class DFS_7_2 {

	public static Scanner cin = new Scanner(System.in);
	/**	 点数，边数， 起点*/
	private static int Nv, Ne, S;
	private static int[][] G;
	private static boolean[] visited;
	

	
	public static void DFSRecursion (int head, int[][] G) {
		
		visited[head] = true;
		System.out.print(head + " ");
		for(int i = 1; i <= Nv; i++) {
			if(visited[i] == false && G[i][head] == 1) {
				DFSRecursion(i, G);
			}
		}
	}
	
	public static void DFSUnRecursion (int head, int[][] G) {
		Stack<Integer> stack = new Stack<>();
		stack.push(head);
		/** 表示已经访问*/
		visited[head] = true; 
		System.out.print(head);
		while(!stack.isEmpty()) {
			for(int i = 1; i <= Nv; i++) {
				/** 没访问过，并且是邻接点 */
				if(visited[i] == false && G[i][head] == 1) {
					stack.push(i);
					visited[i] = true;
					System.out.print(" " + stack.peek());
					break;
				}
			}
			/** 一条路径已经结束*/
			if(head == stack.peek()) {
				stack.pop();
				if(!stack.isEmpty())
					System.out.print(" " + stack.peek());
			}else {
				head = stack.peek();
			}
		}
		
	}
	
 	public static int[][] BuildGraph(int[][] G){
		
		G = new int[Nv+1][Nv+1];
		/** 初始化*/
		for(int i = 1; i <= Nv; i++) {
			for(int j = 1; j <= Nv; j++) {
				G[i][j] = 0;
			}
		}
		
		for(int i = 1; i <= Ne; i++) {
			int a = cin.nextInt();
			int b = cin.nextInt();
			G[a][b] = 1;
			G[b][a] = 1; 
		}
		return G;
	}
	
	public static void main(String[] args) {
		
		Nv = cin.nextInt();
		Ne = cin.nextInt();
		S = cin.nextInt();
		visited = new boolean[Nv+1];
		for(int i = 1; i <= Nv; i++) {
			visited[i] = false;
		}
		/** 建立图*/
		G = BuildGraph(G);
		
		DFSUnRecursion(S, G);
		
		/** 判断图是否连通*/
		for(int i = 1; i <= Nv; i++) {
			if(visited[i] == false) {
				System.out.print(" " + 0);
				break;
			}	
		}
	}

}
