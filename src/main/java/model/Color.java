package model;

/**
 * Created by oliver on 9/19/17.
 */
public class Color {
    private int red;
    private int blue;
    private int green;

    public Color(int red,  int green,int blue) {
        this.red = red;
        this.blue = blue;
        this.green = green;
    }

    @Override
    public String toString() {
        return "Color{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                '}';
    }

    public int getRed() {

        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }
}
