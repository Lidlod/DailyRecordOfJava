package edu.ittj.p3.domain;

public class Designer extends Programmer{
    private double bonus;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public Designer() {
    }

    @Override
    public String toString() {
        return getDetails() + "\t设计师\t" +
                getStatus() + "\t" +
                bonus + "\t\t\t" +
                getEquipment().getDescription();
    }

    public String getTeamDetails(){
        // 5/12   杨致远   27      600.0      设计师   4800.0
        return getMemberDetails() +
                getSalary() + "\t设计师\t" +
                getBonus();
    }
}
