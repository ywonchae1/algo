#include <iostream>
#include <queue>
#include <string.h>

using namespace std;

int W, H;
int board[51][51];
int v[51][51];

int d[8][2] = {{-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}};

void bfs(pair<int, int> sp) {
  queue<pair<int, int> > q;

  q.push(sp);

  v[sp.first][sp.second] = 1;

  while(!q.empty()) {
    pair<int, int> np = q.front();
    q.pop();

    for(int i = 0; i < 8; i++) {
      int nh = np.first + d[i][0];
      int nw = np.second + d[i][1];

      if(nh < 0 || nh >= H || nw < 0 || nw >= W || v[nh][nw] || board[nh][nw] == 0) continue;
      q.push(make_pair(nh, nw));
      v[nh][nw] = 1;
    }
  }
}

int main() {
  while(true) {
    cin >> W >> H;

    if(W == 0 && H == 0) break;

    memset(board, 0, sizeof(board));
    memset(v, 0, sizeof(v));

    for(int i = 0; i < H; i++) {
      for(int j = 0; j < W; j++) {
        int n;
        cin >> n;
        board[i][j] = n;
      }
    }

    // 지도 완성

    int cnt = 0;
    for(int i = 0; i < H; i++) {
      for(int j = 0; j < W; j++) {
        if(v[i][j] || board[i][j] == 0) continue;
        bfs(make_pair(i, j));
        cnt++;
      }
    }
    cout << cnt << endl;
  }
}