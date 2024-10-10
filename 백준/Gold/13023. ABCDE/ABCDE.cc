#include <iostream>
#include <vector>
#include <string.h>

using namespace std;

int N, M;
vector<int> member[2000];
int v[2000];
int answer;

void dfs(int idx, int cnt) {
  if(cnt == 4) {
    answer = 1;
    return;
  }

  v[idx] = 1;

  int size = member[idx].size();
  for(int i = 0; i < size; i++) {
    int nm = member[idx][i];
    if(!v[nm]) {
      dfs(nm, cnt + 1);
      v[nm] = 0;
    }
  }
}

int main() {
  cin >> N >> M;
  for(int i = 0; i < M; i++) {
    int a, b;
    cin >> a >> b;
    member[a].push_back(b);
    member[b].push_back(a);
  }

  for(int i = 0; i < N; i++) {
    memset(v, 0, sizeof(v));
    dfs(i, 0);
    if(answer == 1) {
      cout << answer << endl;
      return 0;
    }
  }

  cout << answer << endl;
}