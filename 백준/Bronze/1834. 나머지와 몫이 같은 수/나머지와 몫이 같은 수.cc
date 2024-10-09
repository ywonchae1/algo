#include <iostream>

using namespace std;

int main() {
  int N;
  cin >> N;
  long answer = 0;
  for(int i = 1; i < N; i++) {
    answer += i;
  }
  answer *= N + 1;
  cout << answer << endl;
}