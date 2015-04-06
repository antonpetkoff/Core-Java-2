package immutable.list;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.SerializationUtils;

/**
 * E extends Serializable because of
 * org.apache.commons.lang3.SerializationUtils.clone()
 * which requires Serializable object as argument.
 */
public final class ImmutableList<E extends Serializable> extends ArrayList<E> {

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
        return SerializationUtils.clone(super.get(index));
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
    
    @SafeVarargs
    public static <T> List<T> asList(T... arguments) {
        return Arrays.asList(arguments);
    }
    
}
