import javax.swing.*;
import java.awt.*;

public class OperationPanel extends JPanel {
    String[] clubNames = {"Math Club","Dance Club","Photography Club"};
    String[] departments = {"PS","CLE","CAE","CAFAE","CASE","CBAE","CCE","CCJE","CEE","CHE","CHSE","CTE","TS","BED"};
    String[] mathClubPositions = {"President","Vice President","Member","Secretary","Choreographer"};
    JTextField presidentField = new JTextField();
    JTextField vicePresidentField = new JTextField();
    JTextField memberField = new JTextField();
    JTextField secretaryField = new JTextField();
    JTextField choreographerField = new JTextField();
    JButton addPresidentButton = new JButton("Add");
    JButton addVicePresidentButton = new JButton("Add");
    JButton addMemberButton = new JButton("Add");
    JButton addSecretaryButton = new JButton("Add");
    JButton addChoreographerButton = new JButton("Add");
    JComboBox<String> clubs =new  JComboBox<>(clubNames);
    JComboBox<String> addPresidentDepartments = new JComboBox<>(departments);
    JComboBox<String> addVicePresidentDepartment = new JComboBox<>(departments);
    JComboBox<String> addMemberDepartment = new JComboBox<>(departments);
    JComboBox<String> addSecretaryDepartment = new JComboBox<>(departments);
    JComboBox<String> addChoreographerDepartment = new JComboBox<>(departments);
    JLabel addMemberTitle;
    JLabel presidentLabel;
    JLabel vicePresidentLabel;
    JLabel memberLabel;
    JLabel secretaryLabel;
    JLabel choreographerLabel;

    OperationPanel(){
        this.setLayout(null);
        addMemberTitle = new JLabel("Add Member");
        addMemberTitle.setBounds(5,10,290,25);
        addMemberTitle.setFont(new Font("Serif",Font.BOLD,20));
        addMemberTitle.setHorizontalAlignment(SwingConstants.CENTER);
        clubs.setBounds(5,45,170,25);


        presidentLabel = new JLabel(mathClubPositions[0]);
        presidentLabel.setBounds(5,75,80,30);
        vicePresidentLabel = new JLabel(mathClubPositions[1]);
        vicePresidentLabel.setBounds(5,105,80,30);
        memberLabel = new JLabel(mathClubPositions[2]);
        memberLabel.setBounds(5,135,80,30);
        secretaryLabel = new JLabel(mathClubPositions[3]);
        secretaryLabel.setBounds(5,165,80,30);
        choreographerLabel = new JLabel(mathClubPositions[4]);
        choreographerLabel.setBounds(5,195,80,30);


        //input text fields
        presidentField.setBounds(85,75,160,30);
        vicePresidentField.setBounds(85,105,160,30);
        memberField.setBounds(85,135,160,30);
        secretaryField.setBounds(85,165,160,30);
        choreographerField.setBounds(85,195,160,30);

        addPresidentButton.setBounds(245,75,50,30);
        addVicePresidentButton.setBounds(245,105,50,30);
        addMemberButton.setBounds(245,135,50,30);
        addSecretaryButton.setBounds(245,165,50,30);
        addChoreographerButton.setBounds(245,195,50,30);

        addPresidentDepartments.setBounds(295,75,70,30);
        addVicePresidentDepartment.setBounds(295,105,70,30);
        addMemberDepartment.setBounds(295,135,70,30);
        addSecretaryDepartment.setBounds(295,165,70,30);
        addChoreographerDepartment.setBounds(295,195,70,30);



        this.add(clubs);
        this.add(addMemberTitle);
        this.add(presidentLabel);
        this.add(vicePresidentLabel);
        this.add(memberLabel);
        this.add(secretaryLabel);
        this.add(choreographerLabel);
        this.add(presidentField);
        this.add(vicePresidentField);
        this.add(memberField);
        this.add(secretaryField);
        this.add(choreographerField);
        this.add(addPresidentButton);
        this.add(addVicePresidentButton);
        this.add(addMemberButton);
        this.add(addSecretaryButton);
        this.add(addChoreographerButton);
        this.add(addPresidentDepartments);
        this.add(addVicePresidentDepartment);
        this.add(addMemberDepartment);
        this.add(addSecretaryDepartment);
        this.add(addChoreographerDepartment);
    }
    public JComboBox<String> getClubComboBox(){
        return clubs;
    }
    public int getClubComboBoxIndex(){
        return clubs.getSelectedIndex();
    }
    public JButton getAddPresidentButton(){
        return addPresidentButton;
    }
    public JButton getAddVicePresidentButton(){
        return addVicePresidentButton;
    }
    public JButton getAddMemberButton(){
        return addMemberButton;
    }
    public JButton getAddSecretaryButton(){
        return addSecretaryButton;
    }
    public JButton getAddChoreographerButton(){
        return addChoreographerButton;
    }
    public JComboBox<String> getAddChoreographerDepartment(){
        return addChoreographerDepartment;
    }
    public JTextField getPresidentField(){
        return presidentField;
    }
    public JTextField getVicePresidentField(){
        return vicePresidentField;
    }
    public JTextField getMemberField(){
        return memberField;
    }
    public JTextField getSecretaryField(){
        return secretaryField;
    }
    public JTextField getChoreographerField(){
        return choreographerField;
    }
    public void setChoreographerInfoDisabled(){
        choreographerField.setEditable(false);
        addChoreographerButton.setEnabled(false);
        addChoreographerDepartment.setEnabled(false);
    }
    public void setChoreographerInfoEnabled(){
        choreographerField.setEditable(true);
        addChoreographerButton.setEnabled(true);
        addChoreographerDepartment.setEnabled(true);
    }
    public void setSecretaryInfoDisabled(){
        secretaryField.setEditable(false);
        addSecretaryButton.setEnabled(false);
        addSecretaryDepartment.setEnabled(false);
    }
    public void setSecretaryInfoEnabled(){
        secretaryField.setEditable(true);
        addSecretaryButton.setEnabled(true);
        addSecretaryDepartment.setEnabled(true);
    }
}
