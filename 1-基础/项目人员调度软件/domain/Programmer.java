package edu.ittj.p3.domain;

import edu.ittj.p3.service.Status;

public class Programmer  extends Employee{
    private int memberId;
    private Status status = Status.FREE;
    private Equipment equipment;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public Programmer() {
    }

    @Override
    public String toString() {
        return getDetails() + "\t程序员\t" +
                status + "\t\t\t\t\t" +
                equipment.getDescription();
    }

    public String getMemberDetails(){
        return getMemberId() + "/" + getId() + "\t" +
                getName() + "\t"+ getAge() + "\t";
    }
    public String getTeamDetails(){
        // 2/4     刘强东   24      7300.0    程序员
        return getMemberDetails() +
                getSalary() + "\t程序员" +"\t";
    }
}
