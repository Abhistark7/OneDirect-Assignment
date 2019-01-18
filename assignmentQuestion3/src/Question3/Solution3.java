package Question3;

/**
 *
 * @author Abhishek Sahu
 */

import jdk.dynalink.NamedOperation;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Solution3
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {

        int choice = 0;

        //All choices
        while (choice!=9){

            System.out.println("Select Options -");
            System.out.println("1. Get immediate parent of a node");
            System.out.println("2. Get immediate children of a node");
            System.out.println("3. Get ancestors of a node");
            System.out.println("4. Get descendants of a node");
            System.out.println("5. Delete dependency from tree");
            System.out.println("6. Delete a node from tree");
            System.out.println("7. Add dependency to tree");
            System.out.println("8. Add new node to tree");
            System.out.println("9. Exit");
            try {
                choice = Integer.parseInt(sc.next());
            } catch (NumberFormatException e){

                System.out.println("Invalid choice!");
            }

            switch (choice){

                case 1: getParent();
                    break;
                case 2: getChildren();
                    break;
                case 3: getAncestors();
                    break;
                case 4: getDescendants();
                    break;
                case 5: delDependency();
                    break;
                case 6: delNode();
                    break;
                case 7: addDependency();
                    break;
                case 8: addNode();
                    break;
                case 9: System.exit(0);
                    break;
                default: System.out.println("Invalid choice!");

            }
        }


    }

    //method to get immediate parent
    static void getParent(){

        System.out.println("Enter node id");
        int nodeId = sc.nextInt();

        //Get node with entered id
        Node currentNode=null;
        ArrayList<Node> allNodes = DAG.getAllNodes();
        for (Node allNode : allNodes) {
            if (allNode.getNodeId() == nodeId) {
                currentNode = allNode;
            }
        }

        if(currentNode==null){
            System.out.println("Invalid NodeID");
        } else {
            System.out.println("Parent nodes are :-");
            DAG dag = new DAG();
            dag.getParents(currentNode);
        }

    }

    //method to get immediate children
    static void getChildren(){

        System.out.println("Enter node id");
        int nodeId = sc.nextInt();

        //Get node with entered id
        Node currentNode=null;
        ArrayList<Node> allNodes = DAG.getAllNodes();
        for (Node allNode : allNodes) {
            if (allNode.getNodeId() == nodeId) {
                currentNode = allNode;
            }
        }

        if(currentNode==null){
            System.out.println("Invalid NodeID");
        } else {
            System.out.println("Children nodes are :-");
            DAG dag = new DAG();
            dag.getChildren(currentNode);
        }

    }

    //method to get all ancestors
    static void getAncestors(){

        System.out.println("Enter node id");
        int nodeId = sc.nextInt();

        //Get node with entered id
        Node currentNode=null;
        ArrayList<Node> allNodes = DAG.getAllNodes();
        for (Node allNode : allNodes) {
            if (allNode.getNodeId() == nodeId) {
                currentNode = allNode;
            }
        }

        if(currentNode==null){
            System.out.println("Invalid NodeID");
        } else {

            System.out.println("Ancestor nodes are :-");
            DAG dag = new DAG();
            dag.getAncestors(currentNode);
        }
    }

    //method to get all descendants
    static void getDescendants(){

        System.out.println("Enter node id");
        int nodeId = sc.nextInt();

        //Get node with entered id
        Node currentNode=null;
        ArrayList<Node> allNodes = DAG.getAllNodes();
        for (Node allNode : allNodes) {
            if (allNode.getNodeId() == nodeId) {
                currentNode = allNode;
            }
        }

        if(currentNode==null){
            System.out.println("Invalid NodeID");
        } else {
            System.out.println("Descendant nodes are :-");
            DAG dag = new DAG();
            dag.getDescendants(currentNode);
        }

    }

    //method to delete a dependency
    static void delDependency(){

        System.out.println("Enter parent node id");
        int parentNodeId = sc.nextInt();

        //Get node with entered id
        Node parentNode=null;
        ArrayList<Node> allNodes = DAG.getAllNodes();
        for (Node allNode : allNodes) {
            if (allNode.getNodeId() == parentNodeId) {
                parentNode = allNode;
            }
        }
        System.out.println("Enter child node id");
        int childNodeId = sc.nextInt();

        //Get node with entered id
        Node childNode =null;
        for (Node allNode : allNodes) {
            if (allNode.getNodeId() == childNodeId) {
                childNode = allNode;
            }
        }

        if(childNode==null || parentNode==null){
            System.out.println("Invalid NodeID");
        } else {
            childNode.removeParent(parentNode);
            parentNode.removeChildren(childNode);
            System.out.println("Dependency removed!\n"+"Parent nodeID = "+parentNode.getNodeId()+" Child nodeID = "+childNode.getNodeId());
        }

    }

    //method to delete a node
    static void delNode(){

        System.out.println("Enter nodeId to delete");
        int nodeID = sc.nextInt();
        DAG.deleteNode(nodeID);

    }

    //method to add a dependency
    static void addDependency(){

        System.out.println("Enter parent node id");
        int parentNodeId = sc.nextInt();

        //Get node with entered id
        Node parentNode=null;
        ArrayList<Node> allNodes = DAG.getAllNodes();
        for (Node allNode : allNodes) {
            if (allNode.getNodeId() == parentNodeId) {
                parentNode = allNode;
            }
        }

        System.out.println("Enter child node id");
        int childNodeId = sc.nextInt();

        //Get node with entered id
        Node childNode=null;
        for (Node allNode : allNodes) {
            if (allNode.getNodeId() == childNodeId) {
                childNode = allNode;
            }
        }

        if (parentNode == null || childNode == null) {
            System.out.println("Invalid nodeID");
        } else {

            //check for cyclic dependency
            Boolean isCyclic = checkCyclic(childNode, parentNode);
            if (!isCyclic) {
                childNode.addParent(parentNode);
                parentNode.addChildren(childNode);
                System.out.println("Dependency added!\n" + "Parent nodeID = " + parentNode.getNodeId() + " Child nodeID = " + childNode.getNodeId());
            } else {
                System.out.println("Cyclic Dependency detected!");
            }
        }
    }

    //method to add a new node
    static void addNode(){

        System.out.println("Enter node id");
        int nodeId = sc.nextInt();
        System.out.println("Enter node value");
        String nodeVal = sc.next();

        DAG.createNode(nodeId, nodeVal);
        System.out.println("Node with id "+ nodeId+ " and value "+nodeVal+" added!");
    }

    static boolean checkCyclic(Node childNode, Node parentNode){

        //check if child node is already a descendant of parent node
        LinkedHashSet<Node> allAncestors = new LinkedHashSet<>();
        DAG dag = new DAG();
        dag.getAncestors(childNode);
        allAncestors = dag.getAllAncestors();
        if(allAncestors!=null) {
            if (allAncestors.contains(parentNode)) {
                System.out.println("parent already an ancestor");
                return true;
            } else {
                //check if child node is already a ancestor of parent node
                LinkedHashSet<Node> allDescendants = new LinkedHashSet<>();
                DAG dag1 = new DAG();
                dag1.getDescendants(childNode);
                allDescendants = dag1.getAllDescendants();
                if(allDescendants!=null) {
                    if (allDescendants.contains(parentNode)) {
                        System.out.println("parent already a descendant");
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }

        return false;

    }

}