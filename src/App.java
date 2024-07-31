
import util.ArrayList;
import util.LinkedList;
import util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.prepend(i);
        }
        List<Integer> list2 = list.sub(0, 5);
        list2.clear();

        System.out.println(list + " " + list2 + " " + list2.count() + " ");
    }

}
