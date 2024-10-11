#include <iostream>

using namespace std;

int N;
int dp[300];
int v[300];

int main() {
  cin >> N;

  for(int i = 0; i < N; i++) {
    if(i == 0) {
      int x;
      cin >> x;
      dp[0] = x;
      v[0] = x;
    }
    else if(i == 1) {
      int x;
      cin >> x;
      dp[1] = dp[0] + x;
      v[1] = x;
    } else {
      int x;
      cin >> x;
      int a = dp[i - 2] + x;
      int b = dp[i - 3] + v[i - 1] + x;
      if(a > b) dp[i] = a;
      else dp[i] = b;
      v[i] = x;
    }
  }

  cout << dp[N - 1] << endl;
}