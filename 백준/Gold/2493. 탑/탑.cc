#include <iostream>
#include <stack>
#include <vector>

using namespace std;

int main() {
  int N;
  cin >> N;
  stack<pair<int, int> > st;
  vector<int> res;

  for(int i = 0; i < N; i++) {
    int b;
    cin >> b;

    while(!st.empty() && st.top().first <= b) {
      st.pop();
    }
    if(st.empty()) res.push_back(0);
    else res.push_back(st.top().second);

    st.push(make_pair(b, i + 1));
  }

  for(int i = 0; i < res.size() - 1; i++) {
    cout << res[i] << " ";
  }
  cout << res[res.size() - 1] << endl;
}