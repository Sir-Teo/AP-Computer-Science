package sample;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Helper class to wrap a list of Students. This is used for saving the
 * list of Students to XML.
 * <p>
 * Note: Element name need to be the same of get/set method, and cannot be the same
 * if nested class inside has same get/set method name
 *
 * Source: https://stackoverflow.com/questions/19467116/unable-to-unmarshal-shadow-class-variable-in-jaxb
 *
 * @author Mic
 */
@XmlRootElement(name = "Book")
public class StudentBookWrapper {

    private List<Student> Students;

    @XmlElement(name = "Student")
    public List<Student> getStudents() {
        return Students;
    }

    public void setStudents(List<Student> Students) {
        this.Students = Students;
    }
}