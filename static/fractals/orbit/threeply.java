/*    Orbit fractal (Threeply) drawing Applet
 *  Copyright (C) 1996, James Henstridge <james@daa.com.au>
 *
 *  This Applet may be freely redistributed, provided that this source code
 *  is also distributed, intact,  with the applet.  This code may also be
 *  used to create other applets, provided credit is given to the
 *  original author (me).
 *
 *  The applet can take the following parameters from the HTML doc:
 *      top, bottom, left and right
 *                        -- sets the bounds for the IFS coordinates used.
 *      dots              -- specifies how many dots to draw.
 *      fgcolor, fgcolour -- specifies the foreground colour to use
 *      bgcolor, bgcolour -- specifies the background colour to use
 *      a, b, c           -- specifies parameters for this fractal
 *
 */

public class threeply extends gingerbread {
  double d = -55.0, e = -1, f = -42;
  
  public void init()
  {
    String s;
  
    t = 2112.0; b = -2112.0; l = -2816.0; r = 2816.0;
    startx = 0.0; starty = 0;
    dots = 65000;
    super.init();
    
    s = getParameter("a");
    if (s != null) d = Double.valueOf(s).doubleValue();
    s = getParameter("b");
    if (s != null) e = Double.valueOf(s).doubleValue();
    s = getParameter("c");
    if (s != null) f = Double.valueOf(s).doubleValue();
  }
  
  public double newX(double x, double y)
  {
    int sgn = (x>0)?1:(x<0)?-1:0;
    
    return y - sgn*Math.abs(Math.sin(x)*Math.cos(e)+f-x*Math.sin(d+e+f));
  }

  public double newY(double x, double y)
  {
    return d - x;
  }

}