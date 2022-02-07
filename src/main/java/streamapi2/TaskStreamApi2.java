package streamapi2;

import java.util.*;
import java.util.stream.Collectors;

public class TaskStreamApi2 {

    private List<String> list = new ArrayList<>();

    private Set<String> set = new HashSet<>();

    private Map<Integer, String> map = new HashMap();


    public static void main(String[] args) {
        new TaskStreamApi2().actionWithCollections();
    }

    public void actionWithCollections() {
        set.add("email-1");
        set.add("email-2");
        set.add("email-3");

        list.add("email-5");
        list.add("email-6");
        list.add("email-7");

        map.put(1, "email-8");
        map.put(2, "email-9");
        map.put(3, "email-10");

        List result = transform(map, list, set);
        System.out.println(result);
    }

    public List transform(Object... collection) {
        List result = Arrays.stream(collection)
                .map(m -> m.toString())
                .collect(Collectors.toList());
        return result;
    }
}
