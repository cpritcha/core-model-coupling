package net.comses.bmi.examples;

import net.comses.bmi.examples.Point;
import org.nlogo.app.App;
import com.sun.jna.Library;
import com.sun.jna.Native;


public class Example1 {

    public interface CLibrary extends Library {
        Point.ByValue example_get_origin();
    }

    public static void main(String[] argv) {
        System.setProperty("jna.library.path", "../../target/release");
        CLibrary INSTANCE = (CLibrary) Native.loadLibrary("core_model_coupling", CLibrary.class);

        Point.ByValue p = INSTANCE.example_get_origin();
        System.out.println("Point");
        System.out.println(p.x);
        App.main(argv);
        try {
            java.awt.EventQueue.invokeAndWait(
                    new Runnable() {
                        public void run() {
                            try {
                                App.app().open("src/main/netlogo/Fire.nlogo");
                            } catch (java.io.IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
            App.app().command("set density 62");
            App.app().command("random-seed 0");
            App.app().command("setup");
            App.app().command("repeat 50 [ go ]");
            System.out.println(
                    App.app().report("burned-trees"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}