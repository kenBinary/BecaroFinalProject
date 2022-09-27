public class Member {
    private String position;
    private String name;
    private String department;
    Member(){

    }
    Member(String cPosition,String cName,String cDepartment){
        position = cPosition;
        name = cName;
        department = cDepartment;
    }
    public String toString() {
        return (position+","+name+","+department);
    }
    public Object[] toObjectArray(int id){
        Object[] newRecord = {id,position,name,department};
        return newRecord;
    }


    public void setPosition(String position) {
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    public String getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }


}
