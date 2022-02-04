import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import streamapi2.TaskStreamApi2;

import java.util.ArrayList;
import java.util.List;

public class StreamApi2Test {

    private List<String> list;

    private TaskStreamApi2 taskStreamApi = new TaskStreamApi2();

    @BeforeEach
    public static void initTest() {
        System.out.println("Start Test");

    }


    @Test
    void whenAddNodeOtherType() {
        Assertions.assertNull(new ArrayList<String>(null), "List cannot be null");
    }

    @AfterEach
    public static void FinishTest() {
        System.out.println("Tests finished!");
    }
}
