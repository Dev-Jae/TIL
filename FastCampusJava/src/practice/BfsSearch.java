package practice;

import java.util.ArrayList;

public class BfsSearch {

    int count;
    boolean[] visited;
    ArrayList<Integer> queue;
    int[][] matrix;

    public BfsSearch(int count){
        this.count = count;
        visited = new boolean[count];
        queue = new ArrayList<Integer>();
    }

    // 현재 ArrayList로 되어 있는거 Queue로 구현해보기
    public void bfsTraversal(){
        queue.add(0);
        visited[0] = true;

        while (queue.size() != 0){
            int node = queue.remove(0);

            System.out.printf(node + " ");

            for(int j = 0; j < count; j++){
                if(matrix[node][j] != 0 && !visited[j]){
                    queue.add(j);
                    visited[j] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int count = 8;
        UndirectedGraph graph = new UndirectedGraph(count);
        graph.addEdges(0, 1, 1);
        graph.addEdges(0, 2, 1);
        graph.addEdges(1, 3, 1);
        graph.addEdges(1, 4, 1);
        graph.addEdges(2, 5, 1);
        graph.addEdges(2, 6, 1);
        graph.addEdges(4, 5, 1);
        graph.addEdges(3, 7, 1);

        BfsSearch bfs = new BfsSearch(count);
        bfs.matrix = graph.getMatrix();
        bfs.bfsTraversal();
    }
}
