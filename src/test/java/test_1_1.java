import ru.baROM.pr1.Person;

public class test_1_1 {


    public static void main(String[] args) {

        Person myPerson = new Person.Builder()
                .firstName("Jon")
                .lastName("Doe")
                .middleName("ml")
                .country("Repubblica Italiana")
                .address("1st street")
                .phone("+39012345678")
                .age(33)
                .gender("male")
                .build();

        System.out.println(myPerson);

    }


}
