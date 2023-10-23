#include <string>
#include <vector>

using namespace std;

vector<int> isRoad(string dir, vector<string> park, vector<int> now) {
    int pos = int(dir[2] - '0');
    
    if(dir[0] == 'N') {
        int nextDir = now[0] - pos;
        
        if(nextDir >= 0 && nextDir < park.size()) {
            for(int i = 1; i <= pos; i++) {
                if(park[now[0]-i][now[1]] == 'X') break;
                if(i == pos) now[0] = nextDir;
            }
        }
    } else if(dir[0] == 'S') {
        int nextDir = now[0] + pos;
        
        if(nextDir >= 0 && nextDir < park.size()) {
            for(int i = 1; i <= pos; i++) {
                if(park[now[0]+i][now[1]] == 'X') break;
                if(i == pos) now[0] = nextDir;
            }
        }
    } else if(dir[0] == 'W') {
        int nextDir = now[1] - pos;
        
        if(nextDir >= 0 && nextDir < park[0].size()) {
            for(int i = 1; i <= pos; i++) {
                if(park[now[0]][now[1]-i] == 'X') break;
                if(i == pos) now[1] = nextDir;
            }
        }
    } else if(dir[0] == 'E') {
        int nextDir = now[1] + pos;
        
        if(nextDir >= 0 && nextDir < park[0].size()) {
            for(int i = 1; i <= pos; i++) {
                if(park[now[0]][now[1]+i] == 'X') break;
                if(i == pos) now[1] = nextDir;
            }
        }
    }
    return now;
}

vector<int> findStart(vector<string> park) {
    for(int i = 0; i < park.size(); i++) {
        for(int j = 0; j < park[i].size(); j++) {
            if(park[i][j] == 'S') {
                vector<int> start = {i, j};
                return start;
            }
        }
    }
}

vector<int> solution(vector<string> park, vector<string> routes) {
    vector<int> answer = findStart(park);
    for(string dir : routes) {
        answer = isRoad(dir, park, answer);
    }
    return answer;
}