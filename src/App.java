
import java.util.Comparator;

import util.LinkedList;
import util.Sequence;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.prepend(i);
        }
        Sequence<Integer> list2 = list.sub(0, 5);

        System.out.println(list + " " + list2 + " " + list2.count());
        list2.clear();
        System.out.println(list + " " + list2);
    }

    public static <T> void sort(Sequence<T> sequence, Comparator<T> comparator) {
        for (int i = 0; i < sequence.count(); i++) {
            for (int j = i + 1; j < sequence.count(); j++) {
                if (comparator.compare(sequence.get(i), sequence.get(j)) > 0) {
                    sequence.swap(i, j);
                }
            }
        }
    }
}
