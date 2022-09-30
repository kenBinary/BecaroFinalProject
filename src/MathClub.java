
public class MathClub extends Club {
    public String ClubSecretary;
    public void addSecretary(Member secretaryMember){
        super.memberList.add(secretaryMember);
    }
    public void removeSecretary(int memberIndex){
        super.memberList.remove(memberIndex);
    }
}
