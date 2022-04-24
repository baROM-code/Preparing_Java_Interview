import ru.baROM.pr2.MyArrayList;
import ru.baROM.pr2.MyLinkedList;

public class test_2 {

    public static void main(String[] args) {

        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("Hello");
        myLinkedList.add("new");
        myLinkedList.add("geeks");
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.indexOf("geeks"));
        System.out.println(myLinkedList.delete("new"));
        myLinkedList.delete(1);
        System.out.println(myLinkedList);

        System.out.println("-----------------------------");

        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("One");
        myArrayList.add("Two");
        myArrayList.add("3");
        myArrayList.add("4");
        myArrayList.add("5");
        myArrayList.add("6");
        myArrayList.add("7");
        myArrayList.add("8");

        myArrayList.add(0,"0");
        System.out.println(myArrayList);

        myArrayList.add(4,"4-");
        myArrayList.set("index7", 7);
        myArrayList.delete(2);
        myArrayList.delete("7");
        System.out.println(myArrayList);

        System.out.println("index " + myArrayList.get(1) + " = " + myArrayList.indexOf("One"));

    }

}
