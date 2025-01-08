package CENG112_HW3;

import java.util.Iterator;
 import java.util.NoSuchElementException;
 /**
 A class that implements the ADT binary tree.
 @author Frank M. Carrano.
 */
 public class BinaryTree<T> implements BinaryTreeInterface<T>
 
 {
 BinaryNode<T> root;
 BinaryTree()
 {
 root = null;
 } // end default constructor

 public BinaryTree(T rootData)
 {
 root = new BinaryNode<>(rootData);
 } // end constructor

 public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
 {
 privateSetTree(rootData, leftTree, rightTree);
 } // end constructor

 public void setTree(T rootData)
 {
 root = new BinaryNode<>(rootData);
 } // end setTree
public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
 BinaryTreeInterface<T> rightTree)
 {
 privateSetTree(rootData, (BinaryTree<T>)leftTree,
 (BinaryTree<T>)rightTree);
 } // end setTree

private void privateSetTree(T rootData, BinaryTree<T> leftTree,
		 BinaryTree<T> rightTree)
		{
		 root = new BinaryNode<>(rootData);
		 if ((leftTree != null) && !leftTree.isEmpty())
		 root.setLeftChild(leftTree.root);
		 if ((rightTree != null) && !rightTree.isEmpty())
		 {
		 if (rightTree != leftTree)
		 root.setRightChild(rightTree.root);
		 else
		 root.setRightChild(rightTree.root.copy());
		 } // end if
		 if ((leftTree != null) && (leftTree != this))
		 leftTree.clear();
		 if ((rightTree != null) && (rightTree != this))
		 rightTree.clear();
		} // end privateSetTree
public T getRootData() throws EmptyTreeException
{
 if (isEmpty())
 throw new EmptyTreeException();
 else
 return root.getData();
} // end getRootData
public boolean isEmpty()
{
 return root == null;
} // end isEmpty
public void clear()
{
 root = null;
} // end clear
protected void setRootData(T rootData)
{
 root.setData(rootData);
} // end setRootData
protected void setRootNode(BinaryNode<T> rootNode)
{
 root = rootNode;
} // end setRootNode
protected BinaryNode<T> getRootNode()
{
 return root;
} // end getRootNode
public int getHeight()
{
 return root.getHeight();
} // end getHeight
public int getNumberOfNodes()
{
 return root.getNumberOfNodes();
} // end getNumberOfNodes

 
  public void remove()
  {
  throw new UnsupportedOperationException();
  } // end remove
  // end InorderIterator

@Override
public Iterator<T> getPreorderIterator() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Iterator<T> getPostorderIterator() {
	// TODO Auto-generated method stub
	return null;
}

public Iterator<T> getInorderIterator()
{
 return new InorderIterator();
} // end getInorderIterator

@Override
public Iterator<T> getLevelOrderIterator() {
	// TODO Auto-generated method stub
	return null;
}
 } // end BinaryTree
 class InorderIterator<T> implements Iterator<T> {
	   ;
	    private StackInterface nodeStack;
	    private BinaryNode currentNode;
	    private BinaryNode root;

	    public InorderIterator() {
	        nodeStack = new LinkedStack<>();
	        BinaryNode root = null;
			currentNode = root;
	    } // end default constructor

	    public boolean hasNext() {
	        return !nodeStack.isEmpty() || (currentNode != null);
	    } // end hasNext

	    public T next() {
	        BinaryNode<T> nextNode = null;

	        // Find leftmost node with no left child
	        while (currentNode != null) {
	            nodeStack.push(currentNode);
	            currentNode = currentNode.getLeftChild();
	        } // end while

	        // Get leftmost node, then move to its right subtree
	        if (!nodeStack.isEmpty()) {
	            nextNode = (BinaryNode<T>) nodeStack.pop();
	            assert nextNode != null; // Since nodeStack was not empty
	            // before the pop
	            currentNode = nextNode.getRightChild();
	        } else {
	            throw new NoSuchElementException();
	        }

	        return nextNode.getData();
	    } // end next

	    public void remove() {
	        throw new UnsupportedOperationException();
	    } // end remove
	} // end InorderIterator
 
