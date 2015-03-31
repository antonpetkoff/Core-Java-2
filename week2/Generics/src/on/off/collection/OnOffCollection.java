package on.off.collection;

import java.util.ArrayList;

public class OnOffCollection<T> extends ArrayList<T> {
    /**
     * 
     */
    private static final long serialVersionUID = 3188050246807287931L;

    @Override
    public boolean add(T e) {
        if (this.contains(e)) {
            this.remove(e);
        }
        return super.add(e);
    }
    
    @Override
    public void add(int index, T element) {
        // TODO Auto-generated method stub
        super.add(index, element);
    }
}