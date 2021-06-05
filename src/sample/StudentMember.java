package sample;

public class StudentMember extends DefaultMember {
    private String schoolName;
    private String guardianName;
    public StudentMember(int membershipNo, String memberName, String memberCat, String schoolName,String guardianName) {
        super(membershipNo, memberName, memberCat);
        this.schoolName = schoolName;
        this.guardianName = guardianName;
    }

    public String getGuardianName() {
        return guardianName;
    }
    public String getSchoolName() {
        return schoolName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}