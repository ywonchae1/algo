#include <iostream>

using namespace std;

int square[100][100];

int main() {
  int num, ex = 0;
  cin >> num;

  for(int i = 0; i < num; i++) {
    int w, h;
    cin >> w >> h;

    w--; h--;

    for(int hi = h; hi < h + 10; hi++) {
      for(int wi = w; wi < w + 10; wi++) {
        square[hi][wi]++;
        if(square[hi][wi] > 1) ex++;
      }
    }
  }

  cout << 100 * num - ex << endl;
}