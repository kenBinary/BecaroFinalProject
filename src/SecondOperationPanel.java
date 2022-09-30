import javax.swing.*;
import java.awt.*;

public class SecondOperationPanel extends JPanel {
    String[] departments = {"PS","CLE","CAE","CAFAE","CASE","CBAE","CCE","CCJE","CEE","CHE","CHSE","CTE","TS","BED"};
    String[] clubNames = {"Math Club","Dance Club","Photography Club"};
    String[] positions = {"President","Vice President","Member","Secretary","Choreographer"};
    DefaultComboBoxModel modelPositions = new DefaultComboBoxModel(new String[] {"President","Vice President","Member","Secretary"});
    JComboBox<String> positionComboBox = new JComboBox(modelPositions);

    JComboBox<String> clubs =new  JComboBox<>(clubNames);

    JButton update = new JButton("Update");
    JButton delete = new JButton("Delete");
    JComboBox<Integer> updateIndex = new JComboBox<>();
    JComboBox<Integer> deleteIndex = new JComboBox<>();
    JTextField nameField = new JTextField();
    JTextField nameDeleteField = new JTextField();
    JLabel nameLabel = new JLabel("Name");
    JLabel departmentLabel = new JLabel("Department");
    JLabel positionLabel = new JLabel("Position");
    JLabel nameDeleteLabel = new JLabel("Name");

    JComboBox<String> departmentComboBox = new JComboBox<>(departments);
    SecondOperationPanel(){
        this.setLayout(null);
        JLabel updateDelete = new JLabel("Update/Delete");
        updateDelete.setBounds(5,5,290,25);
        updateDelete.setFont(new Font("Serif",Font.BOLD,20));
        updateDelete.setHorizontalAlignment(SwingConstants.CENTER);

        clubs.setSelectedIndex(0);
        clubs.setBounds(5,50,170,25);

        nameLabel.setBounds(68,69,40,30);
        updateIndex.setBounds(5,90,60,30);
        nameField.setBounds(65,90,173,30);
        departmentComboBox.setBounds(235,90,75,30);
        update.setBounds(305,90,65,30);

        positionLabel.setBounds(68,110,90,30);
        positionComboBox.setBounds(65,133,173,30);

        nameDeleteLabel.setBounds(68,155,40,30);
        deleteIndex.setBounds(5,177,60,30);
        nameDeleteField.setBounds(65,177,173,30);
        nameDeleteField.setEditable(false);
        delete.setBounds(235,177,75,30);


        this.add(updateDelete);
        this.add(update);
        this.add(delete);
        this.add(updateIndex);
        this.add(deleteIndex);
        this.add(nameField);
        this.add(nameDeleteLabel);
        this.add(departmentLabel);
        this.add(departmentComboBox);
        this.add(nameLabel);
        this.add(nameDeleteField);
        this.add(positionComboBox);
        this.add(clubs);
        this.add(positionLabel);
    }

    public DefaultComboBoxModel getModelPositions() {
        return modelPositions;
    }

    public int indexOf(String department){
        int index = 0;
        for (int i = 0; i < departments.length ; i++) {
            if(departments[i].equals(department)){
                index = i;
                break;
            }
        }
        return index;
    }
    public String[] getPositions(){
        return positions;
    }
    public JButton getUpdate(){
        return update;
    }

    public void setComboBoxItems(int numOfItems){
        removeComboBoxItems();
        for (int i = 0; i < numOfItems ; i++) {
            updateIndex.addItem(i+1);
            deleteIndex.addItem(i+1);
        }
        this.revalidate();
        this.repaint();
    }
    public JTextField getNameDeleteField(){
        return nameDeleteField;
    }

    public JComboBox<String> getPositionComboBox() {
        return positionComboBox;
    }

    public void removeComboBoxItems(){
        updateIndex.removeAllItems();
        deleteIndex.removeAllItems();
        this.revalidate();
        this.repaint();
    }
    public JButton getDelete(){
        return delete;
    }
//    public String[] getDepartments(){
//        return departments;
//    }
    public JComboBox<Integer> getUpdateIndex(){
        return updateIndex;
    }
    public JComboBox<Integer> getDeleteIndex(){
        return deleteIndex;
    }
    public JComboBox<String> getClubComboBox(){
        return clubs;
    }
    public int getClubComboBoxIndex(){
        return clubs.getSelectedIndex();
    }
    public JTextField getNameField(){
        return nameField;
    }

    public JComboBox<String> getDepartmentComboBox(){
        return departmentComboBox;
    }

}
