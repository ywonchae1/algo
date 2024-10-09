#include <iostream>
using namespace std;

int cnt[26];
int maxcnt, maxidx;

int main() {
  string req;
  cin >> req;

  for(int i = 0; i < req.length(); i++) {
    int idx;
    if(req[i] < 'a') idx = req[i] - 'A';
    else idx = req[i] - 'a';
    cnt[idx]++;
  }

  string answer;

  for(int i = 0; i < 26; i++) {
    if(cnt[i] == 0) continue;
    if(maxcnt < cnt[i]) {
      maxidx = i;
      maxcnt = cnt[i];
      answer = string{char('A' + maxidx)};
    } else if(maxcnt == cnt[i]) {
      answer = "?";
    }
  }

  cout << answer << endl;
}