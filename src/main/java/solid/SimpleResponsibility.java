package solid;

import java.util.HashSet;
import java.util.Set;

public class SimpleResponsibility {
    /*not SimpleResponsibility
    public class Birds {
        private Set<Birds> birds = new HashSet<>();

        private String name;

        private String size;

        public Birds(String name, String size) {
            this.name = name;
            this.size = size;
        }

        public String getName() {
            return name;
        }

        public String getSize() {
            return size;
        }

        public void addBirdAndView(String name, String size) {
            birds.add(new Birds(name, size));
            System.out.println(birds);
        }

    }*/

    //SimpleResponsibility
    public class Birds {
        private String name;

        private String size;

        public Birds(String name, String size) {
            this.name = name;
            this.size = size;
        }

        public String getName() {
            return name;
        }

        public String getSize() {
            return size;
        }

    }

    public class DataBirds {
        private Set<Birds> birds = new HashSet<>();

        public void addBird(String name, String size) {
            birds.add(new Birds(name, size));
        }

        public Set<Birds> getBirds() {
            return birds;
        }
    }

}
