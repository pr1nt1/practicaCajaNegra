package com.practica.cajanegra;

import com.binarytree.BinaryTree;
import com.binarytree.Node;

import java.util.ArrayList;
import java.util.Iterator;

public class Pruebas {
    public static void main(String[] args) {

        /** Primer arbol **/

       // Node<String> nodoP = new Node<>("NodoP1");
        BinaryTree<String> bt = new BinaryTree<>("NodoP1");

        Node nodoHD = bt.insert("NodoHD1", bt.getRoot(), false);
        Node nodoHI = bt.insert("NodoHI1", bt.getRoot(), true);

        Node nodoHDD = bt.insert("NodoHD2", nodoHD, false);
        Node nodoHDDD = bt.insert("NodoHD3", nodoHDD, false);


        /*Iterator<String> iterator = bt.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/

        /*ArrayList<String> arr = bt.toList();
        int i = 0;
        while (i < 5){
            System.out.println(arr.get(i));
            i++;
        }*/
    }
}
