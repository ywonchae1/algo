#include <iostream>
#include <vector>

using namespace std;

int N, M;
vector<int> res;
int v[9];

void printRes() {
  for(int i = 0; i < M; i++) {
    cout << res[i] << " ";
  }
  cout << endl;
}

void dfs(int start) {
  v[start] = 1;
  res.push_back(start);

  if(res.size() == M) {
    printRes();
    return;
  }

  for(int i = start + 1; i <= N; i++) {
    if(v[i]) continue;
    dfs(i);
    res.pop_back();
    v[i] = 0;
  }
}

int main() {
  cin >> N >> M;

  for(int i = 1; i <= N; i++) {
    dfs(i);
    res.pop_back();
    v[i] = 0;
  }
}