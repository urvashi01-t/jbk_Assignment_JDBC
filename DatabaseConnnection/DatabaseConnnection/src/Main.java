import java.sql.*;

public class Main {
    public static <reparedStatement> void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println(1);
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println(2);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login", "root", "1234");
        System.out.println(3);

        String query = "Select * from login12334"; //Table name - login
//		String query = "Insert into login(id, username, password) values (2,'sahid','asdbh')"
//		String query = "Insert into login(id, username, password) values (?,?,?)"	//prepareStatement

        PreparedStatement st = con.prepareStatement("Insert into login12334(idLogin, username, password) values (?,?,?)");
     //create
//        st.setInt(1, 3);
//        st.setString(2, "sagar");
//        st.setString(3, "jdsfk");
//        st.setInt(1, 2);
//        st.setString(2, "dagar");
//        st.setString(3, "jdsfk");
//        ResultSet rs = st.executeQuery(query);
//        int check = st.executeUpdate();
//        System.out.println(4);
//update
        PreparedStatement std = con.prepareStatement("UPDATE login12334 SET username = 'Babar', password= '1223' WHERE idLogin = 2");
        ResultSet rs1 = std.executeQuery(query);
        int check1 = std.executeUpdate();

//select
//
//        PreparedStatement std1 = con.prepareStatement("SELECT * FROM  login12334");
//        ResultSet rs2 = std1.executeQuery(query);
//        int check2 = std1.executeUpdate();

// delete
        PreparedStatement stdd1 = con.prepareStatement("DELETE FROM login12334 WHERE idLogin = 2 ");
        ResultSet rss2 = stdd1.executeQuery(query);
        int check22 = stdd1.executeUpdate();
        System.out.println("Check");
    }
}