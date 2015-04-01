package com.algorithms.dlut.exceptions;

import com.algorithms.dlut.KDException;

/**
  * KeyDuplicateException is thrown when the <TT>KDTree.insert</TT> method
  * is invoked on a key already in the KDTree.
  *
  * @author      Simon Levy
  * @version     %I%, %G%
  * @since JDK1.2 
  */

public class KeyDuplicateException extends KDException {

    public KeyDuplicateException() {
	super("Key already in tree");
    }
    
    // arbitrary; every serializable class has to have one of these
    public static final long serialVersionUID = 1L;
}
