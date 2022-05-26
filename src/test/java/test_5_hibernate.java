import ru.baROM.pr5.Hibernate.Student;
import ru.baROM.pr5.Hibernate.StudentDAO;

import java.io.*;
import java.util.List;
import java.util.Random;

public class test_5_hibernate {

    public static void main(final String[] args) throws Exception {

        StudentDAO studentDAO = new StudentDAO();

        Student student1 = new Student("Ivan", 11);
        studentDAO.save(student1);

        student1.setName("Petr");
        studentDAO.save(student1);
        System.out.println(student1);

        student1 = studentDAO.findById(2);
        student1.setMark(22);
        studentDAO.update(student1);
        System.out.println(studentDAO.findById(2));

        studentDAO.delete(studentDAO.findById(1));

        // Add 1000 entries to the Student table
        int count = 1;
        int count_save = 1;
        Random random = new Random();
        try {
            File file = new File("src/test/java/names.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null && count_save < 1001) {
                count++;
                if (count % 20 == 0) {
                    studentDAO.save(new Student(line, random.nextInt(99)));
                    count_save++;
                }
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sampling of all records
        List<Student> studentList = studentDAO.findAll();
        for (Student student : studentList) {
            System.out.println(student.toString());
        }

    }

}