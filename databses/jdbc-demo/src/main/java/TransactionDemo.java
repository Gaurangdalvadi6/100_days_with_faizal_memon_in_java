import java.sql.*;

public class TransactionDemo {

    private static final String URL = "jdbc:mysql://localhost:3306/demo_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Admin@123";

    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD)) {
            System.out.println("Connected to the Database!");

            // Turned off auto commit  == no auto save

            connection.setAutoCommit(false);
            try {
                // Order, OrderItems
                // insert into order
                int orderId =insertOrder(connection,101,"Dev",2000.0);

                // insert into orderItem
                insertOrderItem(connection,orderId,"Laptop1",1,2000.0);

                // manual commit
                connection.commit();
                System.out.println("Transaction commited successfully");
            } catch (Exception e) {
                e.printStackTrace();
                connection.rollback();
                System.out.println("Operation rollback successfully");
            } finally {
                connection.setAutoCommit(true);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void insertOrderItem(Connection connection, int orderId, String productName, int quantity, double price) {
        String sql = "insert into order_items (order_id,product_name,quantity,price) values(?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,orderId);
            statement.setString(2,productName);
            statement.setInt(3,quantity);
            statement.setDouble(4,price);

//            int x = 10/0;

            int rows = statement.executeUpdate();
            System.out.println("inserted into order_items : " + rows);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static int insertOrder(Connection connection, int customerId, String name, double price) {
        String sql = "insert into orders (user_id,customer_name,total_amount) values(?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            statement.setInt(1,customerId);
            statement.setString(2,name);
            statement.setDouble(3,price);
            int rows = statement.executeUpdate();
            System.out.println("inserted into orders : " + rows);

            try (ResultSet rs = statement.getGeneratedKeys()){
                if (rs.next()){
                    int orderId = rs.getInt(1);
                    System.out.println("Order Id : " + orderId);
                    return orderId;
                }else {
                    throw new SQLException("Order Id not generated");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
