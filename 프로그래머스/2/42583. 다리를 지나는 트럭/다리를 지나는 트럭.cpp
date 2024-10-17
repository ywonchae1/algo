#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0, dw = 0;
    queue<pair<int, int>> q;
    vector<int>::iterator it = truck_weights.begin();
    
    while(it != truck_weights.end()) {
        answer++;
        bool flag = true;
        if(dw + *it <= weight && q.size() + 1 <= bridge_length) {
            dw += *it;
            q.push(make_pair(*it, answer));
            it++;
            flag = false;
        }
        if(!q.empty() && answer == q.front().second + bridge_length) {
            dw -= q.front().first;
            q.pop();
            if(it != truck_weights.end() && flag && dw + *it <= weight) {
                dw += *it;
                q.push(make_pair(*it, answer));
                it++;
            }
        }
    }
    
    while(!q.empty()) {
        answer++;
        if(answer == q.front().second + bridge_length) {
            q.pop();
        }
    }
    return answer;
}