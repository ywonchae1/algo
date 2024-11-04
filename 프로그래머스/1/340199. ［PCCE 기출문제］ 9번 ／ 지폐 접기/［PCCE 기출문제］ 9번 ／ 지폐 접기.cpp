#include <string>
#include <vector>

using namespace std;

int solution(vector<int> wallet, vector<int> bill) {
    int answer = 0;
    // 0이 작은 값, 1이 큰 값
    if(bill[0] > bill[1]) {
        int tmp = bill[1];
        bill[1] = bill[0];
        bill[0] = tmp;
    }
    if(wallet[0] > wallet[1]) {
        int tmp = wallet[1];
        wallet[1] = wallet[0];
        wallet[0] = tmp;
    }
    
    while(wallet[0] < bill[0] || wallet[1] < bill[1]) {
        bill[1] /= 2;
        if(bill[0] > bill[1]) {
            int tmp = bill[1];
            bill[1] = bill[0];
            bill[0] = tmp;
        }
        answer++;
    }
    return answer;
}