package com.practica.cajanegra;

import com.binarytree.BinaryTree;
import com.binarytree.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PruebasTest2 {

    /**ÁRBOL DE UN SOLO NODO**/

    BinaryTree<String> bt = new BinaryTree<>("NodoP1");

    @Test
    public void depthTest(){
        assertEquals(1, this.bt.depth());
    }

    @Test
    public void depthConParametrosTest(){
        assertEquals(1, this.bt.depth(bt.getRoot()));
    }

    @Test
    public void equalsTest(){ // da true
        Node<String> nodoP = new Node<>("NodoP1");
        BinaryTree<String> bt2 = new BinaryTree<>(nodoP.getContent());

        assertEquals(true, this.bt.equals(bt2));
    }

    @Test
    public void getRootTest() {
        assertEquals("NodoP1", this.bt.getRoot().getContent());
    }

    @Test
    public void getSubTreeTest(){
        BinaryTree aux = this.bt.getSubTree(this.bt.getRoot());

        assertNull(aux.getRoot().getRightChild());
        assertNull(aux.getRoot().getLeftChild());
    }

    @Test
    public void insertTest(){ //funciona
        this.bt.insert("NodoHD1", this.bt.getRoot(), false);
        this.bt.insert("NodoHI1", this.bt.getRoot(), true);
        assertEquals("NodoHD1", this.bt.getRoot().getRightChild().getContent());
        assertEquals("NodoHI1", this.bt.getRoot().getLeftChild().getContent());
    }

    @Test
    public void iteratorTest(){
        Iterator<String> it = this.bt.iterator();
        assertEquals("NodoP1", it.next());
    }

    @Test
    public void removeTest(){ //no ha borrado el nodo
        this.bt.remove(this.bt.getRoot());
        assertNull(this.bt.getRoot());
    }

    @Test
    public void searchTest(){
        Node aux = this.bt.search("NodoP1");
        assertEquals("NodoP1", aux.getContent());
        assertEquals(this.bt.getRoot().getContent(), aux.getContent());
    }

    @Test
    public void sizeTest(){
        assertEquals(1, bt.size());
    }

    @Test
    public void toListTest(){
        ArrayList<String> arr = this.bt.toList();
        int i = 0;
        assertEquals("NodoP1", arr.get(i));
    }

    @Test
    public void toStringTest(){
        assertEquals("NodoP1 \n", this.bt.toString());
    }
}
