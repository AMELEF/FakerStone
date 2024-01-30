package environment;

public class UniqueIdentifier {
    int id;
    public int getUniqueID(){
        this.id++;
        return id;
    }
}
