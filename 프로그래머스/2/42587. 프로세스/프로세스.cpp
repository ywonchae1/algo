#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    priority_queue<int> pq;
    queue<pair<int, int>> q;
    for(int i = 0; i < priorities.size(); i++) {
        q.push(make_pair(priorities[i], i));
        pq.push(priorities[i]);
    }
    while(!q.empty()) {
        pair<int, int> f = q.front();
        q.pop();
        if(f.first == pq.top()) {
            pq.pop();
            answer++;
            if(f.second == location) return answer;
        } else {
            q.push(f);
        }
    }
    return answer;
}