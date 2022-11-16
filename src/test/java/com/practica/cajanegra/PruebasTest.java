package com.practica.cajanegra;

import com.binarytree.BinaryTree;
import com.binarytree.Node;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThrows;

public class PruebasTest {


    Node<String> nodoP = new Node<>("NodoP1");
    BinaryTree<String> bt1 = new BinaryTree<>(nodoP.getContent());
    Node nodoHD = bt1.insert("NodoHD1", bt1.getRoot(), false);
    Node nodoHI = bt1.insert("NodoHI1", bt1.getRoot(), true);
    Node nodoHDD = bt1.insert("NodoHD2", nodoHD, false);
    Node nodoHDDD = bt1.insert("NodoHD3", nodoHDD, false);

    @Test
    public void binaryTreeTest1() {
        BinaryTree<String> bt2 = new BinaryTree<>("Laura2");
        assertTrue(bt2.getRoot().getContent().equals("Laura2"));
        assertEquals(null, bt2.getRoot().getLeftChild());
        assertEquals(null, bt2.getRoot().getRightChild());
    }

    @Test(expected = IllegalArgumentException.class)
    public void binaryTreeTest2() { //solo letras
        BinaryTree<String> bt3 = new BinaryTree<>("Laura");
    }

    @Test(expected = IllegalArgumentException.class)
    public void binaryTreeTest3() { //solo numeros
        BinaryTree<String> bt3 = new BinaryTree<>("324");
    }

    //TODO: Queda hacerlo
    @Test(expected = IllegalArgumentException.class)
    public void binaryTreeTest4() { //NO ASCII
        BinaryTree<String> bt3 = new BinaryTree<>("324");
    }

    @Test
    public void depthTest(){
       assertEquals(4, this.bt1.depth());
    }

    @Test
    public void depthConParametrosTest(){
        assertEquals(3, this.bt1.depth(nodoHD));
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
    public void getRootTest() {
        assertTrue(this.bt1.getRoot().getContent().equals("NodoP1"));
        assertTrue(this.bt1.getRoot().getLeftChild().getContent().equals("NodoHI1"));
        assertTrue(this.bt1.getRoot().getRightChild().getContent().equals("NodoHD1"));
    }
}
