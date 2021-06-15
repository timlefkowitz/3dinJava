import javax.swing.*;
import java.awt.*;

public class Display extends Canvas implements Runnable {
    private Thread thread;
    private JFrame frame;
    private static String title = "3D Renderer";
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static boolean running = false;


    public Display() {
        this.frame = new JFrame();



        Dimension size = new Dimension(WIDTH, HEIGHT);
        this.setPreferredSize(size);
    }


    public synchronized void start(){
        running = true;
        this.thread = new Thread(this, "Display");
        this.thread.start();
    }

    public static void main(String[] args){
        Display display = new Display();
        display.frame.setTitle(title);
        display.frame.add(display);
        display.frame.pack();
        display.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.frame.setLocationRelativeTo(null);
        display.frame.setResizable(false);
        display.frame.setVisible(true);

        display.start();
    }

    public synchronized void stop() throws InterruptedException {
        running = false;
        try{
            this.thread.join();
        }   catch(InterruptedException e){
            e.printStackTrace();
        }
        this.thread.join();

    }


    @Override
    public void run() {

    }


}