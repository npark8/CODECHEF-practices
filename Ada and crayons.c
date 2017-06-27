// https://www.codechef.com/problems/ADACRA/

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
