package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentListTest {
    StudentList studentList;

    @BeforeEach
    void init(){
        studentList = new StudentList();
        studentList.addNewStudent("6610451231","Fluke",60);
    }

    @Test
    void testAddNewStudentWithTwoParameters(){
        studentList.addNewStudent("6610451001", "Mic");
        Student student = studentList.findStudentById("6610451001");
        assertEquals("6610451001",student.getId());
        assertEquals("Mic", student.getName());
    }

    @Test
    void testAddNewStudentWithThreeParameters(){
        studentList.addNewStudent("6610451002","Mon",5);
        Student student = studentList.findStudentById("6610451002");
        assertEquals("6610451002", student.getId());
        assertEquals("Mon", student.getName());
        assertEquals(5, student.getScore());
    }

    @Test
    void testAddMultipleStudnet(){
        studentList.addNewStudent("6610451003","John");
        studentList.addNewStudent("6610451004", "Mew");
        Student student1 = studentList.findStudentById("6610451003");
        Student student2 = studentList.findStudentById("6610451004");
        assertEquals("6610451003",student1.getId());
        assertEquals("6610451004",student2.getId());
    }

    @Test
    void testFindStudentById(){
        Student student = studentList.findStudentById("6610451231");
        assertEquals("Fluke",student.getName());
    }
    @Test
    void testGiveScoreToId(){
        Student student = studentList.findStudentById("6610451231");
        student.addScore(20);
        assertEquals(80, student.getScore());
    }

    @Test
    void TestViewGradeOfId(){
        Student student = studentList.findStudentById("6610451231");
        assertEquals("C", student.grade());
    }
}