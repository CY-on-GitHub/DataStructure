package tree;

import java.io.PrintWriter;

/**
 * Created by asus on 2020/2/24.
 * 定义树节点
 */
public class TreeNode implements Comparable<TreeNode>{

    private int index;
    private String name;
    private TreeNode left;
    private TreeNode right;

    //1. 如果leftType == 0 表示指向的是左子树, 如果1 则表示指向前驱结点
    //2. 如果rightType == 0 表示指向是右子树, 如果1 表示指向后继结点
    private int leftType;
    private int rightType;


    public TreeNode(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public TreeNode(int index) {

        this.index = index;
    }

    @Override
    public int compareTo(TreeNode node)
    {
        return this.index-node.index;
    }

    @Override
    public String toString() {
        return "TreeNode [no=" + index + ", name=" + name + "]";
    }

    public int getLeftType() {
        return leftType;
    }
    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }
    public int getRightType() {
        return rightType;
    }
    public void setRightType(int rightType) {
        this.rightType = rightType;
    }


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    //前序遍历
    public void preOrder()
    {
        //先输出根节点
        System.out.println(this);
        if(this.left!=null)
        {
            this.left.preOrder();
        }
        if(this.right!=null)
        {
            this.right.preOrder();
        }

    }
    //中序遍历
    public void infixOrder()
    {
        //先左子树递归
        if(this.left!=null)
        {
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!=null)
        {
            this.right.infixOrder();
        }
    }
    //后序遍历
    public void postOrder()
    {
        //先左子树递归
        if(this.left!=null)
        {
            this.left.postOrder();
        }
        if(this.right!=null)
        {
            this.right.postOrder();
        }
        //最后输出当前节点
        System.out.println(this);
    }

    //前序查找.中序查找和后序查找差不多
    public TreeNode preSearch(int index)
    {
        System.out.println("前序搜索");
        if(this.index==index)
        {
            return this;
        }
        TreeNode treeNode=null;
        //左子树遍历
        if(this.left!=null)
        {
            treeNode=this.left.preSearch(index);
        }
        if(treeNode!=null)
        {
            return treeNode;
        }
        if(this.right!=null)
        {
            treeNode=this.right.preSearch(index);
        }
        return treeNode;
    }

    //删除节点的操作.基础版
    public void delNode(int index )
    {

        //删除操作只能通过他的前一个进行，本身删不了自己
        if(this.left!=null&&this.left.index==index)
        {
            this.left=null;
            return;//结束
        }
        if(this.right!=null&&this.right.index==index)
        {
            this.right=null;
            return;
        }
        //前面的没有删除成功，则继续递归
        if(this.left!=null)
        {
            this.left.delNode(index);
        }
        if(this.right!=null)
        {
            this.right.delNode(index);
        }
    }
    //删除节点的完整版
    public void delNode2(int index)
    {

    }
}
