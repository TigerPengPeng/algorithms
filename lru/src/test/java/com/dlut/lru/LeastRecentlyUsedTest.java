package com.dlut.lru;

import com.dlut.lru.data.structure.LRULinkedList;
import junit.framework.Assert;
import org.junit.Test;

public class LeastRecentlyUsedTest {

    public static void main(String[] args) {

        LeastRecentlyUsed leastRecentlyUsed = new LeastRecentlyUsed(3);

        for (String arg : args) {

            int pageValue = Integer.parseInt(arg);
            leastRecentlyUsed.dealingOncePageFrame(pageValue);

            int usedSize = leastRecentlyUsed.getUsedSize();
            int[] pages = leastRecentlyUsed.getPageFrames();
            LRULinkedList LRULinkedList = leastRecentlyUsed.getLRULinkedList();
            LRULinkedList.printList();
            Assert.assertTrue(true);
        }
    }
}