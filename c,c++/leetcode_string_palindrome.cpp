#include"pch.h"
#include<algorithm>
#include<string>
#include<cctype>
#include<iostream>
using namespace std;
class Solution {
public:
	bool isPalindrome(string s) {
		//filter alphanumeric values
		if (s.size() > 0) {
			string s2 = filterAlphNumeric(s);
			for (auto& c : s2) {
				c = toupper(c);
			}
			string s3 = s2;
			reverse(s3.begin(), s3.end());
			if (s2 == s3) return true;
			return false;
		}
		return true;
	}
	string filterAlphNumeric(string s) {
		string ret = "";
		for (auto it = s.begin(); it < s.end(); it++) {
			if (isalnum(*it)) ret += *it;
		}
		return ret;
	}
};

//int main() {
//	bool r1 = Solution().isPalindrome("A man, a plan, a canal: Panama");
//	cout << r1 << endl;
//}