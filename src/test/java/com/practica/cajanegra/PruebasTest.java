package com.practica.cajanegra;

import com.binarytree.BinaryTree;
import com.binarytree.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static org.junit.Assert.*;


public class PruebasTest {

    /**ÁRBOL DE VARIOS NODOS**/

    BinaryTree<String> bt1 = new BinaryTree<>("NodoP1");
    Node nodoHD = bt1.insert("NodoHD1", bt1.getRoot(), false);
    Node nodoHI = bt1.insert("NodoHI1", bt1.getRoot(), true);
    Node nodoHDD = bt1.insert("NodoHD2", nodoHD, false);
    Node nodoHDDD = bt1.insert("NodoHD3", nodoHDD, false);

    @Test
    public void binaryTreeTest1() {
        BinaryTree<String> bt = new BinaryTree<>("Laura2");
        assertEquals("Laura2", bt.getRoot().getContent());
        assertNull(bt.getRoot().getLeftChild());
        assertNull(bt.getRoot().getRightChild());
    }

    @Test
    public void binaryTreeTest2() { //solo letras
        BinaryTree<String> bt = new BinaryTree<>("Laura");
        assertEquals("Laura", bt.getRoot().getContent());
        assertNull(bt.getRoot().getLeftChild());
        assertNull(bt.getRoot().getRightChild());
    }

    @Test
    public void binaryTreeTest3() { //solo numeros
        BinaryTree<String> bt = new BinaryTree<>("324");
        assertEquals("324", bt.getRoot().getContent());
        assertNull(bt.getRoot().getLeftChild());
        assertNull(bt.getRoot().getRightChild());
    }

    @Test
    public void binaryTreeTest4() { //simbolos
        BinaryTree<String> bt = new BinaryTree<>("/ ()*:_ª");
        assertEquals("/ ()*:_ª", bt.getRoot().getContent());
        assertNull(bt.getRoot().getLeftChild());
        assertNull(bt.getRoot().getRightChild());
    }

    @Test
    public void binaryTreeTest5() { //simbolos
        BinaryTree<String> bt = new BinaryTree<>("Laura/ ()*:_ª");
        assertEquals("Laura/ ()*:_ª", bt.getRoot().getContent());
        assertNull(bt.getRoot().getLeftChild());
        assertNull(bt.getRoot().getRightChild());
    }

    @Test(expected = IllegalArgumentException.class)
    public void binaryTreeTest6() { //simbolos
        BinaryTree<String> bt = new BinaryTree<>("32/ ()*:_ª");
        assertEquals("32/ ()*:_ª", bt.getRoot().getContent());
        assertNull(bt.getRoot().getLeftChild());
        assertNull(bt.getRoot().getRightChild());
    }

    @Test
    public void binaryTreeTest7() { //simbolos
        BinaryTree<String> bt = new BinaryTree<>("Laura32/ ()*:_ª");
        assertEquals("Laura32/ ()*:_ª", bt.getRoot().getContent());
        assertNull(bt.getRoot().getLeftChild());
        assertNull(bt.getRoot().getRightChild());
    }

    @Test
    public void binaryTreeTest8() { //letras minusculas solo
        BinaryTree<String> bt = new BinaryTree<>("laura");
        assertEquals("laura", bt.getRoot().getContent());
        assertNull(bt.getRoot().getLeftChild());
        assertNull(bt.getRoot().getRightChild());
    }

    @Test
    public void binaryTreeTest9() { //letras mayusculas solo
        BinaryTree<String> bt = new BinaryTree<>("LAURA");
        assertEquals("LAURA", bt.getRoot().getContent());
        assertNull(bt.getRoot().getLeftChild());
        assertNull(bt.getRoot().getRightChild());
    }

    @Test
    public void binaryTreeTest10() { //letras mayusculas y nums
        BinaryTree<String> bt = new BinaryTree<>("LAURA1");
        assertEquals("LAURA1", bt.getRoot().getContent());
        assertNull(bt.getRoot().getLeftChild());
        assertNull(bt.getRoot().getRightChild());
    }

    @Test
    public void binaryTreeTest11() { //letras minusculas y nums
        BinaryTree<String> bt = new BinaryTree<>("laura1");
        assertEquals("laura1", bt.getRoot().getContent());
        assertNull(bt.getRoot().getLeftChild());
        assertNull(bt.getRoot().getRightChild());
    }

    @Test
    public void binaryTreeTest12() { //letras minusculas, nums y simbolos
        BinaryTree<String> bt = new BinaryTree<>("laura1#");
        assertEquals("laura1#", bt.getRoot().getContent());
        assertNull(bt.getRoot().getLeftChild());
        assertNull(bt.getRoot().getRightChild());
    }

    @Test
    public void binaryTreeTest13() { //letras minusculas, nums y simbolos
        BinaryTree<String> bt = new BinaryTree<>("LAURA1#");
        assertEquals("LAURA1#", bt.getRoot().getContent());
        assertNull(bt.getRoot().getLeftChild());
        assertNull(bt.getRoot().getRightChild());
    }

    @Test
    public void binaryTreeTest14() { //letras minusculas, nums y simbolos
        BinaryTree<String> bt = new BinaryTree<>("LAURA#");
        assertEquals("LAURA#", bt.getRoot().getContent());
        assertNull(bt.getRoot().getLeftChild());
        assertNull(bt.getRoot().getRightChild());
    }

    @Test
    public void binaryTreeTest15() { //letras minusculas, nums y simbolos
        BinaryTree<String> bt = new BinaryTree<>("laura#");
        assertEquals("laura#", bt.getRoot().getContent());
        assertNull(bt.getRoot().getLeftChild());
        assertNull(bt.getRoot().getRightChild());
    }

    @Test
    public void binaryTreeTest16() { //null
        BinaryTree<String> bt = new BinaryTree<>(null);
        assertNull(bt.getRoot().getContent());
        assertNull(bt.getRoot().getLeftChild());
        assertNull(bt.getRoot().getRightChild());
    }

    @Test
    public void depthTest(){
       assertEquals(4, this.bt1.depth());
    }

    @Test
    public void depthConParametrosTest(){
        assertEquals(3, this.bt1.depth(this.bt1.getRoot().getRightChild()));
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
    public void getRootTest1() {
        Node nodoRaiz = new Node("NodoP1");
        assertEquals(nodoRaiz, this.bt1.getRoot());
    }

    @Test
    public void getRootTest2() {
        assertEquals("NodoP1", this.bt1.getRoot().getContent());
        assertEquals("NodoHI1", this.bt1.getRoot().getLeftChild().getContent());
        assertEquals("NodoHD1", this.bt1.getRoot().getRightChild().getContent());
    }

    @Test
    public void getRootTest3() {
        Node nodoRaiz = new Node("NodoHD1");
        assertEquals(nodoRaiz, this.bt1.getRoot());
    }

    @Test
    public void getSubTreeTest1(){
        BinaryTree aux = this.bt1.getSubTree(this.bt1.getRoot().getRightChild());

        assertNull(aux.getRoot().getParent());

        assertEquals("NodoHD1", aux.getRoot().getContent());
        assertNull(aux.getRoot().getLeftChild());

        assertEquals("NodoHD2", aux.getRoot().getRightChild().getContent());
        assertNull(aux.getRoot().getRightChild().getLeftChild());

        assertEquals("NodoHD3", aux.getRoot().getRightChild().getRightChild().getContent());
        assertNull(aux.getRoot().getRightChild().getRightChild().getRightChild());
        assertNull(aux.getRoot().getRightChild().getRightChild().getLeftChild());
    }

    @Test
    public void getSubTreeTest2(){
        BinaryTree aux = this.bt1.getSubTree(this.bt1.getRoot().getRightChild());

        assertEquals(aux.getRoot().getContent(), this.bt1.getRoot().getRightChild().getContent());
    }

    @Test
    public void getSubTreeTest3(){
        BinaryTree aux = this.bt1.getSubTree(this.bt1.getRoot().getLeftChild());

        assertNull(aux.getRoot().getParent());
        assertNull(aux.getRoot().getRightChild());
        assertNull(aux.getRoot().getLeftChild());
        assertEquals("NodoHI1", aux.getRoot().getContent());
    }

    @Test
    public void getSubTreeTest4(){
        BinaryTree aux = this.bt1.getSubTree(this.bt1.getRoot().getRightChild());

        ArrayList<String> aux2 = new ArrayList<>(Arrays.asList("NodoHD1", "NodoHD2", "NodoHD3"));
        assertTrue(aux2.equals(aux));

    }

    @Test
    public void insertTest1(){ //funciona
        this.bt1.insert("NodoHI2", this.nodoHI, true);
        assertEquals("NodoHI2", this.bt1.getRoot().getLeftChild().getLeftChild().getContent());
    }

    @Test
    public void insertTest2(){ //se ha insertado un nodo en una posición en la que ya existía un nodo, ¿debería poder o no poder hacerlo?
        this.bt1.insert("NodoHI2", this.bt1.getRoot(), true);
        assertEquals("NodoHI2", this.bt1.getRoot().getLeftChild().getContent());
    }
    
    @Test
    public void insertTest3(){
        this.bt1.insert("22", this.bt1.getRoot().getLeftChild(), true);
        assertEquals("22", this.bt1.getRoot().getLeftChild().getLeftChild().getContent());
    }
    
    @Test
    public void insertTest4(){
        this.bt1.insert("dd", this.bt1.getRoot().getLeftChild(), true);
        assertEquals("dd", this.bt1.getRoot().getLeftChild().getLeftChild().getContent());
    }

    @Test
    public void insertTest5(){
        this.bt1.insert("dd& %", this.bt1.getRoot().getLeftChild(), true);
        assertEquals("dd& %", this.bt1.getRoot().getLeftChild().getLeftChild().getContent());
    }

    @Test
    public void insertTest6(){
        this.bt1.insert("dd32& %", this.bt1.getRoot().getLeftChild(), true);
        assertEquals("dd32& %", this.bt1.getRoot().getLeftChild().getLeftChild().getContent());
    }

    @Test
    public void insertTest7(){
        this.bt1.insert("23& %", this.bt1.getRoot().getLeftChild(), false);
        assertEquals("23& %", this.bt1.getRoot().getLeftChild().getRightChild().getContent());
    }

    @Test
    public void insertTest8(){
        this.bt1.insert("LAU", this.bt1.getRoot().getLeftChild(), true);
        assertEquals("LAU", this.bt1.getRoot().getLeftChild().getLeftChild().getContent());
    }

    @Test
    public void insertTest9(){
        this.bt1.insert("Lau", this.bt1.getRoot().getLeftChild(), true);
        assertEquals("Lau", this.bt1.getRoot().getLeftChild().getLeftChild().getContent());
    }

    @Test
    public void insertTest10(){
        this.bt1.insert("Lau()3", this.bt1.getRoot().getLeftChild(), true);
        assertEquals("Lau()3", this.bt1.getRoot().getLeftChild().getLeftChild().getContent());
    }

    @Test
    public void insertTest11(){
        this.bt1.insert("LAU()3", this.bt1.getRoot().getLeftChild(), true);
        assertEquals("LAU()3", this.bt1.getRoot().getLeftChild().getLeftChild().getContent());
    }

    @Test
    public void iteratorTest1(){
        Iterator<String> it = this.bt1.iterator();
        assertEquals("NodoP1", it.next());
        assertEquals("NodoHI1", it.next());
        assertEquals("NodoHD1", it.next());
        assertEquals("NodoHD2", it.next());
        assertEquals("NodoHD3", it.next());
        assertFalse(it.hasNext());
    }

    @Test
    public void iteratorTest2(){
        Iterator<String> it = this.bt1.iterator();
        assertEquals("NodoP1", it.next());
        assertEquals("NodoHI1", it.next());
        assertEquals("NodoHD1", it.next());
        assertFalse(it.hasNext());
    }

    @Test
    public void removeTest(){ //remove no funciona "Node out of this tree"
        this.bt1.remove(nodoHDD);
        assertNull(this.bt1.getRoot().getRightChild().getRightChild());
    }

    @Test
    public void removeTest2(){ //remove solo funciona si se está borrando un nodo hoja
        this.bt1.remove(nodoHDDD);
        assertNull(this.bt1.getRoot().getRightChild().getRightChild().getRightChild());
    }

    @Test
    public void searchTest(){
        Node aux = this.bt1.search("NodoHD1");
        assertEquals("NodoHD1", aux.getContent());
        assertEquals(this.bt1.getRoot(), aux.getParent());
        assertEquals(this.bt1.getRoot().getRightChild().getRightChild(), aux.getRightChild());
    }

    @Test
    public void searchTest2(){
        Node aux = this.bt1.search("NodoP1");
        assertEquals("NodoP1", aux.getContent());
        assertEquals(this.bt1.getRoot().getContent(), aux.getContent());
    }

    @Test
    public void searchTest3(){ //falla porque no lo encuentra ya que se borro ese nodo hoja.
        bt1.remove(nodoHI);
        Node aux = this.bt1.search("NodoHI1");
        assertEquals("NodoHI1", aux.getContent());
    }

    @Test
    public void searchTest4(){ //falla, el error se encuentra en remove ya que no funciona correctamente.
        bt1.remove(nodoHD);
        Node aux = this.bt1.search("NodoHD1");
        assertEquals("NodoHD1", aux.getContent());
    }

    @Test
    public void searchTest5(){
        Node aux = this.bt1.search("NodoHD1");
        assertEquals(bt1.getRoot().getRightChild().getContent(), aux.getContent());
    }

    @Test
    public void sizeTest(){
        assertEquals(5, bt1.size());
    }

    @Test
    public void toListTest1(){
        ArrayList<String> arr = this.bt1.toList();
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
    public void toListTest2(){
        ArrayList<String> arr = this.bt1.toList();
        ArrayList<String> aux = new ArrayList<>(Arrays.asList("NodoP1", "NodoHD1", "NodoHD2"));
        assertTrue(aux.equals(arr));
    }

    @Test
    public void toStringTest1(){ //esta mal
        assertEquals("NodoP1 Left: NodoHI1 Right: NodoHD1 \nNodoHI1 \nNodoHD1 Right: NodoHD2 \nNodoHD2 Right: NodoHD3 \nNodoHD3 \n", this.bt1.toString());
    }

    @Test
    public void toStringTest2(){
        assertEquals("NodoP1 Left: NodoHI1 Right: NodoHD1 \n", this.bt1.toString());
    }
}
