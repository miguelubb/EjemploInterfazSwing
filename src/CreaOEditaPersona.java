import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CreaOEditaPersona extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel tfTitulo;
    private JTextField tfRut;
    private JTextField tfNombre;
    private JTextField tfEdad;



    public CreaOEditaPersona() {
        setContentPane(contentPane);
        setModal(true);//hace que el que llama espere a que termine el diálogo, no avanza!!!.
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

        tfEdad.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                enfatizar(tfEdad);
            }
        });

        tfEdad.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                desEnfatizar(tfEdad);
                int edad=Integer.parseInt(tfEdad.getText());
                if(edad<0 || edad >=150){
                    tfEdad.setBackground(Color.red);
                }
            }
        });

        tfRut.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                enfatizar(tfRut);
            }
        });

        tfRut.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                desEnfatizar(tfRut);
            }
        });

        tfNombre.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                enfatizar(tfNombre);
            }
        });

        tfNombre.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                desEnfatizar(tfNombre);
            }
        });
        buttonOK.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                enfatizar(buttonOK);
            }
        });
        buttonOK.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                desEnfatizar(buttonOK);
            }
        });

        buttonCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                enfatizar(buttonCancel);
            }
        });
        buttonCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                desEnfatizar(buttonCancel);
            }
        });

        tfEdad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
            }
        });
    }

    private void desEnfatizar(JComponent c) {
        c.setBackground(Color.white);
    }

    private void enfatizar(JComponent c) {
        c.setBackground(Color.yellow);
    }

    public String getRut() {
        return tfRut.getText();
    }

    public void setRut(String rut) {
        this.tfRut.setText(rut);
    }

    public String getNombre() {
        return tfNombre.getText();
    }

    public void setNombre(String nombre) {
        this.tfNombre.setText(nombre);
    }

    public String getEdad() {
        return tfEdad.getText();
    }

    public void setEdad(String edad) {
        tfEdad.setText(edad);
    }

    public String getTitulo() {
        return tfTitulo.getText();
    }

    public void setTitulo(String titulo) {
        tfTitulo.setText(titulo);
    }

    private void onOK() {
        // add your code here
        if(tfRut.getText().isEmpty() || tfNombre.getText().isEmpty() || tfEdad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes llenar todos los campos");
        }else {
            this.setVisible(false);
        }
    }

    private void onCancel() {
        // add your code here if necessary
        this.setVisible(false);
    }

    public void display(JDialog origen, String titulo, String rut, String nombre, String edad) {
        pack();
        setLocationRelativeTo(origen);
        setTitle(titulo);
        setRut(rut);
        setNombre(nombre);
        setEdad(edad);
        setVisible(true);
    }
}
