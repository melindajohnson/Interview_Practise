import java.util.*;

public class Main {

    public static void main(String[] args) {
      //int[][] matrix = new int[][]{{1,0,0},{1,0,0},{1,9,1}};
//       List<List<Integer>> matrix = new ArrayList<>();
//        List<Integer> c1 =  new ArrayList<>();
//        c1.add(1); c1.add(1); c1.add(1); c1.add(1);
//        matrix.add(c1);
//        List<Integer> c2 =  new ArrayList<>();
//        c2.add(1); c2.add(0); c2.add(0); c2.add(1);
//        matrix.add(c2);
//        List<Integer> c3 =  new ArrayList<>();
//        c3.add(1); c3.add(1); c3.add(9); c3.add(0);
//        matrix.add(c3);
//        List<Coordinate> path = (maze(matrix));
//        for(int i =0; i<path.size();i++){
//            System.out.println("(" + path.get(i).x + ","  +path.get(i).y+ ")");
 //       }

        List<Coordinate> listOfCoordinates =  new ArrayList<>();
        Coordinate c1 = new Coordinate(3,5);
        Coordinate c2 = new Coordinate(2,5);
        Coordinate c3 = new Coordinate(3,1);
        Coordinate c4 = new Coordinate(1,2);
        Coordinate c5 = new Coordinate(3,6);
        Coordinate c6 = new Coordinate(0,5);
        listOfCoordinates.add(c1);
        listOfCoordinates.add(c2);
        listOfCoordinates.add(c3);
        listOfCoordinates.add(c4);
        listOfCoordinates.add(c5);
        listOfCoordinates.add(c6);

        List<Coordinate> result =  findKCoordinates(listOfCoordinates,1);
        for(Coordinate c: result ){
            System.out.println("Coordinate: " + c.x + "," + c.y);
        }
    }

    public static class Coordinate{
        int x= 0;
        int y =0;

        Coordinate(int X,int Y){
            this.x = X;
            this.y = Y;
        }
    }
    public static class CoordinateComparator implements Comparator<Coordinate>{

        // Overriding compare()method of Comparator
        public int compare(Coordinate c1, Coordinate c2) {
            if (c1.x*c1.x+c1.y*c1.y < c2.x*c2.x+c2.y*c2.y)
                return 1;
            else if (c1.x*c1.x+c1.y*c1.y > c2.x*c2.x+c2.y*c2.y)
                return -1;
            return 0;
        }
    }

    public static List<Coordinate> findKCoordinates(List<Coordinate> coordinates, int k){
        int size = k;
        List<Coordinate> result = new ArrayList<>();
        PriorityQueue<Coordinate> maxHeap = new PriorityQueue<>(size,new CoordinateComparator());
        for(int i=0;i<coordinates.size();i++){
            if(k>0){
                maxHeap.add(coordinates.get(i));
                k--;
            }else{
                Coordinate max = maxHeap.peek();
                Coordinate current = coordinates.get(i);
                if(max.x*max.x+max.y*max.y > current.x*current.x+current.y*current.y ){
                    maxHeap.poll();
                    maxHeap.add(current);
                }
            }
        }
        while(!maxHeap.isEmpty()){
            result.add(maxHeap.peek());
            maxHeap.remove();
        }
        return result;
    }

    /*

        public static boolean isNotObstacleAndNotVisited(int x, int y, List<List<Integer>> matrix , int[][]visited){

        if(matrix.get(x).get(y)==0) return false;   //if not 1 then coordinate is  an obstacle
        else if (visited[x][y]!=0) return false; //if not 0 then coordinate is visited
        else {
            //make visited
            visited[x][y]=1;
            return true;
        }
    }

    public static class Coordinate{
        int x = 0;
        int y = 0;
        int dist  = 0;
        Coordinate prev = null;

        Coordinate(int x,int y, int d, Coordinate c){
           this.x = x;
            this.y = y;
           this.dist  =d;
            prev = c;
        }
    }

    public static  List<Coordinate> maze(List<List<Integer>> matrix ){
        int[][] visited = new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        int row = matrix.size();
        int cols = matrix.get(0).size();
        List<Coordinate> path = new ArrayList<>();
       Queue<Coordinate> queue = new LinkedList<>();
        Coordinate start = new Coordinate(0,0,0,null);
        visited[0][0]=1;
        queue.add(start);
       // int path = -1;
        while(!queue.isEmpty()){
            Coordinate c = queue.peek();

            queue.remove();


            //make the adjacent coordinates
            int x = c.x;
            int y = c.y;
            int distance = c.dist;
            if(matrix.get(x).get(y)==9) {
                Coordinate temp = c;

                while(temp!=null){
                    path.add(0,temp);
                    temp = temp.prev;
                }

                return path;
            }

            //right
            if(y+1 < cols){
                if(isNotObstacleAndNotVisited(x,y+1,matrix,visited)) queue.add(new Coordinate(x,y+1,distance+1,c));
            }
            //left
            if(y-1 >= 0) {
                if(isNotObstacleAndNotVisited(x,y-1,matrix,visited))queue.add(new Coordinate(x,y-1,distance+1,c));
            }
            //down
            if( x+1 < row){
               if(isNotObstacleAndNotVisited(x+1,y,matrix,visited)) queue.add(new Coordinate(x+1,y,distance+1,c));
            }
            //up
            if(x-1 >= 0 ){
                if(isNotObstacleAndNotVisited(x-1,y,matrix,visited))queue.add(new Coordinate(x-1,y,distance+1,c));
            }
        }
        return null;
    }

     */
}
