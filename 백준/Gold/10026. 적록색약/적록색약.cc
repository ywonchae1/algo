#include <iostream>
#include <vector>
#include <queue>
#include <string.h>

using namespace std;
#define MAX 100

int N;
vector<string> pic;
vector<string> gpic;
int d[4][2] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
int v[MAX][MAX];
int cnt, gcnt;

void bfs(pair<int, int> sp, char color) {
  queue<pair<int, int> > q;
  q.push(sp);
  while(!q.empty()) {
    pair<int, int> p = q.front();
    q.pop();
    int h = p.first;
    int w = p.second;

    for(int i = 0; i < 4; i++) {
      int nh = h + d[i][0];
      int nw = w + d[i][1];

      if(nh < 0 || nh >= N || nw < 0 || nw >= N) continue;
      if(v[nh][nw] || color != pic[nh][nw]) continue;
      q.push(make_pair(nh, nw));
      v[nh][nw] = 1;
    }
  }
}

void gbfs(pair<int, int> sp, char color) {
  queue<pair<int, int> > q;
  q.push(sp);
  while(!q.empty()) {
    pair<int, int> p = q.front();
    q.pop();
    int h = p.first;
    int w = p.second;

    for(int i = 0; i < 4; i++) {
      int nh = h + d[i][0];
      int nw = w + d[i][1];

      if(nh < 0 || nh >= N || nw < 0 || nw >= N) continue;
      if(v[nh][nw] || color != gpic[nh][nw]) continue;
      q.push(make_pair(nh, nw));
      v[nh][nw] = 1;
    }
  }
}

int main() {
  cin >> N;
  for(int i = 0; i < N; i++) {
    string row;
    cin >> row;
    pic.push_back(row);
    string grow = "";
    for(int j = 0; j < N; j++) {
      if(row[j] == 'G') grow += 'R';
      else grow += row[j];
    }
    gpic.push_back(grow);
  }

  for(int i = 0; i < N; i++) {
    for(int j = 0; j < N; j++) {
      if(v[i][j]) continue;
      v[i][j] = 1;
      bfs(make_pair(i, j), pic[i][j]);
      cnt++;
    }
  }

  memset(v, 0, sizeof(v));

  for(int i = 0; i < N; i++) {
    for(int j = 0; j < N; j++) {
      if(v[i][j]) continue;
      v[i][j] = 1;
      gbfs(make_pair(i, j), gpic[i][j]);
      gcnt++;
    }
  }

  cout << cnt << " " << gcnt << endl;
}