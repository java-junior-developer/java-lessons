package ru.itmo.lessons.lesson24;

import java.io.*;

public class SerializableAndExternalizable {
    static class SerializablePerson implements Serializable /* по умолчанию все свойства включены в сериализацию */ {
        // используется, чтобы избежать ошибки несоответствия версий,
        // если предполагается редактировать сериализуемый класс
        private static final long serialVersionUID = 1L;

        transient public final String email; // исключено из сериализации модификатором transient
        public String login;
        transient public int age; // исключено из сериализации модификатором transient


        public SerializablePerson(String login, int age) {
            this.email = login + "@person.com";
            this.login = login;
            this.age = age;
        }
    }

    static class ExternalizablePerson implements Externalizable /* по умолчанию ни одно свойство не включено в сериализацию */ {
        public String email;
        public String login;  // включено в сериализацию в методе writeExternal и десериализацию в методе readExternal
        public int age; // включено в сериализацию в методе writeExternal и десериализацию в методе readExternal

        // для десериализуемых Externalizable объектов необходим конструктор без параметров
        public ExternalizablePerson(){}

        public ExternalizablePerson(String login, int age) {
            this.email = login + "@person.com";
            this.login = login;
            this.age = age;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeUTF(login);
            out.writeInt(age);
        }

        // последовательность сериализации в методе writeExternal
        // должна соответствовать последовательности десериализации в методе readExternal
        @Override
        public void readExternal(ObjectInput in) throws IOException {
            login = in.readUTF();
            age = in.readInt();
        }
    }
    public static void main(String[] args) {
        SerializablePerson jack = new SerializablePerson("Jack0014", 26);
        System.out.println(jack.age); // 26
        System.out.println(jack.login); // Jack0014
        System.out.println(jack.email); // Jack0014@person.com

        Lesson24.writeToFile("person.bin", jack);

        SerializablePerson jackFromFile = Lesson24.readFromFile("person.bin");
        System.out.println(jackFromFile.age); // 0, было исключено из сериализации модификатором transient
        System.out.println(jackFromFile.login); // Jack0014
        System.out.println(jackFromFile.email); // null, было исключено из сериализации модификатором transient

        ExternalizablePerson mike = new ExternalizablePerson("Mike4555", 47);
        System.out.println(mike.age); // 47
        System.out.println(mike.login); // Mike4555
        System.out.println(mike.email); // Mike4555@person.com

        Lesson24.writeToFile("person.bin", mike);

        ExternalizablePerson mikeFromFile = Lesson24.readFromFile("person.bin");
        System.out.println(mikeFromFile.age); // 47, включено в сериализацию в методе writeExternal и десериализацию в методе readExternal
        System.out.println(mikeFromFile.login); // Jack0014, включено в сериализацию в методе writeExternal и десериализацию в методе readExternal
        System.out.println(mikeFromFile.email); // null, не включено в сериализацию в методе writeExternal и десериализацию в методе readExternal

    }

}
