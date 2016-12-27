package category;

/**
 * Created by JohnWu on 2016-12-20.
 */
public class Item {

    private int id;
    private String name;
    private String description;
    private String priceSmall;
    private String priceLarge;
    private boolean isSpicy;

    public Item() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPriceSmall() {
        return priceSmall;
    }

    public void setPriceSmall(String priceSmall) {
        this.priceSmall = priceSmall;
    }

    public String getPriceLarge() {
        return priceLarge;
    }

    public void setPriceLarge(String priceLarge) {
        this.priceLarge = priceLarge;
    }

    public boolean isSpicy() {
        return isSpicy;
    }

    public void setSpicy(boolean spicy) {
        isSpicy = spicy;
    }
}
