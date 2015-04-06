package com.dlut.interviews.longest.symmetrical;

/**
 * Created by ray on 15-4-6.
 * 目标回文串index和length
 */
public class PalindromeString {


    /**
     *
     */
    private int index;

    /**
     *
     */
    private int length;

    /**
     *
     */
    public PalindromeString() {
        this.index = 0;
        this.length = 1;
    }

    /**
     *
     * @param length
     * @param index
     */
    public PalindromeString(int length, int index) {
        this.length = length;
        this.index = index;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("index: ").append(index).append("\t")
                .append("length: ").append(length);
        return stringBuffer.toString();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
