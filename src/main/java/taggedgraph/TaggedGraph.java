package taggedgraph;

import javax.swing.text.html.parser.TagElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nick on 6/2/14.
 */
public class TaggedGraph implements Graph {

    private int numNodes = 0;
    private ArrayList<Node> nodes;
    private ArrayList<ArrayList<Integer>> edges;

    public TaggedGraph(Collection<Node> nodes, List<ArrayList<Integer>> edges) {
        numNodes = nodes.size();
        this.nodes.addAll(nodes);
        this.edges.addAll(edges);
    }

    @Override
    public boolean isAdjacent(int a, int b) {
        return edges.get(a).contains(b);
    }

    @Override
    public List<Node> neighbors(int a) {
        return edges.get(a).stream().map(b -> nodes.get(b)).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public int addNode(Node node) {
        numNodes++;
        this.nodes.add(node);
        return numNodes;
    }

    @Override
    public void deleteNode(int a) {
        edges.set(a, null);
        numNodes--;
    }

    @Override
    public void addEdge(int a, int b) {
        edges.get(a).add(b);
        edges.get(b).add(a);
    }

    @Override
    public void deleteEdge(int a, int b) {
        int numA = edges.get(a).indexOf(b);
        int numB = edges.get(b).indexOf(a);
        edges.get(a).remove(numB);
        edges.get(b).remove(numA);
    }

    @Override
    public List<Node> getAllNodes() {
        return nodes;
    }

    public void cleanDeletedNodes() {
        int deletedNodes = 0;
        int [] indexMap = new int[nodes.size()];
        ArrayList<ArrayList<Integer>> newEdges = new ArrayList<ArrayList<Integer>>();


        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i - deletedNodes) == null) {
                nodes.remove(i - deletedNodes);
                deletedNodes++;
            }
            else
                indexMap[i] = i - deletedNodes;
        }
        // TODO: Check that numNodes is now equal to nodes.size()

        for (int i = 0; i < nodes.size(); i++) {
            newEdges.add(edges.get(i).stream().map(a -> indexMap[a]).collect(Collectors.toCollection(ArrayList::new)));
        }
    }
}
