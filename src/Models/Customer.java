//Sky Florence 1109038 2020-12-10
package Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Customer {
    @SerializedName("id")
    private int id;
    @SerializedName("firstName")
    private String firstName;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("phoneNumber")
    private String phoneNumber;
    @SerializedName("purchases")
    private ArrayList<Product> purchases = new ArrayList<>();

    public Customer(int id, String firstName, String lastName, String phoneNumber, ArrayList<Product> purchases) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setPurchases(purchases);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Product> getPurchases() {
        return purchases;
    }

    public void setPurchases(ArrayList<Product> purchases) {
        this.purchases = purchases;
    }
}
