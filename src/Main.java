import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{

        // Game Setup Create a Map
        final int WIDTH=2, HEIGHT=2;
        Map world = new Map(WIDTH, HEIGHT);

        // Create some Rooms
        Room lvroom = new Room("Living Room", "You enter the heart of the Griffin household. The couch is worn out from years of Peter’s spontaneous naps, and the TV is perpetually tuned to an old episode of The Quagmire Show. Lois is busy in the kitchen, and Stewie's tiny voice can be heard plotting from upstairs. The room is filled with random clutter, including a half-eaten sandwich, a soda can, and a magazine featuring Peter's latest misadventure. The fireplace flickers lazily in the corner, but something seems off — there’s a suspiciously large stack of comics behind the couch");        
        Room clam = new Room("The Clam", "The familiar, dimly lit pub where Peter, Quagmire, Cleveland, and Joe meet up to drink and talk about their wild, inappropriate adventures. The jukebox hums softly in the background, and you can hear the clinking of glass bottles as the bartender, Jerome, serves drinks. A dartboard hangs on the far wall, but it’s completely covered in broken darts from Peter’s latest attempt at playing. There's a faint smell of stale peanuts in the air, and the smell of fried food wafts from the kitchen. A mysterious figure sits in the corner booth, quietly sipping a drink. It’s none other than Tom Tucker — but what’s he doing here?");
        Room loisRoom = new Room("Lois' Craft Room","Lois’ haven of creativity is a treasure trove of yarn, fabric, paints, and all things DIY. The room is neatly organized, though there are scattered projects half-finished on every surface. In the corner, a sewing machine hums away as Lois is working on yet another home decor item for the house. There's a faint smell of lavender in the air, and the shelves are filled with carefully arranged arts and crafts supplies. If you’re lucky, you might even catch a glimpse of Brian, who has been roped into helping her with some ‘artsy’ task. But be warned — don’t touch anything unless you’re ready to explain yourself.");
        Room den = new Room("The Stewie's Secret Den", "You enter a hidden room under the Griffin house, filled with high-tech gadgets and glowing screens. The walls are lined with blueprints of diabolical inventions, and a hologram of Stewie is floating in the center of the room, acting out a dramatic speech about world domination. It’s clear that Stewie has been busy with his latest experiments, as a few robots roam the floor, occasionally malfunctioning. There’s a small compartment in the corner labeled “Do Not Touch,” but you can’t resist. Could it be the key to his latest scheme? Stewie’s not far behind, though, and he’s not known for his patience.");
        
        // Add the Rooms to the Map
        world.addRoom(lvroom, 0, 0);
        world.addRoom(clam, 0, 1);
        world.addRoom(loisRoom, 1, 0);
        world.addRoom(den, 1, 1);
    
        // Basic input stuff
        Scanner input = new Scanner(System.in);
        String choice = "   ";
        String detail = "";

        // Create a Player
        Player p1 = new Player("Bryan", "You’re a pretty unique guy—well, dog, but you know what I mean. You’re a talking white Labrador with a black nose and those sharp, intelligent eyes. You’ve got this sophisticated, almost pretentious vibe to you, but you pull it off, no question. You’ve got a bit of a sarcastic, dry humor that keeps people on their toes, and you don’t mind giving a little bit of tough love to those around you.");
        
        // Game Loop
        type("Welcome to Bryan's Adventure.");
        type("You are " + p1);
        type(world.show(p1));
        while(!(choice.substring(0,1).equalsIgnoreCase("q"))){
            type("Enter a command [Move, Look, Quit, Pickup, Help, Talk, Use]: ");
            choice = input.next();
            
            if (choice.substring(0,1).equalsIgnoreCase("M")){
                System.out.println("Enter a direction: (Up, Down, Left, Right)");
                detail = input.next();
                String dir = detail.substring(0,1);
                // p1.move(dir, world);
                if(p1.move(dir, world)){
                    System.out.println("You moved " + detail);
                    type(world.show(p1)); // Show the new Room Description
                }
                else{
                    System.out.println("Couldn't move " + detail);
                    // System.out.println(p1.getX() + ", " + p1.getY());
                }
            }
            else if (choice.substring(0,1).equalsIgnoreCase("H")){
                help();
            }
            else if (choice.substring(0,1).equalsIgnoreCase("P")){
                System.out.println("What would you like to pickup: ");
                // List items in the room availUseable to pickup here..
                detail = input.next();
                type("Tried to pickup the Item: \t" + detail);
                //To be implemented
            }
            else if (choice.substring(0,1).equalsIgnoreCase("U")){
                System.out.println("What would you like to use: ");
                // List items in the player's inventory...

                detail = input.next();
                type("Tried to use the Item: \t" + detail);
                //To be implemented
            }
            else{
                type("Invalid command");
            }


        }
        type("Goodbye and thanks for playing...Bryan's Adventure.");
        input.close();
        
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
