<<<<<<< HEAD
public class App {
    
}
=======
import util.Range;
import util.collections.*;

public class App {
    public static void main(String[] args) {
        Range range = new Range(10, 0, 2);
        Queue.Mutable<Integer> list = new ArrayList<>();

        System.out.println(range + " first " + range.getFirst());
        System.out.println(range + " last " + range.getLast());

        for (int i : range) {
            list.addLast(i);
        }

        System.out.println(list + " " + list.size() + " " + range.size());
        dequeue(list);
        System.out.println(list + " " + list.size() + " " + range.size());

    }

    static void dequeue(Queue.Mutable<Integer> queue) {
        while (!queue.isEmpty()) {
            System.out.println(queue.removeFirst());
        }
    }
}
>>>>>>> 18e12cc3c9664cf17ed05fdfc37c167bed53392a
