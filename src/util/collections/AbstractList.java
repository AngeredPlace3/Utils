package util.collections;

import java.util.StringJoiner;

public abstract class AbstractList<E> implements List.Mutable<E> {

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", getClass().getSimpleName() + " [", "]");
        for (E e : this) {
            joiner.add(String.valueOf(e));
        }
        return joiner.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof List list) {
            if (size() != list.size())
                return false;
            for (int i = 0; i < size(); i++) {
                if (!get(i).equals(list.get(i))) {
                    return false;
                }
            }
            return true;

        }
        return false;
    }

    @Override
    public int hashCode() {
        if (size() == 0) {
            return 0;
        }
        int hashCode = 1;
        for (E e : this) {
            hashCode = 31 * hashCode + e.hashCode();
        }
        return hashCode;
    }
}
