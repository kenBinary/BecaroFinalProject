import javax.swing.*;
import java.awt.*;

public class SecondOperationPanel extends JPanel {
    String[] departments = {"PS","CLE","CAE","CAFAE","CASE","CBAE","CCE","CCJE","CEE","CHE","CHSE","CTE","TS","BED","None"};
    JButton update = new JButton("Update");
    JButton delete = new JButton("Delete");
    Integer[] memberIndex = {1,2,3,444};
    JComboBox<Integer> updateIndex = new JComboBox<>(memberIndex);
    JComboBox<Integer> deleteIndex = new JComboBox<>(memberIndex);
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

        nameLabel.setBounds(68,39,40,30);
        updateIndex.setBounds(5,60,60,30);
        nameField.setBounds(65,60,173,30);
        departmentComboBox.setBounds(235,60,75,30);
        update.setBounds(305,60,65,30);

        nameDeleteLabel.setBounds(68,69,40,30);
        deleteIndex.setBounds(5,120,60,30);
        deleteField.setBounds(65,120,173,30);
        delete.setBounds(235,120,75,30);







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
    }
    public JButton getUpdate(){
        return update;
    }
    public JButton getDelete(){
        return delete;
    }

}
