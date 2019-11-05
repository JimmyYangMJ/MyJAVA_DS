package com.ds.tree;

import com.ds.show.Tree;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;


public class Binarytree {

	final public static int max = 100;  // 最大结点数
	public static boolean flag = false;
	static Scanner cin = new Scanner(System.in);
	static Node tree = null;
	static int i = 0;
	// 树结点
	public static class Node {
		public int tem1,tem2;   /* 做打印使用 */
		
		public int data;
		public Node left ;   
		public Node right ;
		Node(int n) {
			this.data = n;
			this.left = null;
			this.right = null;
		}
		Node() {}  // 无参构造函数
	}
	
	// 哈夫曼树 结点 (静态链表)
	public static class HTNode {
		public int weight;
		public int parent;
		public int left ;   
		public int right ;
		HTNode(int n) {
			this.weight = n;
			this.parent = 0;
			this.left = 0;
			this.right = 0;
		}
		HTNode() {}  // 无参构造函数
	}
	
	//生成从m到n的随机整数[m,n]
	public static int MathRandom(int m, int n) {
		return m +(int)( Math.random()*(n - m + 1));  
	}
	
	//用于文件输出 查看
	public static void getWidth(Node Tree, int depth, int shift, char map[][]) {
		int i;

		if (Tree.left != null)
		{
			getWidth(Tree.left, depth+1, shift, map);
			Tree.tem1 = Tree.left.tem1 + Tree.left.tem2 + 1;
			for (i=(Tree.left.tem1+shift)*2; i<shift*2; i=i+2)
			{
				map[depth*2+1][i]='-';
				map[depth*2+1][i+1]='-';
				
			}
		}
		else Tree.tem1 = 0;
		if (Tree.right != null)
		{
			getWidth(Tree.right, depth+1, shift+Tree.tem1+1, map);
			Tree.tem2 = Tree.right.tem1 + Tree.right.tem2 + 1;
		}
		else Tree.tem2 = 0;

		for (i=shift*2; i<(Tree.tem1+shift)*2; i++)
			map[depth*2][i]=' ';
		
		map[depth*2][(Tree.tem1+shift)*2]=(char)(Tree.data / 1000 +48);
		map[depth*2][(Tree.tem1+shift)*2+1]=(char)(Tree.data / 100 % 10 +48);
		map[depth*2][(Tree.tem1+shift)*2+2]=(char)(Tree.data / 10 % 10 +48);
		map[depth*2][(Tree.tem1+shift)*2+3]=(char)(Tree.data %10 +48);
		if (Tree.data<1000)
		{
			map[depth*2][(Tree.tem1+shift)*2]=' ';
			if (Tree.data<100)
			{
				map[depth*2][(Tree.tem1+shift)*2+1]=map[depth*2][(Tree.tem1+shift)*2+2];
				map[depth*2][(Tree.tem1+shift)*2+2]=map[depth*2][(Tree.tem1+shift)*2+3];
				map[depth*2][(Tree.tem1+shift)*2+3]=' ';
				if (Tree.data<10)
					map[depth*2][(Tree.tem1+shift)*2+1]=' ';
			}
		}

		if (Tree.left != null)
		{
			map[depth*2+1][(Tree.left.tem1+shift)*2+1]=' ';
			map[depth*2+1][(Tree.left.tem1+shift)*2+2]='┌';
			map[depth*2+1][(Tree.tem1+shift)*2+1]='─';
			map[depth*2+1][(Tree.tem1+shift)*2+2]='┘';
			for (i=(Tree.left.tem1+shift)*2+3; i<(Tree.tem1+shift)*2; i=i+2)
			{
				map[depth*2+1][i]='─';
				map[depth*2+1][i+1]='─';
			}
		}
		if (Tree.right != null)
		{
			map[depth*2+1][(Tree.tem1+shift)*2+1]=' ';
			map[depth*2+1][(Tree.tem1+shift)*2+2]='└';
			map[depth*2+1][(Tree.tem1+Tree.right.tem1+shift)*2+3]='─';
			map[depth*2+1][(Tree.tem1+Tree.right.tem1+shift)*2+4]='┐';
			for (i=(Tree.tem1+shift)*2+3; i<(Tree.tem1+Tree.right.tem1+shift)*2+2; i=i+2)
			{
				map[depth*2+1][i]='─';
				map[depth*2+1][i+1]='─';
			}
		}
		if (Tree.left != null && Tree.right != null)
		{
			map[depth*2+1][(Tree.tem1+shift)*2+1]='─';
			map[depth*2+1][(Tree.tem1+shift)*2+2]='┴';
		}

	}
	
	// 打印根节点为Tree的子树
	public static void showBinTree(Node Tree) {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Map.txt")))) {

			//最多四位数
			char[][] map = new char[max*2][max*2];
			int i,j,k;
	
			if (Tree == null){
				bw.write("树为空");
				return;
			}
			for (i=0; i<max*2; i++)
				for (j=0; j<max*2; j++)
					map[i][j]=' ';
			getWidth(Tree,0,0,map);
			for (i=0; i<max*2; i++) {
				k=max*2-1; 
				while (k>=0 && map[i][k]==' ') {
					k--;
				}

				for (j=0; j<=k; j++) {
					bw.write(map[i][j]);
					//System.out.print(map[i][j]);
				}
					
				bw.newLine();
				//System.out.println();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("二叉树已经输出到文件");
	}
 	
//	// 创建一个给定的二叉树
//	public static void createTree(Node root) {
//		root = new Node(1);
//		root.left = new Node(2);
//		Node root1 = root.left;
//		root1.left = new Node(3);
//		root1.right = new Node(4);
//		Node root2 = root1.left;
//		root2.left = new Node(5);
//		Node root3 = root1.right;
//		root3.left = new Node(6);
//		Node root4 = root3.left;
//		root4.left = new Node(7);
//		root4.right = new Node(8);
//		Node root5 = root4.left;
//		root5.right = new Node(9);
//		Node root6 = root4.right;
//		root6.left = new Node(10);
//		showBinTree(root);
//
//	}
	
	// 自定义创建二叉树   先序创建二叉树
	public static Node CreateBiTree(Node T) {
		int ch;
		if(flag == false) {
			System.out.printf("输入根节点");
			flag = true;
		}
		ch = cin.nextInt();
		if (ch == -1) { // 没有儿子结点
			T = null;
		}else {
			T = new Node(ch); // 创建数据域为ch的结点
			System.out.printf("输入%d的左子节点：", ch);
			T.left = CreateBiTree(T.left);
			System.out.printf("输入%d的右子节点：", ch);
			T.right = CreateBiTree(T.right);
	    }
		return T;
		
	}
	
	// 随机创建一个大小为n 的二叉树 <核心函数>
	public static Node RandomCreate(int n) {
		int m;
		if(n == 0) { // n表示要创建子树的结点
			return null; // 空结点
		}
		Node p = new Node();
		// m +(int)( Math.random()*(n - m + 1));  //生成从m到n的随机整数[m,n]
		p.data = MathRandom(1, 999);
		m = MathRandom(1, 999) % n; 
		p.left = RandomCreate(m);  // 左边结点 数
		p.right = RandomCreate(n - 1 - m); // 右边结点 数
		return p;
	}
	
	// 叶子结点的数目(递归) <核心函数>
	public static int Leafcount(Node T,int num) {      //求二叉树叶子结点个数recursive
	  
		if(T != null){
			if(T.left == null &&T.right==null) {
				num++;  // 左右孩子都为空， 此节点为叶子结点
			}
			num = Leafcount(T.left, num);   // 左子树的叶子结点个数
			num = Leafcount(T.right, num);  // 右子树的叶子结点个数
		}
		return num;
	}
	
	// 显示树的深度  (递归)  <核心函数>
	public static int GetHeight(Node T) {
		int hl, hr, h;    // 左子树 树高， 右子树 树高， 
		if(T !=  null) {
			hl = GetHeight(T.left);   // 左子树 树高
			hr = GetHeight(T.right);  // 右子树 树高
			h = (hl > hr) ? hl : hr;  // 选择树高较高的那一个 作为子树根节点的深度
			return h+1;   // 根节点也算一层，  所以深度+1
		}else {
			return 0;
		}
	}
	
	// 交换左右子树  <核心函数> 
	public static Node swapLR(Node T){
		if(T == null) {
			return null; // 空树
		}else if(T.left == null && T.right == null) {  // 左右子树都为空，为叶子结点
			return T; //不需要交换
		}else {
			Node temp;
			temp = T.left;
			T.left = T.right;
			T.right = temp;     // 交换左右子树
			
			T.left = swapLR(T.left); // 递归处理左边
			T.right = swapLR(T.right); // 递归处理右边
		}
		return T;
	}

	/**
	 * 生成二叉排序树
	 * @param elem  根据随机数序列
	 * @param T  树根
	 * @return 生成的二叉排序树
	 */
	public static Node binarySortTree(int elem[], Node T) {

		T = null;    // 初始化为空的树  将elem数组的元素输出为二叉排序树
		for(int i = 0; i < elem.length; i++) {  // 依次插入到二叉排序树中
			T = insertSortTree(elem[i], T);
		}
		return T;
	}

	//二叉排序树 插入一个结点 <核心方法>
	public static Node insertSortTree(int key, Node T) {
	    if(T == null) {  // 根节点
	        T = new Node(key);
	        T.left = T.right = null; // 插入结点为叶子结点， 所以左右子树都为空
	    }else if(key < T.data) { //左
	    	T.left = insertSortTree(key, T.left);
	    }else if(key > T.data) { //右
	    	T.right = insertSortTree(key, T.right);
	    }
	    return T;  // 返回根节点
	}

	// 二叉排序树 删除一个结点   <核心方法>
	public static Node deleteSortTreeNode(int key, Node T) {

		Node temp;
		if(T == null) {  // 树为空
			System.out.printf("要删除的元素未找到\n");
			//return null;
		}else {
	        if( key < T.data )
	           T.left = deleteSortTreeNode(key , T.left);   // 从左子树递归删除
	        else if( key > T.data )
	            T.right = deleteSortTreeNode(key , T.right); // 从右子树递归删除
	        else { // T 就是要删除的结点
	            // 如果被删除结点有左右两个子结点
	            if( T.left != null && T.right != null) {
	                // 从右子树中找最小的元素填充删除结点
	            	temp = FindMin( T.right );
	                T.data = temp.data;
	                // 从右子树中递归删除最小元素
	                T.right= deleteSortTreeNode(T.data, T.right);
	            }
	            else { // 被删除结点有一个或无子结点
	                if( T.left  == null )       // 只有右孩子或无子结点
	                    T = T.right;
	                else                   // 只有左孩子
	                    T = T.left;
	            }
	        }
		}
		return T;  // 返回删除完成后子树的根结点
	}

	// 以T为根节点 ， 查找二叉排序子树中最小的结点
	public static Node FindMin(Node T) {
		if(T == null) {  // 子树为空结点
			return null;
		}else if(T.left != null) {  // 左子树不为空
			return FindMin(T.left);
		}else {  // 左子树为空
			return T;
		}

	}

	public static int count = 0; // 显示比较次数
	// 二叉排序树 查找一个结点  <核心方法>  返回查找元素 所在的结点， 显示比较次数
	public static Node FindSortTreeNode(int key, Node T) {

		if(T == null) {  // 树为空
			return null;
		}
		count++;  // 比较次数+1
		if(T.data > key){
			return FindSortTreeNode(key, T.left); // 在左子树中找
		}else if(T.data < key){
			return FindSortTreeNode(key, T.right); // 在右子树中找
		}else if(T.data == key){  // 找到
			return T;
		}

		return null;  // 没有找到
	}

	/**
	 * 还原二叉树 根据先序和后续恢复二叉树 <核心函数>
	 * @param pre  先序序列
	 * @param in   中序序列
	 * @param n  左子树结点数
	 * @param m  右子树结点数
	 * @return  树根结点（链式存储）
	 */
	public static Node preAndinRestoreBinTree(int pre[], int in[],int n,int m) {
		if(m - n + 1 <= 0) { // 空结点,(数组长度为长度为0)
			return null;
		}
		Node T = new Node();

		T.data = pre[i++];

		int index = 0;
		for(int k = n; k <= m; k++) {  // 找到先序中的根节点， 在中序中的位置
			if(in[k] == T.data) {
				index = k;
				break; 
			}
		}
		T.left = preAndinRestoreBinTree(pre, in, n, index-1);
		T.right = preAndinRestoreBinTree(pre, in, index+1, m);
		
		return T;
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {

		while(true) {
			int choice = -1;
			Tree.showMenu(); // 显示菜单
			choice = cin.nextInt();
			switch(choice) {
				case 1:  // 自定义生成二叉树
					System.out.println("输入-1表示 没有孩子对应的孩子结点（即为空）\n");
					tree = CreateBiTree(tree);
					System.out.println();
					showBinTree(tree) ; // 在文件中显示二叉树
					Tree.waitMe();
					break;
				case 2:  // 随机生成二叉树
					tree = Tree.CreateBiTreeRandom(tree);
					System.out.println();
					showBinTree(tree) ; // 在文件中显示二叉树
					Tree.waitMe();
					break;
				case 3:
					Tree.traverseTree(tree);  // 遍历二叉树
					break;
				case 4:
					Tree.contributeTreeShow(tree); // 显示 tree为树根的二叉树的叶子结点, 高度
					break;
				case 5:
					tree = swapLR(tree);  // 左右子树互换
					System.out.println("左右子树已经互换\n");
					showBinTree(tree) ; // 在文件中显示二叉树
					Tree.waitMe();
					break;
				case 6:  //生成二叉排序树
					tree = Tree.showSortTree(tree);
					break;
				case 7:  // 查找结点
					Tree.FindSortTreeNodeshow(tree);
					break;
				case 8:  // 删除结点
					tree = Tree.deleteSortTreeNodeshow(tree);
					// 更新为删除后的完全二叉树
					break;
				case 9:  // 哈夫曼树
					Tree.HuffmanShow();
					break;	
				case 10:  // 还原二叉树
					i = 0; // 初始化变量
					Tree.restoreBinTreeShow();
					break;	
				case 0:
					System.out.println("程序已退出");
					System.exit(0); // 退出程序
			}
		}
		
		//new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		
		
	}
	
	
}
