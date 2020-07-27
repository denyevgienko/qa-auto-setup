package serialize;

import static serialize.Serialization.DeSerializeFromFileToObject;
import static serialize.Serialization.SerializeToFile;

public class TestSerializible {


    public static void main(String[] args)
    {
        Rectangle rect = new Rectangle(18, 78);
        SerializeToFile(rect, "java-sheets/target/rectSerialized");

        Rectangle deSerializedRect = (Rectangle) DeSerializeFromFileToObject("java-sheets/target/rectSerialized");
        assert deSerializedRect != null;
        System.out.println("Rect area is " + deSerializedRect.area());

    }
}
