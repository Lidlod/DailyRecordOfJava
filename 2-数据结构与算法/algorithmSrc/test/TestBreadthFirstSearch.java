package cn.ittj.algorithm.test;

import cn.ittj.algorithm.graph.BreadthFirstSearch;
import cn.ittj.algorithm.graph.Graph;

public class TestBreadthFirstSearch {
    public static void main(String[] args) {
        // 准备Graph对象
        Graph G = new Graph(13);
        G.addEdge(0,5);
        G.addEdge(0,6);
        G.addEdge(0,1);
        G.addEdge(0,2);
        G.addEdge(5,3);
        G.addEdge(3,4);
        G.addEdge(4,6);
        G.addEdge(4,5);

        G.addEdge(7,8);

        G.addEdge(9,10);
        G.addEdge(9,11);
        G.addEdge(9,12);
        G.addEdge(11,12);

        // 准备广度搜索对象
        BreadthFirstSearch search = new BreadthFirstSearch(G,0);

        // 测试与某个顶点相同的顶点数量
        System.out.println(search.count());

        // 测试某个顶点与起点是否相通
        System.out.println(search.marked(4));
    }
}
