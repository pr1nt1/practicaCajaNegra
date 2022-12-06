package com.practica.cajanegra;

import com.binarytree.BinaryTree;
import com.binarytree.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class PruebasTest3 {

    BinaryTree<String> bt = new BinaryTree<>("NodoP1");
    Node nodoHD = bt.insert("NodoHD1", bt.getRoot(), false);
    Node nodoHI = bt.insert("NodoHI1", bt.getRoot(), true);
    Node nodoHDD = bt.insert("NodoHD2", nodoHD, false);
    Node nodoHDI = bt.insert("NodoHI2", nodoHD, true);
    Node nodoHID = bt.insert("NodoHD3", nodoHI, false);
    Node nodoHII = bt.insert("NodoHI3", nodoHI, true);

    @Test
    public void depthTest(){
        assertEquals(3, this.bt.depth());
    }

    @Test
    public void depthConParametrosTest(){
        assertEquals(2, this.bt.depth(this.bt.getRoot().getRightChild()));
    }

    @Test
    public void equalsTest(){
        Node<String> nodoP = new Node<>("NodoP1");
        BinaryTree<String> bt2 = new BinaryTree<>(nodoP.getContent());

        Node nodoHD = bt2.insert("NodoHD1", bt2.getRoot(), false);
        Node nodoHI = bt2.insert("NodoHI1", bt2.getRoot(), true);

        Node nodoHDD = bt2.insert("NodoHD2", nodoHD, false);
        Node nodoHDI = bt2.insert("NodoHI2", nodoHD, true);

        Node nodoHID = bt2.insert("NodoHD3", nodoHI, false);
        Node nodoHII = bt2.insert("NodoHI3", nodoHI, true);

        assertEquals(true, this.bt.equals(bt2));
    }

    @Test
    public void equalsTest2(){ //da true y no debería (si se cambia el contenido del nodo padre si da error
        // por lo que parece que la función solo mira si es igual el contenido del nodo padre )
        Node<String> nodoP = new Node<>("NodoP1");
        BinaryTree<String> bt2 = new BinaryTree<>(nodoP.getContent());

        Node nodoHD = bt2.insert("NodoHD1", bt2.getRoot(), false);
        Node nodoHI = bt2.insert("NodoHI1", bt2.getRoot(), true);


        assertEquals(true, this.bt.equals(bt2));
    }

    @Test
    public void getRootTest1() {
        Node nodoRaiz = new Node("NodoP1");
        assertEquals(nodoRaiz.getContent(), this.bt.getRoot().getContent());
    }

    @Test
    public void getRootTest2() {
        assertEquals("NodoP1", this.bt.getRoot().getContent());
        assertEquals("NodoHI1", this.bt.getRoot().getLeftChild().getContent());
        assertEquals("NodoHD1", this.bt.getRoot().getRightChild().getContent());
    }

    @Test
    public void getSubTreeTest1(){
        BinaryTree aux = this.bt.getSubTree(this.bt.getRoot().getLeftChild());

        assertNull(aux.getRoot().getParent());

        assertEquals(aux.getRoot().getContent(), this.bt.getRoot().getLeftChild().getContent());

        assertEquals(aux.getRoot().getRightChild().getContent(), this.bt.getRoot().getLeftChild().getRightChild().getContent());

        assertEquals(aux.getRoot().getLeftChild().getContent(), this.bt.getRoot().getLeftChild().getLeftChild().getContent());

        assertNull(aux.getRoot().getRightChild().getRightChild());
        assertNull(aux.getRoot().getRightChild().getLeftChild());
        assertNull(aux.getRoot().getLeftChild().getRightChild());
        assertNull(aux.getRoot().getLeftChild().getLeftChild());
    }

    @Test
    public void insertTest(){ //funciona
        this.bt.insert("Lau1", this.nodoHII, true);
        assertEquals("Lau1", this.bt.getRoot().getLeftChild().getLeftChild().getLeftChild().getContent());
    }

    @Test
    public void insertTest2(){ //se ha insertado un nodo en una posición en la que ya existía un nodo, ¿debería poder o no poder hacerlo?
        this.bt.insert("Lau1", this.bt.getRoot(), true);
        assertEquals("Lau1", this.bt.getRoot().getLeftChild().getContent());
        //assertEquals("NodoHI1", this.bt.getRoot().getLeftChild().getContent());
    }

    @Test
    public void insertTest3(){
        this.bt.insert("22", this.bt.getRoot().getLeftChild(), true);
        assertEquals("22", this.bt.getRoot().getLeftChild().getLeftChild().getContent());
    }

    @Test
    public void insertTest4(){
        this.bt.insert("dd", this.bt.getRoot().getLeftChild(), true);
        assertEquals("dd", this.bt.getRoot().getLeftChild().getLeftChild().getContent());
    }

    @Test
    public void insertTest5(){
        this.bt.insert("__&/·#", this.bt.getRoot().getLeftChild().getLeftChild(), true);
        assertEquals("__&/·#", this.bt.getRoot().getLeftChild().getLeftChild().getLeftChild().getContent());
    }


    @Test
    public void iteratorTest(){
        Iterator<String> it = this.bt.iterator();
        assertEquals("NodoP1", it.next());
        assertEquals("NodoHI1", it.next());
        assertEquals("NodoHD1", it.next());
        assertEquals("NodoHD2", it.next());
        assertEquals("NodoHD3", it.next());
        assertFalse(it.hasNext());
    }

    @Test
    public void removeTest(){ //remove no funciona "Node out of this tree"
        this.bt.remove(nodoHDD);
        assertNull(this.bt.getRoot().getRightChild().getRightChild());
    }

    @Test
    public void removeTest2(){ //remove solo funciona si se está borrando un nodo hoja
        this.bt.remove(nodoHDD);
        assertNull(this.bt.getRoot().getRightChild().getRightChild().getRightChild());
    }

    @Test
    public void searchTest(){
        Node aux = this.bt.search("NodoHD1");
        assertEquals("NodoHD1", aux.getContent());
        assertEquals(this.bt.getRoot(), aux.getParent());
        assertEquals(this.bt.getRoot().getRightChild().getRightChild(), aux.getRightChild());
    }

    @Test
    public void searchTest2(){
        Node aux = this.bt.search("NodoP1");
        assertEquals("NodoP1", aux.getContent());
        assertEquals(this.bt.getRoot().getContent(), aux.getContent());
    }

    @Test
    public void searchTest3(){ //falla porque no lo encuentra ya que se borro ese nodo hoja.
        bt.remove(nodoHI);
        Node aux = this.bt.search("NodoHI1");
        assertEquals("NodoHI1", aux.getContent());
    }

    @Test
    public void searchTest4(){ //falla, el error se encuentra en remove ya que no funciona correctamente.
        bt.remove(nodoHD);
        Node aux = this.bt.search("NodoHD1");
        assertEquals("NodoHD1", aux.getContent());
    }

    @Test
    public void sizeTest(){
        assertEquals(7, bt.size());
    }

    @Test
    public void toListTest(){
        ArrayList<String> arr = this.bt.toList();
        ArrayList<String> aux = new ArrayList<>(Arrays.asList("NodoP1", "NodoHI1", "NodoHD1", "NodoHD2", "NodoHD3"));
        assertTrue(aux.equals(arr));
       /* int i = 0;
        assertEquals("NodoP1", arr.get(i));
        i++;
        assertEquals("NodoHI1", arr.get(i));
        i++;
        assertEquals("NodoHD1", arr.get(i));
        i++;
        assertEquals("NodoHD2", arr.get(i));
        i++;
        assertEquals("NodoHD3", arr.get(i));*/
    }

    @Test
    public void toStringTest(){
        assertEquals("NodoP1 Left: NodoHI1 Right: NodoHD1 \nNodoHI1 \nNodoHD1 Right: NodoHD2 \nNodoHD2 Right: NodoHD3 \nNodoHD3 \n", this.bt.toString());
    }
}
