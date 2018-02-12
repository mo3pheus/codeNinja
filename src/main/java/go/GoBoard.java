package go;

import java.awt.*;
import java.util.List;

public class GoBoard {
    private GoNode[][] board = new GoNode[19][19];


    public GoNode findNode(Point p) {
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].getLocation().equals(p)) {
                    return board[i][j];
                }
            }
        }

        return null;
    }


    public boolean isNodeCaptured(GoNode targetNode){
        // a node is captured if all its adjacent nodes are captured.

        // mark targetNode as visited.
        targetNode.setVisited(true);

        // get all adjacent nodes
        List<GoNode> adjacentNodes = targetNode.getAdjacentNodes();

        boolean captured = true;
        for(GoNode go:adjacentNodes){
            if(go.isVisited()){
                captured = captured && evaluateList(go.getAdjacentNodes(), go);
            } else {
                captured = captured && isNodeCaptured(go);
            }
        }
        return captured;
    }


    public boolean evaluateList(List<GoNode> adjNodes, GoNode targetNode){
        for(GoNode goNode:adjNodes){
            if(!goNode.isVisited()&&goNode.getColor().equals(targetNode.getColor())){
                return false;
            }
        }

        return true;
    }

}
