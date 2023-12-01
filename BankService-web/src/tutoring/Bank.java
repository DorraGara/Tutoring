package tutoring;

public class Bank {

    private String userId;
    private long funds;
    private String currency;

    public String getUserId() {
        return userId;
    }

    public Bank(String userId, long funds, String currency) {
        super();
        this.userId = userId;
        this.funds = funds;
        this.currency = currency;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getFunds() {
        return funds;
    }

    public void setFunds(long funds) {
        this.funds = funds;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
