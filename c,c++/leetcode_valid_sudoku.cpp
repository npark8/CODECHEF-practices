#include"pch.h"
#include<vector>
#include<iostream>
using namespace std;

class Solution {
public:
	bool isValidSudoku(vector<vector<char>>& board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' && !is_regal(board, i, j))
					return false;
			}
		}
		return true;
	}
	bool is_regal(vector<vector<char>>& board, int r, int c) {
		for (int i = 0; i < 9; i++) { //check current row
			if (i == c) continue;
			if (board[r][i] != board[r][c])
				continue;
			else {
				cout << "cell: " << board[r][c] << "\n";
				cout << "row: " << r << " failed\n";
				return false;
			}
				
		}
		for (int i = 0; i < 9; i++) { //check current column
			if (i == r) continue;
			if (board[i][c] != board[r][c])
				continue;
			else {
				cout << "cell: " << board[r][c] << "\n";
				cout << "col: " << c << " failed\n";
				return false;
			}

		}
		//check current quadrant
		int cornerX = 0, cornerY = 0;
		if (r >= 3 && r < 6) cornerX = 3;
		else if (r >= 6) cornerX = 6;
		if (c >= 3 && c < 6) cornerY = 3;
		else if (c >= 6) cornerY = 6;
		for (int i = cornerX; i < cornerX + 3; i++) {
			for (int j = cornerY; j < cornerY + 3; j++) {
				if (i == r && j == c) continue;
				if (board[i][j] != board[r][c]) continue;
				else {
					cout << "cell: " << board[r][c] << "\n";
					cout << "quadrant: " << cornerX << "," << cornerY << " failed\n";
					return false;
				}
			}
		}
		return true;
	}
};

void print(bool result) {
	cout << result << endl;
}

//int main() {
//	vector<vector<char>> sudoku =
//		{{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//		{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//		{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//		{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//		{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//		{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//		{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//		{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//		{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
//	bool result = Solution().isValidSudoku(sudoku);
//	print(result);
//}