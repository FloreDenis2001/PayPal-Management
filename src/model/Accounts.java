package model;

public class Accounts {
    private int accountId;
    private String accountNumber;
    private int cardId;
    private int userId;
    private float accountBalance;

    public Accounts(int accountId, String accountNumber, int cardId, int userId, float accountBalance) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.cardId = cardId;
        this.userId = userId;
        this.accountBalance = accountBalance;
    }

    public Accounts(String text) {
        String[] path = text.split(",");
        this.accountId = Integer.parseInt(path[0]);
        this.accountNumber = path[1];
        this.cardId = Integer.parseInt(path[2]);
        this.userId = Integer.parseInt(path[3]);
        this.accountBalance = Float.parseFloat(path[4]);
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String descriere() {
        String text = "Id : " + this.accountId + "\n";
        text += "IBAN: " + this.accountNumber + "\n";
        text += "Card Id: " + this.cardId + "\n";
        text += "User Id: " + this.userId + "\n";
        text += "Balance: " +this.accountBalance+"\n";
        return text;
    }

    public String toSave() {
        String text = this.accountId + "," + this.accountNumber + "," + this.cardId + "," + this.userId+","+this.accountBalance;
        return text;
    }
}
