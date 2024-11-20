public abstract class NamedThing {
    private String name;
    private String description;

    /**
     * @param n the name 
     * @param d the description
     */
    public NamedThing(String n, String d){
        this.name = n;
        this.description = d;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String toString(){
        String s = "You are in the " + name + ".";
        s += "\n" + description + "\n";
        return s;
    }

    
}
