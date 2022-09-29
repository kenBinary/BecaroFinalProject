import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;

public class MathClubPanel extends JPanel {
    DefaultTableModel model = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    FileHandler fileHandler = new FileHandler();
    MathClubPanel(MathClub mathClub){
        this.setLayout(new BorderLayout());

        String[] columnNames = { "#", "Position","Name", "Department" };
        model.setColumnIdentifiers(columnNames);
        JTable mathClubData = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(mathClubData);
        this.add(scrollPane,BorderLayout.CENTER);
        initializeRecord(mathClub);
    }
    public void addNewRecord(Member member,MathClub mathClub){
        model.addRow(member.toObjectArray(mathClub.getNumberOfMembers()+1));
        this.revalidate();
        this.repaint();
    }
    public void initializeRecord(MathClub mathClub){
        File file = new File("MathClub.csv");
        if (file.exists()){
            mathClub.addMembersToList(fileHandler.readFile("MathClub.csv"));
            for (int i = 0; i < mathClub.getNumberOfMembers(); i++) {
                model.addRow(mathClub.memberList.get(i).toObjectArray(i+1));
            }
            this.revalidate();
            this.repaint();
        }

    }
    public void removeData(){
        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        this.revalidate();
        this.repaint();
    }
    public void updateTableRecord(MathClub mathClub){
        for (int i = 0; i < mathClub.getNumberOfMembers(); i++) {
            model.addRow(mathClub.memberList.get(i).toObjectArray(i+1));
        }
        this.revalidate();
        this.repaint();
    }
}
