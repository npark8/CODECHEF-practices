#include"pch.h"
#include<vector>
#include<iostream>
#include<algorithm>
using namespace std;

class Solution {
public:
	void moveZeroes(vector<int>& nums) {
		if (nums.size() > 0) {
			int zero_count = count(nums.begin(), nums.end(), 0);
			int count =0, i = 0;
			while(count < zero_count) {
				if (nums[i] == 0) {
					nums.erase(nums.begin()+i);
					nums.push_back(0);
					count++;
				}
				else i++;
			}
		}
	}
};

void print(vector<int>& nums) {
	for (int i = 0; i < nums.size(); i++) {
		cout << nums[i] << " ";
	}
	cout << endl;
}

//int main() {
//	vector<int> nums = {0,0,1};
//	vector<int> nums2= { 0, 1, 0, 3, 12 };
//	Solution().moveZeroes(nums);
//	Solution().moveZeroes(nums2);
//	print(nums);
//	print(nums2);
//}