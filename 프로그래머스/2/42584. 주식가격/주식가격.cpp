#include <string>
#include <vector>
#include <stack>

using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer;
    int check[100000];
    stack<pair<int, pair<int, int>>> st;
    
    int cnt = 0;
    for(int i = 0; i < prices.size(); i++) {
        pair<int, pair<int, int>> p = make_pair(i, make_pair(prices[i], cnt));
        while(!st.empty() && st.top().second.first > p.second.first) {
            pair<int, pair<int, int>> t = st.top();
            int res = cnt - t.second.second;
            check[t.first] = res;
            st.pop();
        }
        st.push(p);
        cnt++;
    }
    cnt--;
    while(!st.empty()) {
        pair<int, pair<int, int>> t = st.top();
        int res = cnt - t.second.second;
        check[t.first] = res;
        st.pop();
    }
    for(int i = 0; i < prices.size(); i++) {
        answer.push_back(check[i]);
    }
    return answer;
}