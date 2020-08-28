package com.acm.ds.show;

import com.acm.ds.tree.Binarytree;
import com.acm.ds.tree.Binarytree.Node;
import com.acm.ds.tree.HuffmanTree;
import com.acm.ds.tree.TraverseTree;

import java.util.Scanner;


public class Tree {
	static Scanner cin = new Scanner(System.in);
	static boolean flag = false;
	static int i = 0;
	//等待函数
	public static void waitMe() {
		System.out.printf("\n请按输入任意字符继续\n");
		char a = cin.next().charAt(0);  // 输入一个字符
	}
	
	//功能菜单
	public static void showMenu() {
		System.out.printf("\n=============================================\n");
		System.out.printf("\n\n    学号: 20171112819     姓名：杨明杰          \n");
		System.out.printf("\t             二叉树操作  \n");
		System.out.printf("\t======================================");
		System.out.printf("\n\n");
		System.out.printf("\t             1： 自定义创建二叉树         \n");    // 完成
		System.out.printf("\t             2： 随机创建二叉树         \n");    
		
//		2、用递归方法分别先序、中序、后序遍历以Tree为根指针的二叉树。
		System.out.printf("\t             3： 遍历二叉树         \n");    // 完成
		
//		3、编写递归算法，计算二叉树中叶子结点的数目。
//		4、编写递归算法，计算二叉树的深度。
		System.out.printf("\t             4： 二叉树属性         \n");
		
//      5、编写递归算法，将二叉树中所有结点的左、右子树相互交换。
		System.out.printf("\t             5： 左右子树互换      \n");  
		
//		6、使用数组elem中的随机数序列（以0表示结束，不包括0），生成以Tree为根指针的二叉排序树。
		System.out.printf("\t             6：生成二叉排序树         \n"); 
		
//		7、在以Tree为根指针的二叉排序树中查找结点。
		System.out.printf("\t             7：排序树查找结点         \n");
		
//		8、从以Tree为根指针的二叉排序树中删除结点（适用各种位置的结点）。		
		System.out.printf("\t             8：排序树删除结点         \n");
		
//		11、根据Huffman编码原理，使用数组elem中的随机数序列（以0表示结束，不包括0）
//		作为结点的权重，生成赫夫曼树，以及赫夫曼编码，计算平均带权径长度。		
		System.out.printf("\t             9：创建哈夫曼树             \n");
//		 12、（1）随机生成二叉树。 （2）生成并保存先（后）序、中序输出序列。 
//		 （3）按照保存的一对输出序列恢复出二叉树。（4）生成先（后）序输出序列。		
		System.out.printf("\t             10：还原二叉树             \n");
		
		System.out.printf("\n");
		System.out.printf("\t             0：退出         \n");
		System.out.printf("\n");
		System.out.printf("\t请选择：");
	}

	/**
	 * 输入结点数提示语句
	 * @return 结点数
	 */
	public static int createNodeShow(){
		int n;
		while(true) {
			System.out.printf("输入要生成二叉树的结点数（数据个数）： ");
			n = cin.nextInt();
			if(Binarytree.max < n) {
				System.out.printf("输入数据太大，请重新输入 ");
			}else {
				return n;
			}
		}
	}

	// 随机创建二叉树  （先序）
	public static Node CreateBiTreeRandom(Node T) {

		int n = createNodeShow();  // 输入n
		T = Binarytree.RandomCreate(n); // 创建n个结点的二叉树
		return T;
	}
	
	// 遍历选择  界面显示 
	public static void traverseTree(Node head) {
		int choice = 0;
		System.out.printf("1. 先序遍历 \n");
		System.out.printf("2. 中序遍历 \n");
		System.out.printf("3. 后序遍历 \n");
		System.out.printf("4. 先序遍历(非递归)\n");
		System.out.printf("5. 层序遍历(非递归)\n");
		while(true) {
			System.out.printf("请输入要选择的遍历方式, 输入-1 结束： ");
			choice = cin.nextInt();
			if(choice == 1) {
				System.out.printf("==先序遍历 ：");
				TraverseTree.preOrderRecur(head);  // 先序遍历
				System.out.println();
			}else if(choice == 2) {
				System.out.printf("==中序遍历 ：");
				TraverseTree.inOrderRecur(head);  // 中序遍历
				System.out.println();
			}else if(choice == 3) {
				System.out.printf("==后序遍历 ：");
				TraverseTree.posOrderRecur(head);  // 后序遍历
				System.out.println();
			}else if(choice == 4) {
				System.out.printf("==先序遍历(非递归) ：");
				TraverseTree.preOrderUnRecur(head);  // 先序遍历非递归
				System.out.println();
			}else if(choice == 5) {
				System.out.printf("==层序遍历 ：");
				TraverseTree.seqOrdUnRecur(head);  // 层序遍历
				System.out.println();
			}else {
				System.out.printf("遍历结束 \n");
				break;
			}
		}
		
		
	}
	
	// 树的深度  界面显示
	public static void showHeight(Node T) {
		int num = 0; // 叶子结点的个数
		num = Binarytree.GetHeight(T);
		Binarytree.showBinTree(T) ;
		System.out.printf("显示二叉树的深度： %d\n", num);
		System.out.printf("==============================\n");
	}
	
	// 叶子结点 界面显示
	public static void showLeft(Node T) {
		int num = 0; // 叶子结点的个数
		num = Binarytree.Leafcount(T, num);
		Binarytree.showBinTree(T) ;
		System.out.printf("显示叶子结点的数目： %d\n", num);
		System.out.printf("==============================\n");
	}
	
	// 树的属性  界面显示
	public static void contributeTreeShow(Node T) {
		int choice = 0;
		System.out.printf("1. 叶子结点 \n");
		System.out.printf("2. 二叉树深度 \n");
		System.out.printf("请输入要选择的二叉树的属性, 输入-1 结束： ");
		while(true) {
			choice = cin.nextInt();
			if(choice == 1) {
				System.out.printf("叶子== ：");
				showLeft(T);     // 二叉树深度遍历
				System.out.println();
			}else if(choice == 2) {
				System.out.printf("深度== ：");
				Tree.showHeight(T);    // 二叉树树深度
				System.out.println();
			}else {
				System.out.printf("结束 \n");
				break;
			}
		}
	}

	/**
	 * 生成长度为n的随机数序列
	 * @param n  长度
	 */
	public static int[] createRandomArg(int n){
		int[] elem = new int[n];
		// m +(int)( Math.random()*(n - m + 1));  //生成从m到n的随机整数[m,n]
		for(int i = 0; i < n; i++) {
			elem[i] = 1 +(int)( Math.random()*(999 )); //生成从 1到 999 的随机整数
		}
		return elem;
	}
	public static int[] createElemShow(){
		System.out.printf("请输入随机数序列大小： ");
		int num = cin.nextInt();
		int []elem = createRandomArg(num);
		System.out.printf("生成的随机数序列为：\n");
		for(int i = 0; i < num; i++) {
			System.out.printf("%d ", elem[i]);
		}
		return elem;
	}


	// 生成以Tree为根指针的二叉排序树。
	public static Node showSortTree(Node T) {
		int []elem = createElemShow();
		T = Binarytree.binarySortTree(elem, T);  // 调用核心方法
		Binarytree.showBinTree(T);
		Tree.waitMe();
		return T;
	}

	// 二叉排序树 查找  显示
	public static void FindSortTreeNodeshow(Node T) {
		int key = 0;
		System.out.printf("原始二叉排序树 中序遍历为：");
		TraverseTree.inOrderRecur(T);
		System.out.println();

		System.out.printf("请输入要查找的结点");
		key = cin.nextInt();

		Node temp = null;
		temp = Binarytree.FindSortTreeNode(key, T);  // 进入 <核心函数>
		if(temp == null) {
			System.out.printf("没有要查找的元素");
		}else {
			System.out.printf("查找的元素为：%d，比较次数 %d ===", temp.data, Binarytree.count);
			Binarytree.count = 0; // 比较次数清零
			if(temp.left != null) {
				System.out.printf("查找的元素左孩子： %d ===", temp.left.data);
			}else {
				System.out.printf("查找的元素左孩子： 为空 ===");
			}

			if(temp.right != null) {
				System.out.printf("右孩子： %d", temp.right.data);
			}else {
				System.out.printf("右孩子： 为空");
			}
		}
		System.out.println();

	}

	// 二叉排序树 删除
	public static Node deleteSortTreeNodeshow(Node T) {
		int key = 0;
		System.out.printf("原始二叉排序树 中序遍历为：");
		TraverseTree.inOrderRecur(T);
		System.out.println();
		
		System.out.printf("请输入要删除的结点");
		key = cin.nextInt();
		
		T = Binarytree.deleteSortTreeNode(key, T);  // 进入核心函数
		
		System.out.printf("删除后二叉排序树 中序遍历为：");
		TraverseTree.inOrderRecur(T);
		System.out.println();
		Binarytree.showBinTree(T);  // 删除后的二叉排序树 打印到文件中
		System.out.println();
		
		return T;  // 返回删除后的根节点
	}

	// 哈夫曼树 显示
	public static void HuffmanShow() {

		int []elem = createElemShow(); // 创建随机数组
		HuffmanTree.Huffman(elem);
		waitMe();
	}

	// 还原二叉树 显示
	public static void restoreBinTreeShow() {
		int n = createNodeShow();

		Node T = null; // 随机创建二叉树
		T = Binarytree.RandomCreate(n); // 创建n个结点的二叉树
		Binarytree.showBinTree(T);
		waitMe();
		/**************将遍历信息保存在数组中****************/
		System.out.println("先序遍历");
		int []preArray = new int[n];
		i = 0;
		preOrderRecur(preArray, T);  // 先序遍历   遍历结果保存在数组中
		System.out.println();

		System.out.println("中序遍历");
		int []inArray = new int[n];
		i = 0;
		inOrderRecur(inArray, T);  // 中序遍历
		System.out.println();

		System.out.println("后续遍历");
		int []posArray = new int[n];
		i = 0;
		posOrderRecur(posArray, T);  // 后序遍历
		System.out.println();

		System.out.println("===遍历信息 已经通过数组保存===");
		/****************************************/
		System.out.printf("\n先序遍历\n");
		for(int i = 0; i < n; i++) {
			System.out.printf("%d ", preArray[i]);
		}
		System.out.printf("\n中序遍历\n");
		for(int i = 0; i < n; i++) {   //中序
			System.out.printf("%d ", inArray[i]);
		}
		System.out.println();

		Node B = null;  //  还原的二叉树
		i= 0;
		B = Binarytree.preAndinRestoreBinTree(preArray, inArray, 0, n-1) ;//  先序，后续 创建  <核心方法>
		Binarytree.flag = false;
		System.out.printf("\n通过先序和后序 还原后的二叉树=========");

		System.out.printf("\n后续遍历\n");
		TraverseTree.posOrderRecur(B);
		
		System.out.printf("还原的二叉树已经输出到文件");
		Binarytree.showBinTree(B);
		waitMe();
	}
	
	// 先序遍历 递归  保存在数组
	public static void preOrderRecur(int a[], Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.data + " ");
		a[i++] = head.data;
		preOrderRecur(a, head.left);
		preOrderRecur(a, head.right);
	}
	
	// 中序遍历 递归  保存在数组
	public static void inOrderRecur(int a[], Node head) {
		if (head == null) {
			return;
		}
		inOrderRecur(a, head.left);
		System.out.print(head.data + " "); 
		a[i++] = head.data;
		inOrderRecur(a, head.right);
	}

	// 后序遍历 递归 保存在数组
	public static void posOrderRecur(int a[], Node head) {
		if (head == null) {
			return;
		}
		posOrderRecur(a, head.left);
		posOrderRecur(a, head.right);
		System.out.print(head.data + " "); 
		a[i++] = head.data;
	}
}

