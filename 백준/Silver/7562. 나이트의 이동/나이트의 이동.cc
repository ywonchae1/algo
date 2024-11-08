#include <iostream>
#include <queue>
#include <string.h>
#include <climits>
#include <cmath>

using namespace std;

int N, I, SH, SW, EH, EW;
int board[301][301];
int v[301][301];
int d[8][2] = {{-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}};

void bfs(pair<int, int> sp) {
  queue<pair<int, int> > q;

  q.push(sp);
  board[sp.first][sp.second] = 0;

  while(!q.empty()) {
    pair<int, int> np = q.front();
    q.pop();

    if(np.first == EH && np.second == EW) break;

    for(int i = 0; i < 8; i++) {
      int nh = np.first + d[i][0];
      int nw = np.second + d[i][1];

      if(nh < 0 || nh >= I || nw < 0 || nw >= I) continue;
      if(v[nh][nw] && board[nh][nw] <= board[np.first][np.second] + 1) continue;
      q.push(make_pair(nh, nw));
      if(board[nh][nw] == 0) board[nh][nw] = board[np.first][np.second] + 1;
      else board[nh][nw] = min(board[nh][nw], board[np.first][np.second] + 1);
      v[nh][nw] = 1;
    }
  }
}

int main() {
  cin >> N;

  for(int i = 0; i < N; i++) {
    cin >> I >> SH >> SW >> EH >> EW;
    memset(board, 0, sizeof(board));
    memset(v, 0, sizeof(v));

    bfs(make_pair(SH, SW));

    cout << board[EH][EW] << endl;
  }
}