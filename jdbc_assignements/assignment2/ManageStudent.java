package jdbc_assignements.assignment2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class ManageStudent {
    Connection connection = Connectivity.connection();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    void alter(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("alter table student add gender varchar(3)");
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    void fetchYear(){
        try {
            Statement statement = connection.createStatement();
            String query = "select * from student where year ='3' and percentage>70";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                System.out.println("id : "+resultSet.getInt(1)+" name : "+resultSet.getString(2)+" subject : "+resultSet.getString(3)+" city : "+resultSet.getString(4)+" marks : "+resultSet.getInt(5));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    void fetchId(){
        try {
            Statement statement = connection.createStatement();
            String query = "select * from student where id between 1 and 10";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                System.out.println("id : "+resultSet.getInt(1)+" name : "+resultSet.getString(2)+" subject : "+resultSet.getString(3)+" city : "+resultSet.getString(4)+" marks : "+resultSet.getInt(5));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    void case4() throws IOException {
        Boolean flag = true;
        ManageStudent manageDatabase = new ManageStudent();
        while(flag){
            System.out.println("1: add data\n2:update data\n3:remove data\n0:Exit");
            int choice = Integer.parseInt(bufferedReader.readLine());
            switch (choice){

                case 1: manageDatabase.add();
                    break;
                case 2: manageDatabase.update();
                    break;
                case 3: manageDatabase.remove();
                    break;
                case 0: flag=false;
                    break;
                default:
                    System.out.println("You  have entered wrong choice");
            }
        }
    }
    void add(){
        for(int i=1;i<=3;i++) {
            System.out.println("enter student data insert");
            try {
                System.out.println("Enter id of student");
                int id = Integer.parseInt(bufferedReader.readLine());
                System.out.println("Enter name");
                String name = bufferedReader.readLine();
                System.out.println("enter year");
                String year = bufferedReader.readLine();
                System.out.println("Enter percentage");
                int percentage = Integer.parseInt(bufferedReader.readLine());
                System.out.println("Enter city");
                String city = bufferedReader.readLine();
                System.out.println("Enter gender");
                String gender = bufferedReader.readLine();
                PreparedStatement preparedStatement = connection.prepareStatement("insert into employee values(?,?,?,?,?,?)");
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, year);
                preparedStatement.setInt(4, percentage);
                preparedStatement.setString(5, city);
                preparedStatement.setString(6, gender);
                preparedStatement.execute();
            } catch (IOException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    void update(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE employee SET ename = CONCAT('Mr. ', ename) WHERE GENDER = 'M';");
            preparedStatement.execute();
            PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE employee SET ename = CONCAT('Ms. ', ename) WHERE GENDER = 'F';");
            preparedStatement1.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    void remove(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from student where year=4");
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
//Press 1 :: Add Employee Details
//Press 2 :: Show All Records
//Press 3 :: Alter Table
//Press 4 :: TY and % > 70
//Press 5 :: ID between 1 and 10
//Press 6 :: Batch Execute
//3
//Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
//Connection Established.....
//Table altered successfully
//Connection Established.....
//Press 1 :: Add Employee Details
//Press 2 :: Show All Records
//Press 3 :: Alter Table
//Press 4 :: TY and % > 70
//Press 5 :: ID between 1 and 10
//Press 6 :: Batch Execute
//1
//Enter number of Student you want to add ....
//2
//Enter Name::
//Tanmay
//Enter Year ::
//3
//Enter percentage ::
//99
//Enter city ::
//Pune
//Enter gender ::
//m
//Connection Established.....
//2 Students added successfully
//Enter Name::
//Aniket
//Enter Year ::
//4
//Enter percentage ::
//88
//Enter city ::
//Pune
//Enter gender ::
//m
//Connection Established.....
//2 Students added successfully
//Press 1 :: Add Employee Details
//Press 2 :: Show All Records
//Press 3 :: Alter Table
//Press 4 :: TY and % > 70
//Press 5 :: ID between 1 and 10
//Press 6 :: Batch Execute
//2
//Connection Established.....
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//ID :: 1
//Name :: Tanmay
//Year :: 3
//Percentage :: 99
//City :: Pune
//Gender :: m
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//ID :: 2
//Name :: Aniket
//Year :: 4
//Percentage :: 88
//City :: Pune
//Gender :: m
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//Press 1 :: Add Employee Details
//Press 2 :: Show All Records
//Press 3 :: Alter Table
//Press 4 :: TY and % > 70
//Press 5 :: ID between 1 and 10
//Press 6 :: Batch Execute
//6
//Connection Established.....
//Exception in Batch
//Press 1 :: Add Employee Details
//Press 2 :: Show All Records
//Press 3 :: Alter Table
//Press 4 :: TY and % > 70
//Press 5 :: ID between 1 and 10
//Press 6 :: Batch Execute
//2
//Connection Established.....
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//ID :: 1
//Name :: Mr. Tanmay
//Year :: 3
//Percentage :: 99
//City :: Pune
//Gender :: m
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//ID :: 2
//Name :: Mr. Aniket
//Year :: 4
//Percentage :: 88
//City :: Pune
//Gender :: m
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//ID :: 3
//Name :: Mr. yash
//Year :: 2
//Percentage :: 88
//City :: agra
//Gender :: M
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//ID :: 4
//Name :: Ms. Krati
//Year :: 2
//Percentage :: 88
//City :: agra
//Gender :: F
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//ID :: 5
//Name :: Ms. Shreay
//Year :: 3
//Percentage :: 90
//City :: MP
//Gender :: F
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//Press 1 :: Add Employee Details
//Press 2 :: Show All Records
//Press 3 :: Alter Table
//Press 4 :: TY and % > 70
//Press 5 :: ID between 1 and 10
//Press 6 :: Batch Execute
//4
//Connection Established.....
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//ID :: 1
//Name :: Mr. Tanmay
//Year :: 3
//Percentage :: 99
//City :: Pune
//Gender :: m
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//ID :: 5
//Name :: Ms. Shreay
//Year :: 3
//Percentage :: 90
//City :: MP
//Gender :: F
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//Press 1 :: Add Employee Details
//Press 2 :: Show All Records
//Press 3 :: Alter Table
//Press 4 :: TY and % > 70
//Press 5 :: ID between 1 and 10
//Press 6 :: Batch Execute
//5
//Connection Established.....
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//ID :: 1
//Name :: Mr. Tanmay
//Year :: 3
//Percentage :: 99
//City :: Pune
//Gender :: m
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//ID :: 2
//Name :: Mr. Aniket
//Year :: 4
//Percentage :: 88
//City :: Pune
//Gender :: m
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//ID :: 3
//Name :: Mr. yash
//Year :: 2
//Percentage :: 88
//City :: agra
//Gender :: M
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//ID :: 4
//Name :: Ms. Krati
//Year :: 2
//Percentage :: 88
//City :: agra
//Gender :: F
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//ID :: 5
//Name :: Ms. Shreay
//Year :: 3
//Percentage :: 90
//City :: MP
//Gender :: F
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//Press 1 :: Add Employee Details
//Press 2 :: Show All Records
//Press 3 :: Alter Table
//Press 4 :: TY and % > 70
//Press 5 :: ID between 1 and 10
//Press 6 :: Batch Execute