#include <string>
#include <vector>
#include <string.h>

using namespace std;

void convert(string len, int &len_i) {
    string m = len.substr(0, 2);
    string s = len.substr(3, 2);
    
    int mi = stoi(m);
    int si = stoi(s);
    len_i = mi * 60 + si;
}

string prefix(string t) {
    if(t.length() < 2) return '0' + t;
    else return t;
}

void totime(int pos, string &ans) {
    int m = pos / 60;
    int s = pos % 60;
    
    string ms = prefix(to_string(m));
    string ss = prefix(to_string(s));
    
    ans = ms + ':' + ss;
}

string solution(string video_len, string pos, string op_start, string op_end, vector<string> commands) {
    string answer = "";
    // 전부 분으로 변환
    int video_len_i, pos_i, op_start_i, op_end_i;
    convert(video_len, video_len_i);
    convert(pos, pos_i);
    convert(op_start, op_start_i);
    convert(op_end, op_end_i);
    // commands 반복
    // next이면
    // op_start < pos < op_end 이면 op_end로 이동
    // 그렇지 않으면 10초 후로 이동
    // prev이면
    // op_start < pos < op_end 이면 op_start로 이동
    // 그렇지 않으면 10초 전으로 이동
    
    // 처음 위치가 오프닝이면 자동으로 끝나는 위치
    if(op_start_i < pos_i && pos_i < op_end_i) {
        pos_i = op_end_i;
    }
    
    for(string com : commands) {
        if(com == "next") {
            pos_i += 10;
        } else {
            pos_i -= 10;
        }
        // 범위를 넘어갔다면 최대/최소값으로 변경
        if(video_len_i < pos_i) pos_i = video_len_i;
        else if(pos_i < 0) pos_i = 0;
        
        // 오프닝 위치면 오프닝 끝나는 곳으로 이동
        if(op_start_i <= pos_i && pos_i <= op_end_i) {
            pos_i = op_end_i;
        }
    }
    
    // 결과가 video_len보다 크다면 video_len을 반환
    // 결과가 0보다 작다면 00:00을 반환
    
    totime(pos_i, answer);
    return answer;
}