#include <iostream>
#include <string.h>

using namespace std;

int findSeries(int n) {
    int series = 0;
    int number = 666;
    
    while(true) {
        string number_s = to_string(number);
        for(int i = 0; i < number_s.length() - 2; i++) {
            if(number_s[i] == '6' && number_s[i + 1] == '6' && number_s[i + 2] == '6') {
                // 6이 연속 3개
                series++;
                
                if(series == n) return number;
                
                break;
            }
        }
        number++;
    }
}

int main() {
    int n;
    cin >> n;
    
    cout << findSeries(n) << '\n';
}