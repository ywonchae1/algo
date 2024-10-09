#include <iostream>
#include <vector>
#include <string.h>
#include <algorithm>

using namespace std;

vector<string> names;
int dooalpha[26];
int alpha[26];
string love = "LOVE";

int main() {
  int N, maxmod = 0;
  string doo, team;
  cin >> doo >> N;

  for(int i = 0; i < N; i++) {
    string name;
    cin >> name;
    names.push_back(name);
  }

  for(char c : doo) {
    int idx = c - 'A';
    dooalpha[idx]++;
  }

  sort(names.begin(), names.end());
  team = names[0];

  for(int i = 0; i < N; i++) {
    memset(alpha, 0, sizeof(alpha));
    string name = names[i];
    for(char c : name) {
      int idx = c - 'A';
      alpha[idx]++;
    }
    int sum = 1;
    for(int i = 0; i < love.length(); i++) {
      for(int j = i + 1; j < love.length(); j++) {
        int first = love[i] - 'A';
        int second = love[j] - 'A';
        sum *= (dooalpha[first] + alpha[first]) + (dooalpha[second] + alpha[second]);
      }
    }
    int mod = sum % 100;
    if(maxmod < mod) {
      maxmod = mod;
      team = name;
    }
  }

  cout << team << endl;
}