package solid;

public class DependencyInversion {
    /*not DependencyInversion
    public class General {
        Birds birds = new Birds();
        HunterBirds hunterBirds = new HunterBirds();
    }

    public class Birds {

    }

    public class HunterBirds {

    }*/

    //DependencyInversion
    public class General {
        Bird bird = new Birds();

        public void main() {
            System.out.println(bird.action());
            bird = new HunterBirds();
            System.out.println(bird.action());
        }

    }

    public interface Bird {
        String action();
    }

    public class Birds implements Bird {
        public String action() {
            return "Кушает травку";
        }
    }

    public class HunterBirds implements Bird {
        public String action() {
            return "Охотится за червяком";
        }
    }

}
