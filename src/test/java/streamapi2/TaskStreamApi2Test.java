package streamapi2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

class TaskStreamApi2Test {

    private TaskStreamApi2 tsa = new TaskStreamApi2();

    Set<String> set = new HashSet<>();

    List<String> list = new ArrayList<>();

    Map<Integer, String> map = new HashMap();

    @BeforeEach
    public void initTest() {
        System.out.println("Start Test");
    }


    @Test
    void transform() {
        set.add("email-1");
        set.add("email-2");
        set.add("email-3");

        list.add("email-5");
        list.add("email-6");
        list.add("email-7");

        map.put(1, "email-8");
        map.put(2, "email-9");
        map.put(3, "email-10");

        List result = tsa.transform(list, set, map);
        System.out.println(result);
    }


    @AfterEach
    public void FinishTest() {
        System.out.println("Tests finished!");
    }
}