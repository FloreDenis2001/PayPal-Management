package controller;

import model.Accounts;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerAccounts {
    private ArrayList<Accounts> accounts;

    public ControllerAccounts() {
        accounts = new ArrayList<>();
        this.load();
    }

    public void load() {
        try {
            File file = new File("C:\\Users\\flore\\Desktop\\PayPal Plan\\src\\res\\accounts.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();
                Accounts x = new Accounts(text);
                this.accounts.add(x);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afisare() {
        for (Accounts a : accounts) {
            System.out.println(a.descriere());
        }
    }

    public Accounts findByUserId(int userid) {
        for (Accounts x : accounts) {
            if (x.getUserId() == userid) {
                return x;
            }
        }
        return null;
    }

    public float balanceAccount(int userId) {
        Accounts x = findByUserId(userId);
        if (x != null) {
            return x.getAccountBalance();
        }
        return 0;
    }

    public Accounts findByUserAndCardId(int cardId, int userid) {
        for (Accounts x : accounts) {
            if (x.getCardId() == cardId && x.getUserId() == userid) {
                return x;
            }
        }
        return null;
    }

    public void addMoney(int userId,int cardId, float suma) {
        Accounts t = findByUserId(userId);
        if (t != null) {
            float amount = suma + t.getAccountBalance();
            t.setAccountBalance(amount);

        }
    }

    public int getCardIdByUserId(int userId) {
        for (Accounts x : accounts) {
            if (x.getUserId() == userId)
                return x.getCardId();
        }
        return 0;
    }


    public void takeOutMoney(int userId, int cardId, float suma) {
        Accounts t = findByUserAndCardId(cardId, userId);
        if (t != null) {
            float amount = t.getAccountBalance() - suma;
            t.setAccountBalance(amount);

        }
    }

    public String toSaveAccounts() {
        String text = "";
        for (Accounts e : accounts) {
            text += e.toSave() + "\n";
        }
        return text;
    }

    public void save() {
        try {
            File file = new File("C:\\Users\\flore\\Desktop\\PayPal Plan\\src\\res\\accounts.txt");
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.print(toSaveAccounts());

            printWriter.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
