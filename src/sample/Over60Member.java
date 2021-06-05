package sample;

public class Over60Member extends DefaultMember{
    private int age;


    public Over60Member(int membershipNo, String memberName, String memberCat, int age ) {
        super (membershipNo, memberName, memberCat);
        this.age = age;
        setAge(age);
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age){
    }
}
