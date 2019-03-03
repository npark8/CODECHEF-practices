#include"pch.h"
#include<unordered_map>
#include<iostream>
using namespace std;

class Solution {
public:
	//other approach: use int map[26] for a-z lowercase strings; hashmap handles unicodes too
	bool isAnagram(string s, string t) {
		unordered_map<char, int> t_map;
		unordered_map<char, int> s_map;
		if (s.size() == t.size()) {
			for (auto c : t) {
				t_map[c] += 1;
			}
			for (auto c : s) {
				s_map[c] += 1;
			}
			for (auto c : s) {
				if (t_map[c] == 0 || t_map[c] != s_map[c]) return false;
			}
			return true;
		}
		return false;
	}
};


//int main() {
//	int r1 = Solution().isAnagram("aacc","ccac");
//	cout << r1 << endl;
//}