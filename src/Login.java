import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class Login extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel panelBotones;
    private JButton registrarButton;
    private JTextField tfUser;
    private JPasswordField tfPWD;

    public Login() {
        Usuarios.getInstance().registrarUsuario("admin", "admin");
        setContentPane(contentPane);
        setModal(true);//una ventana modal, bloquea al resto de las ventanas de la app.
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

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

        registrarButton.addActionListener(e-> Registrar.display(this));
    }

    private void onOK() {
        //revisar si el usuari y contraseña son válidos
        String user = tfUser.getText();
        String password = new String(tfPWD.getPassword());
        if(Usuarios.getInstance().validarUsuario(user,password)){
            //JOptionPane.showMessageDialog(null, "Bienvenido al sistema.","Información", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
            MenuPrincipal.display();
        }else{
            JOptionPane.showMessageDialog(null, "Usuario y/o contraseña no válidos.","Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Login dialog = new Login();
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        //System.exit(0);
    }
}
