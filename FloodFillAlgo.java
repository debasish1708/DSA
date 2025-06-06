
class FloodFillAlgo{
    private static void floodFillUtil(int[][] image, int sr, int sc, int color, int orgCol) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length
                || image[sr][sc] != orgCol || image[sr][sc] == color) {
            return;
        }

        image[sr][sc] = color;

        // left
        floodFillUtil(image, sr, sc - 1, color, orgCol);
        // right
        floodFillUtil(image, sr, sc + 1, color, orgCol);
        // up
        floodFillUtil(image, sr - 1, sc, color, orgCol);
        // down
        floodFillUtil(image, sr + 1, sc, color, orgCol);
    }
    private static int[][] floodFill(int[][] image,int sr,int sc,int color){
        floodFillUtil(image, sr, sc, color,image[sr][sc]);
        return image;
    }
    public static void main(String[] args) {
        int[][] image={{1,1,1},
                       {1,1,0},
                       {1,0,1}};
        floodFill(image,1,1,2);
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                System.out.print(image[i][j]+" ");
            }
            System.out.println();
        }
    }
}