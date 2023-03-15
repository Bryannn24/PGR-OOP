package lectures._18;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Lecture18 {
    public static String date = "2023-03-15";

    public static void main(String[] args)
    {
        //# 1. Registrer driveren
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //# 2. Hent tilkobling
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Lecture18?allowPublicKeyRetrieval=true&useSSL=false",
                    "lecture18",
                    "password18"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //# 2.1. Sjekke om tilkoblingen fungerer
        System.out.println("Tilkoblingen fungerer!");

        //# 3. Gjør klar uttrykk som skal kjøres
        try {
            Statement statement = connection.createStatement();

            String query = "CREATE TABLE IF NOT EXISTS users"
            + "("
                    + "id INT AUTO_INCREMENT, "
                    + "username VARCHAR(64), "
                    + "password VARCHAR(256), "
                    + "PRIMARY KEY(id)"
            +")";

            statement.execute(query);

            System.out.println(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        //# 4. Kjør uttrykket

        //# 5. Rydd opp etter oss
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
