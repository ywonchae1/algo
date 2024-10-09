#include <iostream>
#include <vector>
#include <set>

using namespace std;
#define MAX 1000

int N;
int stu[MAX][MAX];
set<int> know[MAX];

int main() {
  cin >> N;
  for(int i = 0; i < N; i++) {
    for(int j = 0; j < 5; j++) {
      cin >> stu[i][j];
    }
  }

  for(int w = 0; w < 5; w++) {
    for(int h = 0; h < N; h++) {
      int pivot = stu[h][w];
      for(int k = h + 1; k < N; k++) {
        if(pivot == stu[k][w]) {
          know[h].insert(k);
          know[k].insert(h);
        }
      }
    }
  }

  int maxn = 0;
  int maxidx = 0;

  for(int i = 0; i < N; i++) {
    int stun = know[i].size();
    if(maxn < stun) {
      maxn = stun;
      maxidx = i;
    }
  }

  cout << maxidx + 1 << endl;
}