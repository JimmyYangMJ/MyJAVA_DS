package com.java.base;

final class fff{
	int aaa = 10;
}
interface InterfaceD1{
	int b = 66;
	// ��ͬ��public static final int b = 66 
	void print();
	//public abstract void print();
}
interface InterfaceS1{
	int d = 10;
	
}
interface H extends InterfaceD1,InterfaceS1{  //�ӿڼ̳ж���ӿ�
	int a = b;
}


abstract class AbstractB1{
	public int as = 0;
	private int b2 = 22;
	public AbstractB1(int i) { //�������Ĺ��캯��
		this.as = i;    // ���ã��������SSS�ڱ���as��ֵ
	}
	public abstract void print();
	
	public void printRealize() {
		System.out.printf("�����˸��ࣺ  �������еľ���ʵ�ֵķ���\n");
	}
	
}

class A extends AbstractB1 implements H{
	static long  moblie = 1000;
	int b2 = 20;
	public A(int m) {
		super(6);
		int b = 60;  // �ֲ�����
		b2 = m;
		this.moblie = m; 
		System.out.printf("���๹�캯��--this.b = %d, b = %d, this.as = %d, a = %d \n", this.b, b, this.as, a);
		this.printRealize();
		this.print();  // ʹ��this���ú���������������Ѱ�Ҷ�Ӧ�ĺ��������û�о��ڸ�������
		// ���಻�ܼ̳и����private������ ���Բ�����this.b2
	}
	public A() {
		super(6);
		//this(5);
		System.out.println("�����޲ι��캯��");
	}
	public String show(D obj) {
		//this.show(obj); //���ñ���ĳ�Ա������this���Ժ���
		
		return String.format("A and D ����A.moblie = %d", A.moblie); // ��̬����ͨ����ֱ�ӷ���
	}
	public String show(A obj) {return ("A and A");}/////////////////////////////////////
	//public String show(B obj) {return ("A and B");}
	public String show(C obj) {return ("A and C");}
	
	@Override
	public void print() {
		System.out.printf("��д��InterfaceD1�е�print���󷽷� \n");
	}
	
	protected void printRealizePrivate() {    // �����е�˽�з������ܱ�������д
		System.out.printf("�����˸��ࣺ  �������еľ���ʵ�ֵġ�˽�С�����\n");
	}
	
}
class B extends A{
	public int bd = 77;  //�����У����Ǹ���û��
	int b2 = 658;
	public B() {
		//super(6);
	}
	public B(int m){
		super(m);
	}
	public String show(B obj) {return ("B and B,����ӿڳ���"+a);}
	@Override
	public String show(A obj) {return ("B and A");}
	@Override
	public String show(C obj) {return ("B and C");}
	
	@Override
	public void printRealizePrivate() {    // �����е�˽�з������ܱ�������д
		// �����protected �������Ա���������Ϊpublic
		System.out.printf("��д�˸���protected����\n");
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
        class Woman {   //�ֲ��ڲ���
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
		System.out.println("----���� =  ���� ----");
		A a2 = new B(3);
		System.out.printf("����A�� a2.moblie = %d, a2.b2 = %d\n", a2.moblie, a2.b2);  // ������û������B��bd������ ��û�� a2.bd
		a2.print();
		
		System.out.println("-----------------");

		B b= new B(6);
		
		B ab = (B) a2;//����ת��Ϊ����--�������

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
		System.out.println(b.show(d));//A and D ��B�ĸ�������

		
	}

}
