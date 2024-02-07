from collections import defaultdict
import sys
sys.stdin = open('testcase.txt')

def dfs(node, graph, visited, end):
    print(node)
    if node == end:
        return 1
    visited[node] = True
    count = 0
    for neighbor, _ in graph[node]:
        if not visited[neighbor]:
            count += dfs(neighbor, graph, visited, end)
    visited[node] = False
    return count

N = int(input())
M = int(input())
graph = defaultdict(list)
for _ in range(M):
    src, dst, cost = map(int, input().split())
    graph[src-1].append((dst-1, cost))

start, end = map(int, input().split())
start, end = start-1, end-1
visited = [False for _ in range(N)]

print(dfs(start, graph, visited, end))
