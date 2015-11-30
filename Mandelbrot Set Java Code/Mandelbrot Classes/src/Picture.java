import java.awt.image.BufferedImage;

public class Picture {

  private final BufferedImage image;

  public Picture(BufferedImage image) {
    this.image = image;
  }

  public BufferedImage getImage() {
    return image;
  }

  public int getWidth() {
    return image.getWidth();
  }

  public int getHeight() {
    return image.getHeight();
  }
  
  public void setPixel(int x, int y, Color rgb) {

    image.setRGB(x, y, 0xff000000 | (((0xff & rgb.getRed()) << 16)
        | ((0xff & rgb.getGreen()) << 8) | (0xff & rgb.getBlue())));
  }

  
  
}
