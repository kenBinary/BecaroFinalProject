import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PhotographyClubPanel extends JPanel {
    DefaultTableModel model = new DefaultTableModel(){

        @Override
        public boolean isCellEditable(int row, int column) {
            //all cells false
            return false;
        }
    };;
    FileHandler fileHandler = new FileHandler();

    PhotographyClubPanel(PhotographyClub photographyClub){
        this.setLayout(new BorderLayout());
        String[] columnNames = { "#", "Position","Name", "Department" };
        model.setColumnIdentifiers(columnNames);
        JTable photographyClubData = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(photographyClubData);
        this.add(scrollPane,BorderLayout.CENTER);
        initializeRecord(photographyClub);
    }

    public void addNewRecord(Member member,PhotographyClub photographyClub){
        model.addRow(member.toObjectArray(photographyClub.getNumberOfMembers()+1));
        this.revalidate();
        this.repaint();
    }
    public void initializeRecord(PhotographyClub photographyClub){
        photographyClub.addMembersToList(fileHandler.readFile("PhotographyClub.csv"));
        for (int i = 0; i < photographyClub.getNumberOfMembers(); i++) {
            model.addRow(photographyClub.memberList.get(i).toObjectArray(i+1));
        }
        this.revalidate();
        this.repaint();
    }
}
