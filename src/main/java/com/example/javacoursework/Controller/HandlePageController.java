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
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Year;
import java.util.Arrays;
import java.util.List;

public class HandlePageController {

    @FXML
    ComboBox<String> stepSelectList1;

    @FXML
    ComboBox<String> formSelectList;

    @FXML
    ComboBox<Integer> semestrSelectList;

    @FXML
    ComboBox<AttestationType> typeSelectList;

    @FXML
    Button closeButton, aboutAuthorButton, createDocumentButton, addStudentButton;

    @FXML
    private TableView<Students> studentTable_handle;

    @FXML
    private DatePicker data;

    @FXML
    private TextField professorName, bookField, nameField, hoursField, groupField, subjectField;
    DirectoryChooser directoryChooser = new DirectoryChooser();

    @FXML
    private TableColumn<Students, String> full_name_handle, bookNumberColumn_handle;
    private GroupService groupService = new GroupServiceImpl();
    private SubjectService subjectService = new SubjectServiceImpl();
    private StudentsService studentsService = new StudentServiceImpl();
    private AttestationTypeService attestationTypeService = new AttestationTypeServiceImpl();
    private FacultyService facultyService = new FacultyServiceImpl();
    private EducationHoursService educationHoursService = new EducationHoursServiceImpl();
    private FileCreateService fileCreate = new FileCreateImpl();
    private StringService stringService = new StringServiceImpl();

    public HandlePageController() throws IOException {
    }

    public void initialize()
    {
        List<AttestationType> types = attestationTypeService.getAllTypes();
        List<String> step = Arrays.asList("первая ступень", "вторая ступень");
        List<String> form = Arrays.asList("дневная", "заочная");
        List<Integer> semestr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        typeSelectList.getItems().setAll(types);
        stepSelectList1.getItems().setAll(step);
        formSelectList.getItems().setAll(form);
        semestrSelectList.getItems().setAll(semestr);
    }

    @FXML
    protected void closeButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
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

/*    public void getSelectedGroupItem(ActionEvent event) {
        StudyGroup studyGroup = groupSelectList.getValue();
        ObservableList<Students> students = FXCollections
                .observableArrayList(studentsService.
                        getAllStudentsByGroupId(studyGroup.getId()));
        full_name.setCellValueFactory(new PropertyValueFactory<Students, String>("fullName"));
        bookNumberColumn.setCellValueFactory(new PropertyValueFactory<Students, String>("bookNumber"));
        studentTable.setItems(students);
    }*/

/*
    public void getSelectedSubjectItem(ActionEvent event) {
        Subject subject = subjectSelectList.getValue();
    }
*/

    public void createDocumentButtonClick(ActionEvent event) throws IOException {

        Window owner = createDocumentButton.getScene().getWindow();

        List<Students> studs = studentTable_handle.getItems();
        var group = groupField.getText();
        var subject = subjectField.getText();
        var hours = hoursField.getText();
        AttestationType type = typeSelectList.getValue();
        String professor = professorName.getText();
        LocalDate date = data.getValue();
        String step = stepSelectList1.getValue();
        String form = formSelectList.getValue();
        Integer semester = semestrSelectList.getValue();

        if(group!=null && group!=null && subject!=null
                && type!=null && professor!="" && date!=null
                && step!=null && form!=null && semester!=null && studs.size()!=0 ){
            String code = group.substring(4, 6);
            educationHoursService.addHours(new EducationHours(0, hours, code, semester.toString()));
            subjectService.addSubject(new Subject(0, subject));

            Faculty faculty = facultyService.getFaculty(group);
            Integer entryYear = Integer.parseInt(group.substring(6));
            String year = stringService.getYearByEntryYearAndSemester(semester, entryYear);
            Integer course = Integer.parseInt(Year.now().toString())-(entryYear+2000);
            if(hours == null){
                showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                        "В этом семестре нет данного предмета. Проверьте правильность введенных данных");
                return;
            }
            var directory = directoryChooser.showDialog(owner);
            var path = directory.getAbsolutePath();
            DocModel doc = new DocModel(studs, step, form,  semester.toString(),
                    group, type.getName(), subject, professor,
                    year, faculty.getName(), course, hours, date.toString(), path);
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

    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public void addStudentButtonClick(ActionEvent event){
        var studName = nameField.getText();
        var bookNum = bookField.getText();
        var groupId = groupService.getIdForAddStudent(bookNum);
        studentsService.addStudent(new Students(0, studName, bookNum, groupId));

        ObservableList<Students> students = FXCollections
                .observableArrayList(studentsService.
                        getAllStudentsByGroupId(groupId));
        full_name_handle.setCellValueFactory(new PropertyValueFactory<Students, String>("fullName"));
        bookNumberColumn_handle.setCellValueFactory(new PropertyValueFactory<Students, String>("bookNumber"));
        studentTable_handle.setItems(students);

        studentTable_handle.setOnMouseClicked(ev -> {
            if (ev.getClickCount() == 2 && !studentTable_handle.getSelectionModel().isEmpty()) {
                Students selectedPerson = studentTable_handle.getSelectionModel().getSelectedItem();

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Удаление записи");
                alert.setHeaderText("Вы действительно хотите удалить запись?");
                alert.setContentText("Имя: " + selectedPerson.getFullName());

                alert.showAndWait().ifPresent(result -> {
                    if (result == ButtonType.OK) {
                        studentsService.Delete(selectedPerson);
                    }
                });
            }
        });

    }
}
