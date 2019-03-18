/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import controllers.Node;
import controllers.Tree;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.LinkedList;

/**
 *
 * @author Thien Phuc
 */
public class Dictionary {
    private static final int BOM_UFT8 = 65279;
    private Tree tree;
    boolean isEnglish;
    private static final String EN_VN = "EnglishVietnamese.txt";
    private static final String VN_EN = "VietnameseEnglish.txt";

    public Dictionary(boolean isEnglish) {
        tree = new Tree();
        this.isEnglish = isEnglish;
        loadData();
    }

    private void loadData() {
        String filename = "";
        if (isEnglish) {
            filename = EN_VN;
        } else {
            filename = VN_EN;
        }

        File f = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            f = new File(filename);
            fr = new FileReader(f);
            br = new BufferedReader(fr);

            String line = "";

            while ((line = br.readLine()) != null) {
                if (line.charAt(0) == BOM_UFT8) {
                    line = line.substring(1);
                }
                String[] part = line.split(":");
                
                System.out.println("line: " + line);
                System.out.println("length: " + line.length());
                System.out.println("ascii: " + (int) line.charAt(0));
                System.out.println(part.length);
                //get words
                String words = part[0].trim().toLowerCase();

                //get meaning
                LinkedList<String> meaning = new LinkedList<>();
                String[] meaningPart = part[1].split(",");
                for (String string : meaningPart) {
                    meaning.add(string.trim().toLowerCase());
                }

                //init new node
                Node node = new Node(words, meaning);
                tree.setRoot(tree.insert(tree.getRoot(), node));

                
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void saveData() {
        String filename = "";
        if (isEnglish) {
            filename = EN_VN;
        } else {
            filename = VN_EN;
        }

        File f = null;
        PrintWriter pw = null;

        try {
            f = new File(filename);
            pw = new PrintWriter(f);

            interate(tree.getRoot(), pw);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void interate(Node node, PrintWriter pw) {
        if (node != null) {
            interate(node.getNodeLeft(), pw);

            //write to file
            String line = "";

            String word = node.getWord();
            line += word + " : ";

            for (int i = 0; i < node.getMeaningList().size(); i++) {
                if (i != node.getMeaningList().size() - 1) {
                    line += node.getMeaningList().get(i) + ", ";
                } else {
                    line += node.getMeaningList().get(i);
                }
            }
            pw.println(line);
            //end of write to file

            interate(node.getNodeRight(), pw);
        }
    }

    public void addWords(String word, String meaning) {
        String[] meanComponent = meaning.split(",");
        Node node = tree.search(tree.getRoot(), word);
        if (node != null) {
            LinkedList<String> meanList = node.getMeaningList();
            for (String string : meanComponent) {
                string = string.trim().toLowerCase();
                if (!meanList.contains(string)) {
                    meanList.add(string);
                }
            }
        } else {
            LinkedList<String> meanList = new LinkedList<>();
            for (String string : meanComponent) {
                string = string.trim().toLowerCase();
                meanList.add(string);
            }
            Node newNode = new Node(word, meanList);
            tree.setRoot(tree.insert(tree.getRoot(), newNode));
        }
        saveData();
    }

    public LinkedList<String> translate(String word) {
        LinkedList<String> result = new LinkedList<>();
        Node node = tree.search(tree.getRoot(), word);
        if (node != null) {
            result = node.getMeaningList();
        }
        return result;
    }
}
