package socialdistancing;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

interface Wall{

    int x = 0 ;
     int y = 0;
     int width = 0;
    int height = 0;
   boolean visible = true;
    Image image = null;
    boolean vertical = true ;

    public void createWall(int x, int y, String imageS, boolean vertical) ;
    //{

//        this.x = x;
//        this.y = y;
//        visible = true;
//        this.vertical = vertical;
//        loadImage(imageS);
//        getImageDimensions();
   // }

    abstract void loadImage(String imageName); 
//    {
//
//        ImageIcon ii = new ImageIcon(imageName);
//        image = ii.getImage();
//    }
//    
    abstract void getImageDimensions();
//    {
//
//        this.width = image.getWidth(null);
//        this.height = image.getHeight(null);
//    }    

    abstract Image getImage(); 
//    {
//        return image;
//    }

    abstract int getX(); 
//    {
//        return x;
//    }

    abstract int getY(); 
//    {
//        return y;
//    }

    abstract boolean isVisible(); 
//    {
//        return visible;
//    }

    abstract void setVisible(Boolean visible); 
//    {
//        this.visible = visible;
//    }
    
    abstract Rectangle getBounds(); 
//    {
//        return new Rectangle(x, y, width, height);
//    }
}