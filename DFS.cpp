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
	check[x] = true; // 방문 완료
	cout << "visited " << x << endl;
	for (int i = 1; i < 6; i++) {
		// cout << "i am.. " << i << endl;
		if (arr[x][i] && !check[i]) { // x에서 i로 갈 수 있고 i를 방문하지 않았다면
			dfs(i); // i에 대해서 다시 dfs
		}
	}
}

int main() {
	dfs(1);
}