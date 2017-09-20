/* http://www.programmr.com/challenges/matrix-multiplication-1
   2017/09/20 Wednesday */

import java.io.*;
import java.util.*; 
class MatrixMultiplication{

  public static void main(String[] args)  {

     int array[][] = new int[3][3];
     int array1[][] =new int[3][3];
     int array2[][] = new int[3][3];

     Scanner scan=new Scanner(System.in);

     for(int i = 0; i < 3; i++) {
       for(int j = 0; j <3; j++) {
          System.out.println("Matrix 1st ["+i+"]["+j+"]:");
          array[i][j]=scan.nextInt();
        }
       }

     for(int i = 0; i < 3; i++) {
        for(int j = 0; j < 3; j++) {
          System.out.println("Matrix 2nd ["+i+"]["+j+"]:");
          array1[i][j]=scan.nextInt();
        }
       }

  //write your logic here 
    int count = 0; int res = 0;
    int x = 0; int y = 0;
    while(count < 9){
        for(int j = 0; j < 3; j++) {
           // System.out.println(array[x][j] + " " + array1[j][y]);
          res += array[x][j] * array1[j][y]; 
        }
        //System.out.println(res + " at: " + x + "," + y);
        array2[x][y] = res;
        count++;
        //System.out.println(count);
        y++;
        res = 0;
        if(count==3||count==6||count==9) x++;
        if(y==3) y=0;
    }
  //end


  System.out.println("Multiply of both matrix:");

  for(int i = 0; i < 3; i++) 
  {
     for(int j = 0; j < 3; j++) 
      {
          System.out.print(array2[i][j]+" ");
      }  
     System.out.println();
  }

  }

} 