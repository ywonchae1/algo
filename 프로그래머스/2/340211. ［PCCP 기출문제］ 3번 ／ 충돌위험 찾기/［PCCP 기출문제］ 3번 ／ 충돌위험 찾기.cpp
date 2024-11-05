#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> board[101][101];

int check(vector<int> b) {
    int total = 0;
    for(int i = 0; i < b.size(); i++) {
        int p = b[i];
        int cnt = 0;
        for(int j = i + 1; j < b.size(); j++) {
            if(p != -1 && p == b[j]) {
                b[j] = -1;
                cnt++;
            }
        }
        if(cnt > 0) total++;
    }
    return total;
}

void printboard(vector<int> b) {
    for(int i : b) cout << i;
    cout << endl;
}

int solution(vector<vector<int>> points, vector<vector<int>> routes) {
    int answer = 0;
    for(vector<int> route : routes) {
        int time = 0;
        for(int i = 0; i < route.size() - 1; i++) {
            int sp = route[i] - 1;
            int ep = route[i + 1] - 1;
            
            // h 좌표 갱신
            int hd = 0;
            if(points[ep][0] > points[sp][0]) {
                // h 좌표를 늘려야 함
                hd = 1;
            } else {
                hd = -1;
            }
            
            int sph = points[sp][0];
            while(sph != points[ep][0]) {
                board[sph][points[sp][1]].push_back(time++);
                sph += hd;
            }
            
            // w 좌표 갱신
            int wd = 0;
            if(points[ep][1] > points[sp][1]) {
                wd = 1;
            } else {
                wd = -1;
            }
            
            int spw = points[sp][1];
            while(spw != points[ep][1]) {
                board[points[ep][0]][spw].push_back(time++);
                spw += wd;
            }
            if(i == route.size() - 2)
                board[sph][spw].push_back(time++);
        }
    }
    
    for(int i = 0; i < 101; i++) {
        for(int j = 0; j < 101; j++) {
            int len = board[i][j].size();
            if(len > 1) {
                // 중복된 게 있는 경우, 시간이 같은지 확인
                answer += check(board[i][j]);
            }
        }
    }
    return answer;
}