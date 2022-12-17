import java.util.Scanner;
import java.util.ArrayList;


class Main {
  public static void main(String[] args) {

    Scanner myObj = new Scanner(System.in);
    System.out.println("Enter the number of doctors your clinic has: ");
    int numDoctors = myObj.nextInt();

    Doctor[] doctors = new Doctor[numDoctors];
    String time = "";
    int date = 0;

    for (int doctorCounter = 0; doctorCounter < numDoctors; doctorCounter++) {
      Scanner myObj0 = new Scanner(System.in);
      System.out.println("What is " + (doctorCounter + 1) + " Doctor's name?");
      String docName = myObj0.nextLine();

      Scanner myObj01 = new Scanner(System.in);
      System.out.println("\nWhat is " + docName + "'s department?");
      String docDepartment = myObj01.nextLine();

      Scanner myObj1 = new Scanner(System.in);
      System.out.println("\nEnter the number of patients " + docName + " treats: ");
      int numPatients = myObj1.nextInt();

      Doctor d = new Doctor(numPatients, docName, docDepartment);

      for (int patientCounter = 0; patientCounter < numPatients; patientCounter++) {

        Scanner myObj2 = new Scanner(System.in);
        System.out.println("\n\nEnter the name of your " + (patientCounter + 1) + " patient: ");
        String name = myObj2.nextLine();

        Scanner myObj3 = new Scanner(System.in);
        System.out.println("\nEnter the reason for visit for " + name);
        String reason = myObj3.nextLine();

        Scanner myObj5 = new Scanner(System.in);
        System.out.println("\nEnter the insurance provider of " + name);
        String insurance = myObj5.nextLine();

        patient p = new patient(name, 0, "", reason, insurance);

        boolean dateWorks = false;
        int count = 0;

        while (dateWorks == false) {
          if (count++ != 0) {
            System.out
                .println("\n\nThe date you requested does not work. We are overbooked, please provide a different date...");
          }
          Scanner myObj4 = new Scanner(System.in);
          System.out.println("\nEnter the date you want " + name
              + "'s appointment to be on. We are only accepting appointments for January so please provide a day (in integer format) and the system will randomly pick a time for you if space is available on that day for the doctor you have requested.");
          date = myObj4.nextInt();

          if (d.checkSpace(date)) {
            dateWorks = true;
          }
        }
        p.setDate(date);
        System.out.println("\nThe following randomly generated time has been set for your appointment on January "
            + p.getDate() + ": " + p.timeGenerator());
        d.addPatient(p);

        System.out.println("\n");
      } 
      System.out.println("\n");
      doctors[doctorCounter] = d;

      Scanner myObj9 = new Scanner(System.in);
      System.out.println("\n\nWould you like to cancel any appointment?");
      String cancelQ = myObj9.nextLine();

      if (cancelQ.equals("yes")) {
        Scanner myObj99 = new Scanner(System.in);
        System.out.println("\nWhat is your name?");
        String checkName = myObj99.nextLine();

        for (int i = 0; i < d.getPatients().size(); i++) {
          if (checkName.equals(doctors[doctorCounter].getPatientName(i))) {
            d.getPatients().remove(i);
            System.out.println("\n\t\t\tCancelation successful!");
          }
        }
      } 
    } 
    for (int i = 0; i < numDoctors; i++) {
      Doctor d = doctors[i];
      ArrayList<patient> patients = d.getPatients();

      for (int j = 0; j < patients.size() - 1; j++) {
        for (int x = 0; x < patients.size() - 1 - j; x++) {
          patient p1 = patients.get(x);
          patient p2 = patients.get(x + 1);
          if (p1.getDate() > p2.getDate()) {
            patients.set(x + 1, p1);
            patients.set(x, p2);
           
          }
        }
      }
      System.out.println("For " + d.getDocName()
          + ", here are the patients who have scheduled an appointment within the month of January. The appointments are listed in ascending order.\n" + patients+"\n");
    }
  }
}
