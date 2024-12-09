import java.util.ArrayList;
public class Container extends Room{

    ArrayList<Item> items;
    ArrayList<Entity> characters;
    String asciiArt;

    
    public Container(String n, String d){
        super(n,d);
        this.asciiArt = "";
        // initialize Items and Entitys
    }

    // public void addKey(){
    //     System.out.println("Congrats! You found a key. Keep lookig for the others, or open the vault if you have four.");
    // }
  

    //Make new constructor to create ascii art if desired...

    // Method to display Items and/or Entitys in room...

    //Methods to add/remove Items/Entitys...


  
    

}
