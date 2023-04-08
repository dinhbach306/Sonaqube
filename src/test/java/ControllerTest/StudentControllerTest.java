package ControllerTest;

import com.magnus.read_write.ReadWriteApplicationTests;
import com.magnus.read_write.entity.Student;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StudentControllerTest extends ReadWriteApplicationTests {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getStudentList() throws Exception {
        String uri = "/api/students";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Student[] students = mapFromJson(content, Student[].class);
        assertTrue(students.length > 0);
    }

    @Test
    public void createStudent() throws Exception {
        String uri = "/api/students";
        Student student = new Student();
        student.setId(4);
        student.setName("Baka");
        student.setOld(20);
        student.setAddress("Hanoi");
        String inputJson = mapToJson(student);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Student is created successfully");
    }
}
