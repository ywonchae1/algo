#include <string>
#include <vector>
#include <algorithm>
#include <cmath>
#include <climits>

using namespace std;

int solution(vector<int> citations) {
    int answer = 0, len = citations.size();
    sort(citations.begin(), citations.end());
    for(int i = len - 1; i >= 0; i--) {
        answer = max(answer, min(len - i, citations[i]));
    }
    return answer;
}