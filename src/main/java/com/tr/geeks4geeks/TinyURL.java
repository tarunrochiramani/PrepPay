package com.tr.geeks4geeks;

public class TinyURL {

    public String idToShortURL(Integer n)
    {
        // Map to store 62 possible characters
        char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

        StringBuilder shorturl = new StringBuilder();

        // Convert given integer id to a base 62 number
        while (n > 0)
        {
            shorturl.append(map[n%62]);
            n = n/62;
        }

        return shorturl.toString();
    }

    public int numDistinct(String S, String T) {
        int m = S.length();
        int n = T.length();
        int dp[][] = new int[m+1][n+1];

        for(int i=0; i<=m;i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(S.charAt(i-1) == T.charAt(j-1)){
                    dp[i][j] += dp[i-1][j]+dp[i-1][j-1];
                }else{
                    dp[i][j] +=dp[i-1][j];
                }
            }
        }

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
               System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }


        return dp[m][n];
    }
}
