
/**
 * Write a description of class Technology here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class Technology
{
    private String model;
    private String storage;
    private double price = 0;
    private int stock =0;
    private int timesBought =0;

    public Technology()
    {
        this.model = "";
        this.storage = "";
        this.price = 0;
        this.stock = 0;
       this.timesBought =0;
    }

    public Technology(String model, String storage, double price, int stock, int timesBought )
    {
        this.model = model;
        this.storage = storage;
        this.price = price;
        this.stock = stock;
        this.timesBought = timesBought;
    }

    public String getModel()
    {
        return this.model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getStorage()
    {
        return this.storage;
    }

    public void setStorage(String storage)
    {
        this.storage = storage;
    }  

    public double getPrice()
    {
        return this.price;
    }

    public void setPrice()
    {
        this.price = price;
    }
    
    public int getStock()
    {
        return this.stock;
    }

    public void setStock(int stock)
    {
        this.stock = stock;  
    }
    
     public int getTimesBought()
    {
        return this.timesBought;
    }

    public void setTimesBought(int timesBought)
    {
        this.timesBought = timesBought;  
    }
    
    public String toString()
    {
        return "\nModel : " + this.model +
        "\nStorage : " + this.storage +
        "\nAmount in stock : " + this.stock +
        "\nPrice : " + this.price;
    }
    
    // public void testToString()
    // {
        // System.out.print("\n");
        // System.out.println(toString());
    // }

}
