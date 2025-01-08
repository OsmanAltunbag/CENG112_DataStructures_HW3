package CENG112_HW3;

import java.util.ArrayList;
import java.util.List;

public class Tree<T extends Comparable<? super T>> {
    private Node<T> root;

    public Tree() {
        this.root = null;
    }

    public void add(T data) {
        root = addRecursively(root, data);
    }

    private Node<T> addRecursively(Node<T> node, T data) {
        if (node == null) {
            return new Node<>(data);
        }

        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(addRecursively(node.getLeftChild(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(addRecursively(node.getRightChild(), data));
        }

        return node;
    }

    public T search(T data) {
        return searchRecursively(root, data);
    }

    private T searchRecursively(Node<T> node, T data) {
        if (node == null || node.getData().compareTo(data) == 0) {
            return node != null ? node.getData() : null;
        }

        if (data.compareTo(node.getData()) < 0) {
            return searchRecursively(node.getLeftChild(), data);
        } else {
            return searchRecursively(node.getRightChild(), data);
        }
    }

    public List<T> getAllNodesInSortedOrder() {
        List<T> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal(Node<T> node, List<T> result) {
        if (node != null) {
            inorderTraversal(node.getLeftChild(), result);
            result.add(node.getData());
            inorderTraversal(node.getRightChild(), result);
        }
    }
}

