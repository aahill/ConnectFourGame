package mediacomp;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2008
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture { 
  
  //---//---//---//---// Constructors //---//---//---//---//
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture () {
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName) {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height) {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture) {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image) {
    super(image);
  }
  
  //---//---//---//---// Methods //---//---//---//---//
  
  /* 
   * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
   * !!! Create new methods here !!!
   * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
   */
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString() 
  {
    String output = "Picture " + getFileName() + 
      ", width = " + getWidth() + 
      ", height = " + getHeight();
    return output;    
  }  
  
  /**
   * Main method for testing
   */
  public static void main(String[] args)
  {
  /* 
   * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
   * !!! Code for testing goes here !!!
   * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
   */
  }
  
} // end of Picture; no code after this point