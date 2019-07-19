package com.java.base;


public class Test_enum {

	public static void main(String[] args) {
	/*	ö�ٸ���
		1.ö����ָ��������ֵһһ�г���,���Գ�Ϊ�����ݼ��� ��
		      ������һ��ֻ��7�죬һ��ֻ��12���£�һ�����ĸ����ڵȡ�
		2.Java��enumͨ�����������Ϊö����
		3.ö����ʵ�����޶���Χ����ֹ��Ӧ�÷��������鷢��
		4.ö��ע������
			����ö����Ҫ�ùؼ���enum
			����ö���඼��Enum������
			ö����ĵ�һ���ϱ�����ö������һ��ö�����ķֺ��ǿ���ʡ�Եģ��������ö�����������Ķ���������ֺžͲ���ʡ�ԡ����鲻Ҫʡ��
			ö��������й���������������private�ģ���Ĭ�ϵ�Ҳ��private�ġ�
			ö����Ҳ�����г��󷽷�������ö���������д�÷���
			ö����switch����е�ʹ��
		5. ö����һ��������
*/

		//ʹ��ö��
		Season season = Season.SUMMER;
		season.test();//����ö�ٵķ���
		Season.SPRING.test();
		System.out.printf("������ %s,%s,%s\n", season, season.name(), "����");	
	/*	switch (season) {
		case SPRING:
			System.out.println("�������ˣ���ľ��ѿ�ˡ�����");
			break;
		case SUMMER:
			System.out.println("�������ˣ��յ�������������");
			break;
		case AUTUMN:
			System.out.println("�������ˣ���װ������������");
			break;
		case WINTER:
			System.out.println("�������ˣ��ް�������������");
			break;
		default:
			break;
		}*/
		
		//ö����ĳ�������
		/*		int ordinal() ö�������������0��ʼ
				int compareTo(E o)
				String name() ö��������
				String toString()
				<T> T valueOf(Class<T> type,String name)ͨ���ֽ�������ȡö�ٶ���
				values() �˷�����Ȼ��JDK�ĵ��в��Ҳ�������ÿ��ö���඼���и÷�����������ö���������ö��ֵ�ǳ�����
		*/
				//1.��ȡö�ٶ���
		Season s1 = Season.SPRING;
		Season s2 = Season.WINTER;
		System.out.println("s1:" + s1.ordinal());
		System.out.println("s2:" + s2.ordinal());
		
		//2.�Ƚ�ö��[�������]
		System.out.println(s1.compareTo(s2));
		
		//3.��ӡö��������
		System.out.println("s1 name:" + s1.name());
		System.out.println("s1:" + s1.toString());//ö��������
		
		//4.ͨ���ֽ�������ȡö�ٶ���ûɶ�á�
		Season s3 = Season.valueOf(Season.class, "SPRING");
		System.out.println("s3:" + s3);
				
		//5.�෽����.values() ����ö������
		System.out.println("ö�ٵı���");
		Season[] seasons = Season.values();
		for(Season s : seasons){
			System.out.println(s);
		}
	}
}

//һ�����ĸ�����
enum Season{
	//�����ﶬ
	SPRING("����"){
		@Override
		public void test() {
			System.out.printf("������ %s\n", "����");	
		}
	},
	SUMMER("����"){
		@Override
		public void test() {
			// TODO Auto-generated method stub
			System.out.println("���������������Ĺ�ȥ...");
			
		}
	},
	AUTUMN("����"){
		@Override
		public void test() {
			// TODO Auto-generated method stub
			
		}
	},
	WINTER("����"){
		@Override
		public void test() {
			// TODO Auto-generated method stub
			
		}
	};
	
	Season(){
		System.out.println("�ղεĹ��췽��");
	}
	
	private String s;
	private Season(String s){
		this.s = s;
		System.out.println("�вεĹ��췽��");
	}
	
	public abstract void test();
}

