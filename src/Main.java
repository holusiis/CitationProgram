import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        initialize();
    }

    private static void initialize() {
        FlatDarkLaf.setup();
        JFrame GUI = new GUI();
        GUI.setVisible(true);
    }
}