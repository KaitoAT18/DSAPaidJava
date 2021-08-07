package net.braniumacademy.lesson53;

public class Exercises1 {
    public static void main(String[] args) {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        tree.add("One");
        tree.add("Two");
        tree.add("Three");
        tree.add("Four");
        tree.add("Five");
        tree.add("Six");
        tree.add("Seven");
        tree.add("Eight");
        tree.add("Nine");
        tree.add("Ten");
        // hiển thị
        System.out.println("Danh sách các phần tử trong cây theo thứ tự tăng dần: ");
        tree.inOrder();
        System.out.println("\nDanh sách các phần tử trong cây theo thứ tự giảm dần: ");
        tree.inOrderRNL();
        System.out.println("\nDanh sách các phần tử trong cây theo thứ tự LRN: ");
        tree.traversalLRN();
        System.out.println("\nDanh sách các phần tử trong cây theo thứ tự RLN: ");
        tree.traversalRLN();
        System.out.println("\nDanh sách các phần tử trong cây theo thứ tự NLR: ");
        tree.traversalNLR();
        System.out.println("\nDanh sách các phần tử trong cây theo thứ tự NRL: ");
        tree.traversalNRL();
    }
}
//                One
//              /    \
//           Four    Two
//          /        /  \
//      Five       Three
//       /          /
//    Eight       Six
//                /  \
//             Seven Ten
//               /
//             Nine