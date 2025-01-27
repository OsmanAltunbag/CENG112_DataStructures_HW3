package CENG112_HW3;

public interface TreeInterface<T>
 {
 public T getRootData() throws EmptyTreeException;
 public int getHeight();
 public int getNumberOfNodes();
 public boolean isEmpty();
 public void clear();
 } // end TreeInterface