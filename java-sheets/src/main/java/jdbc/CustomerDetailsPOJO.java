package jdbc;

public class CustomerDetailsPOJO {
    private String courseName;
    private String purchasedDate;
    private int amount;
    private String location;

    public String getCourseName() {
        return courseName;
    }

    public String getPurchasedDate() {
        return purchasedDate;
    }

    public int getAmount() {
        return amount;
    }

    public String getLocation() {
        return location;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setPurchasedDate(String purchasedDate) {
        this.purchasedDate = purchasedDate;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "CustomerDetailsPOJO{" +
                "courseName='" + courseName + '\'' +
                ", purchasedDate='" + purchasedDate + '\'' +
                ", amount=" + amount +
                ", location='" + location + '\'' +
                '}';
    }
}
