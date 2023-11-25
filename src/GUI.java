import com.formdev.flatlaf.FlatDarkLaf;
import net.miginfocom.swing.MigLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;

public class GUI extends JFrame {
    public static void initialize() {
        FlatDarkLaf.setup();
        JFrame gui = new GUI();
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
    }
    Container c;
    CardLayout card = new CardLayout(10, 0);
    //Menu
    JMenuBar menuBar = new JMenuBar();
    JMenuItem mnBook = new JMenuItem("Kniha");
    JMenuItem mnMagazine = new JMenuItem("Časopis");
    JMenuItem mnChapter = new JMenuItem("Kapitola");
    JMenuItem mnWeb = new JMenuItem("Web");
    //Book panel and it's components
    JPanel bookPanel = new JPanel(new MigLayout());
    JTextField txtSurnameBook = new JTextField(80);
    JTextField txtNameBook = new JTextField();
    JTextField txtYearBook = new JTextField();
    JTextField txtNameOfBook = new JTextField();
    JTextField txtPublisherBook = new JTextField();
    JTextField txtCityBook = new JTextField();
    JTextField txtCitationBook = new JTextField();
    JButton btnCreateBook = new JButton("Vytvořit citaci");
    //Magazine panel and it's components
    JPanel magazinePanel= new JPanel(new MigLayout());
    JTextField txtSurnameMagazine = new JTextField(80);
    JTextField txtNameMagazine = new JTextField();
    JTextField txtYearMagazine = new JTextField();
    JTextField txtNameOfArticle = new JTextField();
    JTextField txtNameOfMagazine = new JTextField();
    JTextField txtVolume = new JTextField();
    JTextField txtIssue = new JTextField();
    JTextField txtPages = new JTextField();
    JTextField txtCitationMagazine = new JTextField();
    JButton btnCreateMagazine = new JButton("Vytvořit citaci");
    //Chapter panel and it's components
    JPanel chapterPanel = new JPanel(new MigLayout());
    JTextField txtSurnameChapter = new JTextField(80);
    JTextField txtNameChapter = new JTextField();
    JTextField txtYearChapter = new JTextField();
    JTextField txtNameOfChapter = new JTextField();
    JTextField txtSurnameEditor = new JTextField();
    JTextField txtNameEditor = new JTextField();
    JTextField txtNameOfBookChapter = new JTextField();
    JTextField txtPublisherChapter = new JTextField();
    JTextField txtCityChapter = new JTextField();
    JTextField txtPagesChapter = new JTextField();
    JTextField txtCitationChapter = new JTextField();
    JCheckBox chcbEditor = new JCheckBox();
    JButton btnCreateChapter = new JButton("Vytvořit citaci");
    //Web
    JPanel webPanel = new JPanel(new MigLayout());
    JTextField txtSurnameWeb = new JTextField(80);
    JTextField txtCitationWeb = new JTextField();
    JTextField txtNameWeb = new JTextField();
    JTextField txtOrganisationShortcut = new JTextField(80);
    JTextField txtOrganisationName = new JTextField();
    JTextField txtYearWeb = new JTextField(80);
    JTextField txtNameOfArticleWeb = new JTextField();
    JTextField txtLink = new JTextField();
    ButtonGroup webAuthor = new ButtonGroup();
    JRadioButton rbtnAuthor = new JRadioButton("Autor");
    JRadioButton rbtnOrganisation = new JRadioButton("Organizace");
    JCheckBox chcbOrganisationName = new JCheckBox();
    JButton btnCreateWeb = new JButton("Vytvořit citaci");
    private GUI() {
        this.setTitle("Citační program");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(700, 255));
        this.setResizable(false);
        try {
            this.setIconImage(ImageIO.read(new File("res/icon.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setContainer();
        setComponentsMenu();
        setComponentsBook();
        setComponentsMagazine();
        setComponentsChapter();
        setComponentsWeb();
        menuFunctionality();
        buttonFunctionalityCitation();
        this.pack();
    }
    private void setContainer() {
        c = getContentPane();
        c.setLayout(card);
        c.add("book" ,bookPanel);
        c.add("magazine", magazinePanel);
        c.add("chapter", chapterPanel);
        c.add("web", webPanel);
    }
    private void setComponentsMenu() {
        this.setJMenuBar(menuBar);
        menuBar.add(mnBook);
        menuBar.add(mnMagazine);
        menuBar.add(mnChapter);
        menuBar.add(mnWeb);
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
        bookPanel.add(txtPublisherBook, "wrap, span, grow");
        bookPanel.add(new JLabel("Místo vydání:"));
        bookPanel.add(txtCityBook, "wrap, span, grow");
        bookPanel.add(btnCreateBook);
        bookPanel.add(txtCitationBook, "wrap, span, grow");
        txtCitationBook.setEditable(false);
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
    }
    private void setComponentsChapter() {
        chapterPanel.add(new JLabel("Příjmení:"));
        chapterPanel.add(txtSurnameChapter, "wrap, span, grow");
        chapterPanel.add(new JLabel("Jméno:"));
        chapterPanel.add(txtNameChapter, "wrap, span, grow");
        chapterPanel.add(new JLabel("Rok vydání:"));
        chapterPanel.add(txtYearChapter, "wrap, span, grow");
        chapterPanel.add(new JLabel("Název kapitoly:"));
        chapterPanel.add(txtNameOfChapter, "wrap, span, grow");
        chapterPanel.add(new JLabel("Editor"));
        chapterPanel.add(chcbEditor);
        chapterPanel.add(new JLabel("Je editor jiný než autor?"), "wrap");
        chapterPanel.add(new JLabel("Příjmení"));
        chapterPanel.add(txtSurnameEditor, "wrap, span, grow");
        chapterPanel.add(new JLabel("Jméno:"));
        chapterPanel.add(txtNameEditor, "wrap, span, grow");
        chapterPanel.add(new JLabel("Název knihy:"));
        chapterPanel.add(txtNameOfBookChapter, "wrap, span, grow");
        chapterPanel.add(new JLabel("Nakladatelství:"));
        chapterPanel.add(txtPublisherChapter, "wrap, span, grow");
        chapterPanel.add(new JLabel("Město:"));
        chapterPanel.add(txtCityChapter, "wrap, span, grow");
        chapterPanel.add(new JLabel("Rozsah:"));
        chapterPanel.add(txtPagesChapter, "wrap, span, grow");
        chapterPanel.add(btnCreateChapter);
        chapterPanel.add(txtCitationChapter, "wrap, span, grow");
        txtCitationChapter.setEditable(false);
    }
    private void setComponentsWeb() {
        webAuthor.add(rbtnAuthor);
        rbtnAuthor.setSelected(true);
        webAuthor.add(rbtnOrganisation);
        webPanel.add(rbtnAuthor, "span 3");
        webPanel.add(rbtnOrganisation, "wrap, span");
        webPanel.add(new JLabel("Příjmení:"));
        webPanel.add(txtSurnameWeb, "span 2");
        webPanel.add(new JLabel("Zkratka:"), "split");
        webPanel.add(txtOrganisationShortcut, "wrap, span, grow");
        txtOrganisationShortcut.setEditable(false);
        webPanel.add(new JLabel("Jméno:"));
        webPanel.add(txtNameWeb, "span 2, grow");
        webPanel.add(chcbOrganisationName, "split");
        chcbOrganisationName.setEnabled(false);
        webPanel.add(new JLabel("Název:"));
        webPanel.add(txtOrganisationName, "wrap, span, grow");
        txtOrganisationName.setEditable(false);
        webPanel.add(new JLabel("Rok:"));
        webPanel.add(txtYearWeb, "wrap, span, grow");
        webPanel.add(new JLabel("Název článku:"));
        webPanel.add(txtNameOfArticleWeb, "wrap, span, grow");
        webPanel.add(new JLabel("Odkaz:"));
        webPanel.add(txtLink, "wrap, span, grow");
        webPanel.add(btnCreateWeb);
        webPanel.add(txtCitationWeb, "wrap, span, grow");
        txtCitationWeb.setEditable(false);
    }
    private void menuFunctionality() {
        mnBook.addActionListener(e -> {
            card.show(c, "book");
            this.setSize(700, 255);
        });
        mnMagazine.addActionListener(e -> {
            card.show(c, "magazine");
            this.setSize(700, 310);
        });
        mnChapter.addActionListener(e -> {
            card.show(c, "chapter");
            this.setSize(700, 395);
        });
        mnWeb.addActionListener(e -> {
            card.show(c, "web");
            this.setSize(700, 255);
        });
    }
    private static void copyToClipboard(String whatToCopy) {
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection clipboardContent = new StringSelection(whatToCopy);
        clip.setContents(clipboardContent, clipboardContent);
        JOptionPane.showMessageDialog(null, "Citace vytvořena a zkopírována do schránky");
    }
    private void buttonFunctionalityCitation() {
        btnCreateBook.addActionListener(e -> {
            //Citation creation
            String citation = StringCreation.createBook(txtSurnameBook.getText(), txtNameBook.getText(),
                    txtYearBook.getText(), txtNameOfBook.getText(), txtPublisherBook.getText(), txtCityBook.getText());
            txtCitationBook.setText(citation);
            copyToClipboard(citation);
        });
        btnCreateMagazine.addActionListener(e -> {
            //Citation creation
            String citation = StringCreation.createMagazine(txtSurnameMagazine.getText(), txtNameMagazine.getText(),
                    txtYearMagazine.getText(), txtNameOfArticle.getText(), txtNameOfMagazine.getText(), txtVolume.getText(),
                    txtIssue.getText(), txtPages.getText());
            txtCitationMagazine.setText(citation);
            copyToClipboard(citation);
        });
        btnCreateChapter.addActionListener(e -> {
            //Citation creation
            String citation = StringCreation.createChapter(txtSurnameChapter.getText(), txtNameChapter.getText(), txtYearChapter.getText(),
                    txtNameOfChapter.getText(), chcbEditor.isSelected(), txtSurnameEditor.getText(), txtNameEditor.getText(),
                    txtNameOfBookChapter.getText(), txtPublisherChapter.getText(), txtCityChapter.getText(), txtPagesChapter.getText());
            txtCitationChapter.setText(citation);
            copyToClipboard(citation);
        });
        btnCreateWeb.addActionListener(e -> {
            //Citation creation
            String citation = StringCreation.createWeb(rbtnAuthor.isSelected(), chcbOrganisationName.isSelected(), txtSurnameWeb.getText(),
                    txtNameWeb.getText(), txtOrganisationShortcut.getText(), txtOrganisationName.getText(), txtYearWeb.getText(),
                    txtNameOfArticleWeb.getText(), txtLink.getText());
            txtCitationWeb.setText(citation);
            copyToClipboard(citation);
        });
        rbtnAuthor.addActionListener(e -> {
            txtSurnameWeb.setEditable(true);
            txtNameWeb.setEditable(true);
            txtOrganisationShortcut.setEditable(false);
            txtOrganisationName.setEditable(false);
            chcbOrganisationName.setEnabled(false);
            chcbOrganisationName.setSelected(false);
        });
        rbtnOrganisation.addActionListener(e -> {
            txtSurnameWeb.setEditable(false);
            txtNameWeb.setEditable(false);
            txtOrganisationShortcut.setEditable(true);
            chcbOrganisationName.setEnabled(true);
        });
        chcbOrganisationName.addActionListener(e -> txtOrganisationName.setEditable(chcbOrganisationName.isSelected()));
    }
}
