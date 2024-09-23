
/**
 * Write a description of class Laptops here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Laptops extends Technology
{
    private String processor;
    private int batteryLife = 0;
    private double screenSize = 0;
    
    public Laptops(String  model, String storage, double price, int stock, int timesBought, String processor, int batteryLife, double screenSize)
    {
        super(model, storage, price, stock, timesBought);
        this.processor = processor;
        this.batteryLife = batteryLife;
        this.screenSize = screenSize;
    }
    
     public String getProcessor()
    {
        return this.processor;
    }

    public void setProcessor(String processor)
    {
        this.processor = processor;
    }
    
     public int getBatteryLife()
    {
        return this.batteryLife;
    }

    public void setBatteryLife(int batteryLife)
    {
        this.batteryLife = batteryLife;  
    }
    
    public double getScreenSize()
    {
        return this.screenSize;
    }

    public void setScreenSize(int screenSize)
    {
        this.screenSize = screenSize;  
    }
    
     public String toString()
    {
        String result = super.toString() +
        "\nProcessor : " + this.processor +
        "\nBattery Life: " + this.batteryLife + " hours" +
        "\nScreen Size : " + this.screenSize + " Inch" ;
       
        return result;
    }
    
      // public void testToString()
     // {
        // System.out.print("\n");
        // System.out.println(toString());
    // }

}
