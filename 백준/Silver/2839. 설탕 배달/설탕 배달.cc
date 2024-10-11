#include <iostream>
#include <climits>

using namespace std;

int minn = INT_MAX;

int main() {
  int N;
  cin >> N;
  
  // 5의 배수인 경우
  if(N % 5 == 0) {
    int n = N / 5;
    if(minn > n) minn = n;
  }
  // 3의 배수인 경우
  else if(N % 3 == 0) {
    int n = N / 3;
    if(minn > n) minn = n;
  }
  // 3을 하나씩 더해가며 나누어 떨어지는 순간을 발견
  int cnt = 0;
  while(N > 0) {
    N -= 3;
    cnt++;
    if(N % 5 == 0) {
      int n = (N / 5) + cnt;
      if(minn > n) minn = n;
    }
  }
  if(minn == INT_MAX) cout << -1 << endl;
  else cout << minn << endl;
}