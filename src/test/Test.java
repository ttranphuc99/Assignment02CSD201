/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controllers.Node;
import controllers.Tree;
import dictionary.Dictionary;
import java.text.Collator;
import java.util.Locale;

/**
 *
 * @author Thien Phuc
 */
public class Test {

    public static void main(String[] args) {
//        Tree tree = new Tree();
//        Node node1 = new Node("a", null);
//        Node node2 = new Node("g", null);
//        Node node3 = new Node("e", null);
//        Node node4 = new Node("f", null);
//        Node node5 = new Node("b", null);
//        
//        tree.setRoot(tree.insert(tree.getRoot(), node1));
//        tree.setRoot(tree.insert(tree.getRoot(), node2));
//        tree.setRoot(tree.insert(tree.getRoot(), node3));
//        tree.setRoot(tree.insert(tree.getRoot(), node4));
//        tree.setRoot(tree.insert(tree.getRoot(), node5));
//
//        tree.pre(tree.getRoot());
//        Dictionary eng = new Dictionary(true);
//        eng.saveData();
        Collator myCo = Collator.getInstance(new Locale("vi"));
        System.out.println("a cmp a" + myCo.compare("a", "aw"));
    }
}
