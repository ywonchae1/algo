#include <string>
#include <vector>
#include <cmath>
#include <climits>

using namespace std;

int alpha[26] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
                13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

int solution(string name) {
    int answer = 0, rem = 0, len = name.length(), cnt = INT_MAX;
    
    for(int i = 0; i < len; i++) {
        if(name[i] != 'A') {
            answer += alpha[name[i] - 'A'];
            
            if(i == 0) continue;
            int tmp = rem + len - i;
            cnt = min(cnt, min(tmp + rem, tmp + len - i));
            rem = i;
        }
    }
    answer += min(cnt, rem);
    return answer;
}