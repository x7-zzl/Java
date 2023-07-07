package Java数据结构和算法.数据结构和算法__C语言.查找和排序;

//接种疫苗信息
class VaccinatedInfo {
    private String ID;//身份证号
    private String name;//姓名
    private int haveBeenVaccinated;//已接种了几剂疫苗
    public String firstTime;//第一剂接种时间
    private String secondTime;//第二剂接种时间

    public VaccinatedInfo(String ID, String name, int haveBeenVaccinated, String firstTime, String secondTime) {
        this.ID = ID;
        this.name = name;
        this.haveBeenVaccinated = haveBeenVaccinated;
        this.firstTime = firstTime;
        this.secondTime = secondTime;
    }


    public String getID() {
        //身份证号码验证,1-17位是数字，18位可以是数字或者大写的X
        if (ID.length() != 18 || !ID.matches("\\d{0,16}[0-9X]{17}")) {
            return "身份证号码格式错误";
        }
        return ID;
    }


    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHaveBeenVaccinated() {
        return haveBeenVaccinated;
    }

    public void setHaveBeenVaccinated(int haveBeenVaccinated) {
        this.haveBeenVaccinated = haveBeenVaccinated;
    }

    public String getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(String firstTime) {
        this.firstTime = firstTime;
    }

    public String getSecondTime() {
        return secondTime;
    }

    public void setSecondTime(String secondTime) {
        this.secondTime = secondTime;
    }

    @Override
    public String toString() {
        return "身份证号码:" + getID() + "\t姓名：" + getName() + "\t已接种疫苗数：" + getHaveBeenVaccinated()
                + "\t第一剂接种时间：" + getFirstTime() + "\t\t第二剂接种时间：" + getSecondTime();
    }
}
