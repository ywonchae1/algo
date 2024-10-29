#include <iostream>
using namespace std;

int main() {
    double total = 0;
    double cnttotal = 0;
    for(int i = 0; i < 20; i++) {
        string sub;
        double cnt;
        string score;
        
        cin >> sub >> cnt >> score;
        if(score == "P") {
            continue;
        } else if(score == "A+") {
            total += cnt * 4.5;
        } else if(score == "A0") {
            total += cnt * 4;
        } else if(score == "B+") {
            total += cnt * 3.5;
        } else if(score == "B0") {
            total += cnt * 3;
        } else if(score == "C+") {
            total += cnt * 2.5;
        } else if(score == "C0") {
            total += cnt * 2;
        } else if(score == "D+") {
            total += cnt * 1.5;
        } else if(score == "D0") {
            total += cnt * 1;
        } else {
            total += cnt * 0;
        }
        cnttotal += cnt;
    }
    cout << total / cnttotal << endl;
}