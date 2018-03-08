package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.util.StringConverter;

import java.io.File;

public class StudentHandbookController {
    // Student
    @FXML
    private TableView<Student> studentTable;
    @FXML
    private TableColumn<Student, String> studentNameColumn;

    // Subject
    @FXML
    private TableView<Subject> subjectTable;
    @FXML
    private TableColumn<Subject, String> subjectNameColumn;

    // Test
    @FXML
    private TableView<Test> testTable;
    @FXML
    private TableColumn<Test, String> testNameColumn;
    @FXML
    private TableColumn<Test, Number> testScoreColumn;
    @FXML
    private TableColumn<Test, Number> testPercentColumn;


    @FXML
    private Label average;
    @FXML
    private Label grade;
    @FXML
    private Label totalPercent;

    @FXML
    private Button refresh;

    @FXML
    private Label rightFootNote;

    private ObservableList<Subject> subjectData = FXCollections.observableArrayList();
    private ObservableList<Test> testData = FXCollections.observableArrayList();

    private Subject currentSubject;
    private Student currentStudent;
    private Test currentTest;

    // Reference to the main application.
    private Main main;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public StudentHandbookController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize Relationship
        studentNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        studentNameColumn.setCellFactory(TextFieldTableCell.<Student>forTableColumn());

        subjectNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        subjectNameColumn.setCellFactory(TextFieldTableCell.<Subject>forTableColumn());

        testNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        testNameColumn.setCellFactory(TextFieldTableCell.<Test>forTableColumn());
        testScoreColumn.setCellValueFactory(cellData -> cellData.getValue().scoreProperty());
        testScoreColumn.setCellFactory(TextFieldTableCell.<Test, Number>forTableColumn(new StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                return object.toString();
            }

            @Override
            public Number fromString(String string) {
                Double a = Double.parseDouble(string);
                if (!Utils.isBetween(a, 0, 101)) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setHeaderText("Failed to save Score");
                    alert.setContentText("Score should always between 0-100");
                    alert.show();
                    string = "err";
                }
                return Double.parseDouble(string);
            }
        }));

        testPercentColumn.setCellValueFactory(cellData -> cellData.getValue().percentProperty());
        testPercentColumn.setCellFactory(TextFieldTableCell.<Test, Number>forTableColumn(new StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                return object.toString();
            }

            @Override
            public Number fromString(String string) {
                Double a = Double.parseDouble(string);
                if (!Utils.isBetween(a, 0, 101)) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setHeaderText("Failed to save Percentage");
                    alert.setContentText("Percentage should always between 0-100");
                    alert.show();
                    string = "err";
                }
                return Double.parseDouble(string);
            }
        }));

        // Listen for selection changes and show the person details when changed.
        studentTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showStudentSubjectDetails(newValue));
        subjectTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showStudentSubjectTestsDetails(newValue));
        testTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) ->
                {
                    currentTest = newValue;
                });

    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param main
     */
    public void setMain(Main main) {
        this.main = main;

        // Add observable list data to the table
        studentTable.setItems(main.getStudentData());
    }

    public void showStudentSubjectDetails(Student student) {
        cleanSubjectData();
        if (student != null) {
            subjectData.addAll(student.getSubjects());
            subjectTable.setItems(subjectData);
            currentStudent = student;
        } else {
            cleanSubjectData();
        }

    }

    public void showStudentSubjectTestsDetails(Subject subject) {
        cleanTestData();
        if (subject != null) {
            testData.addAll(subject.getTests());
            testTable.setItems(testData);

            average.setText(subject.average().toString());
            totalPercent.setText(subject.percentage().toString() + "%");
            grade.setText(subject.grade());
            if (subject.percentage() != 100) {
                totalPercent.setTextFill(Color.web("#FF0000"));
                rightFootNote.setText("Warning: Total % is not equal to 100");
                rightFootNote.setTextFill(Color.web("#FF0000"));
            }
            currentSubject = subject;
            refresh.setDisable(false);
        } else {
            cleanTestData();
        }
    }

    protected void cleanTestData() {
        testData = FXCollections.observableArrayList();
        testTable.setItems(testData);
        testTable.refresh();
        average.setText("N/A");
        grade.setText("N/A");
        totalPercent.setText("N/A");
        totalPercent.setTextFill(Color.web("#000000"));
        rightFootNote.setTextFill(Color.web("#000000"));
        rightFootNote.setText("No Errors.");
        refresh.setDisable(true);
        currentTest = null;
    }

    protected void cleanSubjectData() {
        subjectData = FXCollections.observableArrayList();
        subjectTable.setItems(subjectData);
        subjectTable.refresh();
        currentSubject = null;
        currentStudent = null;
    }

    @FXML
    private void refreshTestData() {
        if (currentSubject != null) {
            cleanTestData();
            showStudentSubjectTestsDetails(subjectTable.getFocusModel().getFocusedItem());
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Failed to retrieve selected subjects");
            alert.setContentText("You need to select a subject before refresh");

            alert.showAndWait();
        }
    }

    @FXML
    private void addNewStudent() {
        main.getStudentData().add(new Student());
        studentTable.setItems(main.getStudentData());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("A new student added");
        alert.setContentText("You can now edit as you like");

        alert.showAndWait();
    }

    @FXML
    private void addNewSubject() {
        Student stu = studentTable.getFocusModel().getFocusedItem();
        if (stu != null) {
            stu.addNewSubject();
            showStudentSubjectDetails(stu);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("A new subject added");
            alert.setContentText("You can now edit the subject as you like");

            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Failed to retrieve the student");
            alert.setContentText("You need to click on a student before adding a subject");
            alert.show();
        }
    }

    @FXML
    private void addNewTest() {
        // No idea
        if (currentSubject != null) {
            Subject sub = subjectTable.getFocusModel().getFocusedItem();
            sub.addNewTest();
            showStudentSubjectTestsDetails(sub);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("A new test added");
            alert.setContentText("You can now edit the test as you like");

            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Failed to retrieve the subject");
            alert.setContentText("You need to click on a student's subject before adding a test");
            alert.show();
        }
    }

    @FXML
    private void deleteStudent() {
        if (currentStudent != null) {
            main.getStudentData().remove(currentStudent);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("The selected student removed");
            alert.setContentText("You can now continue as you like");

            alert.showAndWait();
        }
    }

    @FXML
    private void deleteSubject() {
        Student stu = studentTable.getFocusModel().getFocusedItem();
        if (currentSubject != null) {
            stu.getSubjects().remove(currentSubject);
            showStudentSubjectDetails(stu);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("A subject remove");
            alert.setContentText("You can now continue as you like");

            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Failed to retrieve the student/subject");
            alert.setContentText("You need to click on a student's subject before removing");
            alert.show();
        }
    }

    @FXML
    private void deleteTest() {
        // No idea
        if (currentTest != null) {
            Subject sub = subjectTable.getFocusModel().getFocusedItem();
            sub.getTests().remove(currentTest);
            showStudentSubjectTestsDetails(sub);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("A test removed");
            alert.setContentText("You can now continue as you like");

            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Failed to retrieve the test");
            alert.setContentText("You need to click on a student's subject' test before removing");
            alert.show();
        }
    }

    @FXML
    private void author() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thanks for using");
        alert.setHeaderText("Author: Michael Luo");
        alert.setContentText("Contact me with email: i@never.pet");
        alert.show();
    }

    @FXML
    private void handleOpen() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "Xml files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showOpenDialog(main.getPrimaryStage());

        if (file != null) {
            main.loadHandbookFromFile(file);
        }
    }

    /**
     * Opens a FileChooser to let the user select a file to save to.
     */
    @FXML
    private void handleSaveAs() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "Xml files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showSaveDialog(main.getPrimaryStage());

        if (file != null) {
            // Make sure it has the correct extension
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            main.saveHandbookToFile(file);
        }
    }

    @FXML
    private void close() {
        System.exit(0);
    }
}
