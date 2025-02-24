#include <iostream>
#include <queue>
#include <functional>

using namespace std;

int N, L;
priority_queue<int, vector<int>, greater<int>> p;

void dfs(int idx) {
    if(idx == N || p.top() > L) return;
    
    L++;
    p.pop();
    dfs(idx + 1);
}

int main() {
    cin >> N >> L;
    
    for(int i = 0; i < N; i++) {
        int x;
        cin >> x;
        p.push(x);
    }
    
    dfs(0);
    
    cout << L << '\n';
    
    return 0;
}