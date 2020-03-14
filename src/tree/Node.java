package tree;

/**
 * Created by asus on 2020/3/4.
 */
public class Node implements Comparable<Node>{
    Byte data;//存放数据字符本身
    int weight;
    Node left;
    Node  right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }
    @Override
    public int compareTo(Node o)
    {
        return this.weight-o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    public void preOrder()
    {
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
}
