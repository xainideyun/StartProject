package pack13;
import java.util.*;
import java.io.*;
class IODemo38{
    public static void main(String[] args) throws Exception {
        // ��ϰ����5��ѧ����ÿ��ѧ����3�ſεĳɼ����Ӽ�����¼���������ݣ��������������ſγɼ�
        // ¼���ʽ����С˫  60 88 99������ѧ������Ϣ������ܵ÷ְ�˳������Ӳ���ļ���
        List<Student> students = set();
        Collections.sort(students, new Comparator<Student>(){
            public int compare(Student s1, Student s2){
                if(s1.getTotal() > s2.getTotal())
                    return -1;
                else if(s1.getTotal() < s2.getTotal())
                    return 1;
                return 0;
            }
        });
        // System.out.println(students);
        // ������ļ�
        BufferedWriter bw = new BufferedWriter(new FileWriter("Result.txt"));
        String info = null;
        for(Student s : students){
            info = s.toString();
            bw.write(info, 0, info.length());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
    public static List<Student> set() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Student> list = new ArrayList<Student>();
        String[] infoList = null;
        for(int i = 0; i < 5; i++){
            infoList = br.readLine().split(" ");
            list.add(new Student(infoList[0], Integer.parseInt(infoList[1]), infoList[2], Integer.parseInt(infoList[3]), Integer.parseInt(infoList[4]), Integer.parseInt(infoList[5])));
        }
        br.close();
        return list;
    }
}
class Student implements Serializable{
    private String name;
    private int age;
    private String code;
    private int[] score;
    private int total;
    Student(String name, int age, String code, int ...score){
        this.name = name;
        this.age = age;
        this.code = code;
        this.score = score;
        for(int s : score){
            this.total += s;
        }
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public String getCode(){
        return this.code;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setCode(String code){
        this.code = code;
    }
    public int getTotal(){
        return this.total;
    }
    public String toString(){
        return "������" + name + "�����䣺" + age + "�����룺" + code + "���ܷ֣�" + total;
    }
}
