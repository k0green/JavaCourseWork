package com.example.javacoursework.Controller;

import com.example.javacoursework.HelloApplication;
import com.example.javacoursework.entity.*;
import com.example.javacoursework.models.DocModel;
import com.example.javacoursework.models.StudentModel;
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
import javafx.scene.layout.GridPane;
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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Контроллер для главной страницы
 * @author Egor
 * @version 1.0
 */
public class MainPageController {

    /**
     *  Список выбора группы.
     */
    @FXML
    ComboBox<StudyGroup> groupSelectList;
    /**
     *  Список выбора предмета.
     */
    @FXML
    ComboBox<Subject> subjectSelectList;
    /**
     *  Список выбора шага.
     */
    @FXML
    ComboBox<String> stepSelectList1;
    /**
     *  Список выбора преподавателя.
     */
    @FXML
    ComboBox<Professor> professorSelectList;
    /**
     *  Список выбора формы обучения.
     */
    @FXML
    ComboBox<String> formSelectList;
    /**
     *  Список выбора семестра.
     */
    @FXML
    ComboBox<Integer> semestrSelectList;
    /**
     *  Список выбора типа аттестации.
     */
    @FXML
    ComboBox<AttestationType> typeSelectList;
    /**
     *  Кнопка закрытия приложения.
     */
    @FXML
    Button closeButton;
    /**
     *  Кнопка открытия окна "О программе".
     */
    @FXML
    Button aboutAuthorButton;
    /**
     *  Кнопка создания документа.
     */
    @FXML
    Button createDocumentButton;
    /**
     *  Кнопка выполнения действия.
     */
    @FXML
    Button handleButton;
    /**
     *  Кнопка открытия окна "О продукте".
     */
    @FXML
    Button aboutProductButton;
    /**
     *  Таблица со списком студентов.
     */
    @FXML
    private TableView<StudentModel> studentTable;
    /**
     *  Поле выбора даты.
     */
    @FXML
    private DatePicker data;
    /**
     *  Поле ввода имени преподавателя.
     */
    @FXML
    private TextField professorName;
    /**
     *  Выбор директории для сохранения документа.
     */
    DirectoryChooser directoryChooser = new DirectoryChooser();

    @FXML
    private TableColumn<StudentModel, String> full_name, bookNumberColumn, resultColumn;
    private GroupService groupService = new GroupServiceImpl();
    private SubjectService subjectService = new SubjectServiceImpl();
    private StudentsService studentsService = new StudentServiceImpl();
    private AttestationTypeService attestationTypeService = new AttestationTypeServiceImpl();
    private FacultyService facultyService = new FacultyServiceImpl();
    private EducationHoursService educationHoursService = new EducationHoursServiceImpl();
    private FileCreateService fileCreate = new FileCreateImpl();
    private StringService stringService = new StringServiceImpl();
    private ProfessorService professorService = new ProfessorServiceImpl();
    private ResultService resultService = new ResultServiceImpl();
    private List<String> results = Arrays.asList("1/один", "2/два", "3/три", "4/четыре", "5/пять", "6/шесть", "7/семь", "8/восемь", "9/девять", "10/десять");

    private List<String> results1 = Arrays.asList("зачтено", "не зачтено");

    public MainPageController() throws IOException {
    }

    /**
     * метод инициализации данных
     */
    public void initialize()
    {
        List<StudyGroup> groups = groupService.getAllGroup();
        List<Professor> professors = professorService.getAllProfessors();
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
        professorSelectList.getItems().setAll(professors);
    }

    /**
     * Обработчик события нажатия кнопки "Close". Закрывает текущее окно.
     * @param event событие нажатия кнопки
     * @throws IOException если произошла ошибка при закрытии окна
     */
    @FXML
    protected void closeButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Обработчик события нажатия кнопки "Об авторе".
     * @param event событие нажатия кнопки
     * @throws IOException если произошла ошибка при закрытии окна
     */
    @FXML
    protected void aboutAuthorButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) aboutAuthorButton.getScene().getWindow();
        stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("aboutAuthorView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Обработчик события нажатия кнопки "Оо продукте".
     * @param event событие нажатия кнопки
     * @throws IOException если произошла ошибка при закрытии окна
     */
    @FXML
    protected void aboutProductButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) aboutProductButton.getScene().getWindow();
        stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("aboutProject.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Обработчик события нажатия кнопки "получить группу".
     * @param event событие нажатия кнопки
     * @throws IOException если произошла ошибка при закрытии окна
     */
    public void getSelectedGroupItem(ActionEvent event) {
        Window owner = createDocumentButton.getScene().getWindow();

        if(groupSelectList.getValue() != null && subjectSelectList.getValue() != null && semestrSelectList.getValue() != null){
            StudyGroup studyGroup = groupSelectList.getValue();
            ObservableList<StudentModel> students = FXCollections
                    .observableArrayList(studentsService
                            .getAllStudentsByGroupIdSemesterAndSubjectId(studyGroup.getId(), subjectSelectList.getValue().getId(), semestrSelectList.getValue()));
            full_name.setCellValueFactory(new PropertyValueFactory<StudentModel, String>("fullName"));
            bookNumberColumn.setCellValueFactory(new PropertyValueFactory<StudentModel, String>("bookNumber"));
            resultColumn.setCellValueFactory(new PropertyValueFactory<StudentModel, String>("result"));
            studentTable.setItems(students);

            studentTable.setOnMouseClicked(ev -> {
                if (ev.getClickCount() == 2 && !studentTable.getSelectionModel().isEmpty()) {
                    var selectedPerson = studentTable.getSelectionModel().getSelectedItem();

                    Dialog<StudentModel> dialog = new Dialog<>();
                    dialog.setTitle("Редактирование записи");
                    dialog.setHeaderText(null);

                    ButtonType deleteButtonType = new ButtonType("Удалить", ButtonBar.ButtonData.OK_DONE);
                    ButtonType editButtonType = new ButtonType("Редактировать", ButtonBar.ButtonData.OK_DONE);
                    dialog.getDialogPane().getButtonTypes().addAll(deleteButtonType, editButtonType, ButtonType.CANCEL);

                    TextField fullNameTextField = new TextField(selectedPerson.getFullName());
                    TextField bookNumberTextField = new TextField(selectedPerson.getBookNumber());
                    ComboBox<String> resultField = new ComboBox<String>();
                    resultField.getItems().setAll(results);
                    ComboBox<String> resultField1 = new ComboBox<String>();
                    resultField1.getItems().setAll(results1);



                    GridPane gridPane = new GridPane();
                    gridPane.add(new Label("Имя:"), 0, 0);
                    gridPane.add(fullNameTextField, 1, 0);
                    gridPane.add(new Label("Номер зачетной книжки:"), 0, 1);
                    gridPane.add(bookNumberTextField, 1, 1);
                    if(typeSelectList.getValue()!=null){
                        if(typeSelectList.getValue().getId()==3){
                            gridPane.add(new Label("Результат:"), 0, 2);
                            gridPane.add(resultField1, 1, 2);
                        } else if (typeSelectList.getValue().getId()==1 || typeSelectList.getValue().getId()==2) {
                            gridPane.add(new Label("Результат:"), 0, 2);
                            gridPane.add(resultField, 1, 2);
                        } else {
                            gridPane.add(new Label("Тип аттестации не указан"), 0, 2);
                        }
                    } else {
                        showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                                "Тип аттестации не указан");
                        return;
                    }
                    dialog.getDialogPane().setContent(gridPane);

                    dialog.setResultConverter(buttonType -> {
                        if (buttonType == deleteButtonType) {
                            studentsService.Delete(selectedPerson);
                            ObservableList<StudentModel> studs = FXCollections.observableArrayList(
                                    studentsService
                                            .getAllStudentsByGroupIdSemesterAndSubjectId(studyGroup.getId(), subjectSelectList.getValue().getId(), semestrSelectList.getValue())
                            );
                            studentTable.setItems(studs);
                            return null;
                        } else if (buttonType == editButtonType) {
                            selectedPerson.setFullName(fullNameTextField.getText());
                            selectedPerson.setBookNumber(bookNumberTextField.getText());
                            if(typeSelectList.getValue().getId()==3){
                                selectedPerson.setResult(resultField1.getValue());
                            } else if (typeSelectList.getValue().getId()==1 || typeSelectList.getValue().getId()==2) {
                                selectedPerson.setResult(resultField.getValue());
                            }
                            studentsService.Update(selectedPerson, semestrSelectList.getValue(), subjectSelectList.getValue().getId());
                            ObservableList<StudentModel> studUp = FXCollections.observableArrayList(
                                    studentsService
                                            .getAllStudentsByGroupIdSemesterAndSubjectId(studyGroup.getId(), subjectSelectList.getValue().getId(), semestrSelectList.getValue()));
                            studentTable.setItems(studUp);
                            return selectedPerson;
                        } else {
                            return null;
                        }
                    });

                    dialog.showAndWait();
                }
            });
        } else {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Тип аттестации не указан");
            return;
        }
    }

    public void getSelectedSubjectItem(ActionEvent event) {
        Subject subject = subjectSelectList.getValue();
    }

    /**
     * Обработчик события нажатия кнопки "Создать документ".
     * @param event событие нажатия кнопки
     * @throws IOException если произошла ошибка при закрытии окна
     */
    public void createDocumentButtonClick(ActionEvent event) throws IOException {

        Window owner = createDocumentButton.getScene().getWindow();

        List<StudentModel> studs = studentTable.getItems();
        StudyGroup group = groupSelectList.getValue();
        Subject subject = subjectSelectList.getValue();
        AttestationType type = typeSelectList.getValue();
        String professor = professorSelectList.getValue().getName();
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
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            DocModel doc = new DocModel(studs, step, form,  semester.toString(),
                    group.getName(), type.getName(), subject.getName(), professor,
                    year, faculty.getName(), course, hours.getHours(), date.format(formatter).toString(), path);
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

    /**
     * метод для вызова оповещения
     * @param alertType - тип оповещения
     * @param owner - окно
     * @param title - заголовок
     * @param message - сообщение
     */
    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    /**
     * Обработчик события нажатия кнопки "Создать документ вручную".
     * @param event событие нажатия кнопки
     * @throws IOException если произошла ошибка при закрытии окна
     */
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
