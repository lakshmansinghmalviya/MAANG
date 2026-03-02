package coding_patterns.graphs.basic;

import java.util.Arrays;
import java.util.Scanner;

// GraphRepresentation in matrix way  - this takes  N*N complexity in both Directed and undirected graph

public class GraphRepresentationInMatrix {

    // nodes/vertex
    // links/edges

    // store in the matrix but cosumes lot space
    // store in list effiecient way less space

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of nodes and edges ");
        int nodes = sc.nextInt();
        int edges = sc.nextInt();
        int adj[][] = new int[nodes + 1][edges + 1];

        System.out.println("Link the nodes with edges ");

        // for (int i = 0; i < edges; i++) {
        // this is linking in the form of the node but below is in the formal way
        // index pointing
        // int firtNodeToLink = sc.nextInt();
        // int secondNodeToLink = sc.nextInt();
        // matrix[i] = new int[] { firtNodeToLink, secondNodeToLink };
        // }

        for (int i = 0; i < edges; i++) {
            int firtNodeIndexToLink = sc.nextInt();// U
            int secondNodeIndexToLink = sc.nextInt();// V

            adj[firtNodeIndexToLink][secondNodeIndexToLink] = 1;
            adj[secondNodeIndexToLink][firtNodeIndexToLink] = 1;
        }

        for (var arr : adj) {
            System.out.println(Arrays.toString(arr));
        }

        // this we can use this way to reduce the space two seperate array or 2D with 2
        // size
        // this is undirected graph
        // Enter number of nodes and edges
        // 5 7
        // Link the nodes with edges
        // 1 2
        // 1 3
        // 2 3
        // 2 4
        // 3 4
        // 3 5
        // 4 5
        // [1, 2]
        // [1, 3]
        // [2, 3]
        // [2, 4]
        // [3, 4]
        // [3, 5]
        // [4, 5]
    }
}