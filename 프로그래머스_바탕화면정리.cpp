#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> wallpaper) {
    int height = wallpaper.size();
    int weidth = wallpaper[0].size();
    vector<int> answer = {height, weidth, 0, 0};
    // #의 위치 중 가장 작은 x좌표, y좌표 / 가장 큰 x좌표, y좌표 찾기
    for(int i = 0; i < wallpaper.size(); i++) {
        for(int j = 0; j < wallpaper[i].size(); j++) {
            if(wallpaper[i][j] == '#') {
                if(answer[0] > i) {
                    answer[0] = i;
                }
                if(answer[1] > j) {
                    answer[1] = j;
                }
                if(answer[2] < i + 1) {
                    answer[2] = i + 1;
                }
                if(answer[3] < j + 1) {
                    answer[3] = j + 1;
                }
            }
        }
    }
    return answer;
}