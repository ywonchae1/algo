#include <string>
#include <vector>
#include <unordered_map>
#include <set>
#include <iostream>

using namespace std;

int answer;

void dfs(int st, vector<int> &k, int cnt) {
    if(st >= k.size()) return;
    answer += cnt;
    
    for(int i = st + 1; i < k.size(); i++) {
        dfs(i, k, cnt * k[i]);
    }
}

int solution(vector<vector<string>> clothes) {
    unordered_map<string, vector<string>> mp;
    set<string> keys;
    for(vector<string> cl : clothes) {
        mp[cl[1]].push_back(cl[0]);
        keys.insert(cl[1]);
    }
    
    set<string>::iterator it;
    vector<int> kinds;
    for(it = keys.begin(); it != keys.end(); it++) {
        int s = mp[*it].size();
        kinds.push_back(s);
    }
    
    for(int i = 0; i < kinds.size(); i++) {
        dfs(i, kinds, kinds[i]);
    }
    
    return answer;
}