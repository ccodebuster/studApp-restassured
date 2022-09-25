package com.studentapp.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;


public class StudentPostTest extends TestBase {

    @Test
    public void createStudent() {

        List<String>courses=new ArrayList<>();
        courses.add("java");
        courses.add("selenium");
        courses.add("restassured");

        StudentPojo studentPojo=new StudentPojo();
        studentPojo.setFirstName("Rinkesh");
        studentPojo.setLastName("patel");
        studentPojo.setEmail("abc@gmail.com");
        studentPojo.setProgramme("api testing");
        studentPojo.setCourses(courses);

        Response response=given()
                .header("Content-Type","application/json")
                .body(studentPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
