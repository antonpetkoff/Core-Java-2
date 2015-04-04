package unchecked.example;

public class User {
    
    private String name;

    public String getName() {
        if (name.isEmpty()) {
            throw new DatabaseCorruptedException("User name must not be empty!");
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public static void main(String[] args) {
        
    }
    
}
