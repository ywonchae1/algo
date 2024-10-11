#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

int N, M;
priority_queue<int, vector<int>, greater<int> > q;
vector<int> pv;
vector<int> res;
int v[9];

void printRes() {
  for(int i = 0; i < res.size(); i++) {
    cout << res[i] << " ";
  }
  cout << "\n";
}

void dfs(int idx) {
  int n = pv[idx];
  v[idx] = 1;
  res.push_back(n);

  if(res.size() == M) {
    printRes();
    return;
  }

  for(int i = 0; i < pv.size(); i++) {
    if(v[i]) continue;
    dfs(i);
    v[i] = 0;
    res.pop_back();
  }
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> N >> M;
  for(int i = 0; i < N; i++) {
    int n;
    cin >> n;
    q.push(n);
  }
  while(!q.empty()) {
    int n = q.top();
    q.pop();
    pv.push_back(n);
  }

  for(int i = 0; i < pv.size(); i++) {
    dfs(i);
    v[i] = 0;
    res.pop_back();
  }
}