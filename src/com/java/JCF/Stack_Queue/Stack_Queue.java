package com.java.JCF.Stack_Queue;

import java.util.*;

public class Stack_Queue {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack();
		stack.push(2);
		System.out.println(stack.peek());

		Queue<Integer> queue =  new LinkedList<Integer>();
		queue.add(2); // 添加失败会有异常
		queue.offer(3); // 推荐使用,返回boolean变量
		queue.poll(); // 出队
		queue.peek();
	}

}
