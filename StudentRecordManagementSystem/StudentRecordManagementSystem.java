import java.util.*;
import java.io.*;

//Menu
class MainMenu{
  public void menuadmin(){//admin menu
    System.out.println("\n\t===Student Record Management System===");
    System.out.println("\nSelect");
    System.out.println("Press 1 : Add new student");
    System.out.println("Press 2 : View details of a student");
    System.out.println("Press 3 : Remove a student");
    System.out.println("Press 4 : Update student's details");
    System.out.println("Press 5 : Exit Program");

  }
  public void menustudent(){//student menu
    System.out.println("\t===Student Record Management System===");
    System.out.println("\nSelect");
    System.out.println("Press 1 : View details of a student");
    System.out.println("Press 2 : Exit Program");

  }
}

//Add new student and create a text file to store details
class Student_Add{
    public void createFile(){
        Scanner sc=new Scanner(System.in);

        StudentDetail student=new StudentDetail();
        student.getInfo();
        try{
            File f1=new File(student.id+".txt");
            if(f1.createNewFile()){
                FileWriter myWriter = new FileWriter(student.id+".txt");
                myWriter.write(
                "Student's ID              :"+student.id+"\n"+
                "Student's Name            :"+student.name+"\n"+
                "Student's Gender          :"+student.gender+"\n"+
                "Student's Contact Number  :"+student.contact_num+"\n"+
                "Student's Address         :"+student.address+"\n"+
                "Student's Intake          :"+student.intake+"\n"+
                "Student's CGPA            :"+student.cgpa);
                myWriter.close();
                System.out.println("\nStudent Details added \n");

                System.out.print("\nPress Enter to Continue...");
                sc.nextLine();
            }
            else{
                System.out.println("\nStudent already exists.");
                System.out.print("\nPress Enter to Continue...");
                sc.nextLine();
            }
        }
        catch(Exception e){System.out.println(e);}
    }
}

//Input student's detail
class StudentDetail{
    String id;
    String name;
    String gender;
    String contact_num;
    String address;
    String intake;
    String cgpa;
    public void getInfo(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Input Details");
        System.out.print("Enter Student's ID            : ");
        id=sc.nextLine();
        System.out.print("Enter Student's Name          : ");
        name=sc.nextLine();
        System.out.print("Enter Student's Gender        : ");
        gender=sc.nextLine();
        System.out.print("Enter Student's Contact Number: ");
        contact_num=sc.nextLine();
        System.out.print("Enter Student's Address       : ");
        address=sc.nextLine();
        System.out.print("Enter Student's Intake        : ");
        intake=sc.nextLine();
        System.out.print("Enter Student's CGPA          : ");
        cgpa=sc.nextLine();
    }
}

//View student's detail
class Student_View{
  public void viewFile(String s) throws Exception{
    File file = new File(s+".txt");
    Scanner sc = new Scanner(file);

    while (sc.hasNextLine()){
       System.out.println(sc.nextLine());
     }
   }
}

//Remove student
class Student_Remove{
    public void removeFile(String ID){

    File file = new File(ID+".txt");
      if(file.exists()){
        if(file.delete());{
           System.out.println("\nStudent has been removed.");
        }
      }
      else
        {
           System.out.println("\nStudent does not exist");
        }
     }
}

//Update student's detail
class Student_Update{
  public void updateFile(String s,String o,String n) throws IOException{
   File file = new File(s+".txt");
   Scanner sc = new Scanner(file);
   String fileContext="";
   while (sc.hasNextLine()){
         fileContext =fileContext+"\n"+sc.nextLine();
       }
   FileWriter myWriter = new FileWriter(s+".txt");
   fileContext = fileContext.replaceAll(o,n);
   myWriter.write(fileContext);
   myWriter.close();

  }
}

//Exit program
class CodeExit{
  public void end(){
    System.out.println("\t====Program Exited====");
    System.exit(0);
  }
}



//Main program
class StudentRecordManagementSystem{
  public static void main(String arg[]){
    Scanner sc=new Scanner(System.in);
    Scanner input=new Scanner(System.in);

    Student_View stu =new Student_View();

    System.out.println("\t===Student Record Management System===\n");
    System.out.println("Press 1:Admin/Lecturer Login");
    System.out.println("Press 2:Student Login");
    System.out.print("Select:");
    int a=sc.nextInt();
    System.out.println("-------------------------");

    int i=0;
    MainMenu menu = new MainMenu();
    if(a==1){//admin menu
    System.out.print("\nEnter Admin password: ");
    int adminpass;
    adminpass=input.nextInt();
    
    while(i<6){
      menu.menuadmin();
      System.out.print("\nPlease Enter choice :");
      i=sc.nextInt();

      switch(i){
        case 1:{
            Student_Add stuadd =new Student_Add();
            stuadd.createFile();
            break;
        }
        case 2:{
          System.out.print("\nPlease Enter Student's ID :");
          String s=input.nextLine();
          try{stu.viewFile(s);}
            catch(Exception e){System.out.println(e);}

            System.out.print("\nPress Enter to Continue...");
            input.nextLine();
            break;
        }

        case 3:{
          System.out.print("\nPlease Enter Student's ID :");
          String s=input.nextLine();
          Student_Remove sturmv =new Student_Remove();
          sturmv.removeFile(s);

          System.out.print("\nPress Enter to Continue...");
          input.nextLine();
          break;
        }
        case 4:{
            System.out.print("\nPlease Enter Student's ID :");
            String I=input.nextLine();
            try{stu.viewFile(I);}
            catch(Exception e){System.out.println(e);}
            Student_Update stuup = new Student_Update();
    	    System.out.println("\nInput the detail you want to update, then input the updated detail");
            System.out.print("Please Enter the detail you want to Update :");
            String s=input.nextLine();
            System.out.print("Please Enter the Updated Detail :");
            String n=input.nextLine();
            try{stuup.updateFile(I,s,n);

              System.out.print("\nPress Enter to Continue...");
              input.nextLine();
              break;
            }
            catch(IOException e){System.out.println(e);}
        }
        case 5:{
          CodeExit exit = new CodeExit();
          exit.end();
        }
      }
    }
    }
    if(a==2){ //student menu
    while(i<3){
        menu.menustudent();
        System.out.print("\nPlease Enter choice :");
        i=sc.nextInt();

      switch(i){
        case 1:{
          System.out.print("\nPlease Enter Student's ID :");
          String s=input.nextLine();
          try{stu.viewFile(s);}
          catch(Exception e){System.out.println(e);}

          System.out.print("\nPress Enter to Continue...");
          input.nextLine();
          break;
        }

        case 2:{
          CodeExit exit = new CodeExit();
          exit.end();
        }
      }
    }
    }
  }
}

