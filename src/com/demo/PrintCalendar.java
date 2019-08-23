package com.demo;
import java.util.Scanner;

/**
 *  ¥Ú”°»’¿˙
 */
public class PrintCalendar {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input =new Scanner(System.in);
		System.out.println("Please enter the years");
		int year= input.nextInt();
		System.out.println("Please enter the month betweent 1 to 12");
		int month= input.nextInt();
		printMonth(year,month);

	}

	private static void printMonth(int year, int month) {
		// TODO Auto-generated method stub
		printMonthTitle(year,month);

		printMonthBody(year,month);
	}


	private static void printMonthTitle(int year, int month) {
		// TODO Auto-generated method stub
		System.out.println("      "+getMonthName(month)+" "+year);
		System.out.print(" ");
		System.out.println("Sun Mon Tue Wed Thu Fri Sat");
	}

	private static String getMonthName(int month) {
		// TODO Auto-generated method stub
		String monthName="";
		switch(month){
		case 1:monthName="January";break;
		case 2:monthName="February";break;
		case 3:monthName="March";break;
		case 4:monthName="April";break;
		case 5:monthName="May";break;
		case 6:monthName="June";break;
		case 7:monthName="July";break;
		case 8:monthName="August";break;
		case 9:monthName="September";break;
		case 10:monthName="October";break;
		case 11:monthName="November";break;
		case 12:monthName="December";break;

		}
		return monthName;
	}

	private static void printMonthBody(int year, int month) {
		// TODO Auto-generated method stub
		int startday=getStartDay(year,month);
		int numberOfDaysInMonth=getNumberOfDaysInMonth(year,month);
		int i=0;

		for(i=0;i<startday;i++)
			System.out.print("    ");
		for(i=1;i<=numberOfDaysInMonth;i++){
			System.out.printf("%4d",i);
			if((i+startday)%7==0)
				System.out.println();
			}
			System.out.println();
	}

	private static int getStartDay(int year, int month) {
		// TODO Auto-generated method stub
		final int START_DAY_FOR_JAN_Jan_1_1800=3;
		int TotalNumberOfDays=getTotalNumberOfDays(year,month);
		return (TotalNumberOfDays+START_DAY_FOR_JAN_Jan_1_1800)%7;
	}

	private static int getTotalNumberOfDays(int year, int month) {
		// TODO Auto-generated method stub
		int total=0;
		for(int i=1800;i<year;i++)
			if(isLeapYear(i))
				total+=366;
			else
				total+=365;
		for(int i=1;i<month;i++)
			total+=getNumberOfDaysInMonth(year,i);
		return total;
	}

	private static int getNumberOfDaysInMonth(int year, int month) {
		// TODO Auto-generated method stub
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
			return 31;
		if(month==4||month==6||month==9||month==11)
			return 30;
		if(month==2){
			if(isLeapYear(year))
				return 29;
			else
				return 28;

		}
		return 0;
}

	private static boolean isLeapYear(int year) {
		// TODO Auto-generated method stub
		if(year%400==0||(year%4==0&&year%100!=0))
			return true;
		else
		return false;
	}
}