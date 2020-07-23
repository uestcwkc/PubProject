import java.awt.*;
import java.util.Date;
import java.util.Random;


public class MouseMove {
    private Robot robot;
    private boolean isStop = false;
    private Dimension dim;

    public MouseMove() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        double height = dim.getHeight();
        double width = dim.getWidth();
        int intheight = (int)height;
        int intwidth = (int)width;
        System.out.format("Screen size is %s*%s\n", intwidth, intheight);

        int x = 0;
        int y = 0;

        while (!isStop) {
            Date date = new Date();
            String strdate = date.toString();
            PointerInfo pointerInfo = MouseInfo.getPointerInfo();
            Point p = pointerInfo.getLocation();
            int mx = (int)p.getX();
            int my = (int)p.getY();

            if (x != mx && y != my) {
                System.out.format("%s | Mouse is moving.\n", strdate);
                x = (int)p.getX();
                y = (int)p.getY();
                robot.delay(60000);
            } else {
                Random random = new Random();
                x = random.nextInt(intwidth);
                y = random.nextInt(intheight);
                robot.mouseMove(x, y);
                System.out.format("%s | Mouse has moved to %s*%s;\n", strdate, x, y);
                robot.delay(60000);
            }
        }
    }

    public static void main(String[] args) {
        MouseMove mm = new MouseMove();
        mm.run();
    }
}
