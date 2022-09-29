import javax.swing.*;
import java.awt.*;

public class SecondOperationPanel extends JPanel {
    String[] departments = {"PS","CLE","CAE","CAFAE","CASE","CBAE","CCE","CCJE","CEE","CHE","CHSE","CTE","TS","BED","None"};
    String[] clubNames = {"Math Club","Dance Club","Photography Club"};
    JComboBox<String> clubs =new  JComboBox<>(clubNames);

    JButton update = new JButton("Update");
    JButton delete = new JButton("Delete");
    JComboBox<Integer> updateIndex = new JComboBox<>();
    JComboBox<Integer> deleteIndex = new JComboBox<>();
    JTextField nameField = new JTextField();
    JTextField deleteField = new JTextField();

    JLabel nameLabel = new JLabel("Name");
    JLabel departmentLabel = new JLabel("Department");
    JLabel nameDeleteLabel = new JLabel("Name");

    JComboBox<String> departmentComboBox = new JComboBox<>(departments);
    SecondOperationPanel(){
        this.setLayout(null);
        JLabel updateDelete = new JLabel("Update/Delete");
        updateDelete.setBounds(5,5,290,25);
        updateDelete.setFont(new Font("Serif",Font.BOLD,20));
        updateDelete.setHorizontalAlignment(SwingConstants.CENTER);


        clubs.setBounds(5,50,170,25);

        nameLabel.setBounds(68,69,40,30);
        updateIndex.setBounds(5,90,60,30);
        nameField.setBounds(65,90,173,30);
        departmentComboBox.setBounds(235,90,75,30);
        update.setBounds(305,90,65,30);

        nameDeleteLabel.setBounds(68,128,40,30);
        deleteIndex.setBounds(5,150,60,30);
        deleteField.setBounds(65,150,173,30);
        delete.setBounds(235,150,75,30);


        this.add(updateDelete);
        this.add(update);
        this.add(delete);
        this.add(updateIndex);
        this.add(deleteIndex);
        this.add(nameField);
        this.add(deleteField);
        this.add(departmentLabel);
        this.add(departmentComboBox);
        this.add(nameLabel);
        this.add(nameDeleteLabel);
        this.add(clubs);
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
    public void removeComboBoxItems(){
        updateIndex.removeAllItems();
        deleteIndex.removeAllItems();
        this.revalidate();
        this.repaint();
    }
    public JButton getDelete(){
        return delete;
    }
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

}
