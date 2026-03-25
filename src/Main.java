import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String url="jdbc:oracle:thin:@localhost:1521:xe";
        String user="RIBERA";
        String password="ribera";
        Scanner sc=new Scanner(System.in);

        try (Connection conn = DriverManager.getConnection(url,user,password)){
            String sql="SELECT ROUND(AVG(SALARIO),2) as PROMEDIO FROM EMPLEADO2";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                double promedio =resultSet.getDouble("promedio");
                System.out.println(promedio);
            }
        }catch (SQLException e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}
