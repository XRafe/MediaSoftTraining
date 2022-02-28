package solid;

public class LiskovSubstitution {
    /*not LiskovSubstitution

    public class Birds {
        String actionBird;

        public Birds(String actionBird) {
            this.actionBird= actionBird;
        }

        public String eatGrass() {
            actionBird = "Птичка кушает травку";
            return actionBird;
        }
    }


    public class HunterBirds extends Birds {
        public HunterBirds(String actionBird) {
            super(actionBird);
        }


        public void eatInHome() {
            //Заменяет
            actionBird = "Ест червяка";
            System.out.println(actionBird);
        }
    }*/

    public void init() {
        HomeBirds homeBirds = new HomeBirds("");
        homeBirds.eatInHome();
    }

    public static void main(String[] args) {
        new LiskovSubstitution().init();
    }

    //LiskovSubstitution
    public class Birds {
        String actionBird;

        public Birds(String actionBird) {
            this.actionBird = actionBird;
        }

        public String eatGrass() {
            actionBird = "Птичка кушает травку";
            return actionBird;
        }
    }

    public class HomeBirds extends Birds {
        public HomeBirds(String actionBird) {
            super(actionBird);
        }

        public void eatInHome() {
            //Дополняет
            actionBird = eatGrass();
            actionBird += " сидя у окна";
            System.out.println(actionBird);
        }
    }


}
