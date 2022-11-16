package com.practica.cajanegra;

import com.binarytree.BinaryTree;
import com.binarytree.Node;

public class Pruebas {
    public static void main(String[] args) {

        /** Primer arbol **/

        Node<String> nodoP = new Node<>("23432");
        BinaryTree<String> bt = new BinaryTree<>(nodoP.getContent());

        Node nodoHD = bt.insert("NodoHD1", bt.getRoot(), false);
        Node nodoHI = bt.insert("NodoHI1", bt.getRoot(), true);

        Node nodoHDD = bt.insert("NodoHD2", nodoHD, false);
        Node nodoHDDD = bt.insert("NodoHD3", nodoHDD, false);

    }
}
