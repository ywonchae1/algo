#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

bool solution(vector<string> phone_book) {
    bool answer = true;
    unordered_map<string, bool> m;
    for(string s : phone_book) m[s] = true;
    for(string s : phone_book) {
        string tmp = "";
        for(int i = 0; i < s.length() - 1; i++) {
            tmp += s[i];
            if(m[tmp]) return false;
        }
    }
    return answer;
}