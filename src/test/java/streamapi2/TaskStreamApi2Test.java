package streamapi2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TaskStreamApi2Test {

    private TaskStreamApi2 tsa = new TaskStreamApi2();

    Set<String> set = new HashSet<>();

    List<String> list = new ArrayList<>();


    @BeforeEach
    public void initTest() {
        System.out.println("Start Test");
    }


    @Test
    void transform() {
        set.add("email-1");
        set.add("email-2");

        list.add("email-5");
        list.add("email-6");

        List result = tsa.transform(list, set);
        System.out.println(result);
    }


    @AfterEach
    public void FinishTest() {
        System.out.println("Tests finished!");
    }
}