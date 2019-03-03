/*
Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.
*/
#include"pch.h"
#include<vector>
#include<iostream>
using namespace std;
class Solution {
public:
	int removeDuplicates(vector<int>& nums) {
		int len = 0;
		if (nums.size() > 0) { //check input size
			int seen = nums[0]; //tracks what numbers have been seen
			int replace_i = 1; //index of the element to be replaced
			len = 1;
			for (int i = 1; i < nums.size(); i++) {
				if (nums[i] != seen) {
					nums[replace_i] = nums[i]; //replace with new number
					replace_i++;
					seen = nums[i];
					len++;
				}
			}
		}
		return len;
	}
};

void print(vector<int>& nums, int len) {
	cout << len << endl;
	for (int i = 0; i < len; i++) {
		cout << nums[i] << " ";
	}
	cout << endl;
}

//int main() {
//	vector<int> nums = { 0,0,1,1,1,2,2,3,3,4 };
//	vector<int> nums2 = { 0,1,2,3,4,4,4 };
//	int len = Solution().removeDuplicates(nums);
//	int len2 = Solution().removeDuplicates(nums2);
//	print(nums, len);
//	print(nums2, len2);
//}