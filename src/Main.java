import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Main extends JFrame {
    MathClub mathClub = new MathClub();
    DanceClub danceClub = new DanceClub();
    PhotographyClub photographyClub = new PhotographyClub();
    SecondOperationPanel subOperationPanel = new SecondOperationPanel();
    OperationPanel mainOperationPanel = new OperationPanel();
    ClubPanel clubView = new ClubPanel(mathClub,danceClub,photographyClub);
    ActionListener updateIndex;
    ActionListener deleteIndex;
    FileHandler newFileHandler;
    JFrame frame;
    Main(){
        frame = new JFrame("Club Management");
        frame.setLayout(null);
        newFileHandler = new FileHandler();
        mainOperationPanel.getChoreographerField().setEditable(false);
        mainOperationPanel.getAddChoreographerButton().setEnabled(false);
        mainOperationPanel.getAddChoreographerDepartment().setEnabled(false);
        mainOperationPanel.setLayout(null);
        mainOperationPanel.setBounds(0,0,370,600);
        subOperationPanel.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));
        subOperationPanel.setBounds(0,300,370,300);
        subOperationPanel.setComboBoxItems(mathClub.getNumberOfMembers());
        mainOperationPanel.add(subOperationPanel);
        clubView.setBounds(370,0,400,600);
        clubView.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, Color.BLACK));
        frame.add(mainOperationPanel);
        frame.add(clubView);

        mainOperationPanel.getClubComboBox().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                clubView.setTabbedPane(mainOperationPanel.getClubComboBoxIndex());
                if(mainOperationPanel.getClubComboBoxIndex() == 1){
                    mainOperationPanel.getSecretaryField().setText("");
                    mainOperationPanel.setChoreographerInfoEnabled();
                    mainOperationPanel.setSecretaryInfoDisabled();
                }
                else{
                    mainOperationPanel.getChoreographerField().setText("");
                    mainOperationPanel.setChoreographerInfoDisabled();
                    mainOperationPanel.setSecretaryInfoEnabled();
                }
            }
        });
        mainOperationPanel.getAddPresidentButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!mainOperationPanel.getPresidentField().getText().isEmpty()){
                    subOperationPanel.getUpdateIndex().removeActionListener(updateIndex);
                    subOperationPanel.getDeleteIndex().removeActionListener(deleteIndex);
                    String position = "President";
                    String name = mainOperationPanel.getPresidentField().getText();
                    String memberDepartment = String.valueOf(mainOperationPanel.addPresidentDepartments.getSelectedItem());
                    Member newMember = new Member(position,name,memberDepartment);
                    if(mainOperationPanel.getClubComboBoxIndex()==0){
                        if(!checkDuplicatePresident(mathClub)){
                            clubView.getMathPanel().addNewRecord(newMember,mathClub);
                            mathClub.addPresident(newMember);
                            newFileHandler.appendFile(newMember.toString(),"MathClub.csv");
                            subOperationPanel.setComboBoxItems(mathClub.getNumberOfMembers());
                        }
                    }
                    else if (mainOperationPanel.getClubComboBoxIndex()==1) {
                        if(!checkDuplicatePresident(danceClub)){
                            clubView.getDancePanel().addNewRecord(newMember,danceClub);
                            danceClub.addPresident(newMember);
                            newFileHandler.appendFile(newMember.toString(),"DanceClub.csv");
                            subOperationPanel.setComboBoxItems(danceClub.getNumberOfMembers());
                        }
                    }
                    else if(mainOperationPanel.getClubComboBoxIndex()==2){
                        if(!checkDuplicatePresident(photographyClub)){
                            clubView.getPhotographyPanel().addNewRecord(newMember,photographyClub);
                            photographyClub.addPresident(newMember);
                            newFileHandler.appendFile(newMember.toString(),"PhotographyClub.csv");
                            subOperationPanel.setComboBoxItems(photographyClub.getNumberOfMembers());
                        }
                    }
                    subOperationPanel.getUpdateIndex().removeActionListener(updateIndex);
                    subOperationPanel.getDeleteIndex().removeActionListener(deleteIndex);
                    mainOperationPanel.getPresidentField().setText("");
                }
            }
        });
        mainOperationPanel.getAddVicePresidentButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!mainOperationPanel.getVicePresidentField().getText().isEmpty()){
                    subOperationPanel.getUpdateIndex().removeActionListener(updateIndex);
                    subOperationPanel.getDeleteIndex().removeActionListener(deleteIndex);
                    String position = "Vice President";
                    String name = mainOperationPanel.getVicePresidentField().getText();
                    String memberDepartment = String.valueOf(mainOperationPanel.addVicePresidentDepartment.getSelectedItem());
                    Member newMember = new Member(position,name,memberDepartment);
                    if(mainOperationPanel.getClubComboBoxIndex()==0){
                        if(!checkDuplicateVicePresident(mathClub)){
                            clubView.getMathPanel().addNewRecord(newMember,mathClub);
                            mathClub.addVicePresident(newMember);
                            newFileHandler.appendFile(newMember.toString(),"MathClub.csv");
                            subOperationPanel.setComboBoxItems(mathClub.getNumberOfMembers());
                        }
                    }
                    else if (mainOperationPanel.getClubComboBoxIndex()==1) {
                        if (!checkDuplicateVicePresident(danceClub)){
                            clubView.getDancePanel().addNewRecord(newMember,danceClub);
                            danceClub.addVicePresident(newMember);
                            newFileHandler.appendFile(newMember.toString(),"DanceClub.csv");
                            subOperationPanel.setComboBoxItems(danceClub.getNumberOfMembers());
                        }
                    }
                    else if(mainOperationPanel.getClubComboBoxIndex()==2){
                        if (!checkDuplicateVicePresident(photographyClub)){
                            clubView.getPhotographyPanel().addNewRecord(newMember,photographyClub);
                            photographyClub.addVicePresident(newMember);
                            newFileHandler.appendFile(newMember.toString(),"PhotographyClub.csv");
                            subOperationPanel.setComboBoxItems(photographyClub.getNumberOfMembers());
                        }
                    }
                    mainOperationPanel.getVicePresidentField().setText("");
                    subOperationPanel.getUpdateIndex().addActionListener(updateIndex);
                    subOperationPanel.getDeleteIndex().addActionListener(deleteIndex);
                }
            }
        });
        mainOperationPanel.getAddSecretaryButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!mainOperationPanel.getSecretaryField().getText().isEmpty()){
                    subOperationPanel.getUpdateIndex().removeActionListener(updateIndex);
                    subOperationPanel.getDeleteIndex().removeActionListener(deleteIndex);
                    String position = "Secretary";
                    String name = mainOperationPanel.getSecretaryField().getText();
                    String memberDepartment = String.valueOf(mainOperationPanel.addSecretaryDepartment.getSelectedItem());
                    Member newMember = new Member(position,name,memberDepartment);
                    if(mainOperationPanel.getClubComboBoxIndex()==0){
                        if(!checkDuplicateSecretary(mathClub)){
                            clubView.getMathPanel().addNewRecord(newMember,mathClub);
                            mathClub.addSecretary(newMember);
                            newFileHandler.appendFile(newMember.toString(),"MathClub.csv");
                            subOperationPanel.setComboBoxItems(mathClub.getNumberOfMembers());
                        }
                    }
                    else if(mainOperationPanel.getClubComboBoxIndex()==2){
                        if (!checkDuplicateSecretary(photographyClub)){
                            clubView.getPhotographyPanel().addNewRecord(newMember,photographyClub);
                            photographyClub.addSecretary(newMember);
                            newFileHandler.appendFile(newMember.toString(),"PhotographyClub.csv");
                            subOperationPanel.setComboBoxItems(photographyClub.getNumberOfMembers());
                        }
                    }
                    mainOperationPanel.getSecretaryField().setText("");
                    subOperationPanel.getUpdateIndex().addActionListener(updateIndex);
                    subOperationPanel.getDeleteIndex().addActionListener(deleteIndex);

                }
            }
        });
        mainOperationPanel.getAddChoreographerButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!mainOperationPanel.getChoreographerField().getText().isEmpty()){
                    subOperationPanel.getUpdateIndex().removeActionListener(updateIndex);
                    subOperationPanel.getDeleteIndex().removeActionListener(deleteIndex);
                    String position = "Choreographer";
                    String name = mainOperationPanel.getChoreographerField().getText();
                    String memberDepartment = String.valueOf(mainOperationPanel.addChoreographerDepartment.getSelectedItem());
                    Member newMember = new Member(position,name,memberDepartment);
                    if(mainOperationPanel.getClubComboBoxIndex()==1){
                        if (!checkDuplicateChoreographer(danceClub)){
                            clubView.getDancePanel().addNewRecord(newMember,danceClub);
                            danceClub.addClubChoreographer(newMember);
                            newFileHandler.appendFile(newMember.toString(),"DanceClub.csv");
                            subOperationPanel.setComboBoxItems(danceClub.getNumberOfMembers());
                        }
                    }
                    mainOperationPanel.getChoreographerField().setText("");
                    subOperationPanel.getUpdateIndex().addActionListener(updateIndex);
                    subOperationPanel.getDeleteIndex().addActionListener(deleteIndex);
                }
            }
        });
        mainOperationPanel.getAddMemberButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!mainOperationPanel.getMemberField().getText().isEmpty()){
                    subOperationPanel.getUpdateIndex().removeActionListener(updateIndex);
                    subOperationPanel.getDeleteIndex().removeActionListener(deleteIndex);
                    String position = "Member";
                    String name = mainOperationPanel.getMemberField().getText();
                    String memberDepartment = String.valueOf(mainOperationPanel.addMemberDepartment.getSelectedItem());
                    Member newMember = new Member(position,name,memberDepartment);
                    if(mainOperationPanel.getClubComboBoxIndex()==0){
                        clubView.getMathPanel().addNewRecord(newMember,mathClub);
                        mathClub.addMember(newMember);
                        newFileHandler.appendFile(newMember.toString(),"MathClub.csv");
                        subOperationPanel.setComboBoxItems(mathClub.getNumberOfMembers());
                    }
                    else if (mainOperationPanel.getClubComboBoxIndex()==1) {
                        clubView.getDancePanel().addNewRecord(newMember,danceClub);
                        danceClub.addMember(newMember);
                        newFileHandler.appendFile(newMember.toString(),"DanceClub.csv");
                        subOperationPanel.setComboBoxItems(danceClub.getNumberOfMembers());
                    }
                    else if(mainOperationPanel.getClubComboBoxIndex()==2){
                        clubView.getPhotographyPanel().addNewRecord(newMember,photographyClub);
                        photographyClub.addMember(newMember);
                        newFileHandler.appendFile(newMember.toString(),"PhotographyClub.csv");
                        subOperationPanel.setComboBoxItems(photographyClub.getNumberOfMembers());
                    }
                    mainOperationPanel.getMemberField().setText("");
                    subOperationPanel.getUpdateIndex().removeActionListener(updateIndex);
                    subOperationPanel.getDeleteIndex().removeActionListener(deleteIndex);
                }
            }
        });
        updateIndex = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int memberPositionIndex;
                int memberIndex = subOperationPanel.getUpdateIndex().getSelectedIndex();
                String memberName;
                String memberDepartment;
                if(subOperationPanel.clubs.getSelectedIndex()==0){
                    memberName = mathClub.getMemberList().get(memberIndex).getName();
                    memberDepartment = mathClub.getMemberList().get(memberIndex).getDepartment();
                    subOperationPanel.getDepartmentComboBox().setSelectedIndex(subOperationPanel.indexOf(memberDepartment));
                    subOperationPanel.getNameField().setText(memberName);
                    for (int i = 0; i < subOperationPanel.getPositions().length ; i++) {
                        if (subOperationPanel.getPositions()[i].equals(mathClub.getMemberList().get(memberIndex).getPosition())){
                            memberPositionIndex = i;
                            subOperationPanel.getPositionComboBox().setSelectedIndex(memberPositionIndex);
                            break;
                        }
                    }
                }
                else if(subOperationPanel.clubs.getSelectedIndex()==1){
                    memberName = danceClub.getMemberList().get(memberIndex).getName();
                    memberDepartment = danceClub.getMemberList().get(memberIndex).getDepartment();
                    subOperationPanel.getDepartmentComboBox().setSelectedIndex(subOperationPanel.indexOf(memberDepartment));
                    subOperationPanel.getNameField().setText(memberName);
                    for (int i = 0; i < subOperationPanel.getPositions().length ; i++) {
                        if (subOperationPanel.getPositions()[i].equals(danceClub.getMemberList().get(memberIndex).getPosition())){
                            memberPositionIndex = i;
                            subOperationPanel.getPositionComboBox().setSelectedIndex(memberPositionIndex);
                            break;
                        }
                    }
                }
                else{
                    memberName = photographyClub.getMemberList().get(memberIndex).getName();
                    memberDepartment = photographyClub.getMemberList().get(memberIndex).getDepartment();
                    subOperationPanel.getDepartmentComboBox().setSelectedIndex(subOperationPanel.indexOf(memberDepartment));
                    subOperationPanel.getNameField().setText(memberName);
                    for (int i = 0; i < subOperationPanel.getPositions().length ; i++) {
                        if (subOperationPanel.getPositions()[i].equals(photographyClub.getMemberList().get(memberIndex).getPosition())){
                            memberPositionIndex = i;
                            subOperationPanel.getPositionComboBox().setSelectedIndex(memberPositionIndex);
                            break;
                        }
                    }
                }
            }
        };
        deleteIndex = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int memberIndex;
                String memberName;
                if(subOperationPanel.clubs.getSelectedIndex()==0){
                    memberIndex = subOperationPanel.getDeleteIndex().getSelectedIndex();
                    memberName = mathClub.getMemberList().get(memberIndex).getName();
                    subOperationPanel.nameDeleteField.setText(memberName);
                }
                else if(subOperationPanel.clubs.getSelectedIndex()==1){
                    memberIndex = subOperationPanel.getDeleteIndex().getSelectedIndex();
                    memberName = danceClub.getMemberList().get(memberIndex).getName();
                    subOperationPanel.nameDeleteField.setText(memberName);
                }
                else{
                    memberIndex = subOperationPanel.getDeleteIndex().getSelectedIndex();
                    memberName = photographyClub.getMemberList().get(memberIndex).getName();
                    subOperationPanel.nameDeleteField.setText(memberName);
                }
            }
        };
        subOperationPanel.getClubComboBox().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                subOperationPanel.getUpdateIndex().removeActionListener(updateIndex);
                subOperationPanel.getDeleteIndex().removeActionListener(deleteIndex);
                subOperationPanel.getNameDeleteField().setText("");
                subOperationPanel.getNameField().setText("");
                clubView.setTabbedPane(subOperationPanel.getClubComboBoxIndex());
                if(subOperationPanel.getClubComboBoxIndex() == 1){
                    subOperationPanel.setComboBoxItems(danceClub.getNumberOfMembers());
                    if(subOperationPanel.getModelPositions().getIndexOf("Choreographer")==-1&& subOperationPanel.getModelPositions().getIndexOf("Secretary")>0){
                        subOperationPanel.getPositionComboBox().addItem("Choreographer");
                        subOperationPanel.getPositionComboBox().removeItem("Secretary");
                    }
                }
                else if(subOperationPanel.getClubComboBoxIndex()==2){
                    subOperationPanel.setComboBoxItems(photographyClub.getNumberOfMembers());
                    if(subOperationPanel.getModelPositions().getIndexOf("Secretary")==-1){
                        subOperationPanel.getPositionComboBox().addItem("Secretary");
                    }
                    subOperationPanel.getPositionComboBox().removeItem("Choreographer");
                }
                else{
                    if(subOperationPanel.getModelPositions().getIndexOf("Secretary")==-1){
                        subOperationPanel.getPositionComboBox().addItem("Secretary");
                    }
                    subOperationPanel.getPositionComboBox().removeItem("Choreographer");
                    subOperationPanel.setComboBoxItems(mathClub.getNumberOfMembers());
                }
                subOperationPanel.getUpdateIndex().addActionListener(updateIndex);
                subOperationPanel.getDeleteIndex().addActionListener(deleteIndex);
            }
        });
        subOperationPanel.getUpdateIndex().addActionListener(updateIndex);
        subOperationPanel.getDeleteIndex().addActionListener(deleteIndex);
        subOperationPanel.getUpdate().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int memberIndex = subOperationPanel.getUpdateIndex().getSelectedIndex();
                String name = subOperationPanel.getNameField().getText();
                String position = subOperationPanel.getPositionComboBox().getSelectedItem().toString();
                String department = subOperationPanel.getDepartmentComboBox().getSelectedItem().toString();
                Member newMember = new Member(position,name,department);
                if(!subOperationPanel.getNameField().getText().isEmpty()){
                    if(subOperationPanel.clubs.getSelectedIndex()==0){
                        if (!checkDuplicatePosition(mathClub,position)){
                            mathClub.getMemberList().set(memberIndex,newMember);
                            clubView.getMathPanel().removeData();
                            clubView.getMathPanel().updateTableRecord(mathClub);
                            File myObj = new File("MathClub.csv");
                            myObj.delete();
                            for (Member member: mathClub.getMemberList()) {
                                newFileHandler.appendFile(member.toString(),"MathClub.csv");
                            }
                        }
                    }
                    else if(subOperationPanel.clubs.getSelectedIndex()==1){
                        if(checkDuplicatePosition(danceClub,position)){
                            danceClub.getMemberList().set(memberIndex,newMember);
                            clubView.getDancePanel().removeData();
                            clubView.getDancePanel().updateTableRecord(danceClub);
                            File myObj = new File("DanceClub.csv");
                            myObj.delete();
                            for (Member member: danceClub.getMemberList()) {
                                newFileHandler.appendFile(member.toString(),"DanceClub.csv");
                            }
                        }
                    }
                    else{
                        if(checkDuplicatePosition(photographyClub,position)){
                            photographyClub.getMemberList().set(memberIndex,newMember);
                            clubView.getPhotographyPanel().removeData();
                            clubView.getPhotographyPanel().updateTableRecord(photographyClub);
                            File myObj = new File("PhotographyClub.csv");
                            myObj.delete();
                            for (Member member: photographyClub.getMemberList()) {
                                newFileHandler.appendFile(member.toString(),"PhotographyClub.csv");
                            }
                        }
                    }
                }
            }
        });
        subOperationPanel.getDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int memberIndex = subOperationPanel.getDeleteIndex().getSelectedIndex();
                Member newMember;
                subOperationPanel.getUpdateIndex().removeActionListener(updateIndex);
                subOperationPanel.getDeleteIndex().removeActionListener(deleteIndex);
                if(!subOperationPanel.getNameDeleteField().getText().isEmpty()){
                    if (subOperationPanel.clubs.getSelectedIndex()==0){
                        newMember = mathClub.getMemberList().get(memberIndex);
                        mathClub.getMemberList().remove(memberIndex);
                        clubView.getMathPanel().removeData();
                        clubView.getMathPanel().updateTableRecord(mathClub);
                        File myObj = new File("MathClub.csv");
                        myObj.delete();
                        for (Member member: mathClub.getMemberList()) {
                            newFileHandler.appendFile(member.toString(),"MathClub.csv");
                        }
                        subOperationPanel.setComboBoxItems(mathClub.getNumberOfMembers());
                    }
                    else if(subOperationPanel.clubs.getSelectedIndex()==1){
                        newMember = danceClub.getMemberList().get(memberIndex);
                        danceClub.getMemberList().remove(memberIndex);
                        clubView.getDancePanel().removeData();
                        clubView.getDancePanel().updateTableRecord(danceClub);
                        File myObj = new File("DanceClub.csv");
                        myObj.delete();
                        for (Member member: danceClub.getMemberList()) {
                            newFileHandler.appendFile(member.toString(),"DanceClub.csv");
                        }
                        subOperationPanel.setComboBoxItems(danceClub.getNumberOfMembers());
                    }
                    else{
                        newMember = photographyClub.getMemberList().get(memberIndex);
                        photographyClub.getMemberList().remove(memberIndex);
                        clubView.getPhotographyPanel().removeData();
                        clubView.getPhotographyPanel().updateTableRecord(photographyClub);
                        File myObj = new File("PhotographyClub.csv");
                        myObj.delete();
                        for (Member member: photographyClub.getMemberList()) {
                            newFileHandler.appendFile(member.toString(),"PhotographyClub.csv");
                        }
                        subOperationPanel.setComboBoxItems(photographyClub.getNumberOfMembers());
                    }
                }
                subOperationPanel.nameDeleteField.setText("");
                subOperationPanel.getNameField().setText("");
                subOperationPanel.getUpdateIndex().addActionListener(updateIndex);
                subOperationPanel.getDeleteIndex().addActionListener(deleteIndex);

            }
        });
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(770,600);
        frame.setVisible(true);
    }
    public boolean checkDuplicatePosition(Club club,String position){
        if(position.equals("Member")){
            return false;
        }

        if(!position.contains("Vice")){
            for (Member member:club.getMemberList()) {
                if (member.toString().contains(position)&&!member.toString().contains("Vice")){
                    JOptionPane.showMessageDialog(null,position+" Already Exists!","Invalid",JOptionPane.ERROR_MESSAGE);
                    return true;
                }
            }
        }
        else{
            for(Member member:club.getMemberList()){
                if(member.toString().contains("Vice")){
                    JOptionPane.showMessageDialog(null,position+" Already Exists!","Invalid",JOptionPane.ERROR_MESSAGE);
                    return true;
                }

            }
        }
        return false;
    }
    public boolean checkDuplicatePresident(Club club){
        for (Member member:club.memberList) {
            if (member.toString().contains("President")&& !member.toString().contains("Vice President")){
                JOptionPane.showMessageDialog(null,"President already Exists!","Invalid",JOptionPane.ERROR_MESSAGE);
                return true;
            }
        }
        return false;
    }
    public boolean checkDuplicateVicePresident(Club club){
        for (Member member:club.memberList) {
            if (member.toString().contains("Vice President")){
                JOptionPane.showMessageDialog(null,"Vice President Exists!","Invalid",JOptionPane.ERROR_MESSAGE);
                return true;
            }
        }
        return false;

    }
    public boolean checkDuplicateSecretary(Club club){
        for (Member member:club.memberList) {
            if (member.toString().contains("Secretary")){
                JOptionPane.showMessageDialog(null,"Secretary Exists!","Invalid",JOptionPane.ERROR_MESSAGE);
                return true;
            }
        }
        return false;

    }
    public boolean checkDuplicateChoreographer(Club club){
        for (Member member:club.memberList) {
            if (member.toString().contains("Choreographer")){
                JOptionPane.showMessageDialog(null,"Choreographer Exists!","Invalid",JOptionPane.ERROR_MESSAGE);
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (Exception e) {
                }
                new Main();
            }
        });

    }
}