package L7;


public class CollectionTest {
    public static void main(String[] args) {
        Collection<Integer> intList = new Collection<>();

        intList.add(10);
        intList.add(20);
        intList.add(30);
        System.out.println("List_size: " + intList.size());


        System.out.println("DEL_el: " + intList.delete(20).getValue());
        System.out.println("Lest_size_after_DEL: " + intList.size());


        PartCollection<Integer> found = intList.findByValue(30);
        System.out.println("NEW_el: " + (found != null ? found.getValue() : "null"));


        System.out.println("List_el:");
        while (intList.hasNext()) {
            System.out.println(intList.next().getValue());
        }


        System.out.println("DEL_last_el: " + intList.delete().getValue());
        System.out.println("Lest_size_after_DEL: " + intList.size());
    }
}