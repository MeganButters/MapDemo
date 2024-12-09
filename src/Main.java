import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{

        // Game Setup Create a Map
        final int WIDTH=2, HEIGHT=3;
        Map world = new Map(WIDTH, HEIGHT);

        // Create some Rooms
        Room vault = new Room("The Vaults", ".");        
        Room throne = new Room("The Throne Room", "Welcome to the Throne Room. The walls loom over you as you walk down the intricate rug that leads up to the King's throne. The room has not been used since the King's death, but this is the Queen's favorite room.\nRecently, she refurnished the room to her, like adding a large grand piano. Maybe she hid a key... look around and find out.");
        Room bedroom = new Room("The Queen's Bedchamber","Welcome to the Queen's Bedchamber. There lies a large, canopied bed in the center of the room. The golden chest at the front immediatley cathces your attention. The details and carvings reflect the sunlight coming from the large floor-to-wall windows that push out onto the balcony.\nNo one, not even servants or guards, are allowed in here. There must be a reason for that... maybe the reason is a key?");
        Room court = new Room("The Courtyard", "Welcome to the Courtyard. The Courtyard is located within the palace walls, connecting to multiple rooms. This area serves as a gathering spot for many servants, but is closely watched by guards.\nSo be careful of catching the guard's attention, but a servant might know something about the keys.");
        Room kitchen = new Room("The Kitchen", "Welcome to the Kitchen. The chefs are the best in all of Everless. One chef is even a friend of the Queen, but stay away from him. He is a loyal supporter of the Queen and would never betray her trust. Look around and see if the Queen might have hid a key here in the confidence of the chef.");
        Room hall = new Room("The Great Hall", "Welcome to the Great Hall. The Great Hall has held many monarchs and kings over the centuries. However, the Great Hall has not seen any outsiders in years since the Queen decided to close the palace walls in an effort to protect her time.\nThe King, as one of his last acts before death, hid one of the keys to the vault rumored to be in this very hall. Rumors are not always true, but this one might be.");
        
        // Add the Rooms to the Map
        world.addRoom(court, 0, 0);
        world.addRoom(throne, 0, 1);
        world.addRoom(bedroom, 0, 2);
        world.addRoom(vault, 1, 2);
        world.addRoom(kitchen, 1, 1);
        world.addRoom(hall, 1, 0);
        
        // create containers
        Container piano = new Container("Grand Piano", "This piano has been recently added by the Queen due to her love for music. Let's have a look inside to see if she hid anything in here.");
        Container plant = new Container("Potted Plant", "No key! Plants may be a classic hiding spot, but not for the Queen. You'll have to search a bit harder than that.");
        Container painting = new Container("The King's Portrait", "The painting is surrounded by an ornate gold frame that seems to have gone years without being touched due to the dust residing along the edges. Search around and maybe you'll find something.");
        Container cabinets = new Container("Kitchen Cabinets", "The cabinets store the Queen's favorite snacks and often visits the kitchen to be with her friend, the chef. Maybe she hid a key somewhere.");
        Container chest = new Container("The Queen's Chest", "The chest holds many of the Queen's trinkets from journals to her crown. There's a lot to sort through, but rummage around and see if you can find a key.");

        // add containers to rooms
        Room.addContainer(piano, hall);
        Room.addContainer(plant, court);
        Room.addContainer(painting, throne);
        Room.addContainer(cabinets, kitchen);
        Room.addContainer(chest, bedroom);

        // create keys
        Key k1 = new Key("A key!", "Congrats! You foundd a key! Keep looking for the others but if you have found all 4 then go open the vault.");
        Key k2 = new Key("A key!", "Congrats! You foundd a key! Keep looking for the others but if you have found all 4 then go open the vault.");
        Key k3 = new Key("A key!", "Congrats! You foundd a key! Keep looking for the others but if you have found all 4 then go open the vault.");
        Key k4 = new Key("A key!", "Congrats! You foundd a key! Keep looking for the others but if you have found all 4 then go open the vault.");
        
        // add keys to containers
        Container.addKey(k1, piano);
        Container.addKey(k2, painting);
        Container.addKey(k3, cabinets);
        Container.addKey(k4, chest);

        // Basic input stuff
        Scanner input = new Scanner(System.in);
        String choice = "   ";
        String detail = "";


        // Create a Player
        Player p1 = new Player("Jules", "You are an oppressed peasant of the Everless Kingdom who struggling to support your family and time is running out.\nIn this world, time is money, and the Queen has stolen her people's time for herself. The kingdom needs someone who to take on the mission of retrieving the key hidden in the palace that will access the vaults the Queen has stored the stolen time.\nThe people have decided you are that person. Be quick and find the key before your time runs out.\nGood luck.");
        Player npc = new Player("Servant", "Hello. My name is Amma. As a servant within in the castle, I hear many secrets. One might be of help to you. You won't find any keys in the courtyard, there are too many people here for the Queen's liking. But you can find a key in the Queen's chambers. But beware, she " );
        Room.addPlayer(npc, court);


        // Game Loop
        type("Welcome to Everless Adventure.");
        type("You are " + p1); // character description
        type(world.show(p1)); // You are in the ---. The ---- is ....
        while(!(choice.substring(0,1).equalsIgnoreCase("Q"))){
            type("Enter a command [Move, Search, Pickup, Help, Talk, Use, Quit]: ");
            choice = input.next();
            
            if (choice.substring(0,1).equalsIgnoreCase("M")){
                System.out.println("Enter a direction: (Up, Down, Left, Right)");
                detail = input.next();
                String dir = detail.substring(0,1);
                // p1.move(dir, world);
                if(p1.move(dir, world)){
                    System.out.println("You moved " + detail);
                    type(world.show(p1));
                    
                }
                else{
                    System.out.println("Couldn't move " + detail);
                    // System.out.println(p1.getX() + ", " + p1.getY());
                }
            }
            else if (choice.substring(0,1).equalsIgnoreCase("H")){
                help();
            }
            else if (choice.substring(0,1).equalsIgnoreCase("S")){
                
                System.out.println("What would you like to search: " + list);
                // List items in the room availUseable to pickup here..
                if (p1.getY() == 0 && p1.getX() == 0){
                    String list = "Servant", "Potted Plant";
                        if(list.substring(0,1).equalsIgnoreCase("s")){
                            type.show(npc)
                }

                detail = input.next();
                type("Tried to search: \t" + detail);
                //To be implemented
            }
            else if (choice.substring(0,1).equalsIgnoreCase("T")){
                System.out.println("Who would you like to talk to? 1. Servant");
                // List items in the player's inventory...

                detail = input.next();
                type("Tried to talk to person: \t" + detail);
                court.show(npc);
                
            }
            else if (choice.substring(0,1).equalsIgnoreCase("U")){
                System.out.println("What would you like to use: 1. Key");
                // List items in the player's inventory...

                detail = input.next();
                type("Tried to use the Item: 1. Key" );
                //To be implemented
                if (numKeys = 4){
                    System.out.println("Congrats! You have opened the vault and completed the game.)
                        }
                else{
                    System.out.println("Not enough keys. You need 4 before you can use them to open the vault");
            }
            else if (choice.substring(0,1).equalsIgnoreCase("Q")){
                type("Goodbye and thanks for playing...Everless Adventure.");
                input.close();
            }

            else{
                type("Invalid command");
            }


        }
        // type("Goodbye and thanks for playing...Everless Adventure.");
        // input.close();
        
    }

    public static void help(){
        System.out.println("****** Commands *******");
        System.out.println("Move <direction> \tto move in a certain direction example: Move up");
        System.out.println("Look \tsimply describes the location");
        System.out.println("Pickup <item> \tto add an item in the room to your inventory example: Pickup remote");
        System.out.println("Use <item> \tdrops a certain item from your: Move up");


    }

    // Really just a Fancy way to disply text, could use orintln insteadhelp
    public static void type(String s) throws InterruptedException{
        for(int i = 0; i < s.length(); i++){
            System.out.print(s.substring(i, i+1));
            Thread.sleep(5);
        }
        System.out.println();
    }


       
}
