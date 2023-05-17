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
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Year;
import java.util.Arrays;
import java.util.List;

/**
 * Контроллер для страницы создания документа вручную
 * @author Egor
 * @version 1.0
 */
public class HandlePageController {


    /**
     *  Список выбора ступени.
     */
    @FXML
    ComboBox<String> stepSelectList1;

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

    @FXML
    Button closeButton, aboutAuthorButton, createDocumentButton, addStudentButton, aboutProjectButton, getStudentButton;

    @FXML
    private TableView<StudentModel> studentTable_handle;

    @FXML
    private DatePicker data;

    @FXML
    private TextField professorName, bookField, nameField, hoursField, groupField, subjectField;
    DirectoryChooser directoryChooser = new DirectoryChooser();

    @FXML
    private TableColumn<StudentModel, String> full_name_handle, bookNumberColumn_handle, resultColumn_handle;
    private GroupService groupService = new GroupServiceImpl();
    private SubjectService subjectService = new SubjectServiceImpl();
    private StudentsService studentsService = new StudentServiceImpl();
    private AttestationTypeService attestationTypeService = new AttestationTypeServiceImpl();
    private FacultyService facultyService = new FacultyServiceImpl();
    private EducationHoursService educationHoursService = new EducationHoursServiceImpl();
    private FileCreateService fileCreate = new FileCreateImpl();
    private StringService stringService = new StringServiceImpl();

    private List<String> results = Arrays.asList("1/один", "2/два", "3/три", "4/четыре", "5/пять", "6/шесть", "7/семь", "8/восемь", "9/девять", "10/десять");

    private List<String> results1 = Arrays.asList("зачтено", "не зачтено");

    public HandlePageController() throws IOException {
    }

    /**
     * метод инициализирующий данные
     */
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

    /**
     * Обработчик события нажатия кнопки "Close". Закрывает текущее окно.
     * @param event событие нажатия кнопки
     * @throws IOException если произошла ошибка при закрытии окна
     */
    @FXML
    protected void closeButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
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
     * Обработчик события нажатия кнопки "О проекте".
     * @param event событие нажатия кнопки
     * @throws IOException если произошла ошибка при закрытии окна
     */
    @FXML
    protected void aboutProjectButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) aboutProjectButton.getScene().getWindow();
        stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("aboutAuthorView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Обработчик события нажатия кнопки "Получить студентов".
     * @param event событие нажатия кнопки
     * @throws IOException если произошла ошибка при закрытии окна
     */
    @FXML
    protected void getStudentButtonClick(ActionEvent event) throws IOException {
        if(subjectField.getText() != "" && groupField.getText() != "" && semestrSelectList.getValue() != null){
            var bookNum = groupField.getText() + "00";
            var groupId = groupService.getIdForAddStudent(bookNum);
            ObservableList<StudentModel> students = FXCollections
                    .observableArrayList(studentsService.
                            getAllStudentsByGroupIdSemesterAndSubjectId(groupId, subjectService.getSubjectIdByName(subjectField.getText()), semestrSelectList.getValue()));
            full_name_handle.setCellValueFactory(new PropertyValueFactory<StudentModel, String>("fullName"));
            bookNumberColumn_handle.setCellValueFactory(new PropertyValueFactory<StudentModel, String>("bookNumber"));
            resultColumn_handle.setCellValueFactory(new PropertyValueFactory<StudentModel, String>("result"));
            studentTable_handle.setItems(students);

            studentTable_handle.setOnMouseClicked(ev -> {
                if (ev.getClickCount() == 2 && !studentTable_handle.getSelectionModel().isEmpty()) {
                    var selectedPerson = studentTable_handle.getSelectionModel().getSelectedItem();

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

                    Window owner = createDocumentButton.getScene().getWindow();

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
                                    studentsService.getAllStudentsByGroupIdSemesterAndSubjectId(groupId, subjectService.getSubjectIdByName(subjectField.getText()), semestrSelectList.getValue())
                            );
                            studentTable_handle.setItems(studs);
                            return null;
                        } else if (buttonType == editButtonType) {
                            selectedPerson.setFullName(fullNameTextField.getText());
                            selectedPerson.setBookNumber(bookNumberTextField.getText());
                            if(typeSelectList.getValue().getId()==3){
                                selectedPerson.setResult(resultField1.getValue());
                            } else if (typeSelectList.getValue().getId()==1 || typeSelectList.getValue().getId()==2) {
                                selectedPerson.setResult(resultField.getValue());
                            }
                            studentsService.Update(selectedPerson, semestrSelectList.getValue(), subjectService.getSubjectIdByName(subjectField.getText()));
                            ObservableList<StudentModel> studUp = FXCollections.observableArrayList(
                                    studentsService.getAllStudentsByGroupIdSemesterAndSubjectId(groupId, subjectService.getSubjectIdByName(subjectField.getText()), semestrSelectList.getValue())
                            );
                            studentTable_handle.setItems(studUp);
                            return selectedPerson;
                        } else {
                            return null;
                        }
                    });

                    dialog.showAndWait();
                }
            });
        } else {
            Window owner = createDocumentButton.getScene().getWindow();
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Заполните обязательные поля: предмет, семестр, группа");
            return;
        }

    }

    /**
     * Обработчик события нажатия кнопки "Создать документ".
     * @param event событие нажатия кнопки
     * @throws IOException если произошла ошибка при закрытии окна
     */
    public void createDocumentButtonClick(ActionEvent event) throws IOException {

        Window owner = createDocumentButton.getScene().getWindow();

        List<StudentModel> studs = studentTable_handle.getItems();
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
     * Обработчик события нажатия кнопки "Добавить студента".
     * @param event событие нажатия кнопки
     * @throws IOException если произошла ошибка при закрытии окна
     */
    public void addStudentButtonClick(ActionEvent event){
        Window own = createDocumentButton.getScene().getWindow();
        var studName = nameField.getText();
        var bookNum = bookField.getText();
        if(studName!="" && bookNum!="") {
            var groupId = groupService.getIdForAddStudent(bookNum);

            studentsService.addStudent(new StudentModel(0, studName, bookNum, groupId, null), semestrSelectList.getValue(), subjectService.getSubjectIdByName(subjectField.getText()));

            ObservableList<StudentModel> students = FXCollections
                    .observableArrayList(studentsService.
                            getAllStudentsByGroupIdSemesterAndSubjectId(groupId, subjectService.getSubjectIdByName(subjectField.getText()), semestrSelectList.getValue()));
            full_name_handle.setCellValueFactory(new PropertyValueFactory<StudentModel, String>("fullName"));
            bookNumberColumn_handle.setCellValueFactory(new PropertyValueFactory<StudentModel, String>("bookNumber"));
            studentTable_handle.setItems(students);

        /*studentTable_handle.setOnMouseClicked(ev -> {
            if (ev.getClickCount() == 2 && !studentTable_handle.getSelectionModel().isEmpty()) {
                Students selectedPerson = studentTable_handle.getSelectionModel().getSelectedItem();

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Удаление записи");
                alert.setHeaderText("Вы действительно хотите удалить запись?");
                alert.setContentText("Имя: " + selectedPerson.getFullName());

                alert.showAndWait().ifPresent(result -> {
                    if (result == ButtonType.OK) {
                        studentsService.Delete(selectedPerson);
                        ObservableList<Students> studs = FXCollections
                                .observableArrayList(studentsService.
                                        getAllStudentsByGroupId(groupId));
                        full_name_handle.setCellValueFactory(new PropertyValueFactory<Students, String>("fullName"));
                        bookNumberColumn_handle.setCellValueFactory(new PropertyValueFactory<Students, String>("bookNumber"));
                        studentTable_handle.setItems(studs);
                    }
                });
            }
        });*/

            studentTable_handle.setOnMouseClicked(ev -> {
                if (ev.getClickCount() == 2 && !studentTable_handle.getSelectionModel().isEmpty()) {
                    var selectedPerson = studentTable_handle.getSelectionModel().getSelectedItem();

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

                    Window owner = createDocumentButton.getScene().getWindow();

                    GridPane gridPane = new GridPane();
                    gridPane.add(new Label("Имя:"), 0, 0);
                    gridPane.add(fullNameTextField, 1, 0);
                    gridPane.add(new Label("Номер зачетной книжки:"), 0, 1);
                    gridPane.add(bookNumberTextField, 1, 1);
                    if (typeSelectList.getValue() != null) {
                        if (typeSelectList.getValue().getId() == 3) {
                            gridPane.add(new Label("Результат:"), 0, 2);
                            gridPane.add(resultField1, 1, 2);
                        } else if (typeSelectList.getValue().getId() == 1 || typeSelectList.getValue().getId() == 2) {
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
                                    studentsService.getAllStudentsByGroupIdSemesterAndSubjectId(groupId, semestrSelectList.getValue(), subjectService.getSubjectIdByName(subjectField.getText()))
                            );
                            studentTable_handle.setItems(studs);
                            return null;
                        } else if (buttonType == editButtonType) {
                            selectedPerson.setFullName(fullNameTextField.getText());
                            selectedPerson.setBookNumber(bookNumberTextField.getText());
                            studentsService.Update(selectedPerson, semestrSelectList.getValue(), subjectService.getSubjectIdByName(subjectField.getText()));
                            ObservableList<StudentModel> studs = FXCollections.observableArrayList(
                                    studentsService.getAllStudentsByGroupIdSemesterAndSubjectId(groupId, semestrSelectList.getValue(), subjectService.getSubjectIdByName(subjectField.getText()))
                            );
                            ObservableList<StudentModel> studUp = FXCollections.observableArrayList(
                                    studentsService.getAllStudentsByGroupIdSemesterAndSubjectId(groupId, semestrSelectList.getValue(), subjectService.getSubjectIdByName(subjectField.getText()))
                            );
                            studentTable_handle.setItems(studUp);
                            return selectedPerson;
                        } else {
                            return null;
                        }
                    });

                    dialog.showAndWait();
                }
            });

        }
        else{
            showAlert(Alert.AlertType.ERROR, own, "Form Error!",
                    "Проверьте введенные данные");
            return;
        }
    }
}
