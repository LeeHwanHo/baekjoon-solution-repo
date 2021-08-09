import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int FEUL;
    static int NUMBER;
    static int MANS;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        Node[][] map = null;

        // N : 맵 크기,M : 승객 수,F : 연료양
        st = new StringTokenizer(br.readLine());
        NUMBER = Integer.parseInt(st.nextToken());
        MANS = Integer.parseInt(st.nextToken());
        FEUL = Integer.parseInt(st.nextToken());

        map = InitMap(NUMBER);
        SetNode(st, br, map);
        Node startNode = SetObject(st, br, map, MANS);

        System.out.println(StartWorking(startNode, map, MANS, FEUL));

        if (br != null)
            br.close();
    }

    static public class Node {
        public int row, column;
        public boolean imWall;
        public Boolean marked,imPassenger,imDest;
        public int depth;
        public LinkedList<Node> adjacent = null;

        Node(int row, int column) {
            this.row = row;
            this.column = column;
            marked = false;
            imWall = false;
            imPassenger = false;
            imDest = false;
            depth = 0;

            adjacent = new LinkedList<Node>();
        }
    }

    static public Node[][] InitMap(int mapSize) {
        Node[][] map = new Node[mapSize][mapSize];

        for (int row = 0; row < mapSize; row++) {
            for (int column = 0; column < mapSize; column++) {
                map[row][column] = new Node(row, column);
            }
        }

        return map;
    }

    static public void SetNode(StringTokenizer st, BufferedReader br, Node[][] map) throws Exception {
        for (int row = 0; row < map.length; row++) {
            st = new StringTokenizer(br.readLine());
            for (int column = 0; column < map[row].length; column++) {
                if (st.countTokens() == 0)
                    break;
                Node node = map[row][column];
                if (Integer.parseInt(st.nextToken().trim()) == 1)
                    node.imWall = true;
            }
        }

        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map[row].length; column++) {
                Node node = map[row][column];
                int nextColumn = column - 1;
                if (nextColumn >= 0 && nextColumn < map[row].length) {
                    Node adjacentNode = map[row][nextColumn];
                    if (!adjacentNode.imWall)
                        node.adjacent.add(adjacentNode);
                }
                int nextRow = row + 1;
                if (nextRow < map.length) {
                    Node adjacentNode = map[nextRow][column];
                    if (!adjacentNode.imWall)
                        node.adjacent.add(adjacentNode);
                }
                nextColumn = column + 1;
                if (nextColumn < map[row].length) {
                    Node adjacentNode = map[row][nextColumn];
                    if (!adjacentNode.imWall)
                        node.adjacent.add(adjacentNode);
                }
                nextRow = row - 1;
                if (nextRow >= 0 && nextRow < map.length) {
                    Node adjacentNode = map[nextRow][column];
                    if (!adjacentNode.imWall)
                        node.adjacent.add(adjacentNode);
                }
            }
        }
    }

    static public void SetNode(Node[][] map, Node[][] original) throws Exception {
        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map[row].length; column++) {
                Node node = map[row][column];
                if (original[row][column].imWall)
                    node.imWall = true;
            }
        }

        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map[row].length; column++) {
                Node node = map[row][column];
                int nextColumn = column - 1;
                if (nextColumn >= 0 && nextColumn < map[row].length) {
                    Node adjacentNode = map[row][nextColumn];
                    if (!adjacentNode.imWall)
                        node.adjacent.add(adjacentNode);
                }
                int nextRow = row + 1;
                if (nextRow < map.length) {
                    Node adjacentNode = map[nextRow][column];
                    if (!adjacentNode.imWall)
                        node.adjacent.add(adjacentNode);
                }
                nextColumn = column + 1;
                if (nextColumn < map[row].length) {
                    Node adjacentNode = map[row][nextColumn];
                    if (!adjacentNode.imWall)
                        node.adjacent.add(adjacentNode);
                }
                nextRow = row - 1;
                if (nextRow >= 0 && nextRow < map.length) {
                    Node adjacentNode = map[nextRow][column];
                    if (!adjacentNode.imWall)
                        node.adjacent.add(adjacentNode);
                }
            }
        }
    }

    static public Node SetObject(StringTokenizer st, BufferedReader br, Node[][] map, int M) throws Exception {
        st = new StringTokenizer(br.readLine());
        int startRow = Integer.parseInt(st.nextToken().trim()) - 1;
        int startColumn = Integer.parseInt(st.nextToken().trim()) - 1;
        Node taxiNode = map[startRow][startColumn];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int passengerRow = Integer.parseInt(st.nextToken().trim()) - 1;
            int passengerColumn = Integer.parseInt(st.nextToken().trim()) - 1;
            int destRow = Integer.parseInt(st.nextToken().trim()) - 1;
            int destColumn = Integer.parseInt(st.nextToken().trim()) - 1;

            Node passengerNode = map[passengerRow][passengerColumn];
            Node destNode = map[destRow][destColumn];
            passengerNode.imPassenger = true;
            destNode.imDest = true;
        }

        return taxiNode;
    }

    static public Node GetTaxiMoveTaxiToMinPass(Node startNode, Node[][] map, int M, int F) throws Exception {
        LinkedList<Node> passNodes = new LinkedList<Node>();
        Node minNode = null;
        

        for (int i = 0; i < M; i++) {
            Queue<Node> queue = new LinkedList<Node>();
            Queue<Node> resetQ = new LinkedList<Node>();
            queue.add(startNode);
            startNode.marked = true;

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                resetQ.add(node);
                if (node.imPassenger) {
                    if (minNode == null) {
                        passNodes.add(node);
                    }
                    else if (node.depth < minNode.depth) {
                        passNodes.add(node);
                    } 
                    else if (node.depth == minNode.depth) {
                        if (node.row < minNode.row) {
                            passNodes.add(node);
                        } 
                        else if (node.row == minNode.row) {
                            if (node.column < minNode.column) {
                                passNodes.add(node);
                            }
                        }
                    }
                    node.imPassenger = false;
                }

                for (Node adjacentNode : node.adjacent) {
                    if (!adjacentNode.marked) {
                        adjacentNode.marked = true;
                        adjacentNode.depth = node.depth + 1;
                        queue.add(adjacentNode);
                    }
                }
            }

            while(!resetQ.isEmpty()){
                Node node = resetQ.poll();
                //TODO Reset Map
                node.depth = 0;
            }
        }


        return minNode;
    }

    static public Node GetTaxiMovePassToDest(Node startNode, Node[][] map) throws Exception {
        Node[][] cloneMap = DeepCopy(map, startNode);
        Node taxiNode = cloneMap[startNode.row][startNode.column];
        Node destNode = null;
        int destNodeIndex = -1;

        for (int row = 0; row < cloneMap.length; row++) {
            for (int column = 0; column < cloneMap[row].length; column++) {
                Node node = cloneMap[row][column];
                for(int i =0;i<node.destNumbers.size();i++){
                    if (node.imDest && node.destNumbers.get(i) == taxiNode.passNumber) {
                        destNode = node;
                        destNodeIndex = i;
                        break;
                    }
                }
                if(destNode != null) {
                    row = cloneMap.length;
                    break;
                }
            }
        }

        if (destNode == null)
            return null;

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(taxiNode);
        taxiNode.marked = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for(int i =0;i<node.destNumbers.size();i++){
                if (node.imDest && node.destNumbers.get(i) == destNode.destNumbers.get(destNodeIndex)) {
                    return node;
                }
            }

            for (Node adjacentNode : node.adjacent) {
                if (!adjacentNode.marked) {
                    adjacentNode.marked = true;
                    adjacentNode.depth = node.depth + 1;
                    queue.add(adjacentNode);
                }
            }
        }

        return null;
    }

    public static Node[][] DeepCopy(Node[][] original, Node startNode) throws Exception {
        Node[][] result = null;
        result = InitMap(NUMBER);
        SetNode(result, original);
        SetObject(result, original, MANS);
        return result;
    }

    static public int StartWorking(Node startNode, Node[][] map, int M, int F) throws Exception {
        int movePassFuelAmount = 0;
        int moveDestFuelAmount = 0;

        for (int i = 0; i < M; i++) {
            Node toBeStartNode = GetTaxiMoveTaxiToMinPass(startNode, map, M, F);

            if (toBeStartNode == null || toBeStartNode.depth > F) { // taxi can't go to passenger
                return -1;
            } else {
                movePassFuelAmount = toBeStartNode.depth;
                F -= movePassFuelAmount;
                startNode = map[toBeStartNode.row][toBeStartNode.column];
                startNode.imPassenger = false;
            }

            toBeStartNode = GetTaxiMovePassToDest(startNode, map);
            if (toBeStartNode == null || toBeStartNode.depth > F) { // taxi can't go to destinaiton
                return -1;
            } else {
                moveDestFuelAmount = toBeStartNode.depth;
                F -= moveDestFuelAmount;
                startNode = map[toBeStartNode.row][toBeStartNode.column];
            }

            F += moveDestFuelAmount * 2;
        }

        return F;
    }
}