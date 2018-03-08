package sample;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Student")
public class Student {

    private final StringProperty studentName;

    @XmlElement(name = "Subject")
    private List<Subject> subjects;

    public Student(String name) {
        this.studentName = new SimpleStringProperty(name);
        subjects = new ArrayList<Subject>();
    }

    public Student() {
        subjects = new ArrayList<Subject>();
        this.studentName = new SimpleStringProperty("StudentName");
        addNewSubject();
    }

    @XmlElement(name = "StudentName")
    public String getStudentName() {
        return this.studentName.get();
    }

    public StringProperty nameProperty() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName.set(studentName);
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void addNewSubject() {
        subjects.add(new Subject());
    }

}
