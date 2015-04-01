package com.dlut.lru;

import com.dlut.lru.data.structure.LRULinkedList;
import com.dlut.lru.data.structure.LRUNode;

/**
 * @author peng.huang
 * @version 1.0-SNAPSHOT
 * @data 15-3-23
 * @information LRU算法实现
 */
public class LeastRecentlyUsed {

    /**
     * util list
     */
    private com.dlut.lru.data.structure.LRULinkedList<Integer> LRULinkedList;

    /**
     * 存储页帧的数组
     */
    private int[] pageFrames;

    /**
     * 当前使用的页帧空间
     */
    private int usedSize;

    /**
     * constructor
     * @param pageFrameSize
     */
    public LeastRecentlyUsed(int pageFrameSize) {
        this.LRULinkedList = new LRULinkedList<Integer>();
        this.pageFrames = new int[pageFrameSize];
        this.usedSize = 0;
    }

    /**
     * LRU算法核心方法，一次处理一个引用串
     * @param pageFrameValue
     */
    public void dealingOncePageFrame(int pageFrameValue) {

        LRUNode targetNode = this.LRULinkedList.searchNode(pageFrameValue);

        if (targetNode == null) {
            if (this.usedSize == this.pageFrames.length) {

                LRUNode lastUsedNode = this.LRULinkedList.getNodeByIndex(usedSize-1);

                int index = lastUsedNode.getPageIndex();
                // replace value
                this.pageFrames[index] = pageFrameValue;

                // flush lastUsedNode's index
                lastUsedNode.setPageIndex(-1);

                // insert to list
                this.LRULinkedList.insertTop(pageFrameValue, index);

            } else {
                this.pageFrames[usedSize] = pageFrameValue;
                this.LRULinkedList.insertTop(pageFrameValue, usedSize++);
            }

        } else {
            if (this.usedSize == this.pageFrames.length && targetNode.getPageIndex() == -1) {

                LRUNode replaceNode = targetNode;
                while (replaceNode != null && replaceNode.getPageIndex() == -1) {
                    replaceNode = replaceNode.getPreNode();
                }
                int index = replaceNode.getPageIndex();
                // replace value
                this.pageFrames[index] = pageFrameValue;

                // flush replaceNode's index
                replaceNode.setPageIndex(-1);

                // flush targetNode's index
                targetNode.setPageIndex(index);
            }
            this.getLRULinkedList().moveTop(targetNode);
        }
    }

    /**
     *
     * @return
     */
    public int[] getPageFrames() {
        return pageFrames;
    }

    /**
     *
     * @param pageFrames
     */
    public void setPageFrames(int[] pageFrames) {
        this.pageFrames = pageFrames;
    }

    /**
     *
     * @return
     */
    public LRULinkedList<Integer> getLRULinkedList() {
        return LRULinkedList;
    }

    /**
     *
     * @return
     */
    public int getUsedSize() {
        return usedSize;
    }
}
