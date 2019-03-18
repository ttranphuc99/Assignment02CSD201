/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import dictionary.Dictionary;

/**
 *
 * @author Thien Phuc
 */
public class VnEnDictionary {
    public static Dictionary dictionary;
    
    static {
         dictionary = new Dictionary(false);
    }
}
