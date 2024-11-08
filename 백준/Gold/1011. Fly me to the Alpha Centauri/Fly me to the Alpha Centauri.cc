#include <iostream>
#include <cmath>

using namespace std;

int main() {
  int N;
  cin >> N;

  for(int i = 0; i < N; i++) {
    long long s, e;
    cin >> s >> e;
    long long len = e - s;
    long long d = sqrt(len);

    long long cnt = pow(d, 2) == len ? d * 2 - 1 : d * 2;
    if(d * (d + 1) < len) cnt++;

    cout << cnt << endl;
  }
}