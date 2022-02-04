import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import streamapi.TaskStreamApi;

public class StreamApiTest {

    private TaskStreamApi taskStreamApi = new TaskStreamApi();

    @BeforeEach
    public static void initTest() {
        System.out.println("Start Test");
    }


    @Test
    void whenAddNodeWithoutName() {
        Assertions.fail("Name cannot be null");
        Assertions.fail((Throwable) taskStreamApi.addMyNode(1, null, "desc1"));
    }

    @AfterEach
    public static void FinishTest() {
        System.out.println("Tests finished!");
    }
}
