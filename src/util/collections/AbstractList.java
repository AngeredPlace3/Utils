package util.collections;

import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Provides a base implementation of the {@link ReadOnlyList} interface.
 * 
 * @param <E> the type of elements in this list
 */
public abstract class AbstractList<E> implements ReadOnlyList<E> {

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ReadOnlyList<?> list) {
            if (this.size() != list.size()) {
                return false;
            }
            Iterator<E> it1 = iterator();
            Iterator<?> it2 = list.iterator();
            while (it1.hasNext() && it2.hasNext()) {
                if (!Objects.equals(it1.next(), it2.next())) {
                    return false;
                }
            }
            return !it1.hasNext() && !it2.hasNext();
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (E e : this) {
            result = 31 * result + Objects.hashCode(e);
        }
        return result;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", getClass().getSimpleName() + " [", "]");
        for (E e : this) {
            if (e == this) 
                sj.add("this");
            else
                sj.add(Objects.toString(e));

        }
        return sj.toString();
    }

}
