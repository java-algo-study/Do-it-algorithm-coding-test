from collections import defaultdict, deque
import sys

sys.stdin = open('testcase.txt')
N = int(input())
M = int(input())
adjacent_graph = defaultdict(list)
for i in range(M):
    src, dst, cost = map(int, input().split())
    adjacent_graph[src-1].append((dst-1, cost))
start, end = map(int, input().split())
start, end = start-1, end-1
q = deque([(start, 0, [[]])])
dp = [(0, []) for _ in range(N)]
while q:
    node, length, routes = q.popleft()
    print(node, q)
    if dp[node][0]>length:
        continue
    elif dp[node][0] == length:
        dp[node][1].extend(routes)
    else:
        dp[node] = (length, routes)
    for next_info in adjacent_graph[node] :
        next_node, cost = next_info
        for i in range(len(routes)):
            routes[i].append(next_node)
        q.append((next_node, length+cost, routes))
_, routes = dp[N-1]

arr = [False for _ in range(N)]
for route in routes:
    for element in route:
        arr[element] = True
print(sum(arr))