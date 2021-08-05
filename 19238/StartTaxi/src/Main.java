import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        Node[][] map = null;

        //N : 맵 크기,M : 승객 수,F : 연료양
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int F = Integer.parseInt(st.nextToken());

        map = InitMap(N);
        SetNode(st, br, map);
        Node startNode = SetObject(st, br, map, M);


        if(br != null) br.close();
    }

    static public class Node{
        public int row,column;
        public boolean marked,imWall,imPassenger,imDest;
        public int number;
        public LinkedList<Node> adjacent = null;

        Node(int row,int column){
            this.row = row;
            this.column = column;
            marked = false;
            imWall = false;
            imPassenger = false;
            imDest = false;

            adjacent = new LinkedList<Node>();
        }
    }

    static public Node[][] InitMap(int mapSize){
        Node[][] map = new Node[mapSize][mapSize];

        for (int row = 0;row < mapSize;row++){
            for (int column = 0;column < mapSize;column++){
                map[row][column] = new Node(row,column);
            }
        }

        return map;
    }

    static public void SetNode(StringTokenizer st,BufferedReader br,Node[][] map) throws Exception{
        for(int row = 0;row < map.length;row++){
            st = new StringTokenizer(br.readLine());
            for(int column = 0;column < map[row].length;column++){
                if(st.countTokens() == 0) break;
                Node node = map[row][column];
                if(Integer.parseInt(st.nextToken().trim()) == 1) node.imWall = true;
            }
        }

        for(int row = 0;row < map.length;row++){
            for(int column = 0;column < map[row].length;column++){
                Node node = map[row][column];
                int nextColumn = column - 1;
                if(nextColumn >= 0 && nextColumn < map[row].length){
                    Node adjacentNode = map[row][nextColumn];
                    if(!adjacentNode.imWall)
                        node.adjacent.add(adjacentNode);
                }
                int nextRow = row + 1;
                if(nextRow < map.length){
                    Node adjacentNode = map[nextRow][column];
                    if(!adjacentNode.imWall)
                        node.adjacent.add(adjacentNode);
                }
                nextColumn = column + 1;
                if(nextColumn < map[row].length){
                    Node adjacentNode = map[row][nextColumn];
                    if(!adjacentNode.imWall)
                        node.adjacent.add(adjacentNode);
                }
                nextRow = row - 1;
                if(nextRow >= 0 && nextRow < map.length){
                    Node adjacentNode = map[nextRow][column];
                    if(!adjacentNode.imWall)
                        node.adjacent.add(adjacentNode);
                }
            }
        }
    }

    static public Node SetObject(StringTokenizer st,BufferedReader br,Node[][] map,int M) throws Exception{
        st = new StringTokenizer(br.readLine());
        int startRow = Integer.parseInt(st.nextToken().trim()) - 1;
        int startColumn = Integer.parseInt(st.nextToken().trim()) - 1;
        Node taxiNode = map[startRow][startColumn];

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i < M;i++){
            st = new StringTokenizer(br.readLine());
            int passengerRow = Integer.parseInt(st.nextToken().trim()) - 1;
            int passengerColumn = Integer.parseInt(st.nextToken().trim()) - 1;
            int destRow = Integer.parseInt(st.nextToken().trim()) - 1;
            int destColumn = Integer.parseInt(st.nextToken().trim()) - 1;

            Node passengerNode = map[passengerRow][passengerColumn];
            Node destNode = map[destRow][destColumn];
            passengerNode.imPassenger = true;
            passengerNode.number = i;
            destNode.imDest = true;
            destNode.number = i;
        }

        return taxiNode;
    }

    static public Node FindMinDistPassenger(Node startNode,Node[][] map){
        Node targetPassengerNode;
        Node[][] cloneMap = map.clone();

        /*TODO
        * 택시로부터 거리가 가장 짧은 승객을 찾아 리턴해주는 함수 구현 (BFS)
        * 찾았을 경우 original map에 반영 *구태여 두번 계산할 필요 없으니..
        */

        return targetPassengerNode;
    }
}
