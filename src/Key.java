import java.util.ArrayList;
public class Key extends Container{

    ArrayList<Item> items;
    ArrayList<Entity> characters;
    String asciiArt;

    
    public Key(String n, String d){
        super(n,d);
        this.asciiArt = "";
        // initialize Items and Entitys
    }
}