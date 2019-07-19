package com.ds.tree;

import com.ds.tree.Binarytree.HTNode;
import com.ds.tree.Binarytree.Node;

public class HuffmanTree {

	public static boolean flag = false;
	static int i = 0;

	// 哈夫曼树先序遍历 递归  保存在数组
	public static void preOrderHT(int pre[], HTNode[] HT,int head) {
		if(head == 0) {
			return ;
		}
		System.out.printf(HT[head].weight + " ");
		pre[i++] = HT[head].weight;
		preOrderHT(pre, HT, HT[head].left);
		preOrderHT(pre, HT, HT[head].right);
	}
	
	// 哈夫曼树中序遍历 递归  保存在数组
	public static void inOrderHT(int in[], HTNode[] HT,int head) {
		if(head == 0) {
			return ;
		}
		inOrderHT(in, HT, HT[head].left);
		System.out.printf(HT[head].weight + " ");
		in[i++] = HT[head].weight;
		inOrderHT(in, HT, HT[head].right);
	}

	// 存储最小的两个 结点的下标
	public static class Min2{
		int S1;
		int S2;
	}
	
	// 在HT[1..i-1]中选择parent为0且weight最小的两个结点(下标)，
	public static void SelectMin2(HTNode[] HT, int i, Min2 min) {
		int min1 = 100000; // 第1个最小的
		int min1Index = 1;
		for(int k = 1; k <= i; k++) {
			if(HT[k].parent == 0) {
				if(HT[k].weight < min1) {
					min1 = HT[k].weight;
					min1Index = k;
				}
			}
		}
		int min2 = 100000;  // 第2个最小的
		int min2Index = 1;
		for(int k = 1; k <= i; k++) {
			if(HT[k].parent == 0 && k!=min1Index) { // 不和第一个最小的做比较
				if(HT[k].weight < min2) {
					min2 = HT[k].weight;
					min2Index = k;
				}
			}
		}
		min.S1 = min1Index;  // 第一个最小的
		min.S2 = min2Index;  // 第二个最小的
	}

	// 哈夫曼树和哈夫曼编码  <核心方法>
	// 根据随机生成的 elem 数组 生成哈夫曼树和哈夫曼编码
	// 通过静态链表  存储哈夫曼树  

	/**
	 * 哈夫曼树 <核心函数>
 	 */
	public static void Huffman(int elem[]) {

		int n = elem.length; // 叶子结点的个数（数组长度）
		int m =  2 * n - 1; // n + 非叶子结点个数;  没有度为1的结点

		if (n<=1) return ; //只有一个结点
		
		HTNode []HT = new HTNode[m+1];  // 数组下标从1 开始
		for (int i=1; i<=n; i++) { //初始化
			HT[i] = new HTNode();
		    HT[i].weight=elem[i-1];  // 将叶子结点的权重赋值
		    HT[i].parent=0;
		    HT[i].left=0;
		    HT[i].right=0;
		}
		for (int i=n+1; i<=m; i++) { //初始化
			HT[i] = new HTNode();
		    HT[i].weight=0;
		    HT[i].parent=0;
		    HT[i].left=0;
		    HT[i].right=0;
		}
		System.out.printf("\n哈夫曼树的构造过程如下所示：\n");
		System.out.printf("HT初态:\n  结点  weight  parent  lchild  rchild");
		for (i=1; i<=m; i++) {
			System.out.printf("\n%4d%8d%8d%8d%8d",i,HT[i].weight,
					HT[i].parent,HT[i].left, HT[i].right);			  
		}
		System.out.printf("\n继续==============\n");
		/**
		 * 创建二叉树
		 */
		for (int i=n+1; i<=m; i++) {  // 建哈夫曼树
			// 在HT[1..i-1]中选择parent为0且weight最小的两个结点，
			// 其序号分别为s1和s2。
			Min2 min = new Min2();  // 存储最小的两个结点下标
			SelectMin2(HT, i-1, min);
			int s1 = min.S1, s2 = min.S2;
	    
			HT[s1].parent = i;  HT[s2].parent = i;
			HT[i].left = s1;  HT[i].right = s2;
			HT[i].weight = HT[s1].weight + HT[s2].weight;
		}
		  
	    System.out.printf("  结点  weight  parent  lchild  rchild");
	    for (int j=1; j<=m; j++)
	    	System.out.printf("\n%4d%8d%8d%8d%8d",j,HT[j].weight,
	             HT[j].parent,HT[j].left, HT[j].right);

	    /**
	     * --- 从叶子到根<逆向>求每个字符的哈夫曼编码 ---
	     */
	    String cd = "";
	    int WPL = 0; // 带权路径长度
	    for (i=1; i<=n; ++i) {       // 逐个字符求哈夫曼编码
	    	cd = "";
		    for(int c = i, f=HT[i].parent; f!=0; c=f, f=HT[f].parent) {
		        // 从叶子到根逆向求编码
		    	if (HT[f].left==c) {  // c为 f 的左节点  0
		    		cd += '0';		    		
		    	}else {		    	  // c为 f 的右结点  1
		    		cd += '1';
		    	}
		    }
		    System.out.printf("\n权重为%d结点的哈夫曼编码：\n", HT[i].weight);

			System.out.println(stringReverse(cd)); // 逆序输出哈夫曼编码

		    WPL += (cd.length() * HT[i].weight);  // 计算权重

		}
	    System.out.printf("带权径长度为： %d", WPL);
	    System.out.printf("平均带权径长度为： %.2f", WPL*1.0/n);
	    /*****************************************************************/
	    int pre[] = new int[m+1];  // 下标从0 开始
	    int in[] = new int[m+1];
	    // 哈夫曼树先序遍历
	    //flag = false;
	    System.out.printf("\n 哈夫曼树的先序遍历： \n");
	    i = 0;
	    HuffmanTree.preOrderHT(pre, HT, m); //flag = false;
	    System.out.printf("\n 哈夫曼树的中序遍历：\n ");
	    i = 0;
	    HuffmanTree.inOrderHT(in, HT, m);  //flag = false;
	    
	    System.out.printf("\n=====================\n");

	    Node Huff = null;  // 生成的哈夫曼树
	    Huff = Binarytree.preAndinRestoreBinTree(pre, in, 0, m-1);  // 根据先序和后序 在文件中输出二叉树
	    System.out.printf("\n哈夫曼树已经输出到文件： ");
	    Binarytree.showBinTree(Huff);
	}

	// 使得字符串逆序
	public static String stringReverse(String str){
		StringBuilder sb = new StringBuilder(str);
		return  sb.reverse().toString();
	}
}
