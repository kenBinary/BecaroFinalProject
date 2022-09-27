import javax.swing.*;
import java.awt.*;

public class SecondOperationPanel extends JPanel {
    JButton update = new JButton("Update");
    JButton delete = new JButton("Delete");
    Integer[] memberIndex = {1,2,3,44};
    JComboBox<Integer> updateIndex = new JComboBox<>(memberIndex);
    JComboBox<Integer> deleteIndex = new JComboBox<>(memberIndex);
    JTextField nameField = new JTextField();
    JTextField departmentField = new JTextField();
    JTextField deleteField = new JTextField();
    SecondOperationPanel(){
        this.setLayout(null);
        JLabel updateDelete = new JLabel("Update/Delete");
        updateDelete.setBounds(5,5,290,25);
        updateDelete.setFont(new Font("Serif",Font.BOLD,20));
        updateDelete.setHorizontalAlignment(SwingConstants.CENTER);

        update.setBounds(5,35,65,35);
        //y=30
        delete.setBounds(5,145,65,35);
        //y=60
        updateIndex.setBounds(70,35,65,35);
        //x=105
        deleteIndex.setBounds(70,145,65,35);
        //x=105

        nameField.setBorder(BorderFactory.createTitledBorder("Name"));
        departmentField.setBorder(BorderFactory.createTitledBorder("Department"));
        deleteField.setBorder(BorderFactory.createTitledBorder("Name"));
        nameField.setBounds(140,35,150,55);
        departmentField.setBounds(140,90,150,55);
        deleteField.setBounds(140,145,150,55);



        this.add(updateDelete);
        this.add(update);
        this.add(delete);
        this.add(updateIndex);
        this.add(deleteIndex);
        this.add(nameField);
        this.add(departmentField);
        this.add(deleteField);



    }
}
