package streamapi;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.Set;


class TaskStreamApiTest {

    private TaskStreamApi taskStreamApi = new TaskStreamApi();

    Set<MyNode> test = new LinkedHashSet<>();

    @BeforeEach
    public void initTest() {
        System.out.println("Start Test");
    }

    @Test
    void addMyNode() {
        taskStreamApi.addMyNode(1, "name1", "example1");
        taskStreamApi.addMyNode(2, "name2", "example2");
        taskStreamApi.addMyNode(3, "name3", "example3");
        taskStreamApi.addMyNode(4, "name4", "example4");

        for (MyNode node : taskStreamApi.getMyNodes()) {
            if (node.getNextNode() != null) {
                System.out.println("Id = " + node.getId() + " nextNode connected with node:" +
                        node.getNextNode());
            } else {
                System.out.println("Id = " + node.getId() + " nextNode value = null!");
            }
            if (node.getPrevNode() != null) {
                System.out.println("Id = " + node.getId() + " prevNode connected with node:" +
                        node.getNextNode());
            } else {
                System.out.println("Id = " + node.getId() + " prevNode value = null!");
            }
        }
    }

    @Test
    void getMyNodes() {
        test = taskStreamApi.getMyNodes();
        Assertions.assertEquals(test, taskStreamApi.getMyNodes());
    }

    @AfterEach
    public void FinishTest() {
        System.out.println("Tests finished!");
    }
}