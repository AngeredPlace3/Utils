import util.LinkedList;

public class App {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.insert(0, "a");
        list.insert(1, "b");
        list.insert(2, "c");
        System.out.println(list);
    }
}
