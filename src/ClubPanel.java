import javax.swing.*;

public class ClubPanel extends JTabbedPane {
    MathClubPanel mathPanel;
    DanceClubPanel dancePanel;
    PhotographyClubPanel photographyPanel;

    ClubPanel(MathClub mathClub,DanceClub danceClub,PhotographyClub photographyClub){
        mathPanel = new MathClubPanel(mathClub);
        dancePanel = new DanceClubPanel(danceClub);
        photographyPanel = new PhotographyClubPanel(photographyClub);
        this.add("Math Club",mathPanel);
        this.add("Dance Club",dancePanel);
        this.add("Photography Club",photographyPanel);
    }
    public void setTabbedPane(int index){
        this.setSelectedIndex(index);
    }

    public MathClubPanel getMathPanel(){
        return mathPanel;
    }

    public DanceClubPanel getDancePanel() {
        return dancePanel;
    }

    public PhotographyClubPanel getPhotographyPanel() {
        return photographyPanel;
    }
}
