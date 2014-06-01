package taggedgraph;

/**
 * Created by Nick on 6/2/14.
 */

import java.util.Collection;
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

    public List<Node> searchByTag(Collection<String> tags);

    public List<Node> searchByTitle(String text);

    public List<Node> searchByContent(String text);
}
