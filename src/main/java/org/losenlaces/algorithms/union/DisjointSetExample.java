package org.losenlaces.algorithms.union;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DisjointSetExample {

    private void HackerRankChallengeInit() {
        Scanner scan = new Scanner(System.in);
        List<Integer> aux = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        //aux.get(0) elementos
        //aux.get(1)
    }

    public static void main(String[] args) {

        DisjointSet disjointSet = new DisjointSet(4);

        System.out.println("Elementos en el grupo del elemento 2: " +disjointSet.getSize(1));
        disjointSet.union(1, 2);
        System.out.println("Elementos en el grupo del elemento 2: " +disjointSet.getSize(1));
        disjointSet.union(3, 4);
        System.out.println("Elementos en el grupo del elemento 2: " +disjointSet.getSize(1));
        disjointSet.union(1, 3);
        System.out.println("Elementos en el grupo del elemento 2: " +disjointSet.getSize(1));

    }


    static class DisjointSet {
        private Node[] sets;

        public Node[] getSets() {
            return sets;
        }

        private int maxSize = Integer.MIN_VALUE;

        public DisjointSet(int elemetns) {
            this.sets = new Node[elemetns];
            for (int x = 0; x < elemetns; x++) {
                this.sets[x] = new Node(-1, 0, 1);
            }
        }

        public void union(int u, int v) {
            int repU = find(u-1);
            int repV = find(v-1);

            if (repU != repV) {
                if (sets[repU].rank > sets[repV].rank) {
                    sets[repV].parent = repU;
                    sets[repU].size += sets[repV].size;
                    updateMaxSize(sets[repU].size);
                } else if (sets[repU].rank < sets[repV].rank) {
                    sets[repU].parent = repV;
                    sets[repV].size += sets[repU].size;
                    updateMaxSize(sets[repV].size);
                } else {
                    sets[repV].parent = repU;
                    sets[repU].rank++;
                    sets[repU].size += sets[repV].size;
                    updateMaxSize(sets[repU].size);
                }
            }
        }

        public int find(int u) {
            while (sets[u].parent != -1) {
                int temp = u;
                u = find(sets[u].parent);
                sets[temp].parent = u;
            }
            return u;
        }

        public int getSize(int u) {
            return sets[find(u)].size;
        }

        public class Node {
            int parent;
            int rank;
            int size;

            public int getSize() {
                return size;
            }

            public int getParent() {
                return parent;
            }

            public Node(int parent, int rank, int size) {
                this.parent = parent;
                this.rank = rank;
                this.size = size;
            }
        }

        private void updateMaxSize(int size) {
            if (size > maxSize) {
                maxSize = size;
            }
        }


        public int getMaxSize() {
            return maxSize;
        }
    }
}
