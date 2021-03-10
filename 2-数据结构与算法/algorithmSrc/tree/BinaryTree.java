package cn.ittj.algorithm.tree;


import cn.ittj.algorithm.linear.Queue;

public class BinaryTree<Key extends Comparable<Key>,Value> {
    // 记录根结点
    private Node root;
    // 记录树中元素的个数
    private int N;

    private class Node{
        public Key key;
        public Value value;
        public Node left;
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public BinaryTree() {
//        this.root = new Node(null,null,null,null);
        this.root = null;
        this.N = 0;
    }

    // 向树中插入一个键值对
    public void put(Key key,Value value){
        root = put(root,key,value);
    }

    // 在指定树x上，添加一个键值对，并返回添加后的新树；
    private Node put(Node x,Key key,Value value){
        // 树为空，直接把新结点当作根结点使用；
        if(x==null){
            N++;
            return new Node(key,value,null,null);
        }

        int cmp = key.compareTo(x.key);
        if(cmp<0){// 如果新结点key小于当前结点的key，则继续找当前结点的右子结点；
            x.left = put(x.left,key,value);
        }else if(cmp>0){// 如果新结点key大于当前节点的key，则继续找当前结点的左子结点；
            x.right = put(x.right,key,value);
        }else{// 如果新结点key等于当前结点的key，则树中已存在这样的结点，替换该节点的value值；
            x.value = value;
        }
        return x;
    }

    // 根据key，从树中找出对应的值
    public Value get(Key key){
        return get(this.root,key);
    }

    // 从指定的树x中，找出key对应的值
    private Value get(Node x,Key key){// 为什么是私有方法？
        if(x == null){
            return null;
        }

        int cmp = key.compareTo(x.key);
        if(cmp<0){
            return get(x.left,key);
        }else if(cmp>0){
            return get(x.right,key);
        }
        return x.value;
    }

    // 根据key，删除树中对应的键值对
    public void delete(Key key){
        root = delete(root,key);
    }

    // 删除指定树x上的键为key的键值对，并返回删除后的新树
    private Node delete(Node x,Key key){
        // 安全性检验
        if(x == null){
            return null;
        }

        // 找到被删除结点det；递归的好处：不需要记录父节点；
        int cmp = key.compareTo(x.key);
        if(cmp<0){
            x.left=delete(x.left,key);
        }else if(cmp>0){
            x.right=delete(x.right,key);
        }else{
            // 找到要被删除结点x
            // N--;
            this.N--;
            // 右子树为空，pre1指向左子节点；左子树为空，指向右子结点；
            if(x.left==null){
                return x.right;
            }
            if(x.right==null){
                return x.left;
            }
            Node n = x.right;
            while(n.left!=null){
                n = n.left;
            }
            //找到最小结点min
            Node min = n;
            // 删除父亲指针
            if(x.right == min){
                x.right = min.right;
                min.left = x.left;
            }else {
                n = x.right;
                while (n.left!=min){//找到父节点
                    n = n.left;
                }
                n.left = min.right;
                min.left = x.left;
                min.right = x.right;
            }
            // pre1指向min；or root指向min；
            // min.left = det.left; min.right = det.right;
            x = min;
        }
        return x;

        // 找到被删除结点；
        // 找到被删除结点右子树中最小系结点minNode
        // 删除右子树中的最小结点，记录minNode的value
        // 让未删除结点的左子树为最小结点minNode的左子树，让被删除结点的右子树成为最小结点minNode的右子树
        // 被删除结点的父节点指向最小结点minNode

    }

    // 获取树中元素的个数；
    public int size(){
        return this.N;
    }

    // 查找二叉树中最小的键
    public Key min(){
        if(root == null){
            return null;
        }
        Node x = min(root);
        return x.key;
    }

    // 在指定树x中，最小键所在结点
    private Node min(Node x){
        // 安全性检验
        if(x == null){
            return null;
        }

        // 不断搜索左子树
        while(x.left!=null){
            x = x.left;
        }
        return x;
    }

    // 查找二叉树中最大的键
    public Key max(){
        if(root==null){
            return null;
        }
        Node x = max(root);
        return x.key;
    }

    // 在指定树x中，最大键所在结点
    private Node max(Node x){
        // 安全性检验
        if(x==null){
            return null;
        }

        // 不断找右子树
        while(x.right!=null){
            x = x.right;
        }
        return x;
    }

    // 前序遍历
    public Queue<Key> preErgodic(){
        Queue<Key> keys = new Queue<>();
        preErgodic(root,keys);
        return keys;
    }

    private void preErgodic(Node x,Queue<Key> keys){
        if(x==null){
            return;
        }
        keys.enqueue(x.key);
        if(x.left!=null){
            preErgodic(x.left,keys);
        }
        if(x.right!=null){
            preErgodic(x.right,keys);
        }
    }

    // 中序遍历
    public Queue<Key> midErgodic(){
        Queue<Key> keys = new Queue<>();
        midErgodic(root,keys);
        return keys;
    }

    private void midErgodic(Node x,Queue<Key> keys){
        if(x==null){
            return;
        }
        if(x.left!=null){// 可以少递归一次，减少压栈；
            midErgodic(x.left,keys);
        }
        keys.enqueue(x.key);
        if(x.right!=null){
            midErgodic(x.right,keys);
        }
    }

    // 后序遍历
    public Queue<Key> afterErgodic(){
        Queue<Key> keys = new Queue<>();
        afterErgodic(root,keys);
        return keys;
    }

    private void afterErgodic(Node x,Queue<Key> keys){
        if(x==null){
            return;
        }
        if(x.left!=null){
            afterErgodic(x.left,keys);
        }
        if(x.right!=null){
            afterErgodic(x.right,keys);
        }
        keys.enqueue(x.key);
    }

    // 层序遍历
    public Queue<Key> layerErgodic(){
        // 安全检验
        if(root == null){
            return null;
        }
        // 用一个队列存放结点;一个队列存放层序遍历后结果；
        Queue<Node> nodes = new Queue<>();
        Queue<Key> keys = new Queue<>();

        // 存入root
        nodes.enqueue(root);
        Node temp = null;
        // 循环，队列非空
        // 出队,子节点入队；放入keys队列中;
        while(!nodes.isEmpty()){

            temp=nodes.dequeue();
            if(temp.left!=null){
                nodes.enqueue(temp.left);
            }
            if(temp.right!=null){
                nodes.enqueue(temp.right);
            }
            keys.enqueue(temp.key);
        }
        return keys;
    }

    // 计算整个树的最大深度
    public int maxDepth(){
        return maxDepth(root);
    }

    // 计算树x的最大深度；递归
    private int maxDepth(Node x){
        // 安全性检验
        if(x == null){
            return 0;
        }

        int maxDepth = 0;
        int depthLeft = 0;
        int depthRight = 0;
        // 计算左子树最大深度
        if(x.left!=null){
            depthLeft = maxDepth(x.left);
        }
        // 计算右子树最大深度
        if(x.right!=null){
            depthRight = maxDepth(x.right);
        }

        // 当前最大深度=左子树和右子树深度较大者+1
        maxDepth = Math.max(depthLeft,depthRight)+1;
        return maxDepth;
    }
}
