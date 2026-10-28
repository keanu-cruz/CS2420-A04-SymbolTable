package a04;

import java.util.Set;
import java.util.HashSet;
import java.util.List;

/**
 * Represents a binary tree with unique integer values. Provides various methods to
 * manipulate and analyze the tree structure, including doubling even numbers, counting
 * specific types of nodes, and calculating differences between values.
 * 
 * The tree data is represented as a list of integer arrays, where each array contains
 * the value of a node and the indices of its left and right children. For example:
 *
 * [node_value, left_child_index, right_child_index]
 *
 * The root node is at index 0. A left or right child index of null indicates that
 * the node does not have a corresponding child.
 * 
 * @author CS Starter Code + Caliana Caldwell + Keanu Cruz
 */
public class UniqueTree {

    private Node root;
    private Set<Integer> elements = new HashSet<>();  // To ensure uniqueness

    // Inner class representing a node in the tree
    private class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * Constructs a UniqueTree from a list of integer arrays.
     * Each array contains: [node_value, left_child_index, right_child_index]
     *
     * @param treeData the list representing the tree structure
     * @throws IllegalArgumentException if the tree contains duplicate values
     */
    public UniqueTree(List<Integer[]> treeData) {
        if (treeData == null || treeData.isEmpty()) {
            throw new IllegalArgumentException("Tree data cannot be null or empty.");
        }
        this.root = buildTree(treeData, 0);  // Start building from the root (index 0)
    }

    // Helper method to recursively build the tree from the list
    private Node buildTree(List<Integer[]> data, int index) {
        if (index == -1 || index >= data.size() || data.get(index) == null) {
            return null;
        }

        Integer[] nodeData = data.get(index);
        int value = nodeData[0];

        // Check for uniqueness
        if (!elements.add(value)) {
            throw new IllegalArgumentException("Duplicate value found: " + value);
        }

        Node node = new Node(value);

        // Build the left and right subtrees using the provided indices
        node.left = buildTree(data, nodeData[1] != null ? nodeData[1] : -1);
        node.right = buildTree(data, nodeData[2] != null ? nodeData[2] : -1);

        return node;
    }

    /**
     * Doubles the value of all even numbers in the tree.
     */
    public void doubleEvenNumbers() {
        doubleEvenNumbers(root);
    }
    
    private void doubleEvenNumbers(Node node) {
    	if (node == null) {
    		return;
    	}
    	
    	doubleEvenNumbers(node.left);
    	doubleEvenNumbers(node.right);
    	
    	if (node.val % 2 == 0) {
    		node.val *= 2;
    	}
    }

    /**
     * Calculates the sum of all right children.
     * Reminder: The root is not a right child because it has no parent.
     * 
     * @return the sum of all right children
     */
    public int sumOfRightChildren() {
    	return sumOfRightChildren(root);
    }
    
    private int sumOfRightChildren(Node node) {
    	if (node == null) {
    		return 0;
    	}
    	
    	int sum = 0;
    	
    	sum += sumOfRightChildren(node.left);
    	sum += sumOfRightChildren(node.right);
    	
    	if (node.right != null) {
    		sum += node.right.val;
    	}
    	
    	return sum;
    }

    /**
     * Counts how many nodes have at least one child that is a leave.
     * 
     * @return the count of nodes with all children as leaves
     */
    public int countLeafParents() {
    	return countLeafParents(root);
    }
    
    private int countLeafParents(Node node) {
    	if (node == null) {
    		return 0;
    	}
    	
    	int count = 0;
    	
    	count += countLeafParents(node.left);
    	count += countLeafParents(node.right);
    	
    	if ((node.left != null && node.left.left == null && node.left.right == null) || 
    			(node.right != null && node.right.left == null && node.right.right == null)) {
    		count++;
    	}
    	
    	return count;
    }

    /**
     * Calculates the average of all odd numbers in the tree.
     * 
     * @return the average of all odd numbers, or 0 if there are no odd numbers
     */
    public double averageOfOddNumbers() {
        int[] result = averageOfOddNumbers(root);
        if (result[1] == 0) {
        	return 0.0;
        }
        return (double) result[0] / (double) result[1];
    }
    
    private int[] averageOfOddNumbers(Node node) {
    	if (node == null) {
    		return new int[] {0,0};
    	}
    	
    	int[] left = averageOfOddNumbers(node.left);
    	int[] right = averageOfOddNumbers(node.right);
    	
    	int sum = left[0] + right[0];
    	int count = left[1] + right[1];	
    	
    	if (node.val % 2 != 0) {
    		sum += node.val;
    		count++;
    	}
    	
    	return new int[] {sum, count};
    }
    

    /**
     * Finds the difference between the largest and smallest elements in the tree.
     * 
     * @return the difference between the largest and smallest values
     */
    public int greatestDifference() {
    	if (root == null) {
    		return 0;
    	}
    	int[] result = greatestDifference(root);
        return result[0] - result[1];
    }
    
    private int[] greatestDifference(Node node) {
    	if (node == null) {
    		return new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE};
    	}
    	
    	int[] left = greatestDifference(node.left);
    	int[] right = greatestDifference(node.right);
    	
    	int max = Math.max(node.val, Math.max(left[0], right[0]));
    	int min = Math.min(node.val, Math.min(left[1], right[1]));
    	
    	return new int[] {max, min};
    }
}

/**
 * A. Yes, we worked in tandem over video call working each method and test together.
 * B. About 5 hours total work time over video call.
 * C. Yes, we worked together figuring out the structure to each method.
 * D. We tried switching roles, but do to technical issues we used one computer. Both contributed to overall code.
 * E. Both partners agree that everything was positive and respectful.
 * F. Figuring out the base-case for greatestDifference.
 * G. Pebble Distribution: 50/50.
 */

