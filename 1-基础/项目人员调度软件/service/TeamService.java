package edu.ittj.p3.service;

import edu.ittj.p3.domain.Architect;
import edu.ittj.p3.domain.Designer;
import edu.ittj.p3.domain.Employee;
import edu.ittj.p3.domain.Programmer;

public class TeamService {
    private int counter = 1;
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0;

    /**
     * 返回当前团队的所有对象
     * @return:包含所有成员对象的数组，数组大小与成员人数一致
     */
    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    /**
     * 向团队中添加成员
     * @param e
     */
    public void addMember(Employee e) throws TeamException {
//        成员已满，无法添加
        if(total >= MAX_MEMBER){
            throw new TeamException("成员已满，无法添加");
        }
//        该成员不是开发人员，无法添加
        if(!(e instanceof Programmer)){
            throw new TeamException("该成员不是开发人员，无法添加");
        }
//        该员工已在本开发团队中
        Programmer p = (Programmer) e;
        if(isExist(p)){
            throw new TeamException("该员工已在本开发团队中");
        }
//        该员工已是某团队成员
        if("BUSY".equals(p.getStatus().getNAME())){
            throw new TeamException("该员工已是某团队成员");
        }
//        该员正在休假，无法添加
        if("VOCATION".equals(p.getStatus().getNAME())){
            throw new TeamException("该员正在休假，无法添加");
        }
//        团队中至多只能有一名架构师
//        团队中至多只能有两名设计师
//        团队中至多只能有三名程序员
        // 遍历team，记录各类员工个数；
        int numOfPrg = 0, numOfDegn = 0, numOfrArch = 0;
        for (int i = 0; i < total; i++) {
            if(team[i] instanceof Architect){
                numOfrArch++;
            }else if(team[i] instanceof Designer){
                numOfDegn++;
            }else if(team[i] instanceof Programmer){
                numOfPrg++;
            }
        }
        if(p instanceof Architect){
            if(numOfrArch>=1)
                throw new TeamException("团队中至多只能有一名架构师");
        }else if(p instanceof Designer){
            if(numOfDegn>=2)
                throw new TeamException("团队中至多只能有两名设计师");
        }else if(p instanceof Programmer){
            if(numOfPrg>=3)
                throw new TeamException("团队中至多只能有三名程序员");
        }

        // 添加到数组
        team[total++] = p;
        p.setMemberId(counter++);
        p.setStatus(Status.BUSY);
    }

    /**
     * 判断制定元素是否在开发团队中
     * @param p
     * @return
     */
    private boolean isExist(Employee p) {
        for (int i = 0; i < total; i++) {
            if(team[i].getId() == p.getId()){
                return true;
            }
        }
        return false;
    }

    /**
     * 从团队中删除成员
     * @param memberId
     */
    public void removeMember(int memberId) throws Exception {
        // 遍历
        int i = 0;
        for (; i < total; i++) {
            if(team[i].getMemberId() == memberId){
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        //找不到，报异常
        if(total == i){
            throw new Exception("找不到该成员，无法删除");
        }

        for(int j=i+1;j< total;j++){
            team[j-1] = team[j];
        }
        team[--total] = null;
    }
}
