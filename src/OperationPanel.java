import javax.swing.*;
import java.awt.*;

public class OperationPanel extends JPanel {
    String[] clubNames = {"Math Club","Dance Club","Photography Club"};
    JComboBox<String> clubs =new  JComboBox<>(clubNames);
    String[] mathClubPositions = {"President","Vice President","Member","Secretary","Choreographer"};
    JTextField presidentField = new JTextField();
    JTextField vicePresidentField = new JTextField();
    JTextField memberField = new JTextField();
    JTextField secretaryField = new JTextField();

    JTextField choreographerField = new JTextField();
    JButton addMember = new JButton("Add Member");
    String[] departments = {"PS","CLE","CAE","CAFAE","CASE","CBAE","CCE","CCJE","CEE","CHE","CHSE","CTE","TS","BED","None"};
    JTextField[] addMemberTextFields = {presidentField,vicePresidentField,memberField,secretaryField};
    JButton addPresidentButton = new JButton("Add");
    JButton addVicePresidentButton = new JButton("Add");
    JButton addMemberButton = new JButton("Add");
    JButton addSecretaryButton = new JButton("Add");

    JButton addChoreographerButton = new JButton("Add");

    JComboBox<String> addPresidentDepartments = new JComboBox<>(departments);
    JComboBox<String> addVicePresidentDepartment = new JComboBox<>(departments);
    JComboBox<String> addMemberDepartment = new JComboBox<>(departments);
    JComboBox<String> addSecretaryDepartment = new JComboBox<>(departments);

    JComboBox<String> addChoreographerDepartment = new JComboBox<>(departments);
    OperationPanel(){
        this.setLayout(null);
        JLabel addMemberTitle = new JLabel("Add Member");
        addMemberTitle.setBounds(5,10,290,25);
        addMemberTitle.setFont(new Font("Serif",Font.BOLD,20));
        addMemberTitle.setHorizontalAlignment(SwingConstants.CENTER);
        //Club drop down
        clubs.setBounds(5,45,170,25);
        //Input Labels
        JLabel president = new JLabel(mathClubPositions[0]);
        president.setBounds(5,75,80,30);

        JLabel vicePresident = new JLabel(mathClubPositions[1]);
        vicePresident.setBounds(5,105,80,30);

        JLabel Member = new JLabel(mathClubPositions[2]);
        Member.setBounds(5,135,80,30);

        JLabel secretary = new JLabel(mathClubPositions[3]);
        secretary.setBounds(5,165,80,30);

        JLabel choreographer = new JLabel(mathClubPositions[4]);
        choreographer.setBounds(5,195,80,30);


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



        //add member button
        addMember.setBounds(35,220,125,35);


        this.add(addMemberTitle);
        this.add(clubs);

        this.add(president);
        this.add(vicePresident);
        this.add(Member);
        this.add(secretary);
        this.add(choreographer);

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

//        this.add(addMember);


    }
    public JButton getAddMember(){
        return addMember;
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

    public JComboBox<String> getAddPresidentDepartments(){
        return addPresidentDepartments;
    }
    public JComboBox<String> getAddVicePresidentDepartment(){
        return addVicePresidentDepartment;
    }
    public JComboBox<String> getAddMemberDepartment(){
        return addMemberDepartment;
    }
    public JComboBox<String> getAddSecretaryDepartment(){
        return addSecretaryDepartment;
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


    public JTextField[] getAddMemberTextFields(){
        return addMemberTextFields;
    }
    public String[] getMathClubPositions(){
        return mathClubPositions;
    }

}
