#include <iostream>
#include <vector>
#include <cmath>
#include <string.h>
#include <algorithm>

using namespace std;

int N;
vector<int> nums;
int maxsum;

int main() {
  cin >> N;
  for(int i = 0; i < N; i++) {
    int n;
    cin >> n;
    nums.push_back(n);
  }

  sort(nums.begin(), nums.end());

  do {
    int sum = 0;
    for(int i = 0; i < N - 1; i++) {
      sum += abs(nums[i] - nums[i + 1]);
    }
    if(maxsum < sum) maxsum = sum;
  } while(next_permutation(nums.begin(), nums.end()));

  cout << maxsum << endl;
}