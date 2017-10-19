/* http://www.programmr.com/challenges/sexy-pairs-1
 * 2017/09/21 Thursday 
 *
 * Question:
 *
 * Sexy Pairs are nothing but those pairs which contains prime numbers with difference of 6.
 * Consider 5 is a prime no. and adding 6 into 5 makes 11 which is also a prime no.
 * So (5,11) is a sexy pair. Write a program which calculates the Sexy pairs upto the limit given as input.
 *
 * For Ex:
 * 1) If user input 20 then it should print (5 11) (7 13) (11 17) (13 19) as
 * Sexy pairs.
 * 
 * 2) If user input 30 then it should print (5 11) (7 13) (11 17) (13 19)
 * (17 23) (23 29).
 */

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class sexypair
{
  static boolean flag = false;
   
  //helper function that determines if given number is prime or not
  public static boolean isPrime(int num, List<Integer> primeList){
     //if num is divisible by any of 2, 3, 5, 7 (prime numbers), it is not a prime number
     Integer numObj = new Integer(num);
     if((num%2==0||num%3==0||num%5==0||num%7==0) && !primeList.contains(numObj)) return false;
     else return true;
  }
  public static void main(String[] args)
  {
     int max=0;
     System.out.println("Enter Maximum No.:");
     Scanner sc = new Scanner(System.in);
     max = sc.nextInt();
     
     /* 
        your code goes here
     */

        List<Integer> primeList = new ArrayList<Integer>();
        primeList.add(2);
        primeList.add(3);
        primeList.add(5);
        primeList.add(7);

        List<Integer> list = new ArrayList<Integer>();

        //populate above list with the first max number of prime numbers
        for(int i=2; i<max; i++){
          flag = isPrime(i,primeList);
          if(flag) list.add(i);
        }

        Map<Integer,Integer> result =new HashMap<Integer,Integer>();
        //find prime pairs that differs by 6
        for(Integer i : list){
          if(list.contains(i+6) && (i+6)<=max){
            Integer numObj = new Integer(i+6);
            result.put(i, numObj);
          }
        }

      System.out.println("Sexy Pairs:");
      for(Map.Entry r : result.entrySet()){
        System.out.print("(" + r.getKey() + " " + r.getValue() + ")");
      }
  }
}
