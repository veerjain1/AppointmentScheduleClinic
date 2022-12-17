import java.util.Random;

class patient {
  private String name;
  private int date;
  private String time;
  private String reason;
  private String insurance;

  public patient() {
    name = "";
    date = 0;
    time = "";
    reason = "";
    insurance = "";
  }

  public String toString() {
    return ("\nName: " + name + ", date: " + date + ", time: " + time + ", reason: " + reason);
  }

  public patient(String name, int date, String time, String reason, String insurance) {
    this.name = name;
    this.date = date;
    this.time = time;
    this.reason = reason;
    this.insurance = insurance;

  }

  public String timeGenerator() {
    Random rand = new Random();
    int hour = rand.nextInt(8, 18);
    int minute = rand.nextInt(10, 59);

    if(hour<11){
      time = hour + ":" + minute + "AM to " + (hour + 1) + ":" + minute+"AM";
    }
    if(hour>=11 && hour<12){
      time = hour + ":" + minute + "AM to " + (hour + 1) + ":" + minute+"PM";
    }

    if(hour==12){
      time = hour + ":" + minute + "PM to " + (hour + 1) + ":" + minute+"PM";
    }
    if(hour>12){
      hour = hour-12;
      time = hour + ":" + minute + "PM to " + (hour + 1) + ":" + minute+"PM";
    }
    return time;

  }

  public String Display() {
    String info = "The patient: " + name + "has an appointment on: January " + date + " at the time of: " + time
        + " has the following reason for their visit: " + reason + " and has the following insurance: " + insurance;

    return info;
  }

  public String getName() {
    return name;
  }

  public int getDate() {
    return date;
  }

  public String getTime() {
    return time;
  }

  public String getReason() {
    return reason;
  }

  public String getInsurance() {
    return insurance;
  }

  public void setDate(int date) {
    this.date = date;
  }

}