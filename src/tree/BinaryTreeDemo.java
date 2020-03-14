package tree;

/**
 * Created by asus on 2020/2/24.
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        System.out.println();

        //测试一把中序线索二叉树的功能
        TreeNode root = new TreeNode(1, "tom");
        TreeNode node2 = new TreeNode(3, "jack");
        TreeNode node3 = new TreeNode(6, "smith");
        TreeNode node4 = new TreeNode(8, "mary");
        TreeNode node5 = new TreeNode(10, "king");
        TreeNode node6 = new TreeNode(14, "dim");

        //二叉树，后面我们要递归创建, 现在简单处理使用手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        //测试中序线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();

        //测试: 以10 号节点测试
        TreeNode leftNode = node5.getLeft();
        TreeNode rightNode = node5.getRight();
        System.out.println("10 号结点的前驱结点是=" + leftNode); //3
        System.out.println("10 号结点的后继结点是=" + rightNode); //1
        //如果对10的getRight=1有疑问，建议debug一下

        System.out.println("使用线索化的方式遍历线索化二叉树");
        threadedBinaryTree.threadedList(); // 8, 3, 10, 1, 14, 6

    }

}
