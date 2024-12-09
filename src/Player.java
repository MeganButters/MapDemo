

public class Player extends Entity {
    // private int health;
    private int yPos, xPos;

    public Player(String n, String d){
        super(n,d);
        // health = 100;
        xPos = 0;
        yPos = 0;
    }

    public boolean move(String direction, Map m){
        if (direction.substring(0,1).equalsIgnoreCase("r")
                && xPos + 1 < m.getWidth()){
                    xPos += 1;
                    return true;
                }
        if (direction.substring(0,1).equalsIgnoreCase("l")
                && xPos > 0 ){
                    xPos -= 1;
                    return true;
                }
        if (direction.substring(0,1).equalsIgnoreCase("d")
                && yPos + 1 < m.getHt()){
                    yPos += 1;
                    return true;
                }
        if (direction.substring(0,1).equalsIgnoreCase("u")
                && yPos > 0 ){
                    yPos -= 1;
                    return true;
                }
        return false;
    }

    public int getX(){
        return xPos;
    }
    public int getY(){
        return yPos;
    }
 

}
