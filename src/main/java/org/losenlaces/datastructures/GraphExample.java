package org.losenlaces.datastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphExample {

    public static void main(String[] args) {
        SetGraph setGraph = new SetGraph(IGraph.GraphType.DIRECTED, 10);

        setGraph.addEdge(1, 2);
        setGraph.addEdge(1, 3);
        setGraph.addEdge(1, 5);
        setGraph.addEdge(1, 9);
        setGraph.addEdge(2, 4);
        setGraph.addEdge(2, 7);
        setGraph.addEdge(2, 9);
        setGraph.addEdge(4, 0);
        setGraph.addEdge(5, 0);
        setGraph.addEdge(9, 0);
        setGraph.addEdge(5, 6);

        setGraph.getAdjacentVertices(1);
    }


    static class SetGraph implements IGraph {
        private List<Node> vertexList = new ArrayList<>();
        private GraphType graphType = GraphType.DIRECTED;
        private int numVertices = 0;

        public SetGraph(GraphType graphType, int numVertices) {
            this.graphType = graphType;
            for (int i = 0; i < numVertices; i++) {
                vertexList.add(new Node(i));
            }
            this.numVertices = numVertices;
        }

        @Override
        public void addEdge(int v1, int v2) {
            if (v1 >= numVertices || v1 < 0 || v2 >= numVertices || v2 < 0) {
                throw new IllegalArgumentException("Vertex number is not valid: " + v1 + ", " + v2);
            }
            vertexList.get(v1).addEdge(v2, 1);
            if (GraphType.UNDIRECTED.equals(graphType)) {
                vertexList.get(v2).addEdge(v1, 1);
            }
        }

        @Override
        public void addEdge(int v1, int v2, int weight) {
            if (v1 >= numVertices || v1 < 0 || v2 >= numVertices || v2 < 0) {
                throw new IllegalArgumentException("Vertex number is not valid: " + v1 + ", " + v2);
            }
            vertexList.get(v1).addEdge(v2, weight);
            if (GraphType.UNDIRECTED.equals(graphType)) {
                vertexList.get(v2).addEdge(v1, weight);
            }
        }

        @Override
        public int getWeightedEdge(int v1, int v2) {
            return vertexList.get(v1).getWeightedEdge(v2);
        }

        @Override
        public List<Integer> getAdjacentVertices(int v) {
            if (v >= numVertices || v < 0) {
                throw new IllegalArgumentException("Vertex number is not valid");
            }

            return vertexList.get(v).getAdjacentVertices();
        }

        @Override
        public int getIndegree(int v) {
            if (v < 0 || v >= numVertices) {
                throw new IllegalArgumentException("Vertex number is not valid");
            }
            int indegree = 0;
            for (int i = 0; i < numVertices; i++) {
                if (getAdjacentVertices(i).contains(v)) {
                    indegree++;
                }
            }
            return indegree;
        }

        @Override
        public int getNumVertices() {
            return numVertices;
        }

    }

    static class Node {
        private int vertexNumber;
        private Map<Integer, Integer> adjacencySet = new HashMap<>();

        public Node(int vertexNumber) {
            this.vertexNumber = vertexNumber;
        }

        public int getVertexNumber() {
            return vertexNumber;
        }

        public void addEdge(int vertexNumber, int weight) {
            adjacencySet.put(vertexNumber, weight);
        }

        public int getWeightedEdge(int v2) {
            return adjacencySet.get(v2);
        }

        public List<Integer> getAdjacentVertices() {
            List<Integer> sortedList = new ArrayList<>(adjacencySet.keySet());
            Collections.sort(sortedList);
            return sortedList;
        }
    }

    public interface IGraph {

        enum GraphType {
            DIRECTED,
            UNDIRECTED
        }

        void addEdge(int v1, int v2);

        void addEdge(int v1, int v2, int weight);

        int getWeightedEdge(int v1, int v2);

        List<Integer> getAdjacentVertices(int v);

        int getIndegree(int v);

        int getNumVertices();
    }
}
