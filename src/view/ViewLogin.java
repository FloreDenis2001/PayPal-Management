package view;

import controller.ControllerUser;
import model.Users;

import java.util.Scanner;

public class ViewLogin {
    private ControllerUser controllerUser;
    private Scanner scanner;

    public ViewLogin(){
        this.controllerUser=new ControllerUser();
        this.scanner=new Scanner(System.in);
    }

    public void meniu() {
        System.out.println("-----------------------LOGIN-------------------");
        System.out.println("Apasa 1 pentru a te loga");
        System.out.println("Apasa 2 pentru a te inregistra");
        System.out.println("Apasa 3 pentru a iesi");
        System.out.println("-----------------------------------------------");
    }

    public void play() {
        int c;
        boolean running = true;
        while (running) {
            meniu();
            c = Integer.parseInt(scanner.nextLine());
            switch (c) {
                case 1:
                    login();
                    break;
                case 2:
                    registration();
                    break;
                case 3: running=false;
                    break;
            }
        }
    }

    public void login() {
        System.out.println("Introduceti numele utilizatorului : ");
        String email = scanner.nextLine();
        System.out.println("Introduceti parola : ");
        String password = scanner.nextLine();


        Users x = controllerUser.verifyAccount(password,email);

        if (x!=null) {

            View view = new View(x);
            view.play();

        } else {

            System.out.println("Credentialele dvs sunt incorecte");
        }


    }


    public void registration() {
        System.out.println("Phone Number : ");
        String phone=scanner.nextLine();
        System.out.println("Introduceti Nume : ");
        String nume = scanner.nextLine();
        System.out.println("Introduceti Prenume :");
        String prenume = scanner.nextLine();
        System.out.println("Introduceti Email : ");
        String email = scanner.nextLine();
        System.out.println("Introduceti parola : ");
        String password = scanner.nextLine();
        System.out.println("Introduceti address : ");
        String address=scanner.nextLine();
        System.out.println("Anul nasteri: ");
        int age=Integer.parseInt(scanner.nextLine());
        controllerUser.addUser(new Users(controllerUser.nextId(),phone,email,prenume,nume,age,address,password));
        play();
    }


}
