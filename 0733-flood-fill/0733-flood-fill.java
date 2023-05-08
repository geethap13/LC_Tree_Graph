class Solution {
    int[][] del = {{-1,0},{0,1},{1,0},{0,-1}};
    public void dfs(int[][] image, int sr, int sc, int color,int orgcolor,int m,int n) {
        image[sr][sc] = color;
        
        for(int[] i:del){
            int r = sr +i[0];
            int cl = sc +i[1];
            if(r<0||r>=m ||cl<0||cl>=n ) continue;
            else if(image[r][cl] == orgcolor && image[r][cl] != color) {
                dfs(image,r,cl,color,orgcolor,m,n);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        if(sr<0||sr>=m ||sc<0||sc>=n) return image;
        int orgcol = image[sr][sc];
        dfs(image,sr,sc,color,orgcol,m,n);
        return image;
    }
}