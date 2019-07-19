package com.ds.tree;

import com.ds.tree.Binarytree.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TraverseTree {

	// 先序遍历， 非递归
	// 利用堆栈
	public static void preOrderUnRecur(Node head) {
		System.out.print("先序 非递归: ");
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.push(head);
			while (!stack.isEmpty()) {
				head = stack.pop();
				System.out.print(head.data + " ");
				if (head.right != null) {   // 有右先压右
					stack.push(head.right);
				}
				if (head.left != null) {    // 有左后压左
					stack.push(head.left);
					
				}
			}
		}
		System.out.println();
	}
	
	// 层序遍历   非递归
	//利用队列
	public static void seqOrdUnRecur(Node head) {
		System.out.print("层序 非递归: ");
		if (head != null) {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(head);  // 
			while (!queue.isEmpty()) {  // 队列为空时，结束遍历
				head = queue.poll();  // 出队列
				System.out.print(head.data + " ");
				// 左右孩子分别入队列
				if(head.left != null) {  
					queue.add(head.left);  
				}
				if(head.right != null) {  
					queue.add(head.right);  
				}
			}
		}
		System.out.println();
	}
	
	// 先序遍历 递归
	public static void preOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.data + " ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}
	
	// 中序遍历 递归
	public static void inOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		inOrderRecur(head.left);
		System.out.print(head.data + " ");
		inOrderRecur(head.right);
	}

	// 后序遍历 递归
	public static void posOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.print(head.data + " ");
	}

}
