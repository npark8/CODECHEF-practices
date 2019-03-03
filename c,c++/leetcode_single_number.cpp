/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
*/
#include"pch.h"
#include<unordered_map>
#include<vector>

using namespace std;
class Solution {
public:
	//use XOR => [1,2,1,2,3] => r=r^nums[i] ==> 1^1 = 0; 2^2 = 0; 0^3 = 3
	int singleNumber(vector<int>& nums) {
		unordered_map<int, int> duplicates;
		for (int i = 0; i < nums.size(); i++) {
			auto duplicate = duplicates.find(nums[i]);
			if (duplicate != duplicates.end()) {
				duplicate->second++;
			}
			else duplicates.insert({ nums[i],1 });
		}
		for (auto d : duplicates) {
			if (d.second == 1) return d.first;
		}
		return 0;
	}
};