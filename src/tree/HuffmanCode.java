package tree;

import java.util.*;

/**
 * Created by asus on 2020/3/3.
 * 借助霍夫曼二叉树演示霍夫曼编码
 */
public class HuffmanCode {

    static Map<Byte,String> huffmanCodes=new HashMap<Byte, String>() ;
    static StringBuilder stringBuilder=new StringBuilder();

    public static void main(String[] args) {
        System.out.println();

        String  string="i like linhui, she is the best girl i met";
        String str="i like like like java do you like a java";
        byte[] contentBytes=string.getBytes();

        //获取字符串的byte对象集合
        List<Node> nodes=getNodes(contentBytes);
        //由其创建霍夫曼树.返回最后的根节点
        Node node=createHuffmanTree(nodes);
        //输出测试一次
        node.preOrder();

        //产生霍夫曼编码
        getCodes(node,"",stringBuilder);
        //输出编码
        System.out.println("HuffmanCode = "+huffmanCodes);

        //测试数据压缩
        byte[] huffmanCodeBytes=zip(contentBytes,huffmanCodes);
        System.out.println("huffmanCodeBytes= "+Arrays.toString(huffmanCodeBytes));//实测压缩率4%


    }

    private static List<Node> getNodes(byte[] bytes)
    {

        ArrayList<Node> nodes=new ArrayList<Node>();

        //把每一个字节，按其值和出现的次数封装成map对象
        Map<Byte,Integer> counts=new HashMap<>();
        for(byte b:bytes)
        {
            Integer count=counts.get(b);
            if(count==null)
            {
                counts.put(b,1);
            }else {
                counts.put(b,count+1);
            }
        }

        //再次借助map，一个个new出node对象
        for(Map.Entry<Byte,Integer> entry:counts.entrySet())
        {
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }



    //可以通过List 创建对应的赫夫曼树
    private static Node createHuffmanTree(List<Node> nodes) {
            while (nodes.size() > 1) {
                //排序, 从小到大
                Collections.sort(nodes);
                //取出第一颗最小的二叉树
                Node leftNode = nodes.get(0);
                //取出第二颗最小的二叉树
                Node rightNode = nodes.get(1);
                //创建一颗新的二叉树,它的根节点没有data, 只有权值
                Node parent = new Node(null, leftNode.weight + rightNode.weight);
                parent.left = leftNode;
                parent.right = rightNode;
                //将已经处理的两颗二叉树从nodes 删除
                nodes.remove(leftNode);
                nodes.remove(rightNode);
                //将新的二叉树，加入到nodes
                nodes.add(parent);
            }
                //nodes 最后的结点，就是赫夫曼树的根结点
            return nodes.get(0);
        }


    /**
     * 功能：将传入的node 结点的所有叶子结点的赫夫曼编码得到，并放入到huffmanCodes 集合
     * @param node 传入结点
     * @param code 路径： 左子结点是0, 右子结点1
     * @param stringBuilder 用于拼接路径
     */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        //将code 加入到stringBuilder2
        stringBuilder2.append(code);
        if(node != null) { //如果node == null 不处理
            //判断当前node 是叶子结点还是非叶子结点
            if(node.data == null) { //非叶子结点
            //递归处理.左0右1即霍夫曼的编码方式
            //向左递归
                getCodes(node.left, "0", stringBuilder2);
            //向右递归
                getCodes(node.right, "1", stringBuilder2);
            } else { //说明是一个叶子结点
            //就表示找到某个叶子结点的最后
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }

    //为了调用方便，我们重载getCodes
    private static Map<Byte, String> getCodes(Node root) {
        if (root == null) {
            return null;
        }
        //处理root 的左子树
        getCodes(root.left, "0", stringBuilder);
        //处理root 的右子树
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }


    private static void preOrder(Node root)
    {
        if(root!=null)
        {
            root.preOrder();
        }else {

        }
    }

    /*
    *@auther CY
    *@date 2020/3/4 16:44
    *@parm [bytes, huffmanCodes]
    *@return byte[]
    */
    private static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes)
    {
       StringBuilder stringBuilder=new StringBuilder();
        //stringBuilder 是将编码转成字符串。
        for(byte b:bytes)
        {
            //b是map存储的键值。get(b)返回的是对应的value
            stringBuilder.append(huffmanCodes.get(b));
        }
        //接下来转成编码值
        int len=(stringBuilder.length()%8==0) ? stringBuilder.length()/8 : stringBuilder.length()/8+1;

        byte[] huffmanCodeBytes=new byte[len];
        int index=0;
        //下面每次去八个字符，转成byte类型
        for(int i=0;i<stringBuilder.length();i+=8)
        {
            String str;
            if(i+8>stringBuilder.length()) {
                //如果最后剩的长度不够八位byte
                str = stringBuilder.substring(i);//第二个参数默认到字符串末尾
            }else {
                str=stringBuilder.substring(i,i+8);
            }

            //在将其转为byte类型
            huffmanCodeBytes[index++]=(byte)Integer.parseInt(str,2);//参数2表示转换成二进制

        }
               return  huffmanCodeBytes;
    }
}
