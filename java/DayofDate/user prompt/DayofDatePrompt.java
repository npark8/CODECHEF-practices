/* http://www.programmr.com/challenges/find-day-given-date-1
 * 2017/09/22 Friday: initial working copy
 * 2017/10/20 Friday: added user prompt; code in OOP style
 *
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

public class DayofDatePrompt
{
	//global day lists
	static int[] daysPerMonthL = {31,29,31,30,31,30,31,31,30,31,30,31};
	static int[] daysPerMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	private boolean notDigit = false;
	private boolean start = true;
	private int year,date,month;

	/*constructor with parameters*/
	public DayofDatePrompt(int y, int d, int m) {
	    this.year = y;
	    this.date = d;
	    this.month = m;
	}
	/*getters*/
	public int getYear(){
		return year;
	}
	public int getDate(){
		return date;
	}
	public int getMonth(){
		return month;
	}
	public boolean getnotDigit(){
		return notDigit;
	}
	public boolean getStart(){
		return start;
	}
	/*setters*/
	public void setYear(int value){
		this.year = value;
	}
	public void setDate(int value){
		this.date = value;
	}
	public void setMonth(int value){
		this.month = value;
	}
	public void setnotDigit(boolean value){
		this.notDigit = value;
	}
	public void setStart(boolean value){
		this.start = value;
	}

	/*checks if the input is in dd/mm/yyyy format*/
	public boolean correctFormat(final String s){
	    if (s != null && !s.isEmpty() && !(s.length()!=10)){
	    	char[] array = s.toCharArray();
	        for (int i=0;i<array.length;i++){
	            if (!(i==2 || i==5)){
	               	if(!Character.isDigit(array[i])){ 
	               		this.setnotDigit(true);
	               		return false;
	               	}
	            }
	            else{
	            	if(array[i]!='/'){
	               		return false;
	            	}
	            }
	        }
	        return true;
	    }
	    return false;
	}

	/*checks if input is valid*/
	public boolean inputValid(){
		int d = this.getDate();
		int m = this.getMonth();
		int y = this.getYear();
		if(d<=0||d>31||m<=0||m>12) return false;
		if(isLeap(y)){
			if(d>daysPerMonthL[m-1]){
				return false;
			}
		}
		else{
			if(d>daysPerMonth[m-1]){
				return false;
			}
		}
		return true;
	}

	/*decide next prompt action: 0 - restart; 1 - exit; 2 - ask for valid input; 3 - finish prompt */
	public int checkInput(){
		int action = -1;
		Scanner sc = new Scanner(System.in);
		//input format is dd/mm/yyyy
		String input = sc.nextLine();
		if(input==null){
			this.setStart(true);
			return 0;
		}
		if("q".equals(input)){
          System.out.print("\nExit program? (y/n): ");
          while(true){
            input = sc.next();
            if("y".equals(input)){ 
              System.out.print("\nExit program... \n");
              return 1;
            }
            else if("n".equals(input)){
              System.out.print("\nResume program... \n\n");
              action = 0;
              break;
            }
            else{
              System.out.print("\nEnter either \'y\' or \'n\': ");
              continue;
            }
          }
        }
        if(action == 0){ 
        	this.setStart(true);
        	return 0;
        }
		if(!correctFormat(input)){
			if(this.getnotDigit()) System.out.print("\nRe-enter valid date: ");
			else System.out.print("\nRe-enter date in \"dd/mm/yyyy\" format with leading zero: ");
			this.setStart(false);
			this.setnotDigit(false);
			return 2;
		}
		this.setYear(Integer.valueOf(input.substring(6)));
		this.setDate(Integer.valueOf(input.substring(0,2)));
		this.setMonth(Integer.valueOf(input.substring(3,5)));
		if(!this.inputValid()){
			System.out.print("\nRe-enter valid date: ");
			this.setStart(false);
			return 2;
		}
		return 3;
	}

	public static boolean isLeap(int year){
		//int year = this.getYear();
		/*a year is leap year (with 366 days) if evenly divisible by 4
		or by 100 AND 400 at the same time */
		if(year%4 == 0) return true;
		else return false;
	}

	/*find how many days passed since 0000/01/01 */
	public static int absoluteDays(int year, int month, int date){
		int daysPassed = 0;
		for(int i = 0; i<year; i++){
			if(isLeap(i)) daysPassed +=366;
			else daysPassed+=365;
		}
		//calculating days in months
		if(isLeap(year)){ 
			for(int i = 0; i<month-1;i++){
				daysPassed+=daysPerMonthL[i];
			}
		}
		else{ 
			for(int i = 0; i<month-1;i++){
				daysPassed+=daysPerMonth[i];
			}
		}
		//calculate days
		daysPassed+=date;
		return daysPassed;
	}

	public static void main(String[] args)
	{
		//write your logic here
		DayofDatePrompt obj = new DayofDatePrompt(-1,-1,-1);

		while(true){
			int action = -1;
			if(obj.getStart()) System.out.print("Enter date in dd/mm/yyyy format with leading zero or \"q\" to exit: ");

			action = obj.checkInput();// checkInput(year,month,date);
			if(action == 0 || action == 2) continue;
			if(action == 1) break;
			else{
			/*  pick a reference day given in the example
				    		12/12/1988 Monday
			*/
				int year = obj.getYear();
				int date = obj.getDate();
				int month = obj.getMonth();

				int max = Math.max(year, 1988);
				int min = Math.min(year,1988);

				int daysPassed = Math.abs(obj.absoluteDays(year,month,date) - obj.absoluteDays(1988,12,12));
				//offset from reference day: Monday
				int dayConversion = daysPassed%7;
				int indicator = 0;
				if (max == 1988) {
					if (month <= 12 && date <= 12) indicator = 1;
				}

				//list of days to trace both ways (backward and forward)
				String[] days = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday","Monday"};
				String result = "";
				if(indicator == 1){
					//need to trace days backward from Monday
					System.out.println("\nDay is " + days[7-dayConversion] + "\n\n"); 
				}
				else System.out.println("\nDay is " + days[dayConversion] + "\n\n");
				//reset instances
				obj.setStart(true);
				obj.setnotDigit(false);
				obj.setYear(-1);
				obj.setDate(-1);
				obj.setMonth(-1);
			}
		}
	}
}
