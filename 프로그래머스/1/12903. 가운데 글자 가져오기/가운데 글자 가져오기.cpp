#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    string answer = "";
    int center = (s.length() + 1) / 2;
    bool isEven = !(s.length() % 2);
    answer += s[center - 1];
    if(isEven) answer += s[center];
    return answer;
}