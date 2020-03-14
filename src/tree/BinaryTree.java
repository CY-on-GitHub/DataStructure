package tree;

/**
 * Created by asus on 2020/2/24.
 * 没有写构造方法，默认无参数
 */
public class BinaryTree {
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    //从根节点开始前序遍历
    public void preOrder()
    {
        if(root!=null)
        {
            root.preOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //从根节点开始中序遍历
    public void infixOrder()
    {
        if(root!=null)
        {
            root.infixOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //从根节点开始前序遍历
    public void postOrder()
    {
        if(root!=null)
        {
            root.postOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //前序查找.中序和后序的差不多，就不写了
    public TreeNode preSearch(int index)
    {
        if(root!=null)
        {
            return root.preSearch(index);
        }
        else {
            System.out.println("二叉树为空，查找失败");
            return null;
        }
    }

    //删除节点。初级不完善版本
    public void delNode(int index)
    {
        if(root!=null)
        {
            if(root.getIndex()==index)
            {
                root=null;
            }else {
                root.delNode(index);
            }
        }else {
            System.out.println("二叉树为空，无法进行删除操作。");
        }
    }
}
