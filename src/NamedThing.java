public abstract class NamedThing {
    private String name;
    public String getName() {
        return name;
    }


    private String description;


    public String getDescription() {
        return description;
    }


    /**
     * @param n the name 
     * @param d the description
     */
    public NamedThing(String n, String d){
        this.name = n;
        this.description = d;
    }

    public String toString(){
        String s = "You are in the " + name + ".";
        s += "\n" + description + "\n";
        return s;
    }

    
}
