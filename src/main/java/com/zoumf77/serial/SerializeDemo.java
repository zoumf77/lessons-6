package com.zoumf77.serial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.MessageFormat;

/**
 * <p>ClassName: TestObjSerializeAndDeserialize<p>
 * <p>Description: ���Զ�������л��ͷ�����<p>
 * @author xudp
 * @version 1.0 V
 * @createTime 2014-6-9 ����03:17:25
 */
public class SerializeDemo {

    public static void main(String[] args) throws Exception {
        //SerializePerson();//���л�Person����
        Person p = DeserializePerson();//������Perons����
        System.out.println(MessageFormat.format("name={0},age={1},sex={2}",
                                                 p.getName(), p.getAge(), p.getSex()));
    }
    
    /**
     * MethodName: SerializePerson 
     * Description: 把persion实例序列化后存储到一个文件，有的称为冷藏
     * @author xudp
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static void SerializePerson() throws FileNotFoundException,
            IOException {
        Person person = new Person();
        person.setName("gacl");
        person.setAge(25);
        person.setSex("女");
        // ObjectOutputStream
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
                new File("E:/Person.txt")));
        oo.writeObject(person);
       
        oo.close();
    }

    /**
     * MethodName: DeserializePerson 
     * Description: 反序列化，从文件中读出实例，也成解冻
     * @author xudp
     * @return
     * @throws Exception
     * @throws IOException
     */
    private static Person DeserializePerson() throws Exception, IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File("E:/Person.txt")));
        Person person = (Person) ois.readObject();
     
        return person;
    }

}