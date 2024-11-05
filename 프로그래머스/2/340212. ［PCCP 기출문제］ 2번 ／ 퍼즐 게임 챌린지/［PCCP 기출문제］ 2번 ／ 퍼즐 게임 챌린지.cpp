#include <string>
#include <vector>
#include <climits>
#include <iostream>

using namespace std;

long long olimit;
int tsize, answer = INT_MAX;

int left_l, right_l;

void dfs(int level, int i, long long time, vector<int> &diffs, vector<int> &times) {
    if(time > olimit) {
        left_l = level; // 더 큰 level을 찾아야 함
        return;
    }
    if(i == tsize) {
        right_l = level;
        if(answer > level) answer = level;
        return;
    }
    
    if(level >= diffs[i]) {
        dfs(level, i + 1, time + times[i], diffs, times);
    } else {
        int retry = diffs[i] - level;
        int more = times[i - 1] + times[i];
        int res = retry * more + times[i];
        dfs(level, i + 1, time + res, diffs, times);
    }
}

int getMax(vector<int> diffs) {
    int md = 0;
    for(int i : diffs) {
        if(md < i) md = i;
    }
    return md;
}

int getMin(vector<int> diffs) {
    int sd = INT_MAX;
    for(int i : diffs) {
        if(sd > i) sd = i;
    }
    return sd;
}

int findmid(int start, int end) {
    return (start + end) / 2;
}

int solution(vector<int> diffs, vector<int> times, long long limit) {
    left_l = getMin(diffs);
    right_l = getMax(diffs);
    olimit = limit;
    tsize = times.size();
    if(tsize < 2 || left_l == right_l) return left_l;
    dfs(left_l, 0, 0, diffs, times);
    dfs(right_l, 0, 0, diffs, times);
    while(left_l < right_l && left_l + 1 != right_l) {
        dfs(findmid(left_l, right_l), 0, 0, diffs, times);
    }
    return answer;
}