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
        }
        catch (Exception e) {
            System.err.println(e);
        }

//        double[] lowk = {0, 0}; //lowk[0] = X_low, lowk[1] = Y_low
//        double[] uppk = {2, 1}; //uppk[0] = X_upp, uppl[1] = Y_upp
//        List<String> list = kd.range(lowk, uppk);
//        System.out.println(list);

        List<String>  list = kd.nearestHamming(T, 1.8888);
        System.out.println(list);


//        // look for node D
//        try {
//            String n = kd.search(D);
//            System.err.println(n);
//            // return null
//            n = kd.search(T);
//            System.err.println(n);
//        }
//        catch (Exception e) {
//            System.err.println(e);
//        }
//
//        try {
//
//            // find T's nearest neighbor
//            String n = kd.nearest(T);
//            System.err.println(n);
//
//            // remove D from the tree
//            kd.delete(D);
//
//            // now T's nearest neighbor
//            n = kd.nearest(T);
//            System.err.println(n);
//        }
//        catch (Exception e) {
//            System.err.println(e);
//        }
    }

}
