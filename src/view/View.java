package view;

import controller.ControllerAccounts;
import controller.ControllerCards;
import controller.ControllerUser;
import model.Users;

import java.util.Scanner;

public class View {
    private ControllerAccounts controllerAccounts;
    private ControllerCards controllerCards;
    private ControllerUser controllerUser;
    private Scanner scanner;
    private Users user;

    public View(Users users) {
        this.controllerAccounts = new ControllerAccounts();
        this.controllerCards = new ControllerCards();
        this.controllerUser = new ControllerUser();
        this.scanner = new Scanner(System.in);
        this.user = users;
    }

    public void meniu() {
        System.out.println("=======Welcome " + this.user.getUserFirstName() + "=======");
        System.out.println("Apasa 1 pentru actiunii bancare");
        System.out.println("Apasa 2 pentru modificare date personale");
        System.out.println("Apasa 3 pentru a te deloga");
        System.out.println("======================================================");
    }

    public void play() {
        int choose;
        boolean running = true;
        while (running) {
            meniu();
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    playBank();
                    break;
                case 2:
                    playAccount();
                    break;
                case 3:
                    running = false;
                    break;
            }
        }
        controllerCards.save();
        controllerAccounts.save();
        controllerUser.save();
    }

    public void bankMeniu() {
        System.out.println("=====Tranzactii Bancare ale lui " + this.user.getUserFirstName() + "=======");
        System.out.println("Apasa 1 interogare sold");
        System.out.println("Apasa 2 pentru depunere fonduri");
        System.out.println("Apasa 3 pentru retragere fonduri");
        System.out.println("Apasa 4 pentru a reveni la meniul principal");
        System.out.println("======================================================");
    }


    public void playBank() {
        int choose;
        boolean running = true;
        while (running) {
            bankMeniu();
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    balanceAccount();
                    break;
                case 2:
                    addMoneytoAccount();
                    break;
                case 3:
                    takeOutMoney();
                    break;
                case 4:
                    play();
                    running = false;
                    break;
            }
        }
    }

    public void balanceAccount() {
        float x = controllerAccounts.balanceAccount(user.getUserId());
        System.out.println("Balanta contului dvs: " + x);
    }

    public void addMoneytoAccount() {
        System.out.println("Suma depusa : ");
        float suma = Float.parseFloat(scanner.nextLine());
        controllerAccounts.addMoney(this.user.getUserId(), controllerAccounts.getCardIdByUserId(this.user.getUserId()), suma);
        controllerCards.removeMoneyToCard(suma, controllerAccounts.getCardIdByUserId(this.user.getUserId()));
    }

    public void takeOutMoney() {
        System.out.println("Suma retrasa : ");
        float suma = Float.parseFloat(scanner.nextLine());
        controllerAccounts.takeOutMoney(this.user.getUserId(), controllerAccounts.getCardIdByUserId(this.user.getUserId()), suma);
        controllerCards.addMoneyToCard(suma, controllerAccounts.getCardIdByUserId(this.user.getUserId()));
    }


    public void accountMeniu() {
        System.out.println("=====Modificare Date Persoanel  " + this.user.getUserFirstName() + "=======");
        System.out.println("Apasa 1 pentru a schimba email-ul ");
        System.out.println("Apasa 2 pentru a schimba numarul de telefon");
        System.out.println("Apasa 3 pentru a schimba parola ");
        System.out.println("Apasa 4 pentru a reveni la meniul principal");
        System.out.println("======================================================");
    }

    public void playAccount() {
        int choose;
        boolean running = true;
        while (running) {
            accountMeniu();
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    emailMod();
                    break;
                case 2:
                    phoneMod();
                    break;
                case 3:
                    passwordMod();
                    break;
                case 4:
                    running = false;
                    play();
                    break;
            }
        }
    }

    public void emailMod() {
        System.out.println("Noul Email : ");
        String email = scanner.nextLine();
        controllerUser.modEmail(email, this.user.getUserId());
    }

    public void phoneMod() {
        System.out.println("Noul numar de telefon : ");
        String phone = scanner.nextLine();
        controllerUser.modPhone(phone, this.user.getUserId());
    }

    public void passwordMod() {
        System.out.println("Parola veche : ");
        String oldPassword = scanner.nextLine();
        int x = controllerUser.verifyPassword(oldPassword, this.user.getUserId());
        if (x == 1) {
            System.out.println("Introduceti parola noua : ");
            String newPassword=scanner.nextLine();
            controllerUser.modPassword(newPassword, this.user.getUserId());
        }
    }
}
