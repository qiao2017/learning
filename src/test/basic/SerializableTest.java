package test.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.MessageFormat;

/** 
 * @ClassName: SerializableTest
 * @description: 
 * @author: 乔莹
 * @Date: 2019年3月10日 下午4:07:24
 */
public class SerializableTest {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
        SerializablePerson();
        Person p = DeserializablePerson();
        System.out.println(MessageFormat.format("name={0},age={1},sex={2}", 
                p.getName(), p.getAge(), p.getSex()));
    }

    private static void SerializablePerson() throws FileNotFoundException, IOException {
        Person p = new Person();
        p.setName("张三");
        p.setAge(21);
        p.setSex("男");
        ObjectOutputStream oo = new ObjectOutputStream(
                                    new FileOutputStream(new File("person.txt")));
        oo.writeObject(p);
        oo.close();
    }

    private static Person DeserializablePerson() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File("person.txt")));
        Person person = (Person) ois.readObject();
        System.out.println("Person对象反序列化成功！");
        return person;
    }
}

class Person implements Serializable{

    private static final long serialVersionUID = -3456528469819178278L;
    private int age;
    private String name;
    private String sex;
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    
}
