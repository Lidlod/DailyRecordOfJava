package cn.ittj.algorithm.graph;

import cn.ittj.algorithm.linear.Queue;

public class BreadthFirstSearch {
    // 索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    // 记录有多少个顶点与s顶点相同
    private int count;
    // 用来存储待搜索邻接表的点
    private Queue<Integer> waitSearch;

    // 构造方法
    public BreadthFirstSearch(Graph G,int s){
        this.marked = new boolean[G.V()];
        this.count = 0;
        this.waitSearch = new Queue<>();

        bfs(G,s);
    }

    // 使用广度优先搜索找出G图中v顶点的所有相邻顶点
    private void bfs(Graph G,int v){
        // 标记
        marked[v] = true;
        // 入队，广度优先遍历顺序
        waitSearch.enqueue(v);
        count++;
        // 遍历队列
        while(!waitSearch.isEmpty()){
            // 出队
            Integer vertex = waitSearch.dequeue();
            // 遍历vertex子节点，非访问子节点入队
            for (Integer w : G.adj(vertex)) {
                // 判断是否访问过
                if(!marked[w]){
                    bfs(G,w);
                }

            }
        }
    }

    // 判断w顶点与s顶点是否相通
    public boolean marked(int w){
        return marked[w];
    }

    // 获取与顶点s相通的所有顶点的总数
    public int count(){
        return count;
    }
}
