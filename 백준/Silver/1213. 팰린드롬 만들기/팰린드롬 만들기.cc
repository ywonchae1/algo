#include <iostream>
#include <string.h>

using namespace std;

int main() {
    int v1[26] = {0,};
    int v2[26] = {0,};
    string pl;
    cin >> pl;
    
    for(char p : pl) {
        int idx = p - 'A';
        v1[idx]++;
        if(v2[idx]) v2[idx]--;
        else v2[idx]++;
    }
    
    int one_cnt = 0;
    for(int i = 0; i < 26; i++) {
        if(v2[i] == 1) one_cnt++;
    }
    
    if(pl.length() % 2 && one_cnt != 1) {
        cout << "I'm Sorry Hansoo\n";
        return 0;
    }
    if(pl.length() % 2 == 0 && one_cnt != 0) {
        cout << "I'm Sorry Hansoo\n";
        return 0;
    }
    
    // 펠린드롬 생성 가능
    for(int i = 0; i < 26; i++) {
        for(int j = 0; j < v1[i] / 2; j++) {
            cout << (char) ('A' + i);
        }
    }
    for(int i = 0; i < 26; i++) {
        if(v2[i] == 1) cout << (char) ('A' + i);
    }
    for(int i = 25; i >= 0; i--) {
        for(int j = 0; j < v1[i] / 2; j++) {
            cout << (char) ('A' + i);
        }
    }
    cout << '\n';
}