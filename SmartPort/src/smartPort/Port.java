package smartPort;

import java.util.List;

public class Port {

    public String name;
    public List<String> Items;



    // looks like 'PortName K item1 Item2'
    
    public String PortName;
    public String K;
    public String item1;
    public String item2;


    //constructor
    public Port(String portName, String k, String item1, String item2) {
        PortName = portName;
        K = k;
        this.item1 = item1;
        this.item2 = item2;
    }

    //getters and setters
    public String getPortName() {
        return PortName;
    }
    public void setPortName(String portName) {
        PortName = portName;
    }
    public String getK() {
        return K;
    }
    public void setK(String k) {
        K = k;
    }
    public String getItem1() {
        return item1;
    }
    public void setItem1(String item1) {
        this.item1 = item1;
    }
    public String getItem2() {
        return item2;
    }
    public void setItem2(String item2) {
        this.item2 = item2;
    }



public void addItem(String item){
    this.Items.add(item);
}



public void createMatrix(int[][] travelTime){ {
    Dijkstra T = new Dijkstra();
    T.dijkstra(travelTime, 0);
}
    // Dijkstra's Algorithm in Java

    public class Dijkstra {

    public static void dijkstra(int[][] graph, int source) {
        int count = graph.length;
        boolean[] visitedVertex = new boolean[count];
        int[] distance = new int[count];
        for (int i = 0; i < count; i++) {
        visitedVertex[i] = false;
        distance[i] = Integer.MAX_VALUE;
        }

        // Distance of self loop is zero
        distance[source] = 0;
        for (int i = 0; i < count; i++) {

        // Update the distance between neighbouring vertex and source vertex
        int u = findMinDistance(distance, visitedVertex);
        visitedVertex[u] = true;

        // Update all the neighbouring vertex distances
        for (int v = 0; v < count; v++) {
            if (!visitedVertex[v] && graph[u][v] != 0 && (distance[u] + graph[u][v] < distance[v])) {
            distance[v] = distance[u] + graph[u][v];
            }
        }
        }
        for (int i = 0; i < distance.length; i++) {
        System.out.println(String.format("Distance from %s to %s is %s", source, i, distance[i]));
        }

    }

    // Finding the minimum distance
    private static int findMinDistance(int[] distance, boolean[] visitedVertex) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;
        for (int i = 0; i < distance.length; i++) {
        if (!visitedVertex[i] && distance[i] < minDistance) {
            minDistance = distance[i];
            minDistanceVertex = i;
        }
        }
        return minDistanceVertex;
    
    }

    }
    }


