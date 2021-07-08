package pojos;

public class Product {

    private String id;
    private String name;
    private String description;
    private String currency;
    private double price;
    private String imgUrl;

    public Product(){}

    //use this constructor to convert DataTable to Java Object with cucumber DataTableType
    //it accepts Map<String,String> ...
    public Product(String id, String name, String description, String currency, String price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.currency = currency;
        this.price = price!=null ? Double.parseDouble(price) : 0;
        this.imgUrl = imgUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
