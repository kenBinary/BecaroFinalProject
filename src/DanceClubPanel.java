import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;

public class DanceClubPanel extends JPanel {
    DefaultTableModel model = new DefaultTableModel(){

        @Override
        public boolean isCellEditable(int row, int column) {
            //all cells false
            return false;
        }
    };
    FileHandler fileHandler = new FileHandler();

    DanceClubPanel(DanceClub danceClub){
        this.setLayout(new BorderLayout());
        String[] columnNames = { "#", "Position","Name", "Department" };
        model.setColumnIdentifiers(columnNames);
        JTable danceCLubData = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(danceCLubData);
        this.add(scrollPane,BorderLayout.CENTER);
        initializeRecord(danceClub);
    }

    public void addNewRecord(Member member,DanceClub danceClub){
        model.addRow(member.toObjectArray(danceClub.getNumberOfMembers()+1));
        this.revalidate();
        this.repaint();
    }
    public void initializeRecord(DanceClub danceClub){
        File file = new File("MathClub.csv");
        if (file.exists()){
            danceClub.addMembersToList(fileHandler.readFile("DanceClub.csv"));
            for (int i = 0; i < danceClub.getNumberOfMembers(); i++) {
                model.addRow(danceClub.memberList.get(i).toObjectArray(i+1));
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
    public void updateTableRecord(DanceClub danceClub){
        for (int i = 0; i < danceClub.getNumberOfMembers(); i++) {
            model.addRow(danceClub.memberList.get(i).toObjectArray(i+1));
        }
        this.revalidate();
        this.repaint();
    }
}
