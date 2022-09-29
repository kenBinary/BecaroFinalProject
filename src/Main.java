import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Main extends JFrame {
    MathClub mathClub = new MathClub();
    DanceClub danceClub = new DanceClub();
    PhotographyClub photographyClub = new PhotographyClub();
    SecondOperationPanel sOPanel;

    OperationPanel oPanel = new OperationPanel();
    ClubPanel clubView = new ClubPanel(mathClub,danceClub,photographyClub);
    ActionListener updateIndex;
    ActionListener deleteIndex;
    Main(){
        oPanel.getChoreographerField().setText("");
        oPanel.getChoreographerField().setEditable(false);
        oPanel.getAddChoreographerButton().setEnabled(false);
        oPanel.getAddChoreographerDepartment().setEnabled(false);
        FileHandler newFileHandler = new FileHandler();
        JFrame frame = new JFrame("Club Management");
        frame.setLayout(null);
        oPanel.setBounds(0,0,370,600);
        oPanel.setLayout(null);
        sOPanel = new SecondOperationPanel();
        sOPanel.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));
        sOPanel.setBounds(0,300,370,300);
        sOPanel.setComboBoxItems(mathClub.getNumberOfMembers());
        oPanel.add(sOPanel);
        frame.add(oPanel);

        clubView.setBounds(370,0,400,600);
        clubView.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, Color.BLACK));
        frame.add(clubView);

        oPanel.getClubComboBox().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                clubView.setTabbedPane(oPanel.getClubComboBoxIndex());
                if(oPanel.getClubComboBoxIndex() == 1){
                    oPanel.getChoreographerField().setEditable(true);
                    oPanel.getAddChoreographerButton().setEnabled(true);
                    oPanel.getAddChoreographerDepartment().setEnabled(true);
                    oPanel.getSecretaryField().setText("");
                    oPanel.getSecretaryField().setEditable(false);
                    oPanel.getAddSecretaryButton().setEnabled(false);
                    oPanel.getAddSecretaryDepartment().setEnabled(false);
                }
                else{
                    oPanel.getChoreographerField().setText("");
                    oPanel.getChoreographerField().setEditable(false);
                    oPanel.getAddChoreographerButton().setEnabled(false);
                    oPanel.getAddChoreographerDepartment().setEnabled(false);
                    oPanel.getSecretaryField().setEditable(true);
                    oPanel.getAddSecretaryButton().setEnabled(true);
                    oPanel.getAddSecretaryDepartment().setEnabled(true);
                }
            }
        });



        oPanel.getAddPresidentButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!oPanel.getPresidentField().getText().isEmpty()){
                    String position = "President";
                    String name = oPanel.getPresidentField().getText();
                    String memberDepartment = String.valueOf(oPanel.addPresidentDepartments.getSelectedItem());
                    Member newMember = new Member(position,name,memberDepartment);

                    if(oPanel.getClubComboBoxIndex()==0){
                        clubView.getMathPanel().addNewRecord(newMember,mathClub);
                        mathClub.addPresident(newMember);
                        newFileHandler.appendFile(newMember.toString(),"MathClub.csv");
                    }
                    else if (oPanel.getClubComboBoxIndex()==1) {
                        clubView.getDancePanel().addNewRecord(newMember,danceClub);
                        danceClub.addPresident(newMember);
                        newFileHandler.appendFile(newMember.toString(),"DanceClub.csv");

                    }
                    else if(oPanel.getClubComboBoxIndex()==2){
                        clubView.getPhotographyPanel().addNewRecord(newMember,photographyClub);
                        photographyClub.addPresident(newMember);
                        newFileHandler.appendFile(newMember.toString(),"PhotographyClub.csv");

                    }

                }
            }
        });

        oPanel.getAddVicePresidentButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!oPanel.getVicePresidentField().getText().isEmpty()){
                    String position = "Vice President";
                    String name = oPanel.getVicePresidentField().getText();
                    String memberDepartment = String.valueOf(oPanel.addVicePresidentDepartment.getSelectedItem());
                    Member newMember = new Member(position,name,memberDepartment);

                    if(oPanel.getClubComboBoxIndex()==0){
                        clubView.getMathPanel().addNewRecord(newMember,mathClub);
                        mathClub.addVicePresident(newMember);
                        newFileHandler.appendFile(newMember.toString(),"MathClub.csv");
                    }
                    else if (oPanel.getClubComboBoxIndex()==1) {
                        clubView.getDancePanel().addNewRecord(newMember,danceClub);
                        danceClub.addVicePresident(newMember);
                        newFileHandler.appendFile(newMember.toString(),"DanceClub.csv");

                    }
                    else if(oPanel.getClubComboBoxIndex()==2){
                        clubView.getPhotographyPanel().addNewRecord(newMember,photographyClub);
                        photographyClub.addVicePresident(newMember);
                        newFileHandler.appendFile(newMember.toString(),"PhotographyClub.csv");

                    }

                }
            }
        });

        oPanel.getAddMemberButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!oPanel.getMemberField().getText().isEmpty()){
                    String position = "Member";
                    String name = oPanel.getMemberField().getText();
                    String memberDepartment = String.valueOf(oPanel.addMemberDepartment.getSelectedItem());
                    Member newMember = new Member(position,name,memberDepartment);

                    if(oPanel.getClubComboBoxIndex()==0){
                        clubView.getMathPanel().addNewRecord(newMember,mathClub);
                        mathClub.addMember(newMember);
                        newFileHandler.appendFile(newMember.toString(),"MathClub.csv");
                    }
                    else if (oPanel.getClubComboBoxIndex()==1) {
                        clubView.getDancePanel().addNewRecord(newMember,danceClub);
                        danceClub.addMember(newMember);
                        newFileHandler.appendFile(newMember.toString(),"DanceClub.csv");

                    }
                    else if(oPanel.getClubComboBoxIndex()==2){
                        clubView.getPhotographyPanel().addNewRecord(newMember,photographyClub);
                        photographyClub.addMember(newMember);
                        newFileHandler.appendFile(newMember.toString(),"PhotographyClub.csv");
                    }

                }
            }
        });
        oPanel.getAddSecretaryButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!oPanel.getSecretaryField().getText().isEmpty()){
                    String position = "Secretary";
                    String name = oPanel.getSecretaryField().getText();
                    String memberDepartment = String.valueOf(oPanel.addSecretaryDepartment.getSelectedItem());
                    Member newMember = new Member(position,name,memberDepartment);

                    if(oPanel.getClubComboBoxIndex()==0){
                        clubView.getMathPanel().addNewRecord(newMember,mathClub);
                        mathClub.addSecretary(newMember);
                        newFileHandler.appendFile(newMember.toString(),"MathClub.csv");
                    }
                    else if(oPanel.getClubComboBoxIndex()==2){
                        clubView.getPhotographyPanel().addNewRecord(newMember,photographyClub);
                        photographyClub.addSecretary(newMember);
                        newFileHandler.appendFile(newMember.toString(),"PhotographyClub.csv");
                    }

                }
            }
        });
        oPanel.getAddChoreographerButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!oPanel.getChoreographerField().getText().isEmpty()){
                    String position = "Choreographer";
                    String name = oPanel.getChoreographerField().getText();
                    String memberDepartment = String.valueOf(oPanel.addChoreographerDepartment.getSelectedItem());
                    Member newMember = new Member(position,name,memberDepartment);

                    if(oPanel.getClubComboBoxIndex()==1){
                        clubView.getDancePanel().addNewRecord(newMember,danceClub);
                        danceClub.addClubChoreographer(newMember);
                        newFileHandler.appendFile(newMember.toString(),"DanceClub.csv");
                    }

                }
            }
        });


        sOPanel.getUpdateIndex().addActionListener(updateIndex);
        sOPanel.getDeleteIndex().addActionListener(deleteIndex);
        oPanel.getAddMember().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        sOPanel.getClubComboBox().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                sOPanel.getUpdateIndex().removeActionListener(updateIndex);
                sOPanel.getDeleteIndex().removeActionListener(deleteIndex);
                clubView.setTabbedPane(sOPanel.getClubComboBoxIndex());
                if(sOPanel.getClubComboBoxIndex() == 1){
                    sOPanel.setComboBoxItems(danceClub.getNumberOfMembers());
                    if(sOPanel.getModelPositions().getIndexOf("Choreographer")==-1&& sOPanel.getModelPositions().getIndexOf("Secretary")>0){
                        sOPanel.getPositionComboBox().addItem("Choreographer");
                        sOPanel.getPositionComboBox().removeItem("Secretary");
                    }
                }
                else if(sOPanel.getClubComboBoxIndex()==2){
                    sOPanel.setComboBoxItems(photographyClub.getNumberOfMembers());
                    if(sOPanel.getModelPositions().getIndexOf("Secretary")==-1){
                        sOPanel.getPositionComboBox().addItem("Secretary");
                    }
                    sOPanel.getPositionComboBox().removeItem("Choreographer");
                }
                else{
                    if(sOPanel.getModelPositions().getIndexOf("Secretary")==-1){
                        sOPanel.getPositionComboBox().addItem("Secretary");
                    }
                    sOPanel.getPositionComboBox().removeItem("Choreographer");
                    sOPanel.setComboBoxItems(mathClub.getNumberOfMembers());
                }
                sOPanel.getUpdateIndex().addActionListener(updateIndex);
                sOPanel.getDeleteIndex().addActionListener(deleteIndex);
            }
        });

        sOPanel.getUpdate().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int memberIndex = sOPanel.getUpdateIndex().getSelectedIndex();
                String name = sOPanel.getNameField().getText();
                String position = sOPanel.getPositionComboBox().getSelectedItem().toString();
                String department = sOPanel.getDepartmentComboBox().getSelectedItem().toString();
                Member newMember = new Member(position,name,department);
                if(sOPanel.clubs.getSelectedIndex()==0){
                    mathClub.getMemberList().set(memberIndex,newMember);
                    clubView.getMathPanel().removeData();
                    clubView.getMathPanel().updateTableRecord(mathClub);
                    File myObj = new File("MathClub.csv");
                    myObj.delete();
                    for (Member member: mathClub.getMemberList()) {
                        System.out.println(member.toString());
                        newFileHandler.appendFile(member.toString(),"MathClub.csv");
                    }
                }
                else if(sOPanel.clubs.getSelectedIndex()==1){
                    danceClub.getMemberList().set(memberIndex,newMember);
                    clubView.getDancePanel().removeData();
                    clubView.getDancePanel().updateTableRecord(danceClub);
                    File myObj = new File("DanceClub.csv");
                    myObj.delete();
                    for (Member member: danceClub.getMemberList()) {
                        System.out.println(member.toString());
                        newFileHandler.appendFile(member.toString(),"DanceClub.csv");
                    }
                }
                else{
                    photographyClub.getMemberList().set(memberIndex,newMember);
                    clubView.getPhotographyPanel().removeData();
                    clubView.getPhotographyPanel().updateTableRecord(photographyClub);
                    File myObj = new File("PhotographyClub.csv");
                    myObj.delete();
                    for (Member member: photographyClub.getMemberList()) {
                        System.out.println(member.toString());
                        newFileHandler.appendFile(member.toString(),"PhotographyClub.csv");
                    }
                }
            }
        });
        sOPanel.getDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int memberIndex = sOPanel.getDeleteIndex().getSelectedIndex();
                Member newMember;
                if (sOPanel.clubs.getSelectedIndex()==0){
                    newMember = mathClub.getMemberList().get(memberIndex);
                    mathClub.getMemberList().remove(memberIndex);
                    clubView.getMathPanel().removeData();
                    clubView.getMathPanel().updateTableRecord(mathClub);
                    File myObj = new File("MathClub.csv");
                    myObj.delete();
                    for (Member member: mathClub.getMemberList()) {
                        newFileHandler.appendFile(member.toString(),"MathClub.csv");
                    }
                }
                else if(sOPanel.clubs.getSelectedIndex()==1){
                    newMember = danceClub.getMemberList().get(memberIndex);
                    danceClub.getMemberList().remove(memberIndex);
                    clubView.getDancePanel().removeData();
                    clubView.getDancePanel().updateTableRecord(danceClub);
                    File myObj = new File("DanceClub.csv");
                    myObj.delete();
                    for (Member member: danceClub.getMemberList()) {
                        newFileHandler.appendFile(member.toString(),"DanceClub.csv");
                    }

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
                }


                sOPanel.nameDeleteField.setText("");

            }
        });


         updateIndex = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int memberPositionIndex;
                int memberIndex = sOPanel.getUpdateIndex().getSelectedIndex();
                String memberName;
                String memberDepartment;


                if(sOPanel.clubs.getSelectedIndex()==0){
                    memberName = mathClub.getMemberList().get(memberIndex).getName();
                    memberDepartment = mathClub.getMemberList().get(memberIndex).getDepartment();
                    sOPanel.getDepartmentComboBox().setSelectedIndex(sOPanel.indexOf(memberDepartment));
                    sOPanel.getNameField().setText(memberName);
                    for (int i = 0; i < sOPanel.getPositions().length ; i++) {
                        if (sOPanel.getPositions()[i].equals(mathClub.getMemberList().get(memberIndex).getPosition())){
                            memberPositionIndex = i;
                            sOPanel.getPositionComboBox().setSelectedIndex(memberPositionIndex);
                            break;
                        }
                    }
                }
                else if(sOPanel.clubs.getSelectedIndex()==1){
                    memberName = danceClub.getMemberList().get(memberIndex).getName();
                    memberDepartment = danceClub.getMemberList().get(memberIndex).getDepartment();
                    sOPanel.getDepartmentComboBox().setSelectedIndex(sOPanel.indexOf(memberDepartment));
                    sOPanel.getNameField().setText(memberName);
                    for (int i = 0; i < sOPanel.getPositions().length ; i++) {
                        if (sOPanel.getPositions()[i].equals(danceClub.getMemberList().get(memberIndex).getPosition())){
                            memberPositionIndex = i;
                            sOPanel.getPositionComboBox().setSelectedIndex(memberPositionIndex);
                            break;
                        }
                    }
                }
                else{
                    memberName = photographyClub.getMemberList().get(memberIndex).getName();
                    memberDepartment = photographyClub.getMemberList().get(memberIndex).getDepartment();
                    sOPanel.getDepartmentComboBox().setSelectedIndex(sOPanel.indexOf(memberDepartment));
                    sOPanel.getNameField().setText(memberName);
                    for (int i = 0; i < sOPanel.getPositions().length ; i++) {
                        if (sOPanel.getPositions()[i].equals(photographyClub.getMemberList().get(memberIndex).getPosition())){
                            memberPositionIndex = i;
                            sOPanel.getPositionComboBox().setSelectedIndex(memberPositionIndex);
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
                if(sOPanel.clubs.getSelectedIndex()==0){
                    memberIndex = sOPanel.getDeleteIndex().getSelectedIndex();
                    memberName = mathClub.getMemberList().get(memberIndex).getName();
                    sOPanel.nameDeleteField.setText(memberName);
                }
                else if(sOPanel.clubs.getSelectedIndex()==1){
                    memberIndex = sOPanel.getDeleteIndex().getSelectedIndex();
                    memberName = danceClub.getMemberList().get(memberIndex).getName();
                    sOPanel.nameDeleteField.setText(memberName);
                }
                else{
                    memberIndex = sOPanel.getDeleteIndex().getSelectedIndex();
                    memberName = photographyClub.getMemberList().get(memberIndex).getName();
                    sOPanel.nameDeleteField.setText(memberName);

                }
            }
        };


        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(770,600);
        frame.setVisible(true);
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