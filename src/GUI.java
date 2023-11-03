import com.formdev.flatlaf.FlatDarkLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class GUI extends JFrame {
    //private static int whichCitation = 0;
    public static void initialize() {
        FlatDarkLaf.setup();
        JFrame gui = new GUI();
        gui.setVisible(true);
    }
    public static void copyToClipboard(String whatToCopy) {
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection clipboardContent = new StringSelection(whatToCopy);
        clip.setContents(clipboardContent, clipboardContent);
        JOptionPane.showMessageDialog(null, "Citace vytvořena a zkopírována do schránky");
    }
    JPanel bookPanel = new JPanel(new MigLayout());
    //JPanel magazinePanel= new JPanel(new MigLayout("debug"));
    JLabel lbSurname = new JLabel("Příjmení:");
    JLabel lbName = new JLabel("Jméno:");
    JLabel lbYear = new JLabel("Rok vydání:");
    JLabel lbNameOfBook = new JLabel("Název knihy:");
    JLabel lbPublisher = new JLabel("Vydavatel:");
    JLabel lbCity = new JLabel("Město vydání:");
    JTextField txtSurname = new JTextField(80);
    JTextField txtName = new JTextField();
    JTextField txtYear = new JTextField();
    JTextField txtNameOfBook = new JTextField();
    JTextField txtPublisher = new JTextField();
    JTextField txtCity = new JTextField();
    JTextField txtCitation = new JTextField();
    JButton btnCreate = new JButton("Vytvořit citaci");
    JButton btnMagazine = new JButton("Časopis");
    public GUI() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Citační Program - Geografie");
        this.setPreferredSize(new Dimension(600, 280));

        //Layout for bookPanel
        bookPanel.add(lbSurname);
        bookPanel.add(txtSurname, "wrap, span, grow");
        bookPanel.add(lbName);
        bookPanel.add(txtName, "wrap, span, grow");
        bookPanel.add(lbYear);
        bookPanel.add(txtYear, "wrap, span, grow");
        bookPanel.add(lbNameOfBook);
        bookPanel.add(txtNameOfBook, "wrap, span, grow");
        bookPanel.add(lbPublisher);
        bookPanel.add(txtPublisher, "wrap, span, grow");
        bookPanel.add(lbCity);
        bookPanel.add(txtCity, "wrap, span, grow");
        bookPanel.add(btnCreate);
        bookPanel.add(txtCitation, "wrap, span, grow");
        txtCitation.setEditable(false);
        bookPanel.add(btnMagazine);

        //Button functionality
        btnCreate.addActionListener(e -> {
            //Citation creation
            String citation = StringCreation.createBook(txtSurname.getText(), txtName.getText(),
                    txtYear.getText(), txtNameOfBook.getText(), txtPublisher.getText(), txtCity.getText());
            txtCitation.setText(citation);

            copyToClipboard(citation);
        });
        btnMagazine.addActionListener(e -> {

        });

        this.pack();
        this.setContentPane(bookPanel);
    }

}
