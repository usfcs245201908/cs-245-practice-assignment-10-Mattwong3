import java.util.List;
import java.lang.Exception;
import java.util.LinkedList;
import java.util.Stack;


public class GraphImplementation implements Graph {
    LinkedList<Integer> list[];
    int V;

    public  GraphImplementation(int V){
        this.V = V;
        list = new LinkedList[V];
        for (int i = 0; i <V ; i++) {
            list[i] = new LinkedList<>();
        }


    }

    public void addEdge(int v1, int v2) throws Exception{
        //add edge
        
        list[v1].addFirst(v2);

        //add back edge ((for undirected)
        list[v2].addFirst(v1);


    }



    public List<Integer> topologicalSort(){
        List topList = new LinkedList<>();
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }
        System.out.println("Topological Sort: ");
        int size = stack.size();
        for (int i = 0; i <size ; i++) {
            topList.add(stack.pop());
        }
        return topList;
    }

    public void topologicalSortUtil(int start, boolean[] visited, Stack<Integer> stack) {
        visited[start] = true;
        for (int i = 0; i < list[start].size(); i++) {
            int vertex = list[start].get(i);
            if (!visited[vertex])
                topologicalSortUtil(vertex, visited, stack);
        }
        stack.push(start);
    }




    public List<Integer> neighbors(int vertex) throws Exception{
        List allNeighbors = new LinkedList<>();
        for (int j = 0; j < V; j++)
            if (list[j].contains(vertex))
                allNeighbors.add(j);




        return allNeighbors;
    }



}
