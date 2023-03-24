package jdbc_assignements.assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class ManageDatabase {
    Connection connection = Connectivity.connection();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public void retrieve(){

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("select * from employee");
            while(resultSet.next()){
                System.out.println("id : "+resultSet.getInt(1)+" name : "+resultSet.getString(2)+" designation : "+resultSet.getString(3)+" date of joining : "+resultSet.getString(4)+" date of expiry : "+resultSet.getString(5)+" salary : "+resultSet.getInt(6)+" date of joining : "+resultSet.getString(7));
            }
        }
        catch ( SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void insert(){
        for(int i=1;i<=10;i++) {
            System.out.println("enter employee data insert");
            try {
                System.out.println("Enter id of employee");
                int id = Integer.parseInt(bufferedReader.readLine());
                System.out.println("Enter name");
                String name = bufferedReader.readLine();
                System.out.println("enter designation");
                String designation = bufferedReader.readLine();
                System.out.println("Enter date of joining");
                String doj = bufferedReader.readLine();
                System.out.println("Enter date of expiry");
                String exp = bufferedReader.readLine();
                System.out.println("Enter salary");
                int salary = Integer.parseInt(bufferedReader.readLine());
                System.out.println("Enter status");
                String status = bufferedReader.readLine();
                PreparedStatement preparedStatement = connection.prepareStatement("insert into employee values(?,?,?,?,?,?,?)");
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, designation);
                preparedStatement.setString(4, doj);
                preparedStatement.setString(5, exp);
                preparedStatement.setInt(6, salary);
                preparedStatement.setString(7, status);
                preparedStatement.execute();
            } catch (IOException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    void addColumn(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("alter table employee add city varchar(25) default 'pune'");
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    void fetch(){
        try {
            Statement statement = connection.createStatement();
            String query = "select * from employee where city = 'pune' and salary>20000";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                System.out.println("id : "+resultSet.getInt(1)+" name : "+resultSet.getString(2)+" designation : "+resultSet.getString(3)+" date of joining : "+resultSet.getString(4)+" date of expiry : "+resultSet.getString(5)+" salary : "+resultSet.getInt(6)+" date of joining : "+resultSet.getString(7)+" city : "+resultSet.getString(8));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    void update(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update employee set salary=salary+1000 where (EXTRACT(YEAR FROM curdate())- EXTRACT(YEAR FROM doj))>3 ");
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    void delete(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from employee where exp<curdate()");
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
