/**
 * Created by Nick on 6/1/14.
 */
package taggedgraph;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ## Node
 *
 * This represents each node in the graph. All elements ({@link Node#getTitle() title},
 * {@link Node#getContent() content}, {@link Node#getTags() tags}) are implemented as strings.
 *
 * Example:
 *
 * ```java
 * Node physics = new Node("Physics", "Physics is a science...", "science,mathematics,interesting");
 * Node fourier = new Node("Fourier Transform", "Fourier transforms are a way of...", "mathematics,science,filtering,needtolearn");
 * ```
 * @author Nick
 * @version 0.1
 */
public class Node {

    private String title;
    private String content;
    private ArrayList<String> tags = new ArrayList<String>();

    /**
     * Constructs a node with a collection of tags
    */
    public Node(String title, String content, Collection<String> tags) {
        this.title = title;
        this.content = content;
        this.tags.addAll(tags);
    }

    /**
     * Constructs a node with a comma-delimited list of tags.
     * @param tags      A list of tags in the form of a comma-delimited string.
     */
    public Node(String title, String content, String tags) {
        this.title = title;
        this.content = content;
        for (String tag : tags.split(",")) {
            this.tags.add(tag);
        }
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void addTag(String tag) {
        tags.add(tag);
    }

    public void setContent(String content) {
        this.content = content;
    }
}
