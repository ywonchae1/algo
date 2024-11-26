#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

bool comp(vector<int> a, vector<int> b) {
    return a[1] < b[1];
}

int solution(vector<vector<int>> targets) {
    int answer = 1;
    sort(targets.begin(), targets.end(), comp);
    
    int maxn = targets[0][1];
    for(int i = 1; i < targets.size(); i++) {
        vector<int> t = targets[i];
        if(maxn <= t[0]) {
            maxn = t[1];
            answer++;
        }
    }
    return answer;
}