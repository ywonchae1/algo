#include <iostream>
#include <vector>
using namespace std;

vector<bool> check(6, false);
vector<vector<int>> arr = {
	{0, 0, 0, 0, 0, 0},
	{0, 0, 1, 1, 0, 0},
	{0, 1, 0, 1, 1, 0},
	{0, 1, 1, 0, 0, 1},
	{0, 0, 1, 0, 0, 1},
	{0, 0, 0, 1, 1, 0},
};

void dfs(int x) {
	check[x] = true; // �湮 �Ϸ�
	cout << "visited " << x << endl;
	for (int i = 1; i < 6; i++) {
		// cout << "i am.. " << i << endl;
		if (arr[x][i] && !check[i]) { // x���� i�� �� �� �ְ� i�� �湮���� �ʾҴٸ�
			dfs(i); // i�� ���ؼ� �ٽ� dfs
		}
	}
}

int main() {
	dfs(1);
}