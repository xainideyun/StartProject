package pack13;
import java.io.*;

class IODemo31{
    private static String path = "serialize";
    public static void main(String[] args) throws Exception {
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }
        /*
        // 将一个对象序列化
        Student s = new Student("孙小双", 28, "sunxsh");
        serializeObj(s);
        */

        // 反序列化一个对象
        Object obj = deseriazeObj();
        System.out.println(obj);
    }
    public static <T> void serializeObj(T obj) throws Exception {
        ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(path + "\\sunxsh.student"));
        ous.writeObject(obj);
        ous.close();
    }
    public static Object deseriazeObj() throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path + "\\sunxsh.student"));
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }
}





class Student implements Serializable {
    private static final long serialVersionUID = 42L;       // 显示的声明该类的serialVersionUID字段，在类重新生成之后仍然可以反序列化
    private String name;
    private int age;
    private String code;
    Student(String name, int age, String code){
        this.name = name;
        this.age = age;
        this.code = code;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public String getCode()
    {
        return code;
    }
    public void setCode(String cpde)
    {
        this.code = code;
    }
    public String toString(){
        return "我叫"+ this.name + "，今年" + this.age + "岁，" + "编号为" + this.code;
    }
}
