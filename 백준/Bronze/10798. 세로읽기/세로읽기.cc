#include <iostream>

using namespace std;

string mystr[15];

int main() {
  for(int i = 0; i < 5; i++) {
    string s;
    cin >> s;

    for(int i = 0; i < s.length(); i++) {
      mystr[i] += s[i];
    }
  }

  for(int i = 0; i < 15; i++) {
    cout << mystr[i];
  }
  cout << endl;
}