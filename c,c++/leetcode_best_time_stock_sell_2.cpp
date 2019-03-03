/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
			 Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
			 Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
			 engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
*/
#include"pch.h"
#include<vector>
#include<algorithm>
#include<iostream>
using namespace std;
class Solution {
public:
	int maxProfit(vector<int>& prices) {
		int profit = 0;
		if (prices.size() >= 2) {
			const char* flag = "buy";
			int global_min = *min_element(prices.begin(), prices.end());
			int global_max = *max_element(prices.begin(), prices.end());
			if (is_sorted(prices, true))
				//ascending - buy @ min, sell @max
				return global_max - global_min;

			if(is_sorted(prices, false)) //descending - no profit possible
				return 0;
			cout << "min: " << global_min << " max: " << global_max << endl;
			int i;
			for (i = 0; i < prices.size() -1; i++) {
				if (flag == "buy") {
					if (prices[i] == global_min || prices[i] < prices[i + 1]) {
						profit -= prices[i];
						flag = "sell";
					}
				}
				else { //sell
					if (prices[i] == global_max || prices[i] > prices[i + 1]) {
						profit += prices[i];
						flag = "buy";
					}
				}
			}
			cout << "i: " << i << endl;
			//take care of the last sell opportunity if missed
			if (prices[i] > prices[i-1] && flag == "sell") 
				profit += prices[prices.size() - 1];
			//take care of negative profit
			if (profit < 0) profit = 0;
		}
		return profit;
	}
	//simplified version	
	int maxProfit2(vector<int>& prices) {
		int profit = 0;
		if (prices.size() > 0) {
			for (int i = 0; i < prices.size() - 1; i++) {
				if (prices[i] < prices[i + 1]) {
					profit += prices[i+1] - prices[i];
				}
			}
		}
		return profit;
	}
	bool is_sorted(vector<int>& a, bool ascending) {
		for (int i = 0; i < a.size()-1; i++) {
			if (ascending) { //eg. 1,2,3,4,5
				if (a[i] > a[i + 1]) return false;
			}
			else //eg. 5,4,3,2,1
				if (a[i] < a[i + 1]) return false;
		}
		return true;
	}

};

void print(int profit) {
	cout << profit << endl;
}

//int main() {
//	vector<int> prices = { 7,1,5,3,6,4 };
//	vector<int> prices2 = { 1,2,3,4,5 };
//	vector<int> prices3 = { 7,1,5,3,4,6 };
//	int p1 = Solution().maxProfit(prices);
//	int p2 = Solution().maxProfit(prices2);
//	int p3 = Solution().maxProfit(prices3);
//	int p4 = Solution().maxProfit2(prices);
//	int p5 = Solution().maxProfit2(prices2);
//	int p6 = Solution().maxProfit2(prices3);
//	print(p1);
//	print(p2);
//	print(p3);
//	print(p4);
//	print(p5);
//	print(p6);
//}