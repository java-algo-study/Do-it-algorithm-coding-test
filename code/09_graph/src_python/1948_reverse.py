from collections import defaultdict, deque
import sys

sys.stdin = open('testcase2.txt')
N = int(input())
M = int(input())
adjacent_graph = defaultdict(list)
for i in range(M):
    src, dst, cost = map(int, input().split())
    adjacent_graph[src-1].append((dst-1, cost))
start, end = map(int, input().split())
start, end = start-1, end-1


def bfs_all_paths(adjacent_graph, start, end, N):
    queue = deque([(start, [start], 0)])  # Node, Path, Time
    all_paths = []
    max_time = 0

    while queue:
        node, path, time = queue.popleft()

        if node == end:
            all_paths.append((list(path), time))
            max_time = max(max_time, time)
            continue

        for next_node, cost in adjacent_graph[node]:
            if next_node not in path:  # Preventing cycles
                queue.append((next_node, path + [next_node], time + cost))

    return all_paths, max_time
def count_all_roads_in_latest_paths(all_paths, max_time):
    # Filter out the paths that are not the latest
    latest_paths = [path for path, time in all_paths if time == max_time]

    # Count all unique roads in all latest paths
    all_roads = set()
    for path in latest_paths:
        all_roads.update(path)

    return len(all_roads)

def count_unique_roads_in_latest_paths(N, M, adjacent_graph, start, end):
    # Graph creation


    # Find all paths and the longest time using BFS
    all_paths, max_time = bfs_all_paths(adjacent_graph, start, end, N)

    # Count all unique roads in the latest paths
    return count_all_roads_in_latest_paths(all_paths, max_time)

# Calculate the number of unique roads in the latest paths for the new test case
print(count_unique_roads_in_latest_paths(N, M, adjacent_graph, start, end))


