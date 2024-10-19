#include <string>
#include <vector>

using namespace std;

bool solution(string s) {
    bool answer = true;
    if(s.length() != 4 && s.length() != 6) return false;
    for(char c : s) {
        if(c >= 'A') return false;
    }
    return answer;
}