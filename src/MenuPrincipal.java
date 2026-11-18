import javax.swing.*;
import java.awt.event.*;

public class MenuPrincipal extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton ejemploDeSaludoButton;
    private JButton ejemploDeRadioButtonButton;
    private JButton pendienteButton;
    private JButton salirButton;

    public MenuPrincipal() {
        setContentPane(contentPane);
        setModal(true);
        salirButton.addActionListener(e-> onCancel());


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
        ejemploDeSaludoButton.addActionListener(e-> Saludar.display(this));
        ejemploDeRadioButtonButton.addActionListener(e-> EjemploRadioButtom.display(this));
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void display() {
        MenuPrincipal dialog = new MenuPrincipal();
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        System.exit(0);
    }
}
