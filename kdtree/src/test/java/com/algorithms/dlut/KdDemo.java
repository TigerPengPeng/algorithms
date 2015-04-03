package com.algorithms.dlut;

// illustrates behavior of KDTree class


import java.util.List;

public class KdDemo {

    public static void main(String [] args) throws Exception {

        double [] A = {2, 5};
        double [] B = {1, 1};
        double [] C = {3, 9};
        double [] D = {1, 9};
        double [] E = {2, 7};
        double [] F = {2, 1};
        double [] T = {1, 10};

        // make a KD-tree and add some nodes
        KDTree<String> kd = new KDTree<String>(2);
        try {
            kd.insert(A, new String("A"));
            kd.insert(B, new String("B"));
            kd.insert(C, new String("C"));
            kd.insert(D, new String("D"));
            kd.insert(E, new String("E"));
            kd.insert(F, new String("F"));
            kd.insert(A, new String("P"));
        }
        catch (Exception e) {
            System.err.println(e);
        }

        List<String> list = kd.nearest(A, 3);
        System.out.println(list);
    }

}
