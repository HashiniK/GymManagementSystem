package sample;

import com.mongodb.*;

import java.net.UnknownHostException;

public class MongoDatabase {
    public static DB configuration() throws UnknownHostException {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("GymManagementSystem");
        return db;
    }



    public static DBObject DefaultMember(DefaultMember DefaultMember) {
        BasicDBObjectBuilder documentBuilder = BasicDBObjectBuilder.start();

        documentBuilder.append("Membership No",DefaultMember.getMembershipNo());
        documentBuilder.append("Member Name", DefaultMember.getMemberName());
        documentBuilder.append("Member Category", DefaultMember.getMemberCat());

        return documentBuilder.get();
    }

    public static DBObject StudentMember(StudentMember StudentMember) {
        BasicDBObjectBuilder dbObjectBuilder = BasicDBObjectBuilder.start();

        dbObjectBuilder.append("Membership No",StudentMember.getMembershipNo());
        dbObjectBuilder.append("Member Name", StudentMember.getMemberName());
        dbObjectBuilder.append("Guardian Name", StudentMember.getGuardianName());
        dbObjectBuilder.append("School Name", StudentMember.getSchoolName());
        dbObjectBuilder.append("Member Category",StudentMember.getMemberCat());

        return dbObjectBuilder.get();
    }

    public static DBObject Over60Member(Over60Member Over60Member) {
        BasicDBObjectBuilder documentBuilder = BasicDBObjectBuilder.start();

        documentBuilder.append("Membership No",Over60Member.getMembershipNo());
        documentBuilder.append("Member Name", Over60Member.getMemberName());
        documentBuilder.append("Member Age", Over60Member.getAge());
        documentBuilder.append("Member Category",Over60Member.getMemberCat());

        return documentBuilder.get();
    }

    public static void SettingDefaultMember(int memberNo, String memberName,String memberCat)throws UnknownHostException {
        DefaultMember members = new DefaultMember(memberNo, memberName,memberCat);
        DBObject dbObject = MongoDatabase.DefaultMember(members);
        DB database =MongoDatabase.configuration();
        DBCollection collection = database.getCollection("Gym Members");
        collection.insert(dbObject);
    }

    public static void SettingStudentMember(int membershipNo, String memberName, String guardianName,String schoolName, String memberCat) throws UnknownHostException {
        StudentMember members = new StudentMember(membershipNo, memberName, guardianName,schoolName,memberCat);
        DBObject dbObject = MongoDatabase.StudentMember(members);
        DB database =MongoDatabase.configuration();
        DBCollection dbCollection = database.getCollection("Gym Members");
        dbCollection.insert(dbObject);
    }

    public static void SettingOver60Member(int membershipNo, String membershipName, int age, String memberCat) throws UnknownHostException {
        Over60Member members = new Over60Member(membershipNo, membershipName, memberCat, age);
        DBObject dbObject = MongoDatabase.Over60Member(members);
        DB database =MongoDatabase.configuration();
        DBCollection collection = database.getCollection("Gym Members");
        collection.insert(dbObject);
    }

    public static DBObject Date (int year, int month, int day) throws UnknownHostException {
        Date Options = new Date(year, month, day);
        DBObject dbObject = MongoDatabase.Date(Options);
        DB database =MongoDatabase.configuration();
        DBCollection dbCollection = database.getCollection("Gym Members");
        dbCollection.insert(dbObject);
        return dbObject;
    }

    private static DBObject Date(Date options) {

        return null;
    }
}