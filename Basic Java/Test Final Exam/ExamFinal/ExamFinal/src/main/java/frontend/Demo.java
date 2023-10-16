package frontend;

import utils.ScanerUtils;

public class Demo {
    private static Funcion funcion = new Funcion();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Mời chọn chức năng: ");
            System.out.println("1.Tìm theo ProjectID");
            System.out.println("2.Tìm Manager của Project");
            System.out.println("3.Login");
            System.out.println("4.Logout");


            int chosse = ScanerUtils.inputNumber();

            switch (chosse) {
                case 1:
                    funcion.getByProjectId();
                    break;
                case 2:
                    funcion.getManagerOfProject();
                    break;
                case 3:
                    funcion.login();
                    break;
                case 4:
                    System.out.println("GoodBye!");
                    return;
            }


        }
    }

}
