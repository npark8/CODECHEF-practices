/* http://www.programmr.com/challenges/perfect-number
 * 2017/09/21 Thursday 
 *
 * Question:
 *
 * Complete the following program to find whether given number is perfect or not. 
 * Perfect number is a positive number which sum of all positive divisors
 * excluding that number is equal to that number. For example 6 is perfect number
 * since divisor of 6 are 1, 2 and 3. Sum of its divisor is 1 + 2 + 3 = 6
 * Note: 6 is the smallest perfect number.
 * Next perfect number is 28
 *
 * Example1:
 * Enter a number:
 * 6
 * the result is:
 * given number is a perfect number
 *
 * Example2:
 * Enter a number:
 * 5
 * the result is:
 * given number is not a perfect number 
 */

import java.io.*;
import java.util.List;
import java.util.ArrayList;

class perfectnumber{

public static void main(String arg[])throws Exception{

	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter the number:"); 
	int number =Integer.parseInt(br.readLine());

	/*Write down your logic here*/
	//sum starts from 1 as Integers are dividible by 1
	int sum = 1;

	List<Integer> pairList = new ArrayList<Integer>();
	/*i starts from 2 as dividing by 0 is undefined & dividing by 1 is redaundant
	  i only goes upto number-1 as the sum does not include number
	  reducing the iteration approximately by 1/2 by calculating pairs together */

	for (int i=2; i<number; i++){
		if(number%i==0){ 
			Integer divisor = new Integer(i); 
			Integer pair = new Integer(number/i); 
			if(!pairList.contains(i)) pairList.add(divisor); 
			else break;
			if(!pairList.contains(pair)) pairList.add(pair);
			else{ //don't add duplicate divisors
				sum+= i;
				continue;
			}
			sum+= (number/i) + i;
		}
	}

	System.out.println("The result is:");
  	if(number != 1 && sum == number) System.out.println("given number is a perfect number");
	else System.out.println("given number is not a perfect number");

	}
 
}


