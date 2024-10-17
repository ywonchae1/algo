#include <string>
#include <stack>

using namespace std;

bool solution(string s)
{
    stack<char> parts;
    for(char c : s) {
        if(c == ')') {
            if(parts.empty()) return false;
            else if(parts.top() == '(') parts.pop();
        } else {
            parts.push(c);
        }
    }
    
    if(parts.empty()) return true;
    else return false;
}