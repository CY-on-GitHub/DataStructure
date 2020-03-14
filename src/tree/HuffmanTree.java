package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
/**
 * Created by asus on 2020/3/1.
 */
public class HuffmanTree {
    public static void main(String[] args) {
        System.out.println();
        int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
        TreeNode root = createHuffmanTree(arr);
        //测试一把
        preOrder(root); //
    }

    public static void preOrder(TreeNode root) {
        if(root != null) {
            root.preOrder();
        }else{
            System.out.println("是空树，不能遍历~~");
        }
    }
    public static TreeNode createHuffmanTree(int[] arr) {
        //将node放进list里面是为了方便排序
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        for (int value : arr) {
            nodes.add(new TreeNode(value));
        }
        while(nodes.size() > 1) {
            //每次处理后，树都会重新排序从小到大
            Collections.sort(nodes);
            System.out.println("nodes =" + nodes);
            //取出根节点权值最小的两颗二叉树
            //(1) 取出权值最小的结点（二叉树）
            TreeNode leftNode = nodes.get(0);
            //(2) 取出权值第二小的结点（二叉树）
            TreeNode rightNode = nodes.get(1);
            //(3)构建一颗新的二叉树
            TreeNode parent = new TreeNode(leftNode.getIndex() + rightNode.getIndex());
            parent.setLeft(leftNode);
            parent.setRight(rightNode);

            //(4)从ArrayList 删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //(5)将parent 加入到nodes
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}
