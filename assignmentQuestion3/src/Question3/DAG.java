package Question3;


/**
 *
 * @author Abhishek Sahu
 */

import java.util.ArrayList;
import java.util.LinkedHashSet;


//Structure of the tree
public class DAG
{
    static ArrayList<Node> allnodes = new ArrayList<>() ;

    static Node createNode(int id , String value )
    {
        Node node = new Node() ;
        node.setNodeId(id);
        node.setNodeValue(value);

        //add newly created node to list
        allnodes.add(node);
        return node;

    }


    static ArrayList<Node> getAllNodes(){
        return allnodes;
    }

    static void deleteNode(int nodeId){

        //get node with inputted node id
        Node curNode = null;
        for (Node allnode : allnodes) {
            if (allnode.getNodeId() == nodeId) {
                curNode = allnode;
            }
        }

        if(curNode==null){
            System.out.println("Invalid NodeID");
        } else {

            //remove node
            allnodes.remove(curNode);

            //remove all dependencies of this node
            for (Node temp : allnodes) {
                temp.nodeParents.remove(curNode);
                temp.nodeChildren.remove(curNode);
            }

            System.out.println("Node deleted!");
        }

    }


    void getParents(Node node)
    {
        LinkedHashSet<Node> parents = node.nodeParents;
        for (Node parent : parents) {
            System.out.println(parent);

        }

    }

    void getChildren(Node node)
    {
        LinkedHashSet<Node> children = node.nodeChildren;
        for (Node child : children) {
            System.out.println(child);

        }
    }

    void getAncestors(Node node) {

        LinkedHashSet<Node> parent = node.nodeParents;

        if(parent == null)
            return;

        for (Node curNode : parent) {
            System.out.println(curNode);
            //get ancestors of current node
            getAncestors(curNode);
        }
    }

    void getDescendants(Node node){

        LinkedHashSet<Node> children = node.nodeChildren;

        if(children == null)
            return;

        for (Node curNode : children) {
            System.out.println(curNode);
            //get descendants of current node
            getDescendants(curNode);

        }
    }

}