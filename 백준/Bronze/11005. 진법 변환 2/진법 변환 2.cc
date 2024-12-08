#include <iostream>
#include <stack>
using namespace std;

char conv(int rem) {
  if(rem < 10) return rem + '0';
  return (rem - 10) + 'A';
}

int main() {
    long num;
    cin >> num;
    long N;
    cin >> N;
    
    stack<char> res;
    
    while(num > 0) {
        int rem = num % N;
        res.push(conv(rem));
        num /= N;
    }
    
    while(!res.empty()) {
        cout << res.top();
        res.pop();
    }
    cout << endl;
}