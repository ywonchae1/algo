#include <iostream>
#include <string.h>
#include <stack>

using namespace std;

int main() {
  int N;
  cin >> N;
  stack<pair<int, int> > v;
  int big[1000000];
  memset(big, -1, sizeof(big));

  for(int i = 0; i < N; i++) {
    int num;
    cin >> num;
    if(v.empty()) {
      v.push(make_pair(num, i));
      continue;
    }
    while(!v.empty() && v.top().first < num) {
      int n = v.top().second;
      v.pop();
      big[n] = num;
    }
    v.push(make_pair(num, i));
  }

  for(int i = 0; i < N - 1; i++) {
    cout << big[i] << " ";
  }
  cout << big[N - 1] << endl;

  return 0;
}