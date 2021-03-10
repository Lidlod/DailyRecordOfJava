package cn.ittj.algorithm.dp;

import java.util.Arrays;

public class backpack {
    // 输入：背包最大重量total；重量数组，物品i重量w[i] 和物品i价值数组v[i]；
    // 输出：最大价值
    public int backpack01(int total,int[] w,int[] v){
        // 定义dp数组，i为物品i；j为当前背包容量j；
        int[][] dp = new int[w.length][total+1];
        // -递推公式：j<w[i],dp[i][j]=dp[i-1][j];   j>w[i],d[i][j]=max(dp[i-1][j],v[i]+dp[i-1][j-w[i]])
        // dp初始化：第一列全为0，第一行初始化
        for(int i=0;i<w.length;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<total+1;j++){
            if(j>=w[0]){
                dp[0][j]=v[0];
            }
        }
        // 遍历：横向，纵向遍历均可，使用递推公式更新
        for(int i=1;i<w.length;i++){
            for(int j=1;j<total+1;j++){
                if(j<w[i]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],v[i]+dp[i-1][j-w[i]]);
                }
            }
        }
        // -校验
        for(int j=0;j<w.length;j++){
            System.out.println(Arrays.toString(dp[j]));
        }

        return dp[w.length-1][total];
    }

    // 使用滚动数组实现
    public int backpack01Scrolling(int total,int[] w,int[] v){
        // 定义数组
        int[] dp = new int[total+1];
        // 初始化
        for(int j=1;j<total+1;j++){
            dp[j] = v[0];
        }
        System.out.println(Arrays.toString(dp));
        // 遍历
        for (int i=1;i<w.length;i++){
            // 倒序遍历
            for(int j=total;j>=w[i];j--){
                dp[j] = Math.max(dp[j],v[i]+dp[j-w[i]]);
            }
            // 校验
            System.out.println(Arrays.toString(dp));
        }
        return dp[total];
    }

    // 使用滚动数组实现
    public int comBackpack(int total,int[] w,int[] v){
        // 定义数组
        int[] dp = new int[total+1];
//        // 初始化
//        for(int j=1;j<total+1;j++){
//            dp[j] = v[0];
//        }
//        System.out.println(Arrays.toString(dp));
        // 遍历
        for (int i=0;i<w.length;i++){
            // 倒序遍历
            for(int j=w[i];j<=total;j++){
                dp[j] = Math.max(dp[j],v[i]+dp[j-w[i]]);
            }
            // 校验
            System.out.println(Arrays.toString(dp));
        }
        return dp[total];
    }
}
