/* http://www.programmr.com/challenges/matrix-multiplication-1
 * 2017/09/20 Wednesday: initial working copy
 * 2017/10/20 Friday: added user promt; code in OOP style
 *
 * Question:
 *
 * Write a program to takes two matrix(3*3) array as inputs and calculate the multiplication of both matrix. 
 */

import java.io.*;
import java.util.*; 
class MatrixMultiplicationPrompt{
  private int [][] left = new int[3][3];
  private int [][] right = new int[3][3];
  private int [][] result = new int[3][3];
  //private boolean exit = false;

  /*getters*/
  public int[][] getMatrix(String target){
    if("left".equals(target)){
      return left;
    }
    else if("right".equals(target)){
      return right;
    }
    else return result;
  }
  public int getMatrixElem(int row, int col, String target){
    return (this.getMatrix(target))[row][col];
  }

  /*setters*/
  public void setMatrixElem(int row, int col, int value, String target){
    (this.getMatrix(target))[row][col] = value;
  }

  /*initializes matrices with user input*/
  public boolean initMatrix(String target, String rank){
    Scanner scan=new Scanner(System.in);
    int action = -1;
    for(int i = 0; i < 3; i++) {
      for(int j = 0; j <3; j++) {
        System.out.print("\nMatrix " + rank + " ["+i+"]["+j+"]: ");
        String input = scan.next();
        if("q".equals(input)){
          System.out.print("\nExit program? (y/n): ");
          while(true){
            input = scan.next();
            if("y".equals(input)){ 
              System.out.print("\nExit program... \n");
              return true;
            }
            else if("n".equals(input)){
              System.out.print("\nResume program... \n");
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
          action -=1;
          j--;
          continue;
        }
        if(isValid(input)) this.setMatrixElem(i,j,Integer.valueOf(input),target);
        else{
          System.out.print("\nRe-enter valid integer\n");
          j--;
          continue;
        } 
      }
    }
    return false;
  }
  
  /*operates 3x3 matrix multiplication*/
  public void multiply3(){
    int count = 0; int res = 0;
    int x = 0; int y = 0;
    while(count < 9){
      for(int j = 0; j < 3; j++) {
        // calculate one element
        res += this.getMatrixElem(x,j,"left") * this.getMatrixElem(j,y,"right");
      }
      this.setMatrixElem(x,y,res,"result");
      count++;
      //increment column for the right matrix
      y++;
      res = 0;
      //increment row of the left matrix when the entire row elements are calculated
      if(count==3||count==6||count==9) x++;
      //reset column to the first one for next row element calculation
      if(y==3) y=0;
    }
  }

  /*print out multiplication result*/
  public void printResult(){
    System.out.println("\nMultiply of both matrix:\n");
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        System.out.print(this.getMatrixElem(i,j,"result") + "\t");
      }  
      System.out.println("\n\n");
    }
    System.out.println();
  }

  /*checks if input contains any non-numerical character*/
  public static boolean isValid(final String s){
    if (s != null && !s.isEmpty()){
      char[] array = s.toCharArray();
      for(char c: array){
        if(!Character.isDigit(c)) return false;
      }
      return true;
    }
    return false;
  }

  public static void main(String[] args){
    boolean exit = false;
    MatrixMultiplicationPrompt obj = new MatrixMultiplicationPrompt();
    while(true){
      System.out.println("Enter matrix elements with positive integers or \"q\" to exit at any time: ");

      exit = obj.initMatrix("left", "1st");
      if(exit) break;
      exit = obj.initMatrix("right", "2nd");
      if(exit) break;

      obj.multiply3();
      obj.printResult();
    }
  } 
}
