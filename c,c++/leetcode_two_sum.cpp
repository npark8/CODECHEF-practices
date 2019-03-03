/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/


#include"pch.h"
#include<vector>
#include<unordered_map>
#include<iostream>
using namespace std;
class Solution {
public:
	//works if nums is sorted in ascending order
	vector<int> twoSum(vector<int>& nums, int target) {
		int beg = 0;
		int end = nums.size() - 1;
		vector<int> indicies;
		while (beg != end) {
			int temp = nums[beg] + nums[end];
			if (temp < target) beg++;
			else if (temp > target) end--;
			else {
				indicies.push_back(beg);
				indicies.push_back(end);
				break;
			}
		}
		return indicies;
	}
	//general solution
	vector<int> twoSum2(vector<int>& nums, int target) {
		int beg = 0;
		int end = nums.size() - 1;
		vector<int> indicies;
		unordered_map<int, int> complements;
		for (int i = 0; i < nums.size(); i++) {
			if (!complements.empty()){
				int complement = target - nums[i];
				auto find_complement = complements.find(complement);
				if (find_complement != complements.end()) {
					indicies.push_back(find_complement->second);
					indicies.push_back(i);
					break;
				}
			}
			complements.insert({ nums[i],i });
		}
		return indicies;
	}
};

//int main() {
//	vector<int> nums = {3,2,4};
//	vector<int> ret = Solution().twoSum2(nums, 6);
//	cout << ret[0] << " " << ret[1] << endl;
//}