package com.dlut.sorts.bucket.data.structure;

/**
 * Created by ray on 15-4-8.
 * 桶排序辅助使用的双向链表
 */
public class LinkedList<T extends Comparable> {

    /**
     * 头节点不用来存储数据
     */
    private ListNode<T> head;

    /**
     *
     */
    public LinkedList() {
        this.head = new ListNode<T>();
    }

    /**
     * 采用头插法插入节点
     * @param value
     */
    public void headInsert(T value) {
        insertAfter(head, new ListNode<T>(value));
//        ListNode<T> node = new ListNode<T>(value, head, head.getNextNode());
//        head.getNextNode().setPreNode(node);
//        head.setNextNode(node);
    }

    /**
     *
     * @param removeNode
     * @return
     */
    public ListNode<T> removeNode(ListNode<T> removeNode) {
        if (head == removeNode) {
            throw new RuntimeException("can not remove head node");
        }
        if (removeNode.getPreNode() != null) {
            removeNode.getPreNode().setNextNode(removeNode.getNextNode());
        }
        if (removeNode.getNextNode() != null) {
            removeNode.getNextNode().setPreNode(removeNode.getPreNode());
        }
        return removeNode;
    }

    /**
     *
     * @param targetNode
     * @param insertNode
     */
    public void insertAfter(ListNode<T> targetNode, ListNode<T> insertNode) {
        if (targetNode == null ) {
            throw new RuntimeException("targetNode is illegal");
        }
        if (insertNode == null || insertNode == head) {
            throw new RuntimeException("insertNode is illegal");
        }
        insertNode.setPreNode(targetNode);
        insertNode.setNextNode(targetNode.getNextNode());
        if (targetNode.getNextNode() != null) {
            targetNode.getNextNode().setPreNode(insertNode);
        }
        targetNode.setNextNode(insertNode);
    }

    /**
     * 移动moveNode到targetNode之前，targetNode不能为head节点
     * @param targetNode
     * @param moveNode
     */
    public void moveAfterTarget(ListNode<T> targetNode, ListNode<T> moveNode) {
        if (targetNode == null) {
            throw new RuntimeException("targetNode is illegal");
        }
        // 删除moveNode
        moveNode = removeNode(moveNode);
        // 插入moveNode到targetNode之前
        insertAfter(targetNode, moveNode);
    }

    /**
     * 对链表进行排序
     * 排序的方法为链表插入排序
     */
    public void sort() {
        ListNode<T> pos = head.getNextNode().getNextNode();
        while (pos != null) {
            T guard = pos.getValue();
            ListNode<T> target = pos.getPreNode();
            while (target != head && target.compareTo(guard) > 0) {
                target = target.getPreNode();
            }
            moveAfterTarget(target, pos);
            pos = pos.getNextNode();
        }
    }

    /**
     * 将链表的节点的value复制到array中
     * @param array
     * @param beginIndex
     * @return
     */
    public int copyToArray(T[] array, int beginIndex) {
        int pos = beginIndex;
        ListNode<T> node = head.getNextNode();
        while (node != null) {
            array[pos++] = node.getValue();
            node = node.getNextNode();
        }
        return pos - beginIndex;
    }

    /**
     *
     */
    public void printList() {
        ListNode<T> pos = head.getNextNode();
        while (pos != null) {
            System.out.println(pos.getValue());
            pos = pos.getNextNode();
        }
    }

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<Integer>();
        int[] data = new int[] {12,54,333,5,12,30,266,43,5,13};
        for (int item : data) {
            list.headInsert(item);
        }
        list.sort();
        list.printList();

    }
}
