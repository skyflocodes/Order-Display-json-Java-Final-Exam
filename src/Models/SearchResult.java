package Models;

import com.google.gson.annotations.SerializedName;

public class SearchResult {
    @SerializedName("Customers")
    private Customer[] customers;

    private String totalResults;

    public SearchResult(Customer[] customers, String totalResults) {
        setCustomers(customers);
        setTotalResults(totalResults);
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }
}
