package com.dlut.lru.data.structure;

/**
 * to liuzhichao@meituan.com
 * @author peng.huang
 * @version 1.0-SNAPSHOT
 * @data 15-3-23
 * @information 实现LRU算法自定义的链表的节点
 */
public class LRUNode<T> {

    /**
     * value
     */
    private T value;

    /**
     * 记录与该节点值相同的引用串在数组中的下标
     */
    private int pageIndex;

    /**
     *
     */
    private LRUNode<T> preNode;

    /**
     *
     */
    private LRUNode<T> nextNode;

    /**
     * constructor
     * @param value
     * @param pageIndex
     */
    public LRUNode(T value, int pageIndex) {
        this.value = value;
        this.pageIndex = pageIndex;
        this.preNode = null;
        this.nextNode = null;
    }

    /**
     * constructor
     * @param value
     * @param pageIndex
     * @param preNode
     * @param nextNode
     */
    public LRUNode(T value, int pageIndex, LRUNode<T> preNode, LRUNode<T> nextNode) {
        this.value = value;
        this.pageIndex = pageIndex;
        this.preNode = preNode;
        this.nextNode = nextNode;
    }


    /**
     *
     * @return
     */
    public T getValue() {
        return value;
    }

    /**
     *
     * @param value
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     *
     * @return
     */
    public LRUNode<T> getPreNode() {
        return preNode;
    }

    /**
     *
     * @param preNode
     */
    public void setPreNode(LRUNode<T> preNode) {
        this.preNode = preNode;
    }

    /**
     *
     * @return
     */
    public LRUNode<T> getNextNode() {
        return nextNode;
    }

    /**
     *
     * @param nextNode
     */
    public void setNextNode(LRUNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    /**
     *
     * @return
     */
    public int getPageIndex() {
        return pageIndex;
    }

    /**
     *
     * @param pageIndex
     */
    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }
}