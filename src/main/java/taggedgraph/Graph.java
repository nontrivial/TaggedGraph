package taggedgraph;

/**
 * Created by Nick on 6/2/14.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * ## Graph
 *
 * Generic interface for graphs.
 *
 * @author Nick
 * @version 0.1
 */
public interface Graph {

    public boolean isAdjacent(int a, int b);

    public List<Node> neighbors(int a);

    public int addNode(Node n);

    public void deleteNode(int a);

    public void addEdge(int a, int b);

    public void deleteEdge(int a, int b);

    public List<Node> getAllNodes();

    public ArrayList<NodeSearchResult> textSearch(String text);

    public class NodeSearchResult {
        int score = 0;
        int titleIndex = 0;
        ArrayList<Integer> titleHits = new ArrayList<Integer>();
        ArrayList<Integer> contentHits = new ArrayList<Integer>();
        ArrayList<Integer> tagHits = new ArrayList<Integer>();

        public void score() {

        }
    }
}
