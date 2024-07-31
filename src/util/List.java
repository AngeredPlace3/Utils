package util;

import java.util.StringJoiner;

public abstract class List<T> implements Sequence<T> {

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (T item : this) {
            joiner.add(item.toString());
        }
        return joiner.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List<?> list) {
            if (count() != list.count()) {
                return false;
            }
            for (int i = 0; i < count(); i++) {
                if (!get(i).equals(list.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
