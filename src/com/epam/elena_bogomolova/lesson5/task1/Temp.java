package com.epam.elena_bogomolova.lesson5.task1;

import java.io.*;

/**
 * Created by elena_bogomolova on 07.04.2017.
 */
public class Temp {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        TestSerial ts = new TestSerial();
        ts.version = 1000;
        oos.writeObject(ts);
        oos.flush();
        oos.close();



        FileInputStream fis = new FileInputStream("temp.out");
        ObjectInputStream oin = new ObjectInputStream(fis);
        TestSerial ts1 = (TestSerial)oin.readObject();
        System.out.println(ts1.version);

    }
}

class TestParent implements Serializable{

}

class TestSerial extends TestParent  {
    public int version;
    public byte count = 0;
}
