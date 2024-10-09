#include <iostream>
#include <stack>

using namespace std;

void flip(int &n, int &res) {
  stack<int> st;
  int ten = 1;
  while(n) {
    st.push(n % 10);
    n /= 10;
  }
  while(!st.empty()) {
    int n = st.top();
    st.pop();
    res += n * ten;
    ten *= 10;
  }
}

int main() {
  int X, Y;
  cin >> X >> Y;
  int nX = 0, nY = 0;
  flip(X, nX);
  flip(Y, nY);
  int res = nX + nY;
  int nres = 0;
  flip(res, nres);

  cout << nres << endl;
}