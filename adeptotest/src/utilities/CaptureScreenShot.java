package utilities;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;

public class CaptureScreenShot {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh mm ss a");

			    public void robo() throws Exception 
			    {
			        Calendar now = Calendar.getInstance();
			        Robot robot = new Robot();
			        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			        String localDir = System.getProperty("user.dir");    
			        ImageIO.write(screenShot, "JPG", new File(localDir+"//"+formatter.format(now.getTime())+".jpg"));
			        System.out.println(formatter.format(now.getTime()));
			    }

			    public static void main(String[] args) throws Exception
			    {
			    	CaptureScreenShot s2i = new CaptureScreenShot();
			        	s2i.robo();
			            Thread.sleep(10000);
			        
			    }
			

}
