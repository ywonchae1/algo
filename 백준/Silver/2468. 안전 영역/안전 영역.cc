#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<vector<int> > city;
int d[4][2] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

void bfs(int h, int w, int water, int qv[][100]) {
  queue<pair<int, int> > q;
  q.push(make_pair(h, w));
  qv[h][w] = 1;

  while(!q.empty()) {
    pair<int, int> sp = q.front();
    q.pop();
    int h = sp.first, w = sp.second;
    
    for(int i = 0; i < 4; i++) {
      int nh = h + d[i][0], nw = w + d[i][1];
      if(nh < 0 || nh >= city.size() || nw < 0 || nw >= city[0].size()) continue;
      if(qv[nh][nw] || city[nh][nw] <= water) continue;
      qv[nh][nw] = 1;
      q.push(make_pair(nh, nw));
    }
  }
}

int main() {
  int N, maxh = 0, maxcnt = 0;
  cin >> N;

  for(int i = 0; i < N; i++) {
    vector<int> row;
    for(int j = 0; j < N; j++) {
      int x;
      cin >> x;
      if(maxh < x) maxh = x;
      row.push_back(x);
    }
    city.push_back(row);
  }

  // 잠기는 높이를 하나씩 늘린다
  for(int k = 0; k <= maxh; k++) {
    // 방문 벡터 초기화
    int v[100][100] = {0,};
    // 안전지역 개수 초기화
    int cnt = 0;
    // 잠기는 지역을 체크하며 안전지역 개수 확인
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
        if(v[i][j] || city[i][j] <= k) continue;
        bfs(i, j, k, v);
        cnt++;
      }
    }
    if(maxcnt < cnt) maxcnt = cnt; // 최대 안전지역 개수 갱신
  }

  cout << maxcnt << endl;
}