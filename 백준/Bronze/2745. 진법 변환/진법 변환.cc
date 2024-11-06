#include <iostream>

using namespace std;

int main() {
  string s;
  int jin;
  cin >> s >> jin;

  int base = 1;
  long long res = 0;

  for(int i = s.length() - 1; i >= 0; i--) {
    char c = s[i];
    int num;

    if(c >= 'A') {
      num = c - 'A' + 10;
    } else {
      num = c - '0';
    }

    num *= base;
    res += num;
    base *= jin;
  }

  cout << res << endl;
}