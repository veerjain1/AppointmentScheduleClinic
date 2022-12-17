
import java.util.*;

class Doctor {
  private ArrayList<patient> patients;
  private String docName;
  private String docDepartment;

  public Doctor(int numPatients, String docName, String docDepartment) {
    patients = new ArrayList<patient>(numPatients);
    this.docName = docName;
    this.docDepartment = docDepartment;
  }

  public String getPatientName(int position) {
    String name = patients.get(position).getName();
    return name;
  }

  public int getPatientDate(int position) {
    int date = patients.get(position).getDate();
    return date;
  }

  public String getPatientTime(int position) {
    String time = patients.get(position).getTime();
    return time;
  }

  public String getPatientReason(int position) {
    String reason = patients.get(position).getReason();
    return reason;
  }

  public boolean checkSpace(int date) {
    int dateMatchingCounter = 1;
    for (int i = 0; i < patients.size(); i++) {
      if (patients.get(i).getDate() == date) {
       
        dateMatchingCounter++;
      }
    }

    if (dateMatchingCounter <= 4) {
      return true;
    } else {
      return false;
    }
  }

  public ArrayList<patient> getPatients() {
    return this.patients;
  }

  public String getDocName() {
    return docName;
  }

  public String getDocDepartment() {
    return docDepartment;
  }

  public void addPatient(patient p) {
    patients.add(p);
  }

}
