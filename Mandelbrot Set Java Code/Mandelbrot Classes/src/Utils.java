
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;

public class Utils {

  public static Picture createPicture(int width, int height) {
    BufferedImage img = new BufferedImage(width, height,
        BufferedImage.TYPE_INT_RGB);
    return new Picture(img);
  }


  public static boolean savePicture(Picture picture, String destination) {
    try {
      return ImageIO.write(picture.getImage(), "png", new File(destination));
    } catch (IOException e) {
      return false;
    }
  }
}

