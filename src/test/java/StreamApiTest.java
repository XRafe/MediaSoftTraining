import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import streamapi.TaskStreamApi;


public class StreamApiTest {

    private final TaskStreamApi taskStreamApi = new TaskStreamApi();

    @BeforeEach
    public static void initTest() {
        System.out.println("Start Test");
    }


    @Test
    void whenAddNodeWithoutName() {
        Assertions.assertNull(taskStreamApi.addMyNode(1, null, "desc1"),
                "Name cannot be null");

    }

    @AfterEach
    public static void FinishTest() {
        System.out.println("Tests finished!");
    }
}
