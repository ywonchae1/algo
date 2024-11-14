#include <string>
#include <vector>
#include <string.h>
#include <queue>
#include <iostream>

using namespace std;

int H, W;
int v[500][500]; // 방문체크
int log[500][500]; // 그룹기록
int amount[250000]; // 석유양 저장
int av[250000]; // 그룹 방문 기록
int gi; // 그룹 순서
int d[4][2] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

int bfs(int h, int w, vector<vector<int>> &land) {
    queue<pair<int, int>> q;
    q.push(make_pair(h, w));
    v[h][w] = 1;
    log[h][w] = gi; // 그룹 갱신
    int find = 1;
    
    while(!q.empty()) {
        pair<int, int> np = q.front();
        q.pop();
        
        for(int i = 0; i < 4; i++) {
            int nh = np.first + d[i][0];
            int nw = np.second + d[i][1];
            
            if(nh < 0 || nh >= H || nw < 0 || nw >= W
               || land[nh][nw] == 0
               || v[nh][nw]) continue;
            
            v[nh][nw] = 1;
            log[nh][nw] = gi; // 그룹 갱신
            q.push(make_pair(nh, nw));
            find++;
        }
    }
    
    return find;
}

int solution(vector<vector<int>> land) {
    int answer = 0;
    H = land.size(); W = land[0].size();
    
    for(int h = 0; h < H; h++) {
        for(int w = 0; w < W; w++) {
            if(land[h][w] == 0 || v[h][w]) continue; // 0이거나 방문했으면 넘어가기
            int res = bfs(h, w, land);
            amount[gi++] = res;
        }
    }
    // 석유양 계산 완료
    
    for(int w = 0; w < W; w++) {
        int total = 0;
        memset(av, 0, W * H); // 그룹방문체크 초기화
        for(int h = 0; h < H; h++) {
            if(land[h][w] == 0 || av[log[h][w]])
                continue; // 0이거나 방문한 그룹이면 지나간다
            
            total += amount[log[h][w]]; // 석유양을 알아내서 추가
            av[log[h][w]] = 1; // 방문한 그룹임을 체크
        }
        if(answer < total) answer = total;
    }
    return answer;
}