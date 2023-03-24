package jdbc_assignements.assignment2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentData {
    public static void main(String[] args) throws IOException {
        Boolean flag = true;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ManageStudent manageDatabase = new ManageStudent();
        while(flag){
            System.out.println("1: insert data\n2:retrive data\n3:add column\n4:fetch data\n5:update data\n6:delete some data\n0:Exit");
            int choice = Integer.parseInt(bufferedReader.readLine());
            switch (choice){

                case 1: manageDatabase.alter();
                    break;
                case 2: manageDatabase.fetchYear();
                    break;
                case 3: manageDatabase.fetchId();
                    break;
                case 4: manageDatabase.case4();
                    break;
                case 0: flag=false;
                    break;
                default:
                    System.out.println("You  have entered wrong choice");
            }
    }
}
}
