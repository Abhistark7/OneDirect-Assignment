package Question3;

/**
 *
 * @author Abhishek Sahu
 */


import java.util.LinkedHashSet;


//Structure of node
public class Node
{

    private int nodeId;
    private String nodeName;

    LinkedHashSet<Node> nodeParents;
    LinkedHashSet<Node> nodeChildren;

    public int getNodeId()
    {
        return this.nodeId;
    }

    public String getNodeValue()
    {
        return this.nodeName;
    }

    //Constructor
    Node()
    {
        nodeId = 0 ;
        nodeName = null ;
        nodeParents = new LinkedHashSet<Node>();
        nodeChildren = new LinkedHashSet<Node>();

    }

    void setNodeValue(String value)
    {
        this.nodeName = value;
    }

    void setNodeId(int id)
    {
        this.nodeId = id;
    }

    void addParent(Node parent)
    {
        //check for existing parent
        if(this.nodeParents.contains(parent))
        {
            System.out.println("Already a parent");
        }
        else
        {
            this.nodeParents.add(parent);
        }
    }

    void addChildren(Node child)
    {
        //check for existing child
        if(this.nodeChildren.contains(child))
        {
            System.out.println("Already a child");
        }
        else
        {
            this.nodeChildren.add(child);
        }
    }

    void removeParent(Node node){

        if(this.nodeParents.contains(node)){
            this.nodeParents.remove(node);
        } else {
            System.out.println("Dependency not present!");
        }
    }

    void removeChildren(Node node){

        if(this.nodeChildren.contains(node)){
            this.nodeChildren.remove(node);
        } else {
            System.out.println("Dependency not present!");
        }
    }


    @Override
    public String toString()
    {
        return("Node id -> "+this.getNodeId()+"\nNode value -> "+this.getNodeValue());
    }

}
