package socialdistancing;

import java.util.ArrayList;
import java.util.List;

import java.awt.Rectangle;

public class CommunityModel {
    List<Wall> walls = new ArrayList<Wall>();
    List<Rectangle> wall_boundaries = new ArrayList<Rectangle>();

    public CommunityModel() {
        buildingWalls();
    }

    void buildingWalls() {
        // Declares Wall sprites and positions of walls
        walls.add(new Wall(550, 0, "SocialDistancingImages/wall2.png", true));
        walls.add(new Wall(200, 0, "SocialDistancingImages/wall2.png", true));
        walls.add(new Wall(550, 400, "SocialDistancingImages/wall2.png", true));
        walls.add(new Wall(200, 400, "SocialDistancingImages/wall2.png", true));
        walls.add(new Wall(620, 160, "SocialDistancingImages/wall1.png", false));
        walls.add(new Wall(-25, 160, "SocialDistancingImages/wall1.png", false));
        walls.add(new Wall(620, 400, "SocialDistancingImages/wall1.png", false));
        walls.add(new Wall(-25, 400, "SocialDistancingImages/wall1.png", false));
        // static Wall[] walls = { vWall1, hWall1, vWall2, hWall2, vWall3, hWall3,
        // vWall4, hWall4 };
        for (Wall wall : walls) {
            wall_boundaries.add(wall.getBounds());
        }
    }

}