/* http://www.programmr.com/challenges/find-day-given-date-1
 * Question:
 *
 * Write a program to takes input date as [dd/mm/yyyy] formate and find out the day of entered date.
 *
 * for e.g.:
 * 1. If user gives input date 12/12/1988 then the output will be in this formate:
 * Day is Monday
 *
 * 2.If user gives input date 01/01/1985 then the output will be in this formate:
 * Day is Tuesday
 *
 * Note:Make sure the input and output string must be same as given example.
 */


import java.io.*;
import java.util.Scanner;
import java.lang.Math;





public class DayofDate
{
    public static boolean isLeap(int year){
  /*a year is leap year (with 366 days) if evenly divisible by 4
    or by 100 AND 400 at the same time */
  if(year%4 == 0) return true;
  else return false;
}

public static int absoluteDays(int year, int month, int date){
	/*find how many days passed since 0000/01/01 */
	int daysPassed = 0;
	for(int i = 0; i<year; i++){
		if(isLeap(i)) daysPassed +=366;
		else daysPassed+=365;
	}
	//calculating days in months
	if(isLeap(year)){ 
		int[] daysPerMonthL = {31,29,31,30,31,30,31,31,30,31,30,31};
		for(int i = 0; i<month-1;i++){
			daysPassed+=daysPerMonthL[i];
		}
	}
	else{ 
		int[] daysPerMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
		for(int i = 0; i<month-1;i++){
			daysPassed+=daysPerMonth[i];
		}
	}
	//calculate days
	daysPassed+=date;
	return daysPassed;
}
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		       
	        //write your logic here
			Scanner sc = new Scanner(System.in);
			//input format is dd/mm/yyyy
			String dateS = sc.next();
			int year = Integer.valueOf(dateS.substring(6));
			int date = Integer.valueOf(dateS.substring(0,2));
			int month = Integer.valueOf(dateS.substring(3,5));

			/*  pick a reference day given in the example
				12/12/1988 is Monday
			*/
			//int year = 1985; int date = 1; int month = 1;
			int max = Math.max(year, 1988);
			int min = Math.min(year,1988);

			int daysPassed = Math.abs(absoluteDays(year,month,date) - absoluteDays(1988,12,12));
			int dayConversion = daysPassed%7;
			int indicator = 0;
			if (max == 1988) {
				if (month <= 12 && date <= 12) indicator = 1;
			}

			//days cover two weeks to trace both ways (backward and forward)
			String[] days = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday","Monday"};
			String result = "";
			if(indicator == 1){
				//need to trace days backward from Monday
				System.out.println("Day is " + days[7-dayConversion]); 
			}
			else System.out.println("Day is " + days[dayConversion]);
                //end 
        }
}
