#include <iostream>
#include <vector>
#include <utility>

using namespace std;

pair<long long, long long> getFSMax(const vector<vector<long long>>& dp, int row, int C) {
    long long fmax, smax;

    if (dp[row][0] > dp[row][1]) {
        fmax = dp[row][0];
        smax = dp[row][1];
    } else {
        fmax = dp[row][1];
        smax = dp[row][0];
    }

    for (int col = 2; col < C; col++) {
        if (dp[row][col] > fmax) {
            smax = fmax;
            fmax = dp[row][col];
        } else if (dp[row][col] > smax) {
            smax = dp[row][col];
        }
    }

    return {fmax, smax};
}

int main() {
    int R, C;
    cin >> R >> C;

    vector<vector<int>> grid(R, vector<int>(C));
    vector<vector<long long>> dp(R, vector<long long>(C));

    for (int row = 0; row < R; row++) {
        for (int col = 0; col < C; col++) {
            cin >> grid[row][col];

            if (row == 0) {
                dp[row][col] = grid[row][col];
            }
        }
    }

    for (int row = 1; row < R; row++) {
        pair<long long, long long> mx = getFSMax(dp, row - 1, C);
        long long fmax = mx.first;
        long long smax = mx.second;

        for (int col = 0; col < C; col++) {
            dp[row][col] = grid[row][col] +
                           (dp[row - 1][col] == fmax ? smax : fmax);
        }
    }

    cout << getFSMax(dp, R - 1, C).first;

    return 0;
}
