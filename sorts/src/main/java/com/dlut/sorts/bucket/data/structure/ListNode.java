package com.dlut.sorts.bucket.data.structure;


/**
 * Created by ray on 15-4-8.
 * 桶排序辅助使用的双向链表节点
 */
public class ListNode<T extends Comparable> implements Comparable<T> {

    /**
     *
     */
    private T value;

    /**
     *
     */
    private ListNode preNode;

    /**
     *
     */
    private ListNode nextNode;

    /**
     *
     */
    public ListNode() {
        this(null);
    }

    /**
     *
     * @param value
     */
    public ListNode(T value) {
        this(value, null, null);
    }

    /**
     *
     * @param value
     * @param preNode
     * @param nextNode
     */
    public ListNode(T value, ListNode preNode, ListNode nextNode) {
        this.value = value;
        this.preNode = preNode;
        this.nextNode = nextNode;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ListNode getPreNode() {
        return preNode;
    }

    public void setPreNode(ListNode preNode) {
        this.preNode = preNode;
    }

    public ListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(ListNode nextNode) {
        this.nextNode = nextNode;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     * <p/>
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     * <p/>
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     * <p/>
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     * <p/>
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     * <p/>
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(T o) {
        if (this.value.compareTo(o) == 0) {
            return 0;
        } else if (this.value.compareTo(o) < 0) {
            return -1;
        } else {
            return 1;
        }
    }
}
