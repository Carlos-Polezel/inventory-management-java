import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<Task> manager= new ArrayList<>();
        Scanner MyObj = new Scanner(System.in);
        int chose;
        while(true) {
            System.out.println("=== MENU TASK MANAGER ===");
            System.out.println("1 - Add a new task");
            System.out.println("2 - Show all task");
            System.out.println("3 - Search task by title");
            System.out.println("4 - Mark task completed");
            System.out.println("5 - Remove task");
            System.out.println("6 - Show all completed task");
            System.out.println("7 - Show all incompleted task");
            System.out.println("0 - Exit");
            System.out.println("chose a option");
            chose = MyObj.nextInt();
            switch (chose){
                case 1:
                    System.out.println("Insert task id: ");
                    int id = MyObj.nextInt();
                    MyObj.nextLine();
                    System.out.println("Insert task title: ");
                    String Title = MyObj.nextLine();
                    System.out.println("Insert task description: ");
                    String Description = MyObj.nextLine();
                    System.out.println("Insert the term: (format yyyy-mm-dd)");
                    String date = MyObj.nextLine();
                    LocalDate term = LocalDate.parse(date);
                    System.out.println("Insert the task was been completed our not: (true our false)");
                    boolean completed = MyObj.nextBoolean();
                    manager.add(new Task(id, Title, Description, term, completed));
                break;
                case 2:
                    //2 - Show all task//
                    for (Task t: manager){
                        System.out.println("INFORMATION OF THE TASK");
                        System.out.println("The id is: " + t.getId());
                        System.out.println("The title is: " + t.getTitle());
                        System.out.println("The description is: " + t.getDescription());
                        System.out.println("The term is: " +t.getTerm());
                        if (t.getCompleted()){
                            System.out.println("The Task was been completed");
                        }
                        if(!t.getCompleted()){
                            System.out.println("The Task was been incompleted");
                        }
                    }
                break;
                case 3:
                    //3 - Search task by title
                    MyObj.nextLine();
                    boolean exist = false;
                    System.out.println("\ninform the title you wanna search");
                    String search = MyObj.nextLine();
                    for(Task t: manager){
                        if(t.getTitle().equalsIgnoreCase(search)){
                            System.out.println("this are the task " + "\n" +t.getId()+ "\n" + t.getTitle() + "\n" + t.getDescription() + "\n" + t.getTerm());
                            exist = true;
                        }
                    }
                    if(!exist){
                        System.out.println("Task not founded");
                    }
                break;
                case 4:
                    //4 - Mark task completed//
                    MyObj.nextLine();
                    boolean complete = false; ;
                    System.out.println("inform the completed task id: ");
                    int Search = MyObj.nextInt();
                    for(Task t: manager){
                        if(t.getId() == Search){
                            complete = true;
                            t.setCompleted(true);
                        }
                        break;
                    }
                    if(!complete){
                        System.out.println("not found task");
                    }
                break;
                case 5:
                    //5 - Remove task
                    MyObj.nextLine();
                    boolean found = false; ;
                    System.out.println("inform the task id to remove: ");
                    int Search1 = MyObj.nextInt();
                    for(Task t: manager){
                        if(t.getId() == Search1){
                            found = true;
                            manager.remove(t);
                        }
                        break;
                    }
                    if(!found){
                        System.out.println("not found task");
                    }
                break;
                case 6:
                    //6 - Show all completed task
                    for(Task t: manager){
                        if(t.getCompleted() == true){
                            System.out.println("this task are completed: " + "\n" +t.getId()+ "\n" + t.getTitle() + "\n" + t.getDescription() + "\n" + t.getTerm());
                            break;
                        }
                    }
                break;
                case 7:
                    //7 - Show all incompleted task
                    for(Task t: manager){
                        if(t.getCompleted() == false){
                            System.out.println("this task are incompleted: " + "\n" +t.getId()+ "\n" + t.getTitle() + "\n" + t.getDescription() + "\n" + t.getTerm());
                            break;
                        }
                    }
                break;
                case 0:
                    return;
                default:
                    System.out.println("inform a valid option");
            }
            }
        }
    }
