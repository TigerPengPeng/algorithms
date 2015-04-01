package com.dlut.lru;

import com.dlut.lru.data.structure.LRULinkedList;
import com.dlut.lru.data.structure.LRUNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LRULinkedListTest {

    private com.dlut.lru.data.structure.LRULinkedList<Integer> LRULinkedList;

    @Before
    public void initStack() {
        this.LRULinkedList = new LRULinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            this.LRULinkedList.insertTop(i, i);
        }
    }

    @Test
    public void testGetNodeByIndex() throws Exception {
        LRUNode top = this.LRULinkedList.getTop();
        LRUNode node = this.LRULinkedList.getNodeByIndex(1);
        assertNotNull(node);
        assertEquals(node.getValue(), 3);
    }

    @Test
    public void testInsertTop() throws Exception {
        LRUNode top = this.LRULinkedList.getTop();
        assertNotNull(top);
        assertEquals(4, top.getValue());
    }

    @Test
    public void testSearchNode() throws Exception {
        LRUNode node = this.LRULinkedList.searchNode(1);
        assertNotNull(node);
        assertEquals(1, node.getValue());

        node = this.LRULinkedList.searchNode(6);
        assertNull(node);
    }

    @Test
    public void testMoveTop() throws Exception {
        LRUNode node0 = this.LRULinkedList.searchNode(4);
        LRUNode node1 = this.LRULinkedList.searchNode(3);
        LRUNode node2 = this.LRULinkedList.searchNode(0);


        this.LRULinkedList.moveTop(node0);
        this.LRULinkedList.printList();
        LRUNode top = LRULinkedList.getTop();
        assertNotNull(top);
        assertEquals(4, top.getValue());

        this.LRULinkedList.moveTop(node1);
        this.LRULinkedList.printList();
        top = LRULinkedList.getTop();
        assertNotNull(top);
        assertEquals(3, top.getValue());

        this.LRULinkedList.moveTop(node2);
        this.LRULinkedList.printList();
        top = LRULinkedList.getTop();
        assertNotNull(top);
        assertEquals(0, top.getValue());

    }
}