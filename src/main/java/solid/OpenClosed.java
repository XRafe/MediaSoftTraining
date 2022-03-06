package solid;

public class OpenClosed {
    /* not OpenClosed
    public class ActionBirds {

        public void flyBird() {
            System.out.println("Птичка летит");
            //Нужно описание птицы:
            System.out.println("Воробей");
        }

    }*/

    //OpenClosed
    public class ActionBirds {
        public String message = "";


        public ActionBirds(String message) {
            this.message = message;
        }

        public void flyBird() {
            message = "Птичка летит";
            System.out.println(message);
        }

    }


    public class AboutBirds extends ActionBirds {

        public AboutBirds(String message) {
            super(message);
            flyBird();
        }

        public void colorBird() {
            message += " её цвет черный";
            System.out.println(message);
        }

        public void NameBird() {
            message += " её называют воробей";
            System.out.println(message);
        }

    }

}
