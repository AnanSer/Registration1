import java.sql.*;

public class Database {
    public static void main(String[] args) {
        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/user/IdeaProjects/DB/testDB.db");
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS contact" +
                                "(name TEXT, ID TEXT , phoneNumber INTEGER)");
//            statement.execute("INSERT INTO contact (name, ID, phoneNumber)" +
//                                " VALUES ('Babi', '218', 0910)" );
//            statement.execute("INSERT INTO contact (name, ID, phoneNumber)" +
//                    " VALUES ('babila', '222', 0920)" );
//            statement.execute("DELETE FROM contact WHERE name = 'babila'");
            statement.execute("SELECT * FROM contact");
            ResultSet results = statement.getResultSet();
            while(results.next()){
                System.out.println(results.getString("name") + " "+
                                    results.getString("ID") + " ");
//                                    results.getInt("phoneNumber" + " "));
            }
            statement.close();
            conn.close();
        }catch(SQLException e){
            System.out.println("something went wrong  " + e.getMessage());
        }
    }
}
