package io.fclemonschool.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1,
 * find all possible paths from node 0 to node n - 1 and return them in any order.
 * <p>
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i
 * (i.e., there is a directed edge from node i to node graph[i][j]).
 * <p>
 * Example 1:
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * <p>
 * Example 2:
 * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * <p>
 * <p>
 * Constraints:
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i (i.e., there will be no self-loops).
 * All the elements of graph[i] are unique.
 * The input graph is guaranteed to be a DAG.
 */
public class AllPathsFromSourceToTarget {
  public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<List<Integer>> resultPath = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    path.add(0);
    dfs(graph, 0, resultPath, path);
    return resultPath;
  }

  public static void dfs(int[][] array, int i, List<List<Integer>> resultPath, List<Integer> path) {
    if (i == array.length - 1) {
      resultPath.add(new ArrayList<>(path));
      return;
    }

    for (int j : array[i]) {
      path.add(j);
      dfs(array, j, resultPath, path);
      path.remove(path.size() - 1); // undo - backtracking
    }
  }

  public static void main(String[] args) {
    allPathsSourceTarget(new int[][] {{1, 2}, {3}, {3}, {}});
  }
}
