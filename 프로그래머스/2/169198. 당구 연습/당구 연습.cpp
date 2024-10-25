#include <string>
#include <vector>
#include <cmath>

using namespace std;

vector<int> solution(int m, int n, int startX, int startY, vector<vector<int>> balls) {
    vector<int> answer;
    for(vector<int> ball : balls) {
        int len, a, b;
        if (ball[0] == startX)
        {
            a = abs(startY - ball[1]);
            b = 2 * min(m - startX, startX);
            if (startY > ball[1]) len = pow(a + 2*(n - startY), 2);
            else len = pow(a + 2*startY, 2);
        }
        else if(ball[1] == startY)
        {
            a = abs(startX - ball[0]);
            b = 2 * min(n - startY, startY);
            if (startX > ball[0]) len = pow(a + 2*(m - startX), 2);
            else len = pow(a + 2*startX, 2);
        }
        else
        {
            a = min(startX + ball[0], 2*m - startX - ball[0]);
            b = abs(startY - ball[1]);
            len = pow(a, 2) + pow(b, 2);
            a = min(startY + ball[1], 2*n - startY - ball[1]);
            b = abs(startX - ball[0]);
        }
        len = min(len, (int)(pow(a, 2) + pow(b, 2)));
        answer.push_back(len);
    }
    return answer;
}