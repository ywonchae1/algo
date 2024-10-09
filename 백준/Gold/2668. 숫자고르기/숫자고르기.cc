#include <iostream>
#include <queue>
#include <set>
#include <string.h>

using namespace std;
#define MAX 101

int v[MAX];
int vv[MAX];
int cnt[MAX];
int nums[MAX];
int N;
priority_queue<int, vector<int>, greater<int> > res;
set<int> resset;

void checkdfs(int idx) {
  if(vv[idx]) return;
  vv[idx] = 1;
  resset.insert(idx);
  checkdfs(nums[idx]);
}

void resetv(int idx) {
  if(!v[idx]) return;
  v[idx] = 0;
  resetv(nums[idx]);
}

void dfs(int idx, int sp) {
  if(v[idx]) {
    if(idx == sp) {
      checkdfs(idx);
    } else {
      resetv(sp);
    }
    return;
  }
  
  v[idx] = 1;

  dfs(nums[idx], sp);
}

int main() {
  cin >> N;
  for(int i = 1; i <= N; i++) {
    cin >> nums[i];
  }

  for(int i = 1; i <= N; i++) {
    memset(cnt, 0, sizeof(cnt));
    memset(vv, 0, sizeof(vv));
    dfs(i, i);
  }

  for(set<int>::iterator it = resset.begin(); it != resset.end(); it++) {
    res.push(*it);
  }

  cout << res.size() << endl;
  while(!res.empty()) {
    cout << res.top() << endl;
    res.pop();
  }
}