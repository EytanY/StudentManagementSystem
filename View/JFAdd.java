package View;

import javax.swing.JTextField;

public class JFAdd extends JFStudentManagement {
    private JTextField firstNameTextField = new JTextField();
    private JTextField lastNameTextField = new JTextField();
    private JTextField idAddTextField = new JTextField();
    private JTextField fatherNameTextField = new JTextField();
    private JTextField motherNameTextField = new JTextField();
    private JTextField emailTextField = new JTextField();

    public JFAdd() {

    }

    public JTextField getLastNameTextFiled() {
        return lastNameTextField;
    }

    public JTextField idAddTextFiled() {
        return idAddTextField;
    }

    public JTextField getFatherNameTextFiled() {
        return fatherNameTextField;
    }

    public JTextField getMotherNameTextFiled() {
        return motherNameTextField;
    }

    public JTextField getEmailTextFiled() {
        return emailTextField;
    }

    public JTextField getFirstNameTextFiled() {
        return firstNameTextField;
    }

}
