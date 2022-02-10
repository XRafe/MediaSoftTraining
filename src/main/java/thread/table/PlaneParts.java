package thread.table;

public class PlaneParts {
    private final Integer checkSize = 50;

    private final String name;

    private Integer[] size;

    private final Integer count;

    public PlaneParts(String name, Integer size, Integer count) {
        this.name = name;
        this.size = new Integer[count];
        this.count = count;
        while (count - 1 >= 0) {
            this.size[count - 1] = size;
            count--;
        }
    }

    public void setSize(Integer size, Integer index) {
        this.size[index] = size;
    }

    public Integer getCheckSize() {
        return checkSize;
    }

    public String getName() {
        return name;
    }

    public Integer[] getSize() {
        return size;
    }

    public Integer getCount() {
        return count;
    }
}
