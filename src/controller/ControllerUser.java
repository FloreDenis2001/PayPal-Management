package controller;

import model.Users;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerUser {
    private ArrayList<Users> users;

    public ControllerUser() {
        users = new ArrayList<>();
        this.load();
    }

    public void load() {
        try {
            File file = new File("C:\\Users\\flore\\Desktop\\PayPal Plan\\src\\res\\users.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();
                Users x = new Users(text);
                this.users.add(x);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afisare() {
        for (Users x : users) {
            System.out.println(x.descriere());
        }
    }

    public Users findById(int id) {
        for (Users x : users) {
            if (x.getUserId() == id) {
                return x;
            }
        }
        return null;
    }

    public void addUser(Users x) {
        Users t = findById(x.getUserId());
        if (t == null) {
            this.users.add(x);
        } else {
            System.out.println("User existent");
        }
    }

    public void removeUser(int id) {
        Users r = findById(id);
        this.users.remove(r);
    }

    public String toSaveUsers() {
        String text = "";
        for (Users e : users) {
            text += e.toSave() + "\n";
        }
        return text;
    }

    public void save() {
        try {
            File file = new File("C:\\Users\\flore\\Desktop\\PayPal Plan\\src\\res\\users.txt");
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.print(toSaveUsers());

            printWriter.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modEmail(String email, int id) {
        Users x = findById(id);
        if (x != null) {
            x.setUserEmail(email);
        } else {
            System.out.println("Nu exista persoana respectiva");
        }
    }

    public void modPhone(String phone, int id) {
        Users x = findById(id);
        if (x != null) {
            x.setUserPhoneNo(phone);
        } else {
            System.out.println("Nu exista persoana respectiva");
        }
    }

    public int verifyPassword(String password, int id) {
        Users x = findById(id);
        if (x != null) {
            if (x.getPassword().equals(password)) {
                return 1;
            }
        }
        return 0;
    }


    public void modPassword(String password, int id) {
        Users x = findById(id);
        if (x != null) {
            x.setPassword(password);

        } else {
            System.out.println("Nu exista persoana respectiva");
        }
    }

    public Users verifyAccount(String password, String email) {
        for (Users x : users) {
            if (x.getPassword().equals(password) && x.getUserEmail().equals(email)) {
                return x;
            }
        }
        return null;
    }

    public int nextId() {

        if (this.users.size() > 0) {

            return this.users.get(this.users.size() - 1).getUserId() + 1;
        }
        return 1;

    }

}
