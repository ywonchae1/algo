#include <iostream>
#include <vector>

using namespace std;

int main() {
  int N, M;
  cin >> N >> M;

  vector<int> rowv = vector<int>(N);
  vector<int> colv = vector<int>(M);

  int rown = 0, coln = 0;

  for(int i = 0; i < N; i++) {
    string row;
    cin >> row;
    for(int j = 0; j < M; j++) {
      if(row[j] == 'X') {
        rowv[i] = 1;
        colv[j] = 1;
      }
    }
  }
  
  for(int i = 0; i < N; i++) {
    if(rowv[i] == 0) rown++;
  }
  
  for(int i = 0; i < M; i++) {
    if(colv[i] == 0) coln++;
  }

  if(rown > coln) {
    cout << rown << endl;
  } else {
    cout << coln << endl;
  }
}