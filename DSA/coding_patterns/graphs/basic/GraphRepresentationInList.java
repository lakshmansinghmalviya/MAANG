package coding_patterns.graphs.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GraphRepresentationInList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of nodes and edges ");
        int nodes = sc.nextInt();
        int edges = sc.nextInt();
        System.out.println(nodes + "  " + edges);
        List<List<Integer>> ajdList = new ArrayList<>(); // for better clearity to see we can use map of the node,
                                                         // list

        for (int i = 0; i <= nodes; i++) {
            ajdList.add(new ArrayList<>());
        }

        System.out.println("Link the nodes with edges ");
        for (int i = 1; i <= edges; i++) {
            int u = sc.nextInt(); // u-v
            int v = sc.nextInt(); // u-v

            if (ajdList.get(u) == null)
                ajdList.add(u, new ArrayList<>());
            // if undirected graph (both)
            if (ajdList.get(v) == null)
                ajdList.add(v, new ArrayList<>());

            // if undirected graph (both) if directed only one add is enough
            ajdList.get(u).add(v);
            ajdList.get(v).add(u);
        }

        System.out.println(ajdList);
    }
}