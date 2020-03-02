package tp3;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.lang.*;

public class AvlTree<ValueType extends Comparable<? super ValueType> > {

    private BinaryNode<ValueType> root;

    public AvlTree() {
    }

    /**
     * Adds value to the tree and keeps it as a balanced AVL Tree
     *
     * @param value value to add to the tree
     */
    public void insert(ValueType value) {
        if (root == null) {
            root = new BinaryNode<ValueType>(value, null);
        } else {
            insert(value, root);
        }
    }

    /**
     * Removes value from the tree and keeps it as a balanced AVL Tree
     *
     * @param value value to add to the tree
     */
    public void remove(ValueType value) {
        remove(value, root);
    }

    /**
     * Verifies if the tree contains value
     *
     * @param value value to verify
     * @return if value already exists in the tree
     */
    public boolean contains(ValueType value) {
        return contains(value, root);
    }

    /**
     * Returns the max level contained in our root tree
     *
     * @return Max level contained in our root tree
     */
    public int getHeight() {
        return getLevelCount(root) - 1;
    }

    /**
     * Returns the minimal value contained in our root tree
     *
     * @return Minimal value contained in our root tree
     */
    public ValueType findMin() {
        BinaryNode<ValueType> minimalNode = findMin(root);
        if (minimalNode == null) return null;
        return minimalNode.value;
    }

    /**
     * Returns all values contained in the root tree in ascending order
     *
     * @return Values contained in the root tree in ascending order
     */
    public List<ValueType> infixOrder() {
        List<ValueType> items = new LinkedList<ValueType>();
        infixOrder(root, items);
        return items;
    }

    /**
     * Returns all values contained in the root tree in level order from top to bottom
     *
     * @return Values contained in the root tree in level order from top to bottom
     */
    public List<ValueType> levelOrder() {
        List<ValueType> items = new LinkedList<ValueType>();

        ArrayDeque<BinaryNode<ValueType>> nodesToCheck = new ArrayDeque<BinaryNode<ValueType>>();

        if (root != null) {
            nodesToCheck.push(root);
            levelOrder(nodesToCheck, items);
        }

        return items;
    }

    /**
     * TODO O( log n )
     * Adds value to the tree and keeps it as a balanced AVL Tree
     * Should call balance only if insertion succeeds
     * AVL Trees do not contain duplicates
     *
     * @param value       value to add to the tree
     * @param currentNode Node currently being accessed in this recursive method
     * @return if parent node should balance
     */
    private boolean insert(ValueType value, BinaryNode<ValueType> currentNode) {

        if (value.compareTo(currentNode.value) > 0) {
            if (currentNode.right == null) {
                currentNode.right = new BinaryNode<ValueType>(value, currentNode);
                balance(currentNode); //TODO
            } else {
                insert(value, currentNode.right);
            }
        } else if (value.compareTo(currentNode.value) < 0) {
            if (currentNode.left == null) {
                currentNode.left = new BinaryNode<ValueType>(value, currentNode);
                balance(currentNode); //TODO
            } else {
                insert(value, currentNode.left);
            }
        } else {
            ;
        }
        return true;
    }

    /**
     * TODO O ( log n )
     * Removes value from the tree and keeps it as a balanced AVL Tree
     * Should call balance only if removal succeeds
     *
     * @param value       value to remove from the tree
     * @param currentNode Node currently being accessed in this recursive method
     * @return if parent node should balance
     */
    private boolean remove(ValueType value, BinaryNode<ValueType> currentNode) {

        if (currentNode != null) {
            if (value.compareTo(currentNode.value) > 0) {
                return remove(value, currentNode.right);

            } else if (value.compareTo(currentNode.value) < 0) {
                return remove(value, currentNode.left);

            } else if (currentNode.right != null || currentNode.left != null) {
                currentNode.value = findMin(currentNode.right).value;
                return remove(currentNode.value, currentNode.right);

            } else {
                if (currentNode.parent == null) {
                    this.root = (currentNode.left != null) ? currentNode.left : currentNode.right;

                } else if (currentNode.parent.value.compareTo(currentNode.value) > 0) {
                    currentNode.parent.left = (currentNode.left != null) ? currentNode.left : currentNode.right;

                } else {
                    currentNode.parent.right = (currentNode.left != null) ? currentNode.left : currentNode.right;
                }
                balance(currentNode.parent);
                return true;
            }
        }
        return false;
    }

    /**
     * TODO O( n )
     * Balances the subTree
     *
     * @param subTree SubTree currently being accessed to verify if it respects the AVL balancing rule
     */
    private void balance(BinaryNode<ValueType> subTree) {

        if (subTree == null) return;

        if (getLevelCount(subTree.left) - getLevelCount(subTree.right) > 1) {
            if (getLevelCount(subTree.left.left) - getLevelCount(subTree.left.right) < 0) {
                doubleRotateOnLeftChild(subTree);
            } else {
                rotateLeft(subTree);
            }

        } else if (getLevelCount(subTree.left) - getLevelCount(subTree.right) < -1) {
            if (getLevelCount(subTree.right.left) - getLevelCount(subTree.right.right) > 0) {
                doubleRotateOnRightChild(subTree);
            } else {
                rotateRight(subTree);
            }
        }
        if (subTree != root)
            balance(subTree.parent);

    }

    /**
     * TODO O( 1 )
     * Single rotation to the left child, AVR Algorithm
     *
     * @param node1 Node to become child of its left child
     */
    private void rotateLeft(BinaryNode<ValueType> node1) {
        BinaryNode<ValueType> leftChild = node1.left;
        BinaryNode<ValueType> parentNode = node1.parent;
        leftChild.parent = parentNode;

        if (parentNode != null) {
            if (parentNode.value.compareTo(leftChild.value) < 0) {
                parentNode.right = leftChild;
            } else {
                parentNode.left = leftChild;
            }
        } else {
            root = leftChild;
        }
        node1.left = leftChild.right;
        if (leftChild.right != null) {
            leftChild.right.parent = node1;
        }
        leftChild.right = node1;
    }

    /**
     * TODO O( 1 )
     * Single rotation to the right, AVR Algorithm
     *
     * @param node1 Node to become child of its right child
     */
    private void rotateRight(BinaryNode<ValueType> node1) {

        BinaryNode<ValueType> rightChild = node1.right;
        rightChild.parent = node1.parent;
        node1.parent = rightChild;

        if (rightChild.parent != null) {
            if (rightChild.parent.value.compareTo(rightChild.value) < 0) {
                rightChild.parent.right = rightChild;
            } else {
                rightChild.parent.left = rightChild;
            }
        } else {
            root = rightChild;
        }
        node1.right = rightChild.left;
        if (rightChild.left != null) {
            rightChild.left.parent = node1;
        }
        rightChild.left = node1;
    }

    /**
     * TODO O( 1 )
     * Double rotation on left child, AVR Algorithm
     *
     * @param node1 Node to become child of the right child of its left child
     */
    private void doubleRotateOnLeftChild(BinaryNode<ValueType> node1) {
        rotateRight(node1.left);
        rotateLeft(node1);
    }

    /**
     * TODO O( 1 )
     * Double rotation on right child, AVR Algorithm
     *
     * @param node1 Node to become child of the left child of its right child
     */
    private void doubleRotateOnRightChild(BinaryNode<ValueType> node1) {
        rotateLeft(node1.right);
        rotateRight(node1);
    }

    /**
     * TODO O( log n ) //not sure if O(log n) or O(n)
     * Verifies if the root tree contains value
     *
     * @param value       value to verify
     * @param currentNode Node currently being accessed in this recursive method
     * @return if value already exists in the root tree
     */
    private boolean contains(ValueType value, BinaryNode<ValueType> currentNode) {
        if (currentNode == null) {
            return false;
        }

        if (value.compareTo(currentNode.value) > 0) {
            return contains(value, currentNode.right);
        } else if (value.compareTo(currentNode.value) < 0) {
            return contains(value, currentNode.left);
        } else {
            return true;
        }
    }

    /**
     * TODO O( n )
     * Returns the number of level contained in subTree including subTree node level
     *
     * @return Number of level contained in subTree including subTree node level
     */
    private int getLevelCount(BinaryNode<ValueType> subTree) {
        if (subTree == null) {
            return 0;
        } else if (subTree.right != null || subTree.left != null) {
            return (Math.max(getLevelCount(subTree.right), getLevelCount(subTree.left)) + 1);
        } else {
            return 1;
        }
    }

    /**
     * TODO O( log n )
     * Returns the node which has the minimal value contained in our root tree
     *
     * @return Node which has the minimal value contained in our root tree
     */
    private BinaryNode<ValueType> findMin(BinaryNode<ValueType> currentNode) {
        if (currentNode == null) return null;
        if (currentNode.left != null) {
            return findMin(currentNode.left);
        }
        return currentNode;
    }

    /**
     * TODO O( n )
     * Builds items which should contain all values within the root tree in ascending order
     *
     * @param currentNode Node currently being accessed in this recursive method
     * @param items       List being modified to contain all values in the root tree in ascending order
     */
    private void infixOrder(BinaryNode<ValueType> currentNode, List<ValueType> items) {

        if (currentNode.left != null && !items.contains(currentNode.left.value)) {
            infixOrder(currentNode.left, items);
        }

        if (!items.contains(currentNode.value))
            items.add(currentNode.value);

        if (currentNode.right != null && !items.contains(currentNode.right.value)) {
            infixOrder(currentNode.right, items);
        }
    }

    /**
     * TODO O( n )
     * Builds items which should contain all values within the root tree in level order from top to bottom
     *
     * @param nodesToCheck Queue for non-recursive algorithm
     * @param items        List being modified to contain all values in the root tree in level order from top to bottom
     */
    private void levelOrder(ArrayDeque<BinaryNode<ValueType>> nodesToCheck, List<ValueType> items) {
        BinaryNode<ValueType> actualNode;
        while (!nodesToCheck.isEmpty()) {
            actualNode = nodesToCheck.pollFirst();
            if (actualNode.left != null)
                nodesToCheck.addLast(actualNode.left);
            if (actualNode.right != null)
                nodesToCheck.addLast(actualNode.right);
            items.add(actualNode.value);


        }
    }

    static class BinaryNode<ValueType> {
        ValueType value;

        BinaryNode<ValueType> parent; // Pointer to the node containing this node

        BinaryNode<ValueType> left = null; // Pointer to the node on the left which should contain a value below this.value
        BinaryNode<ValueType> right = null; // Pointer to the node on the right which should contain a value above this.value

        BinaryNode(ValueType value, BinaryNode<ValueType> parent) {
            this.value = value;
            this.parent = parent;
        }
    }
}