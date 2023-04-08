package com.example.javacoursework.Controller;

import com.example.javacoursework.HelloApplication;
import com.example.javacoursework.entity.*;
import com.example.javacoursework.models.DocModel;
import com.example.javacoursework.service.*;
import com.example.javacoursework.service.Impl.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

import javafx.stage.Window;

import javafx.scene.control.Alert;

import javax.persistence.Convert;
import java.io.IOException;
import java.nio.Buffer;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MainPageController {

    @FXML
    ComboBox<StudyGroup> groupSelectList;

    @FXML
    ComboBox<Subject> subjectSelectList;

    @FXML
    ComboBox<String> stepSelectList1;

    @FXML
    ComboBox<String> formSelectList;

    @FXML
    ComboBox<Integer> semestrSelectList;

    @FXML
    ComboBox<AttestationType> typeSelectList;

    @FXML
    Button closeButton, aboutAuthorButton, createDocumentButton, handleButton;

    @FXML
    private TableView<Students> studentTable;

    @FXML
    private DatePicker data;

    @FXML
    private TextField professorName;
    DirectoryChooser directoryChooser = new DirectoryChooser();

    @FXML
    private TableColumn<Students, String> full_name, bookNumberColumn;
    private GroupService groupService = new GroupServiceImpl();
    private SubjectService subjectService = new SubjectServiceImpl();
    private StudentsService studentsService = new StudentServiceImpl();
    private AttestationTypeService attestationTypeService = new AttestationTypeServiceImpl();
    private FacultyService facultyService = new FacultyServiceImpl();
    private EducationHoursService educationHoursService = new EducationHoursServiceImpl();
    private FileCreateService fileCreate = new FileCreateImpl();
    private StringService stringService = new StringServiceImpl();

    public MainPageController() throws IOException {
    }

    public void initialize()
    {
        //ObservableList<StudyGroup> studyGroups = FXCollections.observableArrayList(groupService.getAllGroup());
        List<StudyGroup> groups = groupService.getAllGroup();
        List<Subject> subject = subjectService.getAllSubject();
        List<AttestationType> types = attestationTypeService.getAllTypes();
        List<String> step = Arrays.asList("первая ступень", "вторая ступень");
        List<String> form = Arrays.asList("дневная", "заочная");
        List<Integer> semestr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        subjectSelectList.getItems().setAll(subject);
        groupSelectList.getItems().setAll(groups);
        typeSelectList.getItems().setAll(types);
        stepSelectList1.getItems().setAll(step);
        formSelectList.getItems().setAll(form);
        semestrSelectList.getItems().setAll(semestr);
    }

    @FXML
    protected void closeButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void aboutAuthorButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) aboutAuthorButton.getScene().getWindow();
        stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("aboutAuthorView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void getSelectedGroupItem(ActionEvent event) {
        StudyGroup studyGroup = groupSelectList.getValue();
        ObservableList<Students> students = FXCollections
                .observableArrayList(studentsService.
                        getAllStudentsByGroupId(studyGroup.getId()));
        full_name.setCellValueFactory(new PropertyValueFactory<Students, String>("fullName"));
        bookNumberColumn.setCellValueFactory(new PropertyValueFactory<Students, String>("bookNumber"));
        studentTable.setItems(students);
    }

    public void getSelectedSubjectItem(ActionEvent event) {
        Subject subject = subjectSelectList.getValue();
    }

    public void createDocumentButtonClick(ActionEvent event) throws IOException {

        Window owner = createDocumentButton.getScene().getWindow();

        List<Students> studs = studentTable.getItems();
        StudyGroup group = groupSelectList.getValue();
        Subject subject = subjectSelectList.getValue();
        AttestationType type = typeSelectList.getValue();
        String professor = professorName.getText();
        LocalDate date = data.getValue();
        String step = stepSelectList1.getValue();
        String form = formSelectList.getValue();
        Integer semester = semestrSelectList.getValue();

        if(group!=null && group!=null && subject!=null
                && type!=null && professor!="" && date!=null
                && step!=null && form!=null && semester!=null && studs.size()!=0 ){
            Faculty faculty = facultyService.getFaculty(group.getName());
            Integer entryYear = Integer.parseInt(group.getName().substring(6));
            String year = stringService.getYearByEntryYearAndSemester(semester, entryYear);
            String code = group.getName().substring(4, 6);
            Integer course = Integer.parseInt(Year.now().toString())-(entryYear+2000);
            EducationHours hours = educationHoursService.getHoursByGroupCodeAndSemester(semester, code);
            if(hours == null){
                showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                        "В этом семестре нет данного предмета. Проверьте правильность введенных данных");
                return;
            }
            var directory = directoryChooser.showDialog(owner);
            var path = directory.getAbsolutePath();
            DocModel doc = new DocModel(studs, step, form,  semester.toString(),
                    group.getName(), type.getName(), subject.getName(), professor,
                    year, faculty.getName(), course, hours.getHours(), date.toString(), path);
            if(fileCreate.CreateDocument(doc)){
                showAlert(Alert.AlertType.INFORMATION, owner, "Form Success!",
                        "Документ успешно создан");
            }
        }
        else{
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Проверьте введенные данные");
            return;
        }
    }

    public void getSelectedTypeItem(ActionEvent event) {
        Subject subject = subjectSelectList.getValue();
    }

    public void getSelectedStepItem(ActionEvent event) {
        Subject subject = subjectSelectList.getValue();
    }

    public void getSelectedFormItem(ActionEvent event) {
        Subject subject = subjectSelectList.getValue();
    }

    public void getSelectedSemestrItem(ActionEvent event) {
        Subject subject = subjectSelectList.getValue();
    }

    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public void handleButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) handleButton.getScene().getWindow();
        stage.close();
        stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("handlePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}
