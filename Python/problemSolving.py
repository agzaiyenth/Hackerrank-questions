def min_days_to_solve_problems(test_cases):
    results = []
    
    for case in test_cases:
        N, K, ratings = case
        ratings = [(difficulty, rating) for difficulty, rating in enumerate(ratings, start=1)]
        ratings.sort()  # Sort by difficulty
        
        dp = [float('inf')] * (N + 1)
        dp[0] = 0  # No days needed to solve 0 problems
        
        for i in range(1, N + 1):
            min_days = dp[i-1] + 1
            for j in range(i-1, -1, -1):
                if abs(ratings[i-1][1] - ratings[j][1]) >= K:
                    min_days = min(min_days, dp[j] + 1)
            dp[i] = min_days
        
        results.append(dp[N])
    
    return results

# Reading input and formatting it as required
def read_input():
    import sys
    input = sys.stdin.read
    data = input().split()
    
    T = int(data[0])
    index = 1
    test_cases = []
    
    for _ in range(T):
        N = int(data[index])
        K = int(data[index + 1])
        ratings = list(map(int, data[index + 2: index + 2 + N]))
        test_cases.append((N, K, ratings))
        index += 2 + N
    
    return test_cases
																				
# Main function to execute
if __name__ == "__main__":
    test_cases = read_input()
    results = min_days_to_solve_problems(test_cases)

    for result in results:
        print(result)