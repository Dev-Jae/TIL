package practice;

public class UndirectedGraph {
    /* DFS(Depth - First Search, 깊이 우선탐색)와 BFS(Breadth - First Search, 너비 우선탐색)
     * DFS : 최대한 깊이 내려간 뒤, 더 이상 깊이 갈 곳이 없을 경우 옆으로이동
     * 모든 노드를 방문하고자 하는 경우에 DFS 사용
     * DFS가 BFS보다 좀 더 간담, 검색 속도 자체는 BFS에 비해서 느림
     * DFS : 스택 또는 재귀함수로 구현
     *
     * BFS : 최대한 넓게 이동한 다음, 더 이상 갈 수 없을 때 아래로 이동
     * 주로 두 노드 사이의 최단 경로를 찾고 싶을 때 사용
     * BFS : 큐를 이용해서 구현
     */
    private int count;
    private int[][] vertexMatrix;

    public UndirectedGraph(int count){
        this.count = count;
        vertexMatrix = new int[count][count];
    }

    public void addEdges(int from, int to, int weight){
        vertexMatrix[from][to] = weight;
        vertexMatrix[to][from] = weight;
    }

    public int[][] getMatrix(){
        return vertexMatrix;
    }
}
