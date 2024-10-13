#include <iostream>
#include <vector>
#include <queue>
#include <string.h>
#include <climits>

using namespace std;

int N, M, K, X;

vector<int> vx[300001];
int dist[300001];
int v[300001];

void dji(int st) {
    queue<int> q;
    q.push(st);
    dist[st] = 0;
    
    while(!q.empty()) {
        int next = q.front();
        q.pop();
        v[next] = 1;
        
        for(int i = 0; i < vx[next].size(); i++) {
            int nn = vx[next][i];
            if(dist[nn] == -1 || dist[nn] > dist[next] + 1) {
                dist[nn] = dist[next] + 1;
            }
            if(!v[nn]) q.push(nn);
        }
    }
}

int main() {
    cin >> N >> M >> K >> X;
    
    for(int i = 0; i < M; i++) {
        int x, y;
        cin >> x >> y;
        vx[x].push_back(y);
    }
    
    memset(dist, -1, sizeof(dist));
    
    dji(X);

    string res = "";
    
    for(int i = 1; i <= N; i++) {
        if(dist[i] == K) {
            res += to_string(i) + "\n";
        }
    }
    
    if(res == "") cout << -1 << "\n";
    else cout << res;
}