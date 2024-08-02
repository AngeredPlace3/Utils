package util.collections;

import java.util.NoSuchElementException;

interface LastOut<E> {

    E getLast() throws NoSuchElementException;

    interface Mutable<E> extends LastOut<E> {
        E removeLast();
    }
}