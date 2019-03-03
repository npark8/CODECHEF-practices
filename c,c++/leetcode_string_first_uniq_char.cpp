/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
*/

#include"pch.h"
#include<unordered_map>
using namespace std;

class Solution {
public:
	int firstUniqChar(string s) {
		if (s.size() > 0) {
			unordered_map<char, int> duplicates;
			for (auto c : s) {
				duplicates[c] += 1;
			}
			int i = 0;
			for (auto c : s) {
				if (duplicates[c] == 1) return i;
				i++;
			}
		}
		return -1;
	}
};