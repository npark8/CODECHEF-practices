/*Given an array, rotate the array to the right by k steps, where k is non - negative.

Example 1:

Input: [1, 2, 3, 4, 5, 6, 7] and k = 3
	Output : [5, 6, 7, 1, 2, 3, 4]
	Explanation :
	rotate 1 steps to the right : [7, 1, 2, 3, 4, 5, 6]
	rotate 2 steps to the right : [6, 7, 1, 2, 3, 4, 5]
	rotate 3 steps to the right : [5, 6, 7, 1, 2, 3, 4]
	Example 2 :

	Input : [-1, -100, 3, 99] and k = 2
	Output : [3, 99, -1, -100]
	Explanation :
	rotate 1 steps to the right : [99, -1, -100, 3]
	rotate 2 steps to the right : [3, 99, -1, -100]
*/
#include"pch.h"
#include<vector>
using namespace std;
class Solution {
public:
	void rotate(vector<int>& nums, int k) {
		//simply pop the back element and reappend it to the beginning of the vector 
		for (int i = 0; i < k; i++) {
			int temp = nums.back();
			nums.pop_back();
			nums.insert(nums.begin(), temp);
		}
	}
};