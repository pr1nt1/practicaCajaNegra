package com.practica.cajanegra;

import com.binarytree.BinaryTree;
import com.binarytree.Node;
import org.junit.Test;
import static org.junit.Assert.*;

public class PruebasTest {

    BinaryTree bt;
    Node nodeP;
    Node nodeHD;
    Node nodeHI;

    public void setNodoP() throws Exception {
        nodeP = new Node("NodoP1");
    }

    public void setNodoHD() throws Exception {
        nodeHD = new Node("NodoHD1",nodeP);
        nodeP.setRightChild(nodeHD);
    }

    public void setNodoHI() throws Exception {
        nodeHI = new Node("NodoHI1",nodeP);
        nodeP.setLeftChild(nodeHI);
    }

    public void setBt() throws Exception {
        bt = new BinaryTree(nodeP);
    }

    @Test
    public void depthTest(){
        int depth = this.bt.depth();
       assertEquals(true, depth == this.bt.depth());
    }

    @Test
    public void depthTest2(){

    }

    @Test
    public void getRootTest(){
        Node node = this.nodeP;
        assertEquals(true, node == this.nodeP);
    }
}
