#include <iostream>
#include <queue>

using namespace std;

int main() {
  int T, N;
  cin >> T;
  for(int i = 0; i < T; i++) {
    cin >> N;
    priority_queue<pair<int, int> > q;
    for(int j = 0; j < N; j++) {
      pair<int, int> p;
      int x, y;
      cin >> x >> y;
      p.first = -x;
      p.second = y;
      q.push(p);
    }

    int cnt = 1;
    pair<int, int> sp = q.top();
    q.pop();
    while(!q.empty()) {
      pair<int, int> np = q.top();
      q.pop();
      if(sp.second > np.second) {
        cnt++;
        sp = np;
      }
    }
    cout << cnt << endl;
  }
}