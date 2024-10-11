#include <string>
#include <vector>

using namespace std;

int nodev[200];

void dfs(int x, vector<vector<int> > &computers) {
    vector<int> comp = computers[x];
    nodev[x] = 1;
    for(int i = 0; i < comp.size(); i++) {
        if(comp[i] == 1 && nodev[i] == 0) {
            dfs(i, computers);
        }
    }
}

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    for(int i = 0; i < n; i++) {
        if(nodev[i]) continue;
        dfs(i, computers);
        answer++;
    }
    return answer;
}