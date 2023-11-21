/**
 * @author johnmichael.gerona
 * @created 11/21/23
 */
public class User {
    private String name;
    private String mobileNumber;

    private Double loadBalance;

    public User() {}

    public User(String name, String mobileNumber, Double loadBalance) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.loadBalance = loadBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Double getLoadBalance() {
        return loadBalance;
    }

    public void setLoadBalance(Double loadBalance) {
        this.loadBalance = loadBalance;
    }
}
