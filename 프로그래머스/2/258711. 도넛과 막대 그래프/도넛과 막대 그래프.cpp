#include <string>
#include <vector>
#include <queue>

using namespace std;

int inde[1000005];
int outde[1000005];
vector<vector<int>> path(1000005);
int t8, t1, t0;

void check(int start) {
    queue<int> q;
    q.push(start);
    bool isvisited = false; // 시작점을 방문했는지
    
    while(!q.empty()) {
        int now = q.front();
        q.pop();
        
        if(now == start && isvisited) {
            // 시작 지점으로 돌아왔고 방문했다면
            t0++; // 도넛
            return;
        }
        
        if(path[now].size() >= 2) {
            // 현재 위치에서 나가는 간선이 2개 이상이면
            t8++; // 8자
            return;
        }
        
        for(int i = 0; i < path[now].size(); i++) {
            q.push(path[now][i]);
        }
        isvisited = true; // 방문했다
    }
    t1++; // return되지 않은 것들은 직선
    return;
}

vector<int> solution(vector<vector<int>> edges) {
    vector<int> answer;
    
    for(int i = 0; i < edges.size(); i++) {
        inde[edges[i][1]]++; // 정점 i로 들어오는 간선
        outde[edges[i][0]]++; // 정점 i에서 나가는 간선
        path[edges[i][0]].push_back(edges[i][1]);
    }
    
    for(int i = 1; i < 1000005; i++) {
        if(inde[i] == 0 && outde[i] >= 2) {
            // 들어오는 간선이 없고, 나가는 간선이 두 개 이상이면 새로운 정점
            answer.push_back(i);
            break;
        }
    }
    
    vector<int> start = path[answer[0]];
    for(int i = 0; i < start.size(); i++) {
        check(start[i]);
    }
    
    answer.push_back(t0);
    answer.push_back(t1);
    answer.push_back(t8);
    
    return answer;
}