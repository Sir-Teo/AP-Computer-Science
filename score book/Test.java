package sample;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Test")
public class Test {

    protected StringProperty testName;
    protected DoubleProperty testScore;
    protected DoubleProperty testPercent;

    public Test(String name, Double score, Double percent) {
        this.testName = new SimpleStringProperty(name);
        this.testScore = new SimpleDoubleProperty(score);
        this.testPercent = new SimpleDoubleProperty(percent);
    }

    public Test() {
        this.testName = new SimpleStringProperty("testName");
        this.testScore = new SimpleDoubleProperty(Double.parseDouble("0"));
        this.testPercent = new SimpleDoubleProperty(Double.parseDouble("0"));
    }

    @XmlElement(name = "TestScore")
    public Double getTestScore() {
        return this.testScore.get();
    }

    public void setTestScore(Double score) {
        this.testScore.set(score);
    }

    @XmlElement(name = "TestName")
    public String getTestName() {
        return this.testName.get();
    }

    public void setTestName(String name) {
        this.testName.set(name);
    }

    @XmlElement(name = "TestTotalPercent")
    public Double getTestTotalPercent() {
        return this.testPercent.get();
    }

    public StringProperty nameProperty() {
        return testName;
    }

    public DoubleProperty scoreProperty() {
        return testScore;
    }

    public DoubleProperty percentProperty() {
        return testPercent;
    }

    public void setTestTotalPercent(Double percent) {
        this.testPercent.set(percent);
    }


}
