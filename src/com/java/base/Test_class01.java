package com.java.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


interface Comparators{
	void SumAscending(Staff[] staff);
	public abstract void PresonAscending(Staff[] staff);
}
class Staff {
	private int number = -1;
	private String name = null;
	private String sex = null;
	private int sumAchie = 0;
	private int personAchie = 0;
	private int sum = 0;
	public Staff(int number, int sumachie,int personAchie, String name,String sex) {
		super();
		this.number = number;
		this.name = name;
		this.sex = sex;
		this.sumAchie = sumachie;
		this.personAchie = personAchie;
		this.sum = sumachie + personAchie;
	}
	public Staff() {}
	public int getNumber() {
		return number;
	}
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public int getSumAchie() {
		return sumAchie;
	}
	public int getPersonAchie() {
		return personAchie;
	}
	public int getSum() {
		return sum;
	}
}
public class Test_class01 implements Comparators{

	static int number;
	public static void log(String s) {
		System.out.println(s);
	}
	public static void main(String[] args) {
		Staff[] staff = {new Staff(1,500,400,"ְ��1","female"), new Staff(2,400,600,"ְ��2","female"),new Staff(3,600,300,"ְ��3","male"), new Staff(4,800,200,"ְ��4","female")
				, new Staff(5,500,700,"ְ��5","male")};
		/****************ʹ��Comparator�����ڲ���***********************/ 
		ArrayList<Staff> list = new ArrayList<Staff>();
		Staff staff1 = new Staff(1,500,400,"ְ��1","female");
		Staff staff2 = new Staff(2,400,600,"ְ��2","female");
		Staff staff3 = new Staff(3,600,300,"ְ��3","male");
		Staff staff4 = new Staff(4,800,200,"ְ��4","female");
		list.add(staff1);list.add(staff2);list.add(staff3);list.add(staff4);
		list.add(new Staff(5,500,700,"ְ��5","male")); //����ֱ��д������
	
        Collections.sort(list,new Comparator<Staff>() {  //ʹ��Comparator�����ڲ���
            @Override
            public int compare(Staff o1, Staff o2) {
                return o1.getSumAchie()-o2.getSumAchie(); //������
            }
        });
        System.out.println("�����������/PresonAscending:");
        for (Staff staffs : list) {
        	log(String.format("%d,%d,%d,%s,%s",staffs.getNumber(),staffs.getSumAchie(),
					staffs.getPersonAchie(), staffs.getName(), staffs.getSex()));
        }
      /**************************************************/
		number = staff.length;
		Test_class01 a = new Test_class01();

		a.SumAscending(staff);
		a.ShowStaff(staff);
		a.PresonAscending(staff);
		a.ShowStaff(staff);
	}
	
	public void ShowStaff(Staff[] staff) {
		log("���,����,����,����,�Ա�");
		for(int i = 0; i < number; i++) {
			log(String.format("%d,%d,%d,%s,%s",staff[i].getNumber(),staff[i].getSumAchie(),
					staff[i].getPersonAchie(), staff[i].getName(), staff[i].getSex()));
		}
	}

	@Override
	public  void PresonAscending(Staff[] staff) {
		Staff temp = new Staff();
		for(int i = 0; i < number -1; i++) {
			for(int j = 0; j < number -1-i ; j++) {
				if(staff[j].getSumAchie() > staff[j+1].getSumAchie()) {
					temp = staff[j];
					staff[j] = staff[j+1];
					staff[j+1] = temp;

				}
			}
		}
	}
	@Override
	public void SumAscending(Staff[] staff) {
		Staff temp = new Staff();
		for(int i = 0; i < number -1; i++) {
			for(int j = 0; j < number -1-i ; j++) {
				if(staff[j].getSum() > staff[j+1].getSum()) {
					temp = staff[j];
					staff[j] = staff[j+1];
					staff[j+1] = temp;
				}
			}
		}
	}

}
