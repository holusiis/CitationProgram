import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class GUI_Book extends JFrame {
    JPanel mainPanel = new JPanel(new BorderLayout());
    JPanel centerPanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    JPanel leftPanel = new JPanel();
    JPanel rightPanel = new JPanel();
    JLabel lbSurname = new JLabel("Příjmení:", SwingConstants.LEFT);
    JLabel lbName = new JLabel("Jméno:", SwingConstants.LEFT);
    JLabel lbYear = new JLabel("Rok vydání:", SwingConstants.LEFT);
    JLabel lbNameOfBook = new JLabel("Název knihy:", SwingConstants.LEFT);
    JLabel lbPublisher = new JLabel("Vydavatel:", SwingConstants.LEFT);
    JLabel lbCity = new JLabel("Město vydání:", SwingConstants.LEFT);
    JLabel lbTop = new JLabel("Citace pro knihy - Geografie");
    JTextField txtSurname = new JTextField();
    JTextField txtName = new JTextField();
    JTextField txtYear = new JTextField();
    JTextField txtNameOfBook = new JTextField();
    JTextField txtPublisher = new JTextField();
    JTextField txtCity = new JTextField();
    JTextField txtCitation = new JTextField();
    JButton btnCreate = new JButton("Vytvořit citaci");
    public GUI_Book() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(800, 400));
        this.pack();

        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(txtCitation, BorderLayout.SOUTH);
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.EAST);
        mainPanel.add(lbTop, BorderLayout.NORTH);
        lbTop.setHorizontalAlignment(SwingConstants.CENTER);
        txtCitation.setPreferredSize(new Dimension(800, 30));
        txtCitation.setEditable(false);

        centerPanel.add(lbSurname);
        centerPanel.add(txtSurname);
        centerPanel.add(lbName);
        centerPanel.add(txtName);
        centerPanel.add(lbYear);
        centerPanel.add(txtYear);
        centerPanel.add(lbNameOfBook);
        centerPanel.add(txtNameOfBook);
        centerPanel.add(lbPublisher);
        centerPanel.add(txtPublisher);
        centerPanel.add(lbCity);
        centerPanel.add(txtCity);
        centerPanel.add(bottomPanel);

        bottomPanel.add(btnCreate);
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

        this.setContentPane(mainPanel);
    }
}
