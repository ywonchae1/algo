#include <iostream>
#include <vector>
#include <string.h>

using namespace std;

int N, M, SN, EN;
vector<pair<int, int> > edge[1001];
int v[1001];
int dp[1001];

void dfs(int cur) {
  if(cur == EN) return;

  for(pair<int, int> p : edge[cur]) {
    int np = p.first;
    int g = p.second;

    if(v[np] && dp[np] <= dp[cur] + g) continue;

    dp[np] = dp[cur] + g;
    v[np] = 1;
    dfs(np);
  }
}

int main() {
  cin >> N >> M;

  for(int i = 0; i < N - 1; i++) {
    int a, b, c;
    cin >> a >> b >> c;

    edge[a].push_back(make_pair(b, c));
    edge[b].push_back(make_pair(a, c));
  }
  // 연결 끝

  for(int i = 0; i < M; i++) {
    cin >> SN >> EN;

    memset(v, 0, sizeof(v));
    memset(dp, 0, sizeof(dp));

    v[SN] = 1;
    dfs(SN);

    cout << dp[EN] << endl;
  }
}