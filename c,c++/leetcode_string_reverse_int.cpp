/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1]. 
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/
#include"pch.h"
#include<string>
#include<cmath>
#include<iostream>
#include<climits>
using namespace std;
class Solution {
public:
	int reverse(int x) {
		if (x > LONG_MAX || x < LONG_MIN) 
			return 0;
		string x_s = to_string(x);
		string ret = (x<0)?"-":"";//add negative sign 
		
		for (auto it = x_s.end() - 1; it >= x_s.begin();) {
			ret += *it;
			if (it > x_s.begin()) it--;
			else break;
		}
		x = stoi(ret);
		return x;
	}
};

static void print(int x) {
	cout << x << endl;
}

//int main() {
//	int r1 = Solution().reverse(321651684984);
//
//	print(r1);
//}