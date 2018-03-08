package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Student> studentData = FXCollections.observableArrayList();

    public Main() {
        studentData.add(new Student());
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Student HandBook");

        initRootLayout();

        showBookOverview();
        // Link

    }

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/rootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void showBookOverview() {
        try {
            // Load Student overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/MainLayout.fxml"));
            AnchorPane bookOverview = (AnchorPane) loader.load();

            // Set Book overview into the center of root layout.
            rootLayout.setCenter(bookOverview);

            // Give the controller access to the main app.
            StudentHandbookController controller = loader.getController();
            controller.setMain(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Student> getStudentData() {
        return this.studentData;
    }

    /**
     * Loads Student data from the specified file. The current Student data will
     * be replaced.
     *
     * @param file
     */
    public void loadHandbookFromFile(File file) {

        try {
            JAXBContext context = JAXBContext
                    .newInstance(StudentBookWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling.
            StudentBookWrapper wrapper = (StudentBookWrapper) um.unmarshal(file);

            studentData.clear();
            studentData.addAll(wrapper.getStudents());


        } catch (Exception e) { // catches ANY exception
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Failed to open file");
            alert.setContentText("Could not load data from file:\r\n" + file.getPath());
            alert.show();
        }
    }

    /**
     * Saves the current Student data to the specified file.
     *
     * @param file
     */

    public void saveHandbookToFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(StudentBookWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Wrapping our Student data.
            StudentBookWrapper wrapper = new StudentBookWrapper();
            wrapper.setStudents(studentData);

            // Marshalling and saving XML to the file.
            m.marshal(wrapper, file);

        } catch (Exception e) { // catches ANY exception
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Failed to save file");
            alert.setContentText("Could not save data to file:\r\n" + file);
            alert.show();
        }
    }
}
