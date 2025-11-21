import java.sql.*;

public class JdbcDemo {

    private static final String URL = "jdbc:mysql://localhost:3306/demo_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Admin@123";

    public static void main(String[] args) {

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD)) {
            System.out.println("Connected to the Database!");
            insertStudent(connection,"Abhay","abhay@gmail.com");
//            updateStudent(connection,3,"sanjay","sanjay@gmail.com");
//            selectStudents(connection);
//            deleteStudent(connection,3);
            selectStudents(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertStudent(Connection connection,String name,String email){
//        String sql = "INSERT INTO student (name, email) VALUES ('" + name + "','"+ email +"')";
        String sql = "INSERT INTO student (name, email) VALUES (?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,name);
            statement.setString(2,email);
            int rows = statement.executeUpdate();
            System.out.println("INSERTED : " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void selectStudents(Connection connection){
        String sql = "select * from student";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery();
            System.out.println("Student List : ");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println(id + " : " + name + " : " + email);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateStudent(Connection connection,int id,String name,String email){
//        String sql = "UPDATE student set name ='" + name +"', email ='"+ email+"' where id=" +id;
        String sql = "UPDATE student SET name = ?, email = ? WHERE id = ?";

        try (PreparedStatement psmt= connection.prepareStatement(sql)){
            psmt.setString(1,name);
            psmt.setString(2,email);
            psmt.setInt(3,id);
            int rows = psmt.executeUpdate();
            System.out.println("Updated : " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudent(Connection connection,int id){
        String sql = "delete from student where id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,id);
            int rows = statement.executeUpdate();
            System.out.println("Deleted : " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
