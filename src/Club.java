import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class Club {
    public ArrayList<Member> memberList = new ArrayList<>();
    public String president;
    public String vicePresident;

    public void addMember(String memberInfo){

    }
    public void addPresident(Member presidentMember){
        memberList.add(presidentMember);
    }
    public void addVicePresident(String vicePresidentInfo){

    }
    public void removeMember(String memberInfo){

    }
    public void removePresident(String vicePresidentInfo){

    }
    public void removeVicePresident(String presidentInfo){

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
    public void printList(){
        for(Member member: memberList){
            member.toString();
        }
    }
}
