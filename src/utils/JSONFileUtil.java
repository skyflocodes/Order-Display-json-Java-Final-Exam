//Sky Florence 1109038 2020-12-10
package utils;

import Models.Customer;
import Models.SearchResult;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class JSONFileUtil {
    /**
     * get an array list of type player fom the json entered
     * @param jsonFileName
     * @return
     */
    public static ArrayList<Customer> getCustomers(String jsonFileName)
    {
        ArrayList<Customer> customers = new ArrayList<>();
        Gson gson = new Gson();
        try(
                FileReader fileReader = new FileReader(jsonFileName);
                JsonReader jsonReader = new JsonReader(fileReader);
                )
        {
            SearchResult searchResult = gson.fromJson(jsonReader,SearchResult.class);
            customers.addAll(Arrays.asList(searchResult.getCustomers()));
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return customers;
    }
}
