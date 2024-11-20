public class Map {
    Room[][] map;
    int ht, width;

    public Map(int h, int w){
        this.ht = h;
        this.width = w;
        map = new Room[h][w];

    }
    public int getWidth(){
        return this.width;
    }
    public int getHt(){
        return this.ht;
    }
    public void addRoom(Room r, int row, int col){
        if(row < this.ht && col < this.width){
                        map[row][col] = r;
        }
        else{
                        System.out.println("Invalid location");
            throw new IllegalStateException();
        }

    }

    public String show(Player p){
        return map[p.getY()][p.getX()].toString();
    }
    public void displayFullMap(){
        // -----------------------
        // |          |          |
        // |   name   |   name   | 
        // |          |          |
        // -----------------------
        // |          |          |
        // |   name   |   name   | 
        // |          |          |
        // -----------------------
        System.out.println("Full Map");

    }
}
