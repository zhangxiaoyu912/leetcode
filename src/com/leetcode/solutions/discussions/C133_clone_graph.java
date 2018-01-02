package com.leetcode.solutions.discussions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class C133_clone_graph {
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    ;

    // solution from the dicussion, similar as tree clone !
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;

        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map =
                new HashMap<UndirectedGraphNode,UndirectedGraphNode>();

        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);

        queue.add(node);
        map.put(node, newHead);

        while(!queue.isEmpty()){
            UndirectedGraphNode curr = queue.pop();
            List<UndirectedGraphNode> currNeighbors = curr.neighbors;

            for(UndirectedGraphNode aNeighbor: currNeighbors){
                if(!map.containsKey(aNeighbor)){
                    UndirectedGraphNode copy = new UndirectedGraphNode(aNeighbor.label);
                    map.put(aNeighbor,copy);
                    map.get(curr).neighbors.add(copy);
                    queue.add(aNeighbor);
                }else{
                    map.get(curr).neighbors.add(map.get(aNeighbor));
                }
            }

        }
        return newHead;
    }

    // the solution doesn't work as it doens't have a queue
//     public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//         if (node == null)
//             return node;

//         Map<Integer, UndirectedGraphNode> map = new HashMap<>();
//         UndirectedGraphNode root = new UndirectedGraphNode(node.label);
//         bfs(root, node, map);
//         return root;
//     }

//     private void bfs(UndirectedGraphNode root, UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
//         if (map.containsKey(node.label))
//             return;

//         root = new UndirectedGraphNode(node.label);
//         root.neighbors = new ArrayList<>();
//         for (UndirectedGraphNode nei : node.neighbors) {
//             if (map.containsKey(nei.label)) {
//                 UndirectedGraphNode neiNode = map.get(nei.label);
//                 root.neighbors.add(neiNode);
//                 bfs(neiNode, nei, map);
//             } else {
//                 UndirectedGraphNode neiNode = new UndirectedGraphNode(nei.label);
//                 map.put(nei.label, neiNode);
//                 root.neighbors.add(neiNode);
//                 bfs(neiNode, nei, map);
//             }
//         }
//     }
}
