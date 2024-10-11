#include <iostream>
#include <string.h>
#include <vector>

using namespace std;

int N;
int v[10];
vector<int> bu;
string maxs, mins;

void compMinMax(string str) {
  if(maxs == "" && mins == "") {
    maxs = str;
    mins = str;
  }

  for(int i = 0; i <= N; i++) {
    if(maxs[i] < str[i]) {
      maxs = str;
      break;
    } else if(maxs[i] == str[i]) continue;
    else if(maxs[i] > str[i]) break;
  }
  for(int i = 0; i <= N; i++) {
    if(mins[i] < str[i]) break;
    else if(mins[i] == str[i]) continue;
    else if(mins[i] > str[i]) {
      mins = str;
      break;
    }
  }
}

void dfs(int x, int bx, string str) {
  if(str.length() == N + 1) {
    compMinMax(str);
    return;
  }
  if(v[x]) {
    return;
  }

  v[x] = 1;

  int start, end;
  if(bu[bx]) {
    // before > after
    start = 0;
    end = x;
  } else {
    start = x + 1;
    end = 10;
  }

  for(int i = start; i < end; i++) {
    if(v[i]) continue;
    dfs(i, bx + 1, str + to_string(i));
    v[i] = 0;
  }
}

int main() {
  cin >> N;
  for(int i = 0; i < N; i++) {
    char c;
    cin >> c;
    if(c == '<') bu.push_back(0);
    else if(c == '>') bu.push_back(1);
  }

  for(int i = 0; i < 10; i++) {
    dfs(i, 0, to_string(i));
    v[i] = 0;
  }

  cout << maxs << endl;
  cout << mins << endl;
}