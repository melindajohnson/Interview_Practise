import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {


    static class  adjacencyList{
        int vertex;
        int[] friends;

        adjacencyList(int i, int[] array){
            vertex = i;
            friends= array;
        }
    }

    public static void main(String[] args) {
	// friend circle adjacency list
        int n = 7;
        List<adjacencyList> list = new ArrayList<>();
        list.add(new adjacencyList(0,new int[]{1,2}));
        list.add(new adjacencyList(1,new int[]{0}));
        list.add(new adjacencyList(2,new int[]{0}));
        list.add(new adjacencyList(3,new int[]{4,5}));
        list.add(new adjacencyList(4,new int[]{3}));
        list.add(new adjacencyList(5,new int[]{3,6}));
        list.add(new adjacencyList(6,new int[]{5}));

          int result = 0;
          boolean[] visited = new boolean[7];
//        for(int i=0; i<n;i++ ){
//            if(!visited[i]){
//                dfs(list, i,  visited);
//                result++;
//            }
//        }

       // System.out.println(result);

        //friend circle adjacency matrix
//        int[][] friends = new int[][]{{1,1,0,0},{1,1,0,0},{0,0,1,0},{0,0,0,1}};
//        boolean[] visitedArray = new boolean[4];
//        for(int i=0; i<visitedArray.length;i++ ){
//            if(!visited[i]){
//                dfsFriend(friends, i,  visited);
//                result++;
//            }
//        }
//        System.out.println(result);

//        String[][] grid = new String[][]{
//                {"1","1","1","1","0"},
//                {"1","1","0","1","0"},
//                {"1","1","0","0","0"},
//                {"0","0","1","0","1"}};

//        String[][] grid = new String[][]{{"1"},{"1"}};
//        System.out.println(numIslands(grid));



    }


    public static boolean isValidTree(int n, int[][] edges ) {
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();
        for(int i=0; i<n; i++){
            graph.put(i,new ArrayList<>());
        }

        for(int[] edge: edges){
            graph.get(edge[0]).add(1);
            graph.get(edge[1]).add(0);
        }

       boolean[] visited = new boolean[n];

        if(dfshelper())
    }

    public static boolean dfshelper(HashMap<Integer,ArrayList<Integer>> graph, ) {


    }


    public static int numIslands(String[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int numberOfIslands = 0;
        for(int i = 0; i<grid.length;i++){
            for(int j = 0; j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]=="1"){
                    dfs(grid,i,j,visited);
                    numberOfIslands++;
                }
            }

        }
        return numberOfIslands;
    }


    public static void dfs( String[][] map, int i, int j, boolean[][] visited) {

        if(i<0 || i>=map.length || j<0 || j>=map[0].length) return;
        if (!visited[i][j]&& map[i][j]=="1") {
            visited[i][j] = true;
            dfs(map,i-1,j,visited);
            dfs(map,i,j-1,visited);
            dfs(map,i+1,j,visited);
            dfs(map,i,j+1,visited);

        }
    }


    public static void dfsFriend( int[][] friends, int i,  boolean[] visited) {
        //if not visited

        if (!visited[i]) {
            visited[i] = true;
            for (int itertaor = 0; itertaor < friends.length; itertaor++ ) {
                if (!visited[itertaor] && friends[i][itertaor]==1&& i != itertaor) {
                    dfsFriend(friends, itertaor, visited);
                }
            }
        }
    }
    public static void dfs(List<adjacencyList> list, int i,  boolean[] visited) {
        //if not visited

        if (!visited[list.get(i).vertex]) {
            visited[list.get(i).vertex] = true;
            int[] friendsList = list.get(i).friends;
            for (int itertaor = 0; itertaor < friendsList.length; itertaor++) {
                if (!visited[friendsList[itertaor]]) {
                    dfs(list, friendsList[itertaor], visited);
                }
            }
        }
    }

    /*
    {0: [1, 2],
1: [0, 5],
2: [0],
3: [6],
4: [],
5: [1],
6: [3]}
     */
}
