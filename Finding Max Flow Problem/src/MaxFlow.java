
// Java program for implementation of Ford Fulkerson algorithm 
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.LinkedList;

class MaxFlow {

    static int V;   //Number of vertices in graph
    /* Returns true if there is a path from source 's' to sink 
      't' in residual graph. Also fills parent[] to store the 
      path */
    boolean bfs(int rGraph[][], int s, int t, int parent[]) {
        // Create a visited array and mark all vertices as not 
        // visited 
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; ++i)
            visited[i] = false;

        // Create a queue, enqueue source vertex and mark 
        // source vertex as visited
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s] = -1;

        // Standard BFS Loop 
        while (queue.size() != 0) {
            int u = queue.poll();

            for (int v = 0; v < V; v++) {
                if (visited[v] == false && rGraph[u][v] > 0) {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        // If we reached sink in BFS starting from source, then 
        // return true, else false 
        return (visited[t] == true);
    }

    // Returns tne maximum flow from s to t in the given graph 
    int fordFulkerson(int graph[][], int s, int t) {
        int u, v;

        // Create a residual graph and fill the residual graph
        // with given capacities in the original graph as
        // residual capacities in residual graph

        // Residual graph where rGraph[i][j] indicates
        // residual capacity of edge from i to j (if there
        // is an edge. If rGraph[i][j] is 0, then there is
        // not)
        int rGraph[][] = new int[V][V];

        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                rGraph[u][v] = graph[u][v];

        // This array is filled by BFS and to store path
        int parent[] = new int[V];
        int[] augmentedPath = new int[V];

        int max_flow = 0;  // There is no flow initially

        List<Integer> path = new ArrayList<>();
        List<Integer> flow = new ArrayList<>();
        // Augment the flow while tere is path from source
        // to sink
        while (bfs(rGraph, s, t, parent)) {
            // Find minimum residual capacity of the edhes
            // along the path filled by BFS. Or we can say
            // find the maximum flow through the path found.
            int path_flow = Integer.MAX_VALUE;
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                path.add(u);
                flow.add(path_flow);
                path_flow = Math.min(path_flow, rGraph[u][v]);
            }

            // update residual capacities of the edges and
            // reverse edges along the path
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;

            }

//            t=s;
//            int i = 1;
//            while(t != source ){
//                int s = parent[t];
//                residualGraph[s][t]-=flow_capacity;

            // Add path flow to overall flow 
            max_flow += path_flow;
            path.add(v);
            Collections.sort(path);
            System.out.println(path + " ");
            System.out.println("The path flowing is: " + flow.get(flow.size() - 1) + "\n");
            path.clear();

        }

        // Return the overall flow 
        return max_flow;
    }

    public static void modify(int graph[][]) {

        int row;
        int column;
        int newValue;
        int another;
        do {
            System.out.println("Enter the row you wish to edit: ");
            Scanner sc6 = new Scanner(System.in);
            row = sc6.nextInt();

            System.out.println("Enter the column you wish to edit: ");
            Scanner sc7 = new Scanner(System.in);
            column = sc7.nextInt();

            System.out.println("Enter the edge: ");
            Scanner sc9 = new Scanner(System.in);
            newValue = sc9.nextInt();

            graph[row][column] = newValue;
            System.out.println("Want to modify another? 1 for yes, 2 for no.");
            Scanner sc8 = new Scanner(System.in);
            another = sc8.nextInt();
        } while (another == 1);
    }


    // Driver program to test above functions 
    public static void main(String[] args) throws java.lang.Exception {

        int source;
        int sink;
        int repeat;


        System.out.println("Press '1' to find the max flow | Press '2' to edit the nodes");
        Scanner sc17 = new Scanner(System.in);
        int choice = sc17.nextInt();
//        if(choice == 1){

        System.out.println("Enter the amount of vertices for the graph: ");

        Scanner sc1 = new Scanner(System.in);
        V = sc1.nextInt();

        System.out.println("Enter the source: ");
        Scanner sc2 = new Scanner(System.in);
        source = sc2.nextInt();

        System.out.println("Enter the sink: ");
        Scanner sc3 = new Scanner(System.in);
        sink = sc3.nextInt();

        if (V >= 6 && V <= 12) {
            if (V == 10) {

                int doubling;

                Scanner sc = new Scanner(new BufferedReader(new FileReader(V + "-11.txt")));
                System.out.println("Enter the doubling amount (1 - 4)");
                sc = new Scanner(System.in);
                doubling = sc.nextInt();
//                do {
                if(doubling==1) {
                    System.out.println("You chose to double once");
                    sc = new Scanner(new BufferedReader(new FileReader(V + "-11.txt")));
                } else if(doubling==2){
                    System.out.println("You chose to double twice");
                    sc = new Scanner(new BufferedReader(new FileReader(V + "-22.txt")));
                }else if(doubling==3) {
                    System.out.println("You chose to double thrice");
                    sc = new Scanner(new BufferedReader(new FileReader(V + "-44.txt")));
                }else if(doubling==4) {
                    System.out.println("You chose to double four times");
                    sc = new Scanner(new BufferedReader(new FileReader(V + "-88.txt")));
                }else{
                        System.out.println("Entered value is invalid, enter a number from 1 - 4");
                }
//

            } else {

                Scanner sc = new Scanner(new BufferedReader(new FileReader(V + ".txt")));

//
                int rows = V;
                int columns = V;
                int[][] graph = new int[rows][columns];
                while (sc.hasNextLine()) {
                    for (int i = 0; i < graph.length; i++) {
                        String[] line = sc.nextLine().trim().split(" ");
                        for (int j = 0; j < line.length; j++) {
                            graph[i][j] = Integer.parseInt(line[j]);
                        }
                    }
                }

                System.out.println(Arrays.deepToString(graph).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));


                MaxFlow m = new MaxFlow();

                long startTime = System.nanoTime();
                System.out.println("The maximum possible flow is " +
                        m.fordFulkerson(graph, source, sink));
                long endTime = System.nanoTime();
                double timeElapsed = endTime - startTime;
                System.out.println("Elapsed time: " + timeElapsed);


                modify(graph);
                System.out.println(Arrays.deepToString(graph).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));

                System.out.println("The vertice number entered in invalid, please try again with a number between 4-10");
            }
        }
    }
}
