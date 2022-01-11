package org.pg4200.ex05;

import org.pg4200.les05.MyMapBinarySearchTree;

public class BinaryTreeLeftMaxDelete<K extends Comparable<K>, V> extends MyMapBinarySearchTree<K, V> {

    /*
        Returns the possibly new root from the subtree
    */
    @Override
    protected TreeNode delete(K key, TreeNode subtreeRoot) {
//        Stopping condition => when the desired node does not exist
        if (subtreeRoot == null) {
            return null;
        }

        int comparison = key.compareTo(subtreeRoot.key);

//        Move to the left
        if (comparison > 0) {
            subtreeRoot.right = delete(key, subtreeRoot.right);
            return subtreeRoot;
        }

//        Move to the right
        if (comparison < 0) {
            subtreeRoot.left = delete(key, subtreeRoot.left);
            return subtreeRoot;
        }

//        This is the desired node
        if (comparison == 0) {

            size--;

            if (subtreeRoot.left == null) {
                return subtreeRoot.right;
            }

            if (subtreeRoot.right == null) {
                return subtreeRoot.left;
            }

            if (subtreeRoot.left != null && subtreeRoot.right != null) {
                TreeNode tmp = subtreeRoot;
                subtreeRoot = getMax(tmp.left);
                subtreeRoot.left = deleteMax(tmp.left);
                subtreeRoot.right = tmp.right;

                return subtreeRoot;
            }
        }

        return null;
    }

    private TreeNode getMax(TreeNode node) {
        if (node.right == null) {
            return node;
        }

        return getMax(node.right);
    }

    private TreeNode deleteMax(TreeNode node) {
        if (node.right == null) {
            return node.left;
        }

        node.right = deleteMax(node.right);

        return node;
    }

}
