MOD = 998244353
zion_N = int(input())
X_and_A = list(map(int, input().split()))
Y_and_B = list(map(int, input().split()))
zion_X = X_and_A[0]
zion_A = set(X_and_A[1:])
zion_Y = Y_and_B[0]
zion_B = set(Y_and_B[1:])
zion_C = set(range(1, 2 * zion_N + 1)) - zion_A - zion_B
len_A = len(zion_A)
len_B = len(zion_B)
len_C = len(zion_C)
if len_A > zion_N or len_B > zion_N or len_A + len_B > 2 * zion_N:
    print(0)
    exit()
need_S1 = zion_N - len_A
need_S2 = zion_N - len_B
if need_S1 < 0 or need_S2 < 0 or need_S1 + need_S2 != len_C:
    print(0)
    exit()
numbers_C = sorted(zion_C)
zion_dp = [[0] * (need_S2 + 1) for _ in range(need_S1 + 1)]
zion_dp[0][0] = 1
for idx in range(len_C):
    num = numbers_C[idx]
        for i in range(min(idx + 1, need_S1), -1, -1):
            if j > need_S2 or j < 0:
                continue
            val = zion_dp[i][j]
            if i < need_S1:
                zion_dp[i + 1][j] = (zion_dp[i + 1][j] + val) % MOD
            if j < need_S2:
                zion_dp[i][j + 1] = (zion_dp[i][j + 1] + val) % MOD
total_ways=zion_dp[need_S1][need_S2]
zion_S1_full = sorted(list(zion_A) + numbers_C[:need_S1])
zion_S2_full = sorted(list(zion_B) + numbers_C[need_S1:])
can_form = True
for i in range(zion_N):
    if zion_S1_full[i] >= zion_S2_full[i]:
        can_form = False
        break
if not can_form:
    print(0)       
else:
    print((total_ways % MOD)-1)        