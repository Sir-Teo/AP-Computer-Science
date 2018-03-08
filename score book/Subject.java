package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Subject")
public class Subject {

    private StringProperty subjectName;

    @XmlElement(name = "Test")
    private List<Test> tests;

    public Subject(String name) {
        this.subjectName = new SimpleStringProperty(name);
        tests = new ArrayList<Test>();
    }

    public Subject() {
        this.subjectName = new SimpleStringProperty("SubjectName");
        tests = new ArrayList<Test>();
        addNewTest();
    }

    @XmlElement(name = "SubjectName")
    public String getSubjectName() {
        return this.subjectName.get();
    }

    public void setSubjectName(String name) {
        this.subjectName.set(name);
    }

    public StringProperty nameProperty() {
        return subjectName;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void addNewTest() {
        tests.add(new Test());
    }

    public Double average() {
        Double avg = new Double("0");
        for (Test test : this.getTests()) {
            avg += test.getTestScore() * test.getTestTotalPercent() / 100;
        }
        return Math.floor(avg * 100) / 100;
    }

    public Double percentage() {
        Double percentage = new Double("0");
        for (Test test : this.getTests()) {
            percentage += test.getTestTotalPercent();
        }
        return percentage;
    }

    public String grade() {
        if (average() < 60) {
            return "F";
        } else if (Utils.isBetween(average(), 60, 70)) {
            return "D";
        } else if (Utils.isBetween(average(), 70, 80)) {
            return "C";
        } else if (Utils.isBetween(average(), 80, 90)) {
            return "B";
        } else {
            return "A";
        }
    }

}
