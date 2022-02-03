package streamapi;

public class MyNode {

    private Integer id;

    private String name;

    private String description;

    private MyNode nextNode;

    private MyNode prevNode;

    public MyNode(Integer id, String name, String description, MyNode nextNode, MyNode prevNode) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.nextNode = nextNode;
        this.prevNode = prevNode;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getId() {
        return id;
    }

    public MyNode getNextNode () {
        return nextNode;
    }

    public void setNextNode(MyNode nextNode) {
        this.nextNode = nextNode;
    }

    public MyNode getPrevNode () {
        return prevNode;
    }

    public void setPrevNode(MyNode prevNode) {
        this.prevNode = prevNode;
    }
}
