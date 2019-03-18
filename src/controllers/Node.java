/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.text.Collator;
import java.util.LinkedList;
import java.util.Locale;

/**
 *
 * @author Thien Phuc
 */
public class Node {
    int height;
    private String word;
    private LinkedList<String> meaningList;
    private Node nodeLeft, nodeRight;

    public Node(String word, LinkedList<String> meaningList) {
        this.word = word;
        this.meaningList = meaningList;
        height = 1;
    }

    public LinkedList<String> getMeaningList() {
        return meaningList;
    }

    public void setMeaningList(LinkedList<String> meaningList) {
        this.meaningList = meaningList;
    }

    public Node getNodeLeft() {
        return nodeLeft;
    }

    public void setNodeLeft(Node nodeLeft) {
        this.nodeLeft = nodeLeft;
    }

    public Node getNodeRight() {
        return nodeRight;
    }

    public void setNodeRight(Node nodeRight) {
        this.nodeRight = nodeRight;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
    
    public boolean addMeaning(String meaning) {
        boolean check = false;
        if (!isContainingMeaning(meaning)) {
            meaningList.add(meaning);
            check = true;
        }
        return check;
    }
    
    public boolean isContainingMeaning(String meaning) {
        boolean check = false;
        for (String string : meaningList) {
            if (meaning.equalsIgnoreCase(string)) {
                check = true;
                break;
            }
        }
        return check;
    }
    
    public int compareTo(String word) {
        Collator myCo = Collator.getInstance(new Locale("vi"));
        return myCo.compare(this.word, word);
    }
}
