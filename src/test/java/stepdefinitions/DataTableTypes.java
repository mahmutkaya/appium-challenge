package stepdefinitions;

import io.cucumber.java.DataTableType;
import pojos.Product;
import pojos.Review;

import java.util.Map;

//convert DataTable to Java Object
public class DataTableTypes {

    @DataTableType
    public Product productEntry(Map<String, String> entry) {
        return new Product(
                entry.get("id"),
                entry.get("name"),
                entry.get("description"),
                entry.get("currency"),
                entry.get("price"),
                entry.get("imgUrl")
        );
    }

    @DataTableType
    public Review reviewEntry(Map<String, String> entry) {
        return new Review(
                entry.get("productId"),
                entry.get("locale"),
                entry.get("rating"),
                entry.get("text")
        );
    }
}
