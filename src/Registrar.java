import javax.swing.*;
import java.awt.event.*;

public class Registrar extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField tfUsuario;
    private JPasswordField tfPwd1;
    private JPasswordField tfPWD2;

    public Registrar() {
        setContentPane(contentPane);
        setModal(true);
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
    }

    private void onOK() {
        //crear un nuevo usuario
        String usuario=tfUsuario.getText();
        String pwd1=new String(tfPwd1.getPassword());
        String pwd2=new String(tfPWD2.getPassword());
        if(usuario.isEmpty() || pwd1.isEmpty() || pwd2.isEmpty() ){
            JOptionPane.showMessageDialog(this, "los campos no deben estar vacíos","Error",JOptionPane.ERROR_MESSAGE);
        }else if(!pwd1.equals(pwd2)){
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden","Error",JOptionPane.ERROR_MESSAGE);
        }else{
            boolean ok=Usuarios.getInstance().registrarUsuario(usuario,pwd1);
            if(ok){
                JOptionPane.showMessageDialog(this, "Registro exitoso","Registro",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this, "Usuario ya existe","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void display(JDialog origen) {
        Registrar dialog = new Registrar();
        dialog.pack();
        dialog.setLocationRelativeTo(origen);//lo centra a la ventana de origen
        dialog.setVisible(true);
    }
}
