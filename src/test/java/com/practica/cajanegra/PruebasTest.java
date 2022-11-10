package com.practica.cajanegra;

import com.binarytree.BinaryTree;
import com.binarytree.Node;
import org.junit.Test;
import static org.junit.Assert.*;

public class PruebasTest {


    Node<String> nodoP = new Node<>("NodoP1");
    BinaryTree<String> bt1 = new BinaryTree<>(nodoP.getContent());

    Node nodoHD = bt1.insert("NodoHD1", bt1.getRoot(), false);
    Node nodoHI = bt1.insert("NodoHI1", bt1.getRoot(), true);

    Node nodoHDD = bt1.insert("NodoHD2", nodoHD, false);
    Node nodoHDDD = bt1.insert("NodoHD3", nodoHDD, false);

    @Test
    public void depthTest(){
       assertEquals(true, this.bt1.depth() == 4);
    }

    @Test
    public void depthConParametrosTest(){
        assertEquals(true, this.bt1.depth(nodoHD) == 3);
    }

    @Test
    public void equalsTest(){ // da true
        Node<String> nodoP = new Node<>("NodoP1");
        BinaryTree<String> bt2 = new BinaryTree<>(nodoP.getContent());

        Node nodoHD = bt2.insert("NodoHD1", bt2.getRoot(), false);
        Node nodoHI = bt2.insert("NodoHI1", bt2.getRoot(), true);

        Node nodoHDD = bt2.insert("NodoHD2", nodoHD, false);
        Node nodoHDDD = bt2.insert("NodoHD3", nodoHDD, false);

        assertEquals(true, this.bt1.equals(bt2));
    }

    @Test
    public void equalsTest2(){ //da true y no debería (si se cambia el contenido del nodo padre si da error
                               // por lo que parece que la función solo mira si es igual el contenido del nodo padre )
        Node<String> nodoP = new Node<>("NodoP1");
        BinaryTree<String> bt2 = new BinaryTree<>(nodoP.getContent());

        Node nodoHD = bt2.insert("NodoHD1", bt2.getRoot(), false);
        Node nodoHI = bt2.insert("NodoHI1", bt2.getRoot(), true);


        assertEquals(true, this.bt1.equals(bt2));
    }

    @Test
    public void getRootTest(){
        assertEquals(true, this.bt1.getRoot().getContent().equals("NodoP1"));
        assertEquals(true, this.bt1.getRoot().getLeftChild().getContent().equals("NodoHI1"));
        assertEquals(true, this.bt1.getRoot().getRightChild().getContent().equals("NodoHD1"));
    }
}
