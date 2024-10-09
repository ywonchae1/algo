#include <iostream>
#include <vector>

using namespace std;

int main() {
  int A, B;
  cin >> A >> B;
  
  int after = 0;
  int p = 1;
  int num = 1;
  while(p <= B) {
    for(int i = 0; i < num; i++) {
      if(p >= A) after += num;
      p++;
      if(p > B) break;
    }
    num++;
  }

  cout << after << endl;
}