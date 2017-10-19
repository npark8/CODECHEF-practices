/* https://www.codechef.com/problems/ADACRA/
 *  2017/06/24 Saturday 
 *
 * Question:
 * Ada has an array of N crayons, some crayons are pointing upwards and some downwards. 
 * Ada thinks that an array of crayons is beautiful if all the crayons are pointing in the same direction.
 * In one step you can flip any segment of consecutive crayons. 
 * After flipping a segment, all crayons pointing downwards will point upwards and visceversa
 * What is the minimum number of steps to make the array of crayons beautiful?
 *
 * Input:
 * The first line of the input contains T the number of test cases. 
 * Each test case is described in one line containing a string S of N characters, 
 * the i-th character is 'U' if the i-th crayon is pointing upwards and 'D' if it is pointing downwards.
 * 
 * Output:
 * For each test case, output a single line containing the minimum number of flips needed 
 * to make all crayons point to the same direction.
 *
 * Constraints:
 * 1 ≤ T ≤ 3000
 * 1 ≤ N ≤ 50
 */

#include <stdio.h>
#include <string.h>
 
int countSeg(char direction, int length, char crayon[]){
	int i,count = 0;
	for(i = 0;i<length;i++){
		if(crayon[i]==direction){
			count++;
			while(crayon[i]==direction && i<length) i++; 
			//look for consecutive U's/D's
		}
	}
	return count;
}
 
int main(){
	int t,u,d;
	char crayon[51];
	scanf("%d",&t);
	while(t>0){
		t--;
		scanf("%s",crayon);
		int length = strlen(crayon);
		u = countSeg('U',length,crayon);
		d = countSeg('D',length,crayon);
		if(u>d) printf("%d\n",d);
		else printf("%d\n",u);		
	}
	return 0;
}   
