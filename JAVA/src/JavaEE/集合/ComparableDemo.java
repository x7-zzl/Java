package JavaEE.集合;

public class ComparableDemo  {
}
class Student implements Comparable<Student>{
    int sno;
    int score;
    Student(int sno,int score){
        this.sno = sno;
        this.score = score;
    }
    @Override
    public int compareTo(Student o) {
        if(this.score<o.score) return -1;
        else if(this.score>o.score) return 1;
        else return 0;
    }
}


