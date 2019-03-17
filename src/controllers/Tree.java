/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author Thien Phuc
 */
public class Tree {

    private Node root;

    public Tree() {
    }

    public Tree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean isEmpty() {
        if (root != null) {
            return false;
        }
        return true;
    }
/*
    public boolean insert(Node node) {
        boolean check = true;
        if (isEmpty()) {
            root = node;
        } else {
            Node tNode = root, parentNode = null;
            do {
                parentNode = tNode;
                if (tNode.compareTo(node.getWord()) < 0) {
                    tNode = tNode.getNodeLeft();
                } else if (tNode.compareTo(node.getWord()) > 0) {
                    tNode = tNode.getNodeRight();
                } else {
                    check = false;
                    break;
                }
            } while (tNode != null);
            
            if (parentNode.compareTo(node.getWord()) < 0) {
                parentNode.setNodeLeft(node);
            } else if (parentNode.compareTo(node.getWord()) > 0) {
                parentNode.setNodeRight(node);
            }
        }
        return check;
    }
*/  
    public Node search(Node node, String word) {
        Node result = null;
        boolean found = false;
        while (node != null && !found) {
            if (node.compareTo(word) < 0) {
                node = node.getNodeLeft();
            } else if (node.compareTo(word) > 0) {
                node = node.getNodeRight();
            } else {
                result = node;
                found = true;
            }
        }
        return result;
    }
    
    public Node leftRotate(Node node) {
        Node tNode1 = node.getNodeRight();
        Node tNode2 = tNode1.getNodeLeft();

        //perform rotate
        tNode1.setNodeLeft(node);
        node.setNodeRight(tNode2);
        
        //update height
        node.height = max(getHeight(node.getNodeLeft()), getHeight(node.getNodeRight())) + 1;
        tNode1.height = max(getHeight(tNode1.getNodeLeft()), getHeight(tNode1.getNodeRight())) + 1;
        return tNode1;
    }
    
    public Node rightRotate(Node node) {
        Node tNode1 = node.getNodeLeft();
        Node tNode2 = tNode1.getNodeRight();

        //perform rotate
        tNode1.setNodeRight(node);
        node.setNodeLeft(tNode2);
        
        //update height
        node.height = max(getHeight(node.getNodeLeft()), getHeight(node.getNodeRight())) + 1;
        tNode1.height = max(getHeight(tNode1.getNodeLeft()), getHeight(tNode1.getNodeRight())) + 1;
        
        
        return tNode1;
    }
    
    public static int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }
    
    public static int getBalance(Node node) {
        if (node == null) {
            return 0;
        }

        return getHeight(node.getNodeRight()) - getHeight(node.getNodeLeft());
    }
    
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }
    
    public Node insert(Node parentNode, Node addNode) {
        if (parentNode == null) return addNode;
        
        if (addNode.compareTo(parentNode.getWord()) < 0) {
            parentNode.setNodeLeft(insert(parentNode.getNodeLeft(), addNode));
        } else if (addNode.compareTo(parentNode.getWord()) > 0) {
            parentNode.setNodeRight(insert(parentNode.getNodeRight(), addNode));
        } else {
            return parentNode;
        }
        
        parentNode.height = 1 + max(getHeight(parentNode.getNodeLeft()), getHeight(parentNode.getNodeRight()));

        int balance = getBalance(parentNode);

        if (balance > 1 && parentNode.compareTo(addNode.getWord()) < 0 ) {
            //right right case
            return leftRotate(parentNode);
        } else if (balance > 1 && parentNode.compareTo(addNode.getWord()) > 0) {
            //right left case
            parentNode.setNodeRight(rightRotate(parentNode.getNodeRight()));
            return leftRotate(parentNode);
        } else if (balance < -1 && parentNode.compareTo(addNode.getWord()) > 0) {
            //left left case
            return rightRotate(parentNode);
        } else if (balance < -1 && parentNode.compareTo(addNode.getWord()) < 0) {
            //left right case
            parentNode.setNodeLeft(leftRotate(parentNode.getNodeLeft()));
            return rightRotate(parentNode);
        }
        return parentNode;
    }
    
    public void pre(Node node) {
        if (node != null) {
//            System.out.println(node.getWord());
            pre(node.getNodeLeft());
            System.out.println(node.getWord());
            pre(node.getNodeRight());
        }
    }
}
