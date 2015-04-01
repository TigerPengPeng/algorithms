package com.dlut.lru.data.structure;

/**
 * @author peng.huang
 * @version 1.0-SNAPSHOT
 * @data 15-3-23
 * @information 实现LRU算法自定义的链表
 */
public class LRULinkedList<T> {

    private LRUNode<T> top;

    /**
     * constructor function
     */
    public LRULinkedList() {
        this.top = null;
    }

    /**
     * 通过比较value的值来索引节点。若返回null，则代表该value不存在于list中
     * @param value
     * @return LRUNode<T> or null
     */
    public LRUNode<T> searchNode(T value) {
        LRUNode<T> pos = this.top;
        while (pos != null) {
            if (pos.getValue().equals(value)) {
                return pos;
            }
            pos = pos.getNextNode();
        }
        return null;
    }

    /**
     * 根据index返回第index个节点
     * <if>index < 0</if>return top node<then></then>
     * <elseif>index > size of node</elseif><then>return null</then>
     * <else><return node at location of index/else>
     * @param index
     * @return
     */
    public LRUNode<T> getNodeByIndex(int index) {
        LRUNode<T> pos = this.top;
        int i = 0;
        while(pos != null && i < index) {
            pos = pos.getNextNode();
            i++;
        }
        return pos;
    }

    /**
     * 往list中插入节点，采用头插法
     * @param value
     * @param pageIndex
     * @return null
     */
    public void insertTop(T value, int pageIndex) {
        if (this.top == null) {
            this.top = new LRUNode<T>(value, pageIndex, null, null);
        } else {
            LRUNode<T> LRUNode = new LRUNode<T>(value, pageIndex, null, this.top);
            this.top.setPreNode(LRUNode);
            this.top = LRUNode;
        }
    }

    /**
     * 将节点移动到top, LRUNode是通过searchNode(T value)方法查找获得的节点
     * @param LRUNode
     * @return null
     */
    public void moveTop(LRUNode<T> LRUNode) {
        // <if>LRUNode为空 or LRUNode就是top节点</if>
        // <then>do nothing and return</then>
        if (LRUNode == null || LRUNode == this.top) {
            // do nothing
            return;
        }
        LRUNode<T> pre = LRUNode.getPreNode();
        LRUNode<T> next = LRUNode.getNextNode();
        pre.setNextNode(next);
        if (next != null) {
            next.setPreNode(pre);
        }

        LRUNode.setPreNode(null);
        LRUNode.setNextNode(this.top);
        this.top.setPreNode(LRUNode);

        this.top = LRUNode;
    }

    /**
     *
     * @return
     */
    public LRUNode<T> getTop() {
        return top;
    }

    /**
     * for test method
     */
    public void printList() {
        LRUNode node = this.top;
        while (node != null) {
            System.out.print(node.getValue() + "," + node.getPageIndex() + "\t");
            node = node.getNextNode();
        }
        System.out.println("");
    }


}
