package model;

public class Cards {
    private int cardId;
    private String cardNumber;
    private String name;
    private String dateOfExpiration;
    private int cvv;
    private float money;

    public Cards(int cardId, String cardNumber, String name, String dateOfExpiration, int cvv, float money) {
        this.cardId = cardId;
        this.cardNumber = cardNumber;
        this.name = name;
        this.dateOfExpiration = dateOfExpiration;
        this.cvv = cvv;
        this.money = money;
    }

    public Cards(String text) {
        String[] path = text.split(",");
        this.cardId = Integer.parseInt(path[0]);
        this.cardNumber = path[1];
        this.name = path[2];
        this.dateOfExpiration = path[3];
        this.cvv = Integer.parseInt(path[4]);
        this.money = Float.parseFloat(path[5]);
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfExpiration() {
        return dateOfExpiration;
    }

    public void setDateOfExpiration(String dateOfExpiration) {
        this.dateOfExpiration = dateOfExpiration;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String descriere() {
        String text = "Id : " + this.cardId + "\n";
        text += "Card Number: " + this.cardNumber + "\n";
        text += "Type: " + this.name + "\n";
        text += "Date Of Expiration : " + this.dateOfExpiration + "\n";
        text += "CVV : " + this.cvv + "\n";
        text += "Money: " + this.money + "\n";
        return text;
    }

    public String toSave() {
        String text = this.cardId + "," + this.cardNumber + "," + this.name + "," + this.dateOfExpiration + "," + this.cvv + "," + this.money;
        return text;
    }
}
