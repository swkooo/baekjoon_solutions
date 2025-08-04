T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    Ai = list(map(int, input().split()))
    Bj = list(map(int, input().split()))
    
    move = abs(N - M)
    max_num = 0
    
    for m in range(move + 1):
        num = 0
        for i in range(min(N, M)):
            if N >= M:
                num += Ai[i + m] * Bj[i]
            else:
                num += Ai[i] * Bj[i + m]
        if num > max_num:
            max_num = num
    print(f"#{test_case} {max_num}")