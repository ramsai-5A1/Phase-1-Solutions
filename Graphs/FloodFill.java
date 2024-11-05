public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int target = image[sr][sc];image[sr][sc] = newColor;
    if(target == newColor){
        return image;
    }

    final int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    Queue<int[]> queue = new LinkedList<>();
//        Queue<int[]> visited = new LinkedList<>();
    queue.add(new int[]{sr,sc});

    while(!queue.isEmpty()){
        int[] cur = queue.poll();
//            visited.add(cur);
        for(int[] dir : directions){
            int row = cur[0] + dir[1];
            int col = cur[1] + dir[0];
//                if(isVaild(row,col,image,target) && !visited.contains(new int[]{row,col})){
            if(isVaild(row,col,image,target)){// target must != newColor,so if isVaild(row,col,image,target) is false, means this point is visited.
                image[row][col] = newColor;
                queue.add(new int[]{row,col});
            }
        }
    }
    return image;
}

private boolean isVaild(int row,int col,int[][] image,int target){
    if(row >= image.length || row < 0 || col >= image[0].length || col < 0 || image[row][col] != target){
        return false;
    }
    return true;
}