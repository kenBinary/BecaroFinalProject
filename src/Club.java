import java.util.ArrayList;

public class Club {
    public ArrayList<Member> memberList = new ArrayList<>();
    public String president;
    public String vicePresident;

    public void addMember(Member memberInfo){
        memberList.add(memberInfo);
    }
    public void addPresident(Member presidentMember){
        memberList.add(presidentMember);
    }
    public void addVicePresident(Member vicePresidentMember){
        memberList.add(vicePresidentMember);
    }
    public void removeMember(int memberIndex){
        memberList.remove(memberIndex);
    }
    public void removePresident(int memberIndex){
        memberList.remove(memberIndex);
    }
    public void removeVicePresident(int memberIndex){
        memberList.remove(memberIndex);
    }
    public int getNumberOfMembers(){
        return memberList.size();
    }
    public ArrayList<Member> getMemberList(){
        return memberList;
    }
    public void addMembersToList(ArrayList<Member> list){
        memberList.addAll(list);
    }
}
