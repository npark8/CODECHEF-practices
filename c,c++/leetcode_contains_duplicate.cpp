/*
Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
*/
#include"pch.h"
#include<vector>
#include<unordered_map>
#include<algorithm>
using namespace std;
class Solution {
public:
	bool containsDuplicate(vector<int>& nums) {
		if (nums.size() > 0) {
			unordered_map<int, int> duplicates; //tracks elements that has been seen, space complexity O(n)
			for (int i = 0; i < nums.size(); i++) {
				auto seen = duplicates.find(nums[i]);
				if (seen != duplicates.end())//found
					return true;
				duplicates.insert({ nums[i],nums[i] });
			}
		}
		return false;
	}
	//use sort and comparison
	bool containsDuplicate2(vector<int>& nums) {
		if (nums.size() > 0) {
			sort(nums.begin(), nums.end());
			for (int i = 0; i < nums.size() -1; i++) {
				if (nums[i] == nums[i+1])//found
					return true;
			}
		}
		return false;
	}
};