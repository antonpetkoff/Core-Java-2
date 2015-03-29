package pack.pair;

final public class Pair {

    private Object left;
    private Object right;
    
    Pair(Object left, Object right) {
        this.left = left;
        this.right = right;
    }
    
    public Object getLeft() {
        return this.left;
    }
    
    public void setLeft(Object left) {
        this.left = left;
    }
    
    public Object getRight() {
        return this.right;
    }
    
    public void setRight(Object right) {
        this.right = right;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof Pair) {
            Pair other = (Pair) obj;
            if (this.left.equals(other.getLeft()) && this.right.equals(other.getRight())) {
                return true;
            }
        }

        return false;
    }
    
    @Override
    public int hashCode() {
        return this.left.hashCode() ^ this.right.hashCode();
    }
    
    @Override
    public String toString() {
        return "(" + this.left.toString() + "," + this.right.toString() + ")";
    }
       
}
