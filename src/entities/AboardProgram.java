package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AboardProgram {
    private String id;
    private String name;
    private String time;
    private Date fromRegistrationDate;
    private Date endRegistrationDate;
    private int days;
    private String location;
    private float cost;
    private String content;

    public AboardProgram(String id, String name, String time, Date fromRegistrationDate, Date endRegistrationDate, int days, String location, float cost, String content) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.fromRegistrationDate = fromRegistrationDate;
        this.endRegistrationDate = endRegistrationDate;
        this.days = days;
        this.location = location;
        this.cost = cost;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getFromRegistrationDate() {
        return fromRegistrationDate;
    }

    public void setFromRegistrationDate(Date fromRegistrationDate) {
        this.fromRegistrationDate = fromRegistrationDate;
    }

    public Date getEndRegistrationDate() {
        return endRegistrationDate;
    }

    public void setEndRegistrationDate(Date endRegistrationDate) {
        this.endRegistrationDate = endRegistrationDate;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void print(int no) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.format("%-5d", no);
        System.out.format("%-5s", id);
        System.out.format("%-30s", name);
        System.out.format("%-15s", time);
        System.out.format("%-15s", dateFormat.format(fromRegistrationDate));
        System.out.format("%-15s", dateFormat.format(endRegistrationDate));
        System.out.format("%-5d", days);
        System.out.format("%-50s", location);
        System.out.format("%-10s", cost);
        System.out.format("%-20s\n", content);
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return id + "\t\t" + name + "\t\t" + time + "\t\t" + dateFormat.format(fromRegistrationDate) + "\t\t"
                + dateFormat.format(endRegistrationDate) + "\t\t" + days + "\t\t" + location + "\t\t" + cost + "\t\t"
                + content;
    }
}
