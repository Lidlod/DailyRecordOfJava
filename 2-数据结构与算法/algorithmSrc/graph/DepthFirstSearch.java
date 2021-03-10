package cn.ittj.algorithm.graph;

import cn.ittj.algorithm.linear.Queue;

public class DepthFirstSearch {
    // 索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    // 记录有多少个顶点与s顶点相同
    private int count;

    // 构造方法
    public DepthFirstSearch(Graph G, int s) {
        this.marked = new boolean[G.V()];
        this.count = 0;

        // 深度优先搜索
        dfs(G,s);
    }

    // 使用深度优先搜索找出G图中v顶点的所有相通顶点
    private void dfs(Graph G,int v){
        // 当前节点已访问，深度优先遍历顺序
        marked[v] = true;
        this.count++;
        for(Integer w :G.adj(v)){
            // 找v的子节点w，判断是否访问过
            // 未访问过，对vs继续dfs
            if(!marked[w]){
                dfs(G,w);
            }
        }
    }

    // 判断w顶点与s顶点是否相通
    public boolean marked(int w){
        return marked[w];
    }

    // 获取与顶点s相通的所有顶点的总数
    public int count(){
        return this.count;
    }
}
