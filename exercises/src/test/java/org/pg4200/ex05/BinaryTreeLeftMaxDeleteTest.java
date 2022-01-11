package org.pg4200.ex05;

import org.pg4200.les05.MyMapBinarySearchTreeTest;
import org.pg4200.les05.MyMapTreeBased;

public class BinaryTreeLeftMaxDeleteTest extends MyMapBinarySearchTreeTest {
    @Override
    protected <K extends Comparable<K>, V> MyMapTreeBased<K, V> getTreeInstance() {
        return new BinaryTreeLeftMaxDelete<>();
    }
}
