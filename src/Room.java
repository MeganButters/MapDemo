import java.util.ArrayList;
public class Room extends NamedThing{

    ArrayList<Item> items;
    ArrayList<Entity> characters;
    String asciiArt;

    
    public Room(String n, String d){
        super(n,d);
        this.asciiArt = "";
        // initialize Items and Entitys
    }

    //Make new constructor to create ascii art if desired...

    // Method to display Items and/or Entitys in room...

    //Methods to add/remove Items/Entitys...


    public String toString(){
        String s = asciiArt + "\n\n";
        return s + super.toString();
    }

}
