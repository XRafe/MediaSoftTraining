package streamapi;


import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TaskStreamApi {

    private Set<MyNode> myNodes = new LinkedHashSet<>();


    public static void main(String[] args) {
        new TaskStreamApi().actionWithMyNode();
    }

    public void actionWithMyNode () {
        addMyNode(0,"Car", "Lada");
        addMyNode(1, "PC", "HP");
        addMyNode(2, "PC", "ASUS");
        addMyNode(3, "PC", "XIAOMI");
        addMyNode(4, "PC", "ACER");
        addMyNode(5, "Car", "KIA");
        addMyNode(6, "Car", "FIAT");
        addMyNode(7,"Phone", "Xiaomi");
        addMyNode(8, "Phone", "ACER");
        addMyNode(9, "Phone", "ASUS");
        addMyNode(10, "PC", "MSI");
        addMyNode(11, "PC", "LENOVO");
        addMyNode(12, "Phone", "IPhone");
        addMyNode(13, "PC", "BENQ");

        //Фильтр
        myNodes.stream().filter(f -> f.getId() > 10)
                .map(m -> m.getName() + " " + m.getDescription())
                .forEach(s -> System.out.println(s));

        //Кол-во Name
        Map<Object, Long> countName = myNodes.stream().collect(Collectors.groupingBy(g -> g.getName(),
                Collectors.counting()));
        for (Map.Entry<Object, Long> item: countName.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue());
        }

        //Из Set в Map
        Map<Integer, Object> toMap = myNodes.stream()
                .collect(Collectors.toMap(MyNode::getId, o -> o.getName() + " " + o.getDescription()));

        toMap.forEach((o, i) -> System.out.println(o + " - " + i));

        //Сортировка

        List result = myNodes.stream()
                .sorted((s1, s2) -> s2.getId()
                        .compareTo(s1.getId())).map(m -> m.getId() + " " + m.getName() + " " + m.getDescription())
                .collect(Collectors.
                        toList());

        System.out.println(result);

        //Вывод нодов
        String Ent = myNodes.stream()
                .map(m -> "<- " + m.getName() + " " + m.getDescription() + " ->")
                .reduce(" ", String::concat);

        System.out.println(Ent);
    }


    public Set<MyNode> addMyNode(Integer id, String name, String descriptions) {
        myNodes.add(new MyNode(id, name, descriptions, null, null));
        for (MyNode myNode: myNodes) {
            if (myNode.getId() == id - 1) {
                for (MyNode tempMyNode: myNodes) {
                    if (tempMyNode.getId() == id) {
                        myNode.setNextNode(tempMyNode);
                    }
                }
            }
        }
        for (MyNode myNode: myNodes) {
            if (myNode.getId() == id) {
                for (MyNode tempMyNode: myNodes) {
                    if (tempMyNode.getId() == id - 1) {
                        myNode.setPrevNode(tempMyNode);
                    }
                }
            }
        }
        return myNodes;
    }


}
