package streamapi;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.Set;


class TaskStreamApiTest {


    Set<MyNode> test = new LinkedHashSet<>();

    private TaskStreamApi taskStreamApi = new TaskStreamApi();
    @BeforeEach
    public static void initTest() {
        System.out.println("Start Test");
    }

    @Test
    void addMyNode() {
        taskStreamApi.addMyNode(1, "name1", "example");
        taskStreamApi.addMyNode(2, "name2", "example");
        taskStreamApi.addMyNode(3, "name3", "example");

    }



    @AfterEach
    public static void FinishTest() {
        System.out.println("Tests finished!");
    }
}