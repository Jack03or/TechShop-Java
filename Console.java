
/**
 * Write a description of class Console here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Console extends Technology
{
    private String colour;
    private String controller; // create a method to make sure each console gets the correct  controller
    private boolean headset;   // using a boolean so only playstations and xbox can have headsets
    public Console(String  model, String storage, double price, int stock, int timesBought, String colour, String controller, boolean headset)
    {
        super(model, storage, price, stock, timesBought);
        this.colour = colour;
        this.controller = controller;
        this.headset = headset;
    }

    public String getColour()
    {
        return this.colour;
    }

    public void setColour(String colour)
    {
        this.colour = colour;
    }

    public String getController()
    {
        return this.controller;
    }

    public void setController(String controller)
    {
        this.controller = controller;
    }

    public boolean getHeadset()
    {
        return this.headset;
    }

    public void setHeadset(boolean Headset)
    {
        this.headset = headset;
    }

    public String toString()
    {
        String result = super.toString() +
            "\ncolour : " + this.colour +
            "\ncontroller : " + this.controller +
            "\nHeadset : ";
        if ( this.headset == true)
        {
            result = result + "this console comes with a headset";
        }
        else
        {
            result = result + "this console wont come with a headset";  
        }
        return result;
    }

    // public void testToString()
    // {
    // System.out.print("\n");
    // System.out.println(toString());
    // }

}