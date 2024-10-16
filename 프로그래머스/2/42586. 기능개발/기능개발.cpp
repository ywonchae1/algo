#include <string>
#include <vector>
#include <queue>
#include <cmath>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    queue<int> rq;
    
    for(int i = 0; i < progresses.size(); i++) {
        int rem = ceil((100.0 - progresses[i]) / speeds[i]);
        rq.push(rem);
    }
    
    int lst = rq.front();
    rq.pop();
    int cnt = 1;
    while(!rq.empty()) {
        int next = rq.front();
        rq.pop();
        if(lst < next) {
            answer.push_back(cnt);
            cnt = 1;
            lst = next;
        } else {
            cnt++;
        }
    }
    answer.push_back(cnt);
    
    return answer;
}