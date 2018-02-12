package go;

import java.awt.*;
import java.util.List;

public class GoNode {
    private Point                 location;
    private GoConstants.GO_COLORS color;
    private boolean               visited;

    public List<GoNode> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(List<GoNode> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    private List<GoNode> adjacentNodes;

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public GoConstants.GO_COLORS getColor() {
        return color;
    }

    public void setColor(GoConstants.GO_COLORS color) {
        this.color = color;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
