/* https://www.hackerrank.com/challenges/java-stack
 * 2017/10/23 Monday
 *
 * Question: 
 *
 * A string containing only parentheses is balanced if the following is true: 1. if it is an empty string 2. if A and B are correct, AB is correct, 3. if A is correct, (A) and {A} and [A] are also correct.
 *
 * Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})" 
 *
 * Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.
 *
 * Given a string, determine if it is balanced or not.
 */



import java.util.*;
class Solution{
   
   public static void main(String []argh)
   {
      Scanner sc = new Scanner(System.in);
      
      while (sc.hasNext()) {
         String input=sc.next();
         char [] array = input.toCharArray();
         Stack<String> s = new Stack<String>();
         int ret = 0;
         for(char c: array){
            //only push the opening prantheses and pop if matching closing is detected
             if(c=='{'||c=='('||c=='['){
                 s.push(Character.toString(c));
                 continue;
             }
             if(c=='}'){
                 if(!s.empty() && s.peek().equals("{")) s.pop();
                 else{
                    ret = 1;
                    break; 
                 } 
             }
             else if(c==')'){
                 if(!s.empty() && s.peek().equals("(")) s.pop();
                 else{
                    ret = 1;
                    break; 
                 }
             }
             else if(c==']'){
                 if(!s.empty() && s.peek().equals("[")) s.pop();
                 else{
                    ret = 1;
                    break; 
                 }
             }
         }
         if(ret==0 && s.empty())System.out.println("true");
         else System.out.println("false");
      }
   }
}
