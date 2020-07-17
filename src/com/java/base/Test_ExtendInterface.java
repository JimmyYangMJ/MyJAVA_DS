package com.java.base;


/**
 * 类之间的继承、实现、向上造型等实例
 */

/**
 * 常量类
 */
final class fff{
	int aaa = 10;
}

/**
 * 接口1
 * <br>  常量，抽象方法<br/>
 */
interface InterfaceD1 {
	int b = 66;
	// 等同于public static final int b = 66 
	void print();
	//public abstract void print();
}

/**
 * 接口2
 * <br>  常量<br/>
 */
interface InterfaceS2 {
	int d = 10;
	
}

/**
 * 接口3
 * <br>  继承 接口 1 和 接口2
 */
interface H3 extends InterfaceD1, InterfaceS2 {  //接口继承多个接口
	int a = b;
}

/**
 * 抽象类1
 */
abstract class AbstractB1{
	public int as = 0;
	private int b2 = 22;
	public AbstractB1(int i) { //抽象函数的构造函数
		this.as = i;    // 作用：赋予对象SSS内变量as初值
	}

	public abstract void print();
	
	public void printRealize() {
		System.out.printf("调用了父类：  抽象类1中的具体实现的方法\n");
	}
	
}

class A extends AbstractB1 implements H3 {
	static long  moblie = 1000;
	int b2 = 20;
	public A(int m) {
		super(6);
		int b = 60;  // 局部变量
		b2 = m;
		this.moblie = m; 
		System.out.printf("父类构造函数--this.b = %d, b = %d, this.as = %d, a = %d \n", this.b, b, this.as, a);
		this.printRealize();
		this.print();  // 使用this调用函数，先在子类中寻找对应的函数，如果没有就在父类中找
		// 子类不能继承父类的private变量， 所以不能用this.b2
	}
	public A() {
		super(6);
		//this(5);
		System.out.println("父类无参构造函数");
	}
	public String show(D obj) {
		//this.show(obj); //调用本类的成员方法，this可以忽略
		
		return String.format("A and D 其中A.moblie = %d", A.moblie); // 静态变量通过类直接访问
	}
	public String show(A obj) {return ("A and A");}/////////////////////////////////////
	//public String show(B obj) {return ("A and B");}
	public String show(C obj) {return ("A and C");}
	
	@Override
	public void print() {
		System.out.printf("重写了InterfaceD1中的print抽象方法 \n");
	}
	
	protected void printRealizePrivate() {    // 父类中的私有方法不能被子类重写
		System.out.printf("调用了父类：  抽象类中的具体实现的《私有》方法\n");
	}
	
}

class B extends A{
	public int bd = 77;  //子类有，但是父类没有
	int b2 = 658;
	public B() {
		//super(6);
	}
	public B(int m){
		super(m);
	}
	public String show(B obj) {return ("B and B,父类接口常量"+a);}
	@Override
	public String show(A obj) {return ("B and A");}
	@Override
	public String show(C obj) {return ("B and C");}
	
	@Override
	public void printRealizePrivate() {    // 父类中的私有方法不能被子类重写
		// 父类的protected 方法可以被子类提升为public
		System.out.printf("重写了父类protected方法\n");
	}
	


}

class C extends B{}

class D extends B{}

public  class Test_ExtendInterface{

	private static int d;

	public Test_ExtendInterface(int h) {
		this.d = h;
		
	}
	public void temp() {
		System.out.print(d);
	}
    public void  getWoman(){
        class Woman {   //局部内部类
            int age =0;
        }
        Woman asdf = new Woman();
    }
	public static void main(String[] args) {
		
		Test_ExtendInterface asd = new Test_ExtendInterface(2);
		asd.temp();
		
		fff sd = new fff();
		sd.aaa= 10;
		System.out.print("+++"+sd.aaa);

		A a1 = new A();
		System.out.println("----父类 =  子类 ----");

		/** 向上造型*/
		A a2 = new B(3);

		System.out.printf("父类A中 a2.moblie = %d, a2.b2 = %d\n", a2.moblie, a2.b2);  // 对象中没有子类B的bd变量， 即没有 a2.bd
		a2.print();

		/** 接口 == 实现接口的子类*/
		H3 interfaceclass = new A();
		interfaceclass.print();

		System.out.println("-----------------");

		B b= new B(6);
		
		B ab = (B) a2;   //父类转化为子类--特殊情况（向下转型，一般不允许）
		//B ab2 = (B) a1;  // 错误，会抛出异常ClassCastException

		C c = new C();
		D d = new D();
		b.moblie = 10;
		c.moblie = 20;
		System.out.println(a1.show(b)+b.moblie);//A and A
		System.out.println(a1.show(c)+c.moblie);//A and C
		System.out.println(a1.show(d)+a1.moblie);//A and D
		System.out.println(a2.show(b));//B and A
		System.out.println(a2.show(c));//B and C
		System.out.println(a2.show(d));//A and D
		System.out.println(b.show(b));//B and B
		System.out.println(b.show(c));//B and C
		System.out.println(b.show(d));//A and D 在B的父类中找

		
	}

}
