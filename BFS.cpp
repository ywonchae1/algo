#include <iostream>
#include <vector>
#include <queue>
using namespace std;

vector<int> visited(6, false);
vector<vector<int>> graph = {
	{0, 0, 0, 0, 0, 0},
	{0, 0, 0, 1, 0, 1},
	{0, 0, 0, 1, 1, 0},
	{0, 1, 1, 0, 0, 0},
	{0, 0, 1, 0, 0, 0},
	{0, 1, 0, 0, 0, 0},
};

void bfs(int x) {
	queue<int> q;
	q.push(x);

	while (!q.empty()) {
		// q가 비어있을 때까지
		int num = q.front();
		q.pop();
		cout << "visited.." << num << endl;
		visited[num] = true;
		for (int i = 1; i < 6; i++) {
			if (!visited[i] && graph[num][i]) {
				// 방문하지 않았다면
				q.push(i);
			}
		}
	}
}

int main() {
	bfs(1);
}