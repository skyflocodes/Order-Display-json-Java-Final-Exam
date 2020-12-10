package Models;

import com.google.gson.annotations.SerializedName;

public class SearchResult {
    @SerializedName("Customers")
    private Customer[] customers;

    public SearchResult(Customer[] customers) {
        setCustomers(customers);
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public String getTotalResults() {
        int results = getCustomers().length;
        return results + "";
    }
}
