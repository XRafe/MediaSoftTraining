package streamapi2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TaskStreamApi2 {

    public static void main(String[] args) {

    }

    public List transform(Object... collection) {
        List result = Arrays.stream(collection)
                .map(m -> m.toString())
                .collect(Collectors.toList());
        return result;
    }
}
