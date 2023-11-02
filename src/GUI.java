import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class GUI extends JFrame {
    JPanel centerPanel = new JPanel(new MigLayout());
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
    public GUI() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Citační Program - Geografie");
        this.setPreferredSize(new Dimension(600, 250));

        centerPanel.add(lbSurname);
        centerPanel.add(txtSurname, "wrap, span, grow");
        centerPanel.add(lbName);
        centerPanel.add(txtName, "wrap, span, grow");
        centerPanel.add(lbYear);
        centerPanel.add(txtYear, "wrap, span, grow");
        centerPanel.add(lbNameOfBook);
        centerPanel.add(txtNameOfBook, "wrap, span, grow");
        centerPanel.add(lbPublisher);
        centerPanel.add(txtPublisher, "wrap, span, grow");
        centerPanel.add(lbCity);
        centerPanel.add(txtCity, "wrap, span, grow");
        centerPanel.add(btnCreate);
        centerPanel.add(txtCitation, "span, grow");

        btnCreate.addActionListener(e -> {
            //Citation creation
            String citation = StringCreation.createBook(txtSurname.getText(), txtName.getText(),
                    txtYear.getText(), txtNameOfBook.getText(), txtPublisher.getText(), txtCity.getText());
            txtCitation.setText(citation);

            //Copy to clipboard
            Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection clipboardContent = new StringSelection(citation);
            clip.setContents(clipboardContent, clipboardContent);
            JOptionPane.showMessageDialog(null, "Citace vytvořena a zkopírována do schránky");
        });

        this.pack();
        this.setContentPane(centerPanel);
    }
}
