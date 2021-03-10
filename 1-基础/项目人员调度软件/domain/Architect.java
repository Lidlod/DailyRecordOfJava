package edu.ittj.p3.domain;

public class Architect extends Designer{
    private int stock;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public Architect() {
    }

    @Override
    public String toString() {
        return getDetails() + "\t架构师\t" +
                getStatus() + "\t" +
                getBonus() + "\t" +
                stock + "\t" +
                getEquipment().getDescription();
    }

    public String getTeamDetails(){
        // 3/2     马化腾   32      18000.0  架构师   15000.0  2000
        return getMemberDetails() +
                getSalary() + "\t架构师\t" +
                getBonus() + '\t' + getStock();
    }
}
