package solid;

public class InterfaceSegregation {
    //not InterfaceSegregation
    public interface Animal {
        void fly();

        void swim();

        void run();
    }

    //InterfaceSegregation

    public interface Bird {
        void fly();
    }

    public interface Fish {
        void swim();
    }

    public interface Cat {
        void run();
    }


}
