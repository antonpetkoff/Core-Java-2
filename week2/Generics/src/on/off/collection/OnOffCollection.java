package on.off.collection;

import java.util.ArrayList;

public class OnOffCollection<T> extends ArrayList<T> {
    /**
     * 
     */
    private static final long serialVersionUID = 3188050246807287931L;

    /**
     * @return false if elements was removed, else true
     */
    @Override
    public boolean add(T e) {
        if (this.contains(e)) {
            this.remove(e);
            return false;
        }
        return super.add(e);
    }
    
    @Override
    public void add(int index, T element) {
        // TODO Auto-generated method stub
        if (this.get(index).equals(element)) {
            this.remove(index);
        } else {
            super.add(index, element);
        }
    }
    
    public static void main(String[] args) {
        OnOffCollection<Integer> onoff = new OnOffCollection<Integer>();
        onoff.add(1);
        onoff.add(2);
        onoff.add(2);
        System.out.println(onoff.size());
        onoff.add(2);
        onoff.add(0, 1);
        System.out.println(onoff.size());
    }
}