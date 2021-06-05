package sample;

import com.mongodb.*;
import javafx.application.Application;

import java.io.FileWriter;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyGymManager implements  GymManager {
    Scanner scanner = new Scanner(System.in);

    private String memberName;
    private int memberAge;
    private String guardianName;
    private int memberNo;
    private String memberCat;
    private String schoolName;
    private int count = 1;
    private ArrayList<String> details = new ArrayList<String>();

    static  MongoClient mongoClient;
    static {
        try{
            mongoClient = new MongoClient();

        } catch (UnknownHostException unknownHostException) {
            unknownHostException.printStackTrace();
        }
    }

    public static  DB mongoDB = mongoClient.getDB("GymManagementSystem");
    public static  DBCollection dbCollection = mongoDB.getCollection( "Gym Members");
    public static BasicDBObjectBuilder members = BasicDBObjectBuilder.start();

    @Override
    public void add(String option) throws UnknownHostException {

            System.out.println("\n -----Enter the member type----- \n N - Normal Member \n O - Over 60 Member \n S - Student Member ");
            System.out.print("\n Please enter the option - ");

            option = scanner.nextLine().toLowerCase();

            switch (option) {
                case "s":
                    memberCat = "Student Member";

                    System.out.print("\n Please enter the full name - ");
                    memberName = scanner.nextLine().toLowerCase();

                    System.out.print("\n Please enter the membership number - ");
                    memberNo = scanner.nextInt();

                    scanner.nextLine();
                    System.out.print("\n Please enter the guardian's full name -  ");
                    guardianName = scanner.nextLine().toLowerCase();

                    System.out.print("\n Please enter the school name - ");
                    schoolName = scanner.nextLine().toLowerCase();

                    MongoDatabase.SettingStudentMember(memberNo, memberName, guardianName, schoolName, memberCat);
                    System.out.println("\n Member added successfully!");
                    count++;

                    break;
                case "o":
                    memberCat = "Over 60 Member";
                    System.out.print("\n Please enter the full name - ");
                    memberName = scanner.nextLine().toLowerCase();
                    System.out.print("\n Please enter the membership number - ");
                    memberNo = scanner.nextInt();

                    while (true) {
                        System.out.print("\n Please enter the age - ");
                        memberAge = scanner.nextInt();
                        if (memberAge >= 60) {
                            this.memberAge = memberAge;

                            break;
                        } else {
                            System.out.println("Invalid age! (age>=60)");
                        }
                    }

                    MongoDatabase.SettingOver60Member(memberNo, memberName, memberAge, memberCat);
                    System.out.println("\n Member added successfully!");
                    count++;

                    break;
                case "n":
                    memberCat = "Default Member";
                    scanner.nextLine();
                    System.out.print("\n Please enter the full name - ");
                    memberName = scanner.nextLine().toLowerCase();

                    System.out.print("\n Please enter the membership number - ");
                    memberNo = scanner.nextInt();

                    MongoDatabase.SettingDefaultMember(memberNo, memberName, memberCat);
                    System.out.println("\n Member added successfully!");
                    count++;

                    break;
                default:
                    System.out.println("\n Invalid option!");
            }
        }


    @Override
    public void delete() throws UnknownHostException {

        DB db = MongoDatabase.configuration();
        DBCollection col = db.getCollection("Gym Members");
        Scanner sc = new Scanner(System.in);
        System.out.print("\n Enter the member's ID that you want to delete - ");
        int membershipNumber = sc.nextInt();
        col.remove(new BasicDBObject().append("Membership No", membershipNumber));
        System.out.println("Member removed successfully!");
    }

    @Override
    public void printConsole() throws UnknownHostException {
        //retrieving data
        DBObject dbObject = null;
        DBCursor dbCursor = dbCollection.find();
        System.out.println("--------------------------------------------------------------------------");
        while (dbCursor.hasNext()){
            dbObject = dbCursor.next();
            System.out.println("Membership No   : "+dbObject.get("Membership No"));
            System.out.println("Member Name     : "+dbObject.get("Member Name"));
            System.out.println("Member Category : "+dbObject.get("Member Category"));
            System.out.println("Member Age      : "+dbObject.get("Member Age"));
            System.out.println("School Name     : "+dbObject.get("School Name"));
            System.out.println("------------------------------------------------------------------------");
        }
    }


    @Override
    public void write() {
        FileWriter MemberDetails = null;
        try {
            MemberDetails = new FileWriter("Member_Details.txt");
            DBObject dbObject = null;
            DBCursor dbCursor = dbCollection.find();
            MemberDetails.write("------------------------------------------------------");
            while (dbCursor.hasNext()){
                dbObject = dbCursor.next();
                try{
                    MemberDetails.write("\nMembership No    : " + dbObject.get("Membership No").toString());
                }catch(NullPointerException exception){
                    MemberDetails.write("-");
                }

                try{
                    MemberDetails.write("\nMember Name      : " + dbObject.get("Member Name").toString());
                }catch(NullPointerException exception){
                    MemberDetails.write("-");
                }
                try{
                    MemberDetails.write("\nMember Category  : " + dbObject.get("Member Category").toString());
                }catch(NullPointerException exception){
                    MemberDetails.write("-");
                }
                try{
                    MemberDetails.write("\nSchool Name      : " + dbObject.get("School Name").toString());
                }catch(NullPointerException exception){
                    MemberDetails.write("-");
                }
                try{
                    MemberDetails.write("\nMember Age: " + dbObject.get("Member Age").toString());
                }catch(NullPointerException exception){
                    MemberDetails.write("-");
                }
            }
            MemberDetails.close();
            System.out.println("File Saved Successfully! ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void open() {

            Application.launch(Tableview.class);

    }

    @Override
    public void quit() {
        System.out.println("\n Program will now quit!");
        System.exit(0);
    }

}
