package immutable.list;

import java.util.ArrayList;
import java.util.Collection;

public final class ImmutableList<E> extends ArrayList<E> {

    /**
     * 
     */
    private static final long serialVersionUID = 7303374698298935558L;
    
    public ImmutableList(Collection<? extends E> c) {
        super(c);
    }
    
    @Override
    public void trimToSize() {
        throw new ImmutableListModifyException("Modifications are not allowed! Immutable Object!");
    }
    
    @Override
    public void ensureCapacity(int minCapacity) {
        throw new ImmutableListModifyException("Modifications are not allowed! Immutable Object!");
    }
    
    @Override
    public E get(int index) {
        // TODO Auto-generated method stub
        return super.get(index);
    }
    
    @Override
    public E set(int index, E element) {
        throw new ImmutableListModifyException("Modifications are not allowed! Immutable Object!");
    }
    
    @Override
    public boolean add(E e) {
        throw new ImmutableListModifyException("Modifications are not allowed! Immutable Object!");
    }
    
    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new ImmutableListModifyException("Modifications are not allowed! Immutable Object!");
    }

    @Override
    public void add(int index, E element) {
        throw new ImmutableListModifyException("Modifications are not allowed! Immutable Object!");
    }
    
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new ImmutableListModifyException("Modifications are not allowed! Immutable Object!");
    }
    
    @Override
    public boolean remove(Object o) {
        throw new ImmutableListModifyException("Modifications are not allowed! Immutable Object!");
    }

    @Override
    public E remove(int index) {
        throw new ImmutableListModifyException("Modifications are not allowed! Immutable Object!");
    }
    
    @Override
    public boolean removeAll(Collection<?> c) {
        throw new ImmutableListModifyException("Modifications are not allowed! Immutable Object!");
    }
    
    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new ImmutableListModifyException("Modifications are not allowed! Immutable Object!");
    }
    
    @Override
    public boolean retainAll(Collection<?> c) {
        throw new ImmutableListModifyException("Modifications are not allowed! Immutable Object!");
    }
    
    @Override
    public void clear() {
        throw new ImmutableListModifyException("Modifications are not allowed! Immutable Object!");
    }
    
    @Override
    public Object clone() {
        throw new ImmutableListModifyException("Modifications are not allowed! Immutable Object!");
    }
    
}
