public class DanceClub extends Club{
    public String clubChoreographer;
    public void addClubChoreographer(Member choreographerMember){
        super.memberList.add(choreographerMember);
    }
    public void removeClubChoreographer(int memberIndex){
        super.memberList.remove(memberIndex);
    }
}
