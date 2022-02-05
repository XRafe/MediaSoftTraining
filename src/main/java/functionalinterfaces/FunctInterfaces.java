package functionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctInterfaces
{
    private List <String> list = new ArrayList<>();

    private List <Integer> intList = new ArrayList<>();



    public static void main (String[] args) {
    System.out.println(new FunctInterfaces().convert(new FunctInterfaces().addList()));
    }

    public List addList() {
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        System.out.println(list);

        return list;
    }

    public List convert(List temp) {

        Function<String, Integer> convertList = x -> Integer.parseInt(x);

        for (int i=0; temp.stream().count() > i; i++) {
            intList.add(convertList.apply((String)temp.get(i)));
        }

        return intList;
    }

}
