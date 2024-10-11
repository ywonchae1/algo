#include <iostream>

using namespace std;

int v[10000];
int p[10000];
int dp[10000];
int maxn, N;

int main() {
  cin >> N;
  for(int i = 0; i < N; i++) {
    int x;
    cin >> x;
    v[i] = x;
    if(i == 0) {
      dp[i] = x;
      if(maxn < dp[i]) maxn = dp[i];
      continue;
    } else if(i == 1) {
      dp[i] = dp[0] + x;
    } else if(i == 2) {
      int a = dp[i - 2] + x;
      int b = v[i - 1] + x;
      if(a > b) dp[i] = a;
      else dp[i] = b;
    } else {
      // dp[i - 2]까지의 최대 + x
      int max = 0;
      for(int j = 0; j < i - 1; j++) {
        if(max < dp[j]) max = dp[j];
      }
      int a = max + x;
      // dp[i - 3] 까지의 최대 + v[i - 1] + x
      max = 0;
      for(int j = 0; j < i - 2; j++) {
        if(max < dp[j]) max = dp[j];
      }
      int b = max + v[i - 1] + x;
      if(a > b) dp[i] = a;
      else dp[i] = b;
    }
    if(maxn < dp[i]) maxn = dp[i];
  }

  cout << maxn << endl;
}