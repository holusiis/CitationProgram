import com.formdev.flatlaf.FlatDarkLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class GUI extends JFrame {
    private static void copyToClipboard(String whatToCopy) {
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection clipboardContent = new StringSelection(whatToCopy);
        clip.setContents(clipboardContent, clipboardContent);
        JOptionPane.showMessageDialog(null, "Citace vytvořena a zkopírována do schránky");
    }
    Container c;
    CardLayout card = new CardLayout(10, 0);
    //Book panel and it's components
    JPanel bookPanel = new JPanel(new MigLayout());
    JPanel buttonsPanelBook = new JPanel();
    JTextField txtSurnameMagazine = new JTextField(80);
    JTextField txtNameBook = new JTextField();
    JTextField txtYearBook = new JTextField();
    JTextField txtNameOfBook = new JTextField();
    JTextField txtPublisher = new JTextField();
    JTextField txtCityBook = new JTextField();
    JTextField txtCitationBook = new JTextField();
    JButton btnCreateBook = new JButton("Vytvořit citaci");
    JButton btnBookBook = new JButton("Kniha");
    JButton btnMagazineBook = new JButton("Časopis");
    //Magazine panel and it's components
    JPanel magazinePanel= new JPanel(new MigLayout());
    JPanel buttonsPanelMagazine = new JPanel();
    JTextField txtSurnameBook = new JTextField(80);
    JTextField txtNameMagazine = new JTextField();
    JTextField txtYearMagazine = new JTextField();
    JTextField txtNameOfArticle = new JTextField();
    JTextField txtNameOfMagazine = new JTextField();
    JTextField txtVolume = new JTextField();
    JTextField txtIssue = new JTextField();
    JTextField txtPages = new JTextField();
    JTextField txtCitationMagazine = new JTextField();
    JButton btnCreateMagazine = new JButton("Vytvořit citaci");
    JButton btnBookMagazine = new JButton("Kniha");
    JButton btnMagazineMagazine = new JButton("Časopis");
    private GUI() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Citační Program - Geografie");
        this.setPreferredSize(new Dimension(600, 340));
        this.setLocationRelativeTo(null);
        buttonFunctionalityBook();
        buttonFunctionalityMagazine();
        setComponentsBook();
        setComponentsMagazine();
        setContainer();
        this.pack();
    }
    private void setContainer() {
        c = getContentPane();
        c.setLayout(card);
        c.add("book" ,bookPanel);
        c.add("magazine", magazinePanel);
    }
    private void setComponentsBook() {
        bookPanel.add(new JLabel("Příjmení:"));
        bookPanel.add(txtSurnameBook, "wrap, span, grow");
        bookPanel.add(new JLabel("Jméno:"));
        bookPanel.add(txtNameBook, "wrap, span, grow");
        bookPanel.add(new JLabel("Rok vydání:"));
        bookPanel.add(txtYearBook, "wrap, span, grow");
        bookPanel.add(new JLabel("Název knihy:"));
        bookPanel.add(txtNameOfBook, "wrap, span, grow");
        bookPanel.add(new JLabel("Vydavatel:"));
        bookPanel.add(txtPublisher, "wrap, span, grow");
        bookPanel.add(new JLabel("Místo vydání:"));
        bookPanel.add(txtCityBook, "wrap, span, grow");
        bookPanel.add(btnCreateBook);
        bookPanel.add(txtCitationBook, "wrap, span, grow");
        txtCitationBook.setEditable(false);
        buttonsPanelBook.add(btnBookBook);
        buttonsPanelBook.add(btnMagazineBook);
        bookPanel.add(buttonsPanelBook, "dock north");
    }
    private void setComponentsMagazine() {
        magazinePanel.add(new JLabel("Příjmení:"));
        magazinePanel.add(txtSurnameMagazine, "wrap, span, grow");
        magazinePanel.add(new JLabel("Jméno:"));
        magazinePanel.add(txtNameMagazine, "wrap, span, grow");
        magazinePanel.add(new JLabel("Rok vydání:"));
        magazinePanel.add(txtYearMagazine, "wrap, span, grow");
        magazinePanel.add(new JLabel("Název článku:"));
        magazinePanel.add(txtNameOfArticle, "wrap, span, grow");
        magazinePanel.add(new JLabel("Časopis:"));
        magazinePanel.add(txtNameOfMagazine, "wrap, span, grow");
        magazinePanel.add(new JLabel("Ročník:"));
        magazinePanel.add(txtVolume, "wrap, span, grow");
        magazinePanel.add(new JLabel("Číslo vydání:"));
        magazinePanel.add(txtIssue, "wrap, span, grow");
        magazinePanel.add(new JLabel("Rozsah stran:"));
        magazinePanel.add(txtPages, "wrap, span, grow");
        magazinePanel.add(btnCreateMagazine);
        magazinePanel.add(txtCitationMagazine, "wrap, span, grow");
        txtCitationMagazine.setEditable(false);
        buttonsPanelMagazine.add(btnBookMagazine);
        buttonsPanelMagazine.add(btnMagazineMagazine);
        magazinePanel.add(buttonsPanelMagazine, "dock north");
    }
    private void buttonFunctionalityBook() {
        btnCreateBook.addActionListener(e -> {
            //Citation creation
            String citation = StringCreation.createBook(txtSurnameBook.getText(), txtNameBook.getText(),
                    txtYearBook.getText(), txtNameOfBook.getText(), txtPublisher.getText(), txtCityBook.getText());
            txtCitationBook.setText(citation);

            copyToClipboard(citation);
        });
        btnBookBook.addActionListener(e -> card.show(c, "book"));
        btnMagazineBook.addActionListener(e -> card.show(c, "magazine"));
    }
    private void buttonFunctionalityMagazine() {
        btnCreateMagazine.addActionListener(e -> {
            String citation = StringCreation.createMagazine(txtSurnameMagazine.getText(), txtNameMagazine.getText(),
                    txtYearMagazine.getText(), txtNameOfArticle.getText(), txtNameOfMagazine.getText(), txtVolume.getText(),
                    txtIssue.getText(), txtPages.getText());
            txtCitationMagazine.setText(citation);
            copyToClipboard(citation);
        });
        btnBookMagazine.addActionListener(e -> card.show(c, "book"));
        btnMagazineMagazine.addActionListener(e -> card.show(c, "magazine"));
    }
    public static void initialize() {
        FlatDarkLaf.setup();
        JFrame gui = new GUI();
        gui.setVisible(true);
    }
}
