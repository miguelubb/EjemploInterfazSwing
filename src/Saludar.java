import javax.swing.*;
import java.awt.event.*;

public class Saludar extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel titulo;
    private JTextField tfNombre;
    private JTextField tfA;
    private JTextField tfB;
    private JTextField tfResult;
    private JButton calcularButton;

    public Saludar() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e->onOK());

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        tfNombre.addKeyListener(new KeyAdapter() {
        });
        calcularButton.addActionListener(e -> sumar());
    }

    private void sumar() {
        double a = Double.parseDouble(tfA.getText());
        double b = Double.parseDouble(tfB.getText());
        double d = a+b;
        tfResult.setText(""+d);
    }

    private void onOK() {
        // add your code here
       // dispose();
        String nombre = tfNombre.getText();
        JOptionPane.showMessageDialog(this, "¡Un gusto en conocerte, "+nombre+"!");
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void display(JDialog origen) {
        Saludar dialog = new Saludar();
        dialog.pack();
        dialog.setLocationRelativeTo(origen);
        dialog.setVisible(true);
    }
}
