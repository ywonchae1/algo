#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(vector<int> mats, vector<vector<string>> park) {
    int answer = -1;
    int find[10] = {0,};
    sort(mats.begin(), mats.end());
    int H = park.size(), W = park[0].size();
    for(int i = mats.size() - 1; i >= 0; i--) {
        for(int mh = 0; mh <= H - mats[i]; mh++) {
            if(find[i]) break;
            for(int mw = 0; mw <= W - mats[i]; mw++) {
                if(find[i]) break;
                // 시작점 정해짐
                bool flag = true;
                for(int h = mh; h < mh + mats[i]; h++) {
                    for(int w = mw; w < mw + mats[i]; w++) {
                        if(park[h][w] != "-1") {
                            flag = false;
                            break;
                        }
                    }
                    if(flag == false) break; // 이 돗자리는 이 시작점에서 깔 수 없다
                }
                if(flag) {
                    // 깔 수 있다
                    find[i] = 1;
                    break;
                }
            }
        }
        // 찾으면 그만
        if(find[i]) {
            answer = mats[i];
            break;
        }
    }
    return answer;
}