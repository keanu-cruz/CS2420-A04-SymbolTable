package a04;

import java.util.List;

/**
 * The {@code UniqueTreeDemo} class serves as a driver program to test and validate 
 * the functionality of the {@link UniqueTree} class. It provides a sample tree structure 
 * using a list of integer arrays, where each array represents a node and its left and 
 * right child indices. This class ensures that the implemented methods in 
 * {@link UniqueTree} work for arbitrary tree structures.
 *
 * <p>The provided tree structure uses the following format for each node:
 * <ul>
 *   <li>Element at index 0: The value of the node</li>
 *   <li>Element at index 1: The index of the left child in the list (or {@code null} if no left child)</li>
 *   <li>Element at index 2: The index of the right child in the list (or {@code null} if no right child)</li>
 * </ul>
 * 
 * @author CS Starter Code + Caliana Caldwell + Keanu Cruz
 */
class UniqueTreeDemo {
	

    public static void main(String[] args) {
        // This is starter code to help you test your method implementations.
   	    // Ensure your code works for any tree structure, not just the provided example.
    	
        List<Integer[]> treeData = List.of(
            new Integer[]{52, 1, 2}, // root: 52; left child: 23 (index 1) right child: 87 (index 2)
            new Integer[]{23, 3, 4}, 
            new Integer[]{87, 5, 6},
            new Integer[]{34, 7, 8},
            new Integer[]{45, 9, 10},
            new Integer[]{67, 11, null},
            new Integer[]{78, 12, 13},
            new Integer[]{12, null, null},
            new Integer[]{19, null, null},
            new Integer[]{33, 14, 15},
            new Integer[]{49, null, null},
            new Integer[]{56, null, null},
            new Integer[]{69, 16, null},
            new Integer[]{85, null, null},
            new Integer[]{62, null, null},
            new Integer[]{13, null, null},
            new Integer[]{24, null, null}
        );

        // === Base Function Testing ===
        UniqueTree tree = new UniqueTree(treeData);
        System.out.println("=== Base Function Testing ===");
        tree.doubleEvenNumbers();
        System.out.println("Count of leaf parents: " + tree.countLeafParents());
        System.out.println("Average of all odd numbers: " + tree.averageOfOddNumbers());
        System.out.println("Sum of all right children (excluding root): " + tree.sumOfRightChildren());
        System.out.println("Greatest difference between two numbers in the tree: " + tree.greatestDifference());
        System.out.println();
        
        // === Small Tree / Leaf Test ===
        List<Integer[]> treeData2 = List.of(
        		new Integer[]{7, 1, 2},
                new Integer[]{25, null, null});
        UniqueTree tree2 = new UniqueTree(treeData2);
        System.out.println("=== Small Tree / Leaf Test ===");
        System.out.println("Count of leaf parents: " + tree2.countLeafParents());
        System.out.println("Expected: 1");
        System.out.println("Greatest difference between two numbers in the tree: " + tree2.greatestDifference());
        System.out.println("Expected: 18");
        System.out.println();
        
        // === Left-Leaning Tree Tests===
        List<Integer[]> treeData3 = List.of(
                new Integer[]{52, 1, null},
                new Integer[]{23, 2, null}, 
                new Integer[]{87, 3, null},
                new Integer[]{34, 4, null},
                new Integer[]{45, 5, null},
                new Integer[]{67, 6, null},
                new Integer[]{78, 7, null});
        
        UniqueTree tree3 = new UniqueTree(treeData3);
        
        System.out.println("=== Left-Leaning Tree Test ===");
        System.out.println("Count of leaf parents: " + tree3.countLeafParents());
        System.out.println("Expected: 1");
        System.out.println("Average of all odd numbers: " + tree3.averageOfOddNumbers());
        System.out.println("Expected: 55.5");
        System.out.println("Sum of all right children (excluding root): " + tree3.sumOfRightChildren());
        System.out.println("Expected: 0");
        System.out.println("Greatest difference between two numbers in the tree: " + tree3.greatestDifference());
        System.out.println("Expected: 64");
        System.out.println();
        
     // === Right-Leaning Tree Tests===
        List<Integer[]> treeData4 = List.of(
                new Integer[]{52, null, 1},
                new Integer[]{23, null, 2}, 
                new Integer[]{87, null, 3},
                new Integer[]{34, null, 4},
                new Integer[]{45, null, 5},
                new Integer[]{67, null, 6},
                new Integer[]{78, null, 7});
        
        UniqueTree tree4 = new UniqueTree(treeData4);
        
        System.out.println("=== Right-Leaning Tree Test ===");
        System.out.println("Count of leaf parents: " + tree4.countLeafParents());
        System.out.println("Expected: 1");
        System.out.println("Average of all odd numbers: " + tree4.averageOfOddNumbers());
        System.out.println("Expected: 55.5");
        System.out.println("Sum of all right children (excluding root): " + tree4.sumOfRightChildren());
        System.out.println("Expected: 334");
        System.out.println("Greatest difference between two numbers in the tree: " + tree4.greatestDifference());
        System.out.println("Expected: 64");
        System.out.println();
        
        // === Single Node Tree Tests===
//        List<Integer[]> treeData5 = List.of(
//                new Integer[]{52, null, null});
//        
//        UniqueTree tree5 = new UniqueTree(treeData5);
//        
//        *Tried Creating Single Node but Constructor accepts List[] not a List of a single item.*
        
        // === All Odd / One Negative Tree Test ===
        List<Integer[]> treeData5 = List.of(
        		new Integer[]{53, 1, 2},
                new Integer[]{23, 3, 4}, 
                new Integer[]{87, 5, 6},
                new Integer[]{35, 7, 8},
                new Integer[]{-45, 9, 10},
                new Integer[]{67, 11, null},
                new Integer[]{79, 12, 13});
        
        UniqueTree tree5 = new UniqueTree(treeData5);
        
        System.out.println("=== All Odd / One Negative Tree Test ===");
        System.out.println("Count of leaf parents: " + tree5.countLeafParents());
        System.out.println("Expected: 2");
        System.out.printf("Average of all odd numbers: %.1f%n", tree5.averageOfOddNumbers());
        System.out.println("Expected: 42.7");
        System.out.println("Sum of all right children (excluding root): " + tree5.sumOfRightChildren());
        System.out.println("Expected: 121");
        System.out.println("Greatest difference between two numbers in the tree: " + tree5.greatestDifference());
        System.out.println("Expected: 132");
        System.out.println();
        
        // === All Even Tree Test ===
        List<Integer[]> treeData6 = List.of(
        		new Integer[]{52, 1, 2},
                new Integer[]{24, 3, 4}, 
                new Integer[]{86, 5, 6},
                new Integer[]{34, 7, 8},
                new Integer[]{44, 9, 10},
                new Integer[]{68, 11, null},
                new Integer[]{76, 12, 13});
        
        UniqueTree tree6 = new UniqueTree(treeData6);
        
        System.out.println("=== All Even Tree Test ===");
        tree6.doubleEvenNumbers(); // All Values Doubled: Passed
        System.out.println("Count of leaf parents: " + tree6.countLeafParents());
        System.out.println("Expected: 2");
        System.out.println("Average of all odd numbers: " + tree6.averageOfOddNumbers());
        System.out.println("Expected: 0.0");
        System.out.println("Sum of all right children (excluding root): " + tree6.sumOfRightChildren());
        System.out.println("Expected: 412");
        System.out.println("Greatest difference between two numbers in the tree: " + tree6.greatestDifference());
        System.out.println("Expected: 124");
        System.out.println();
        		
    }
}