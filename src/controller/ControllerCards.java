package controller;

import model.Cards;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerCards {
    private ArrayList<Cards> cards;

    public ControllerCards() {
        cards = new ArrayList<>();
        this.load();
    }

    public void load() {
        try {
            File file = new File("C:\\Users\\flore\\Desktop\\PayPal Plan\\src\\res\\cards.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();
                Cards x = new Cards(text);
                this.cards.add(x);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afisare() {
        for (Cards x : cards) {
            System.out.println(x.descriere());
        }
    }


    public void removeMoneyToCard(float suma, int cardId) {
        for (Cards x : cards) {
            if (x.getCardId() == cardId) {
                float amount = x.getMoney() - suma;
                x.setMoney(amount);
            }
        }
    }


    public void addMoneyToCard(float suma, int cardId) {
        for (Cards x : cards) {
            if (x.getCardId() == cardId) {
                float amount = x.getMoney() + suma;
                x.setMoney(amount);
            }
        }
    }

    public String toSaveCards() {
        String text = "";
        for (Cards e : cards) {
            text += e.toSave() + "\n";
        }
        return text;
    }

    public void save() {
        try {
            File file = new File("C:\\Users\\flore\\Desktop\\PayPal Plan\\src\\res\\cards.txt");
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.print(toSaveCards());

            printWriter.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
