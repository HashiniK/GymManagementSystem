package sample;

public class DefaultMember {
    private int membershipNo;
    public String memberName;
    private String memberCat;

    public DefaultMember(int membershipNo, String memberName, String memberCat) {
        this.membershipNo = membershipNo;
        this.memberName = memberName;
        this.memberCat = memberCat;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getMembershipNo() {
        return membershipNo;
    }

    public void setMembershipNo(int membershipNo) {
        this.membershipNo = membershipNo;
    }

    public void setMemberCat (String memberCat) { this.memberCat = memberCat;}

    public String getMemberCat (){return memberCat;}



}

