#include <string>
#include <vector>
#include <algorithm>

using namespace std;
/*
[4, 5]와 겹치는 것의 집합 ([4, 8], [4, 5], [3, 7])
[4, 8]과 겹치는 것의 집합 ([4, 8], [4, 5], [5, 12], [3, 7])
[10, 14]와 겹치는 것의 집합 ([10, 14], [11, 13], [5, 12])
[11, 13]과 겹치는 것의 집합 ([10, 14], [11, 13], [5, 12])
[5, 12]와 겹치는 것의 집합 ([4, 8], [10, 14], [11, 13], [5, 12], [3, 7])
[3, 7]과 겹치는 것의 집합 ([4, 5], [4, 8], [5, 12], [3, 7] [1, 4])
[1, 4]와 겹치는 것의 집합 ([3, 7], [1, 4])
각 집합 사이의 교집합 구하기, 그 조합의 수가 가장 작은 것을 선택 bfs
교집합이 없으면 0 증가
*/
/*
아냐.. 이걸로 해볼래
배열 정렬
1, 1.5, 2, 2.5... 배열의 원소와 비교, 사잇값이면 요격될 리스트(distroy)에 추가
전체 배열 원소 조회 후 요격 리스트에서 killed true (요격 성공)인 미사일이 없다면 answer++
요격 리스트의 모든 원소를 killed true
==> 시간초과..ㅎ
*/

int findMin(vector<vector<int>> targets) {
    int min = 100000001;
    for(vector<int> target : targets) {
        if(min > target[0]) min = target[0];
        if(min > target[1]) min = target[1];
    }
    return min;
}
int findMax(vector<vector<int>> targets) {
    int max = 0;
    for(vector<int> target : targets) {
        if(max < target[0]) max = target[0];
        if(max < target[1]) max = target[1];
    }
    return max;
}

int solution(vector<vector<int>> targets) {
    int answer = 0; // 얼마나 쏴야 하는지
    sort(targets.begin(), targets.end());
    int min = findMin(targets);
    int max = findMax(targets);
    vector<int> killed(targets.size(), false); // 이미 해치웠는지 
    for(float i = min; i <= max; i += 0.5) {
        vector<int> distroy;
        for(int j = 0; j < targets.size(); j++) {
            if(targets[j][0] < i && i < targets[j][1]) {
                distroy.push_back(j);
            }
        }
        // distroy 벡터 중 이미 사망한 미사일이 있는지
        bool flag = true; // answer를 늘릴 건지
        for(int d : distroy) {
            if(killed[d]) { // 사망했으면 answer 늘리지 않아도 됨
                flag = false;
            }
        }
        for(int d : distroy) {
            killed[d] = true; // 해치웠음 표시
        }
        if(flag) answer++; // 사망하지 않았으면 answer 늘림
    }
    return answer;
}