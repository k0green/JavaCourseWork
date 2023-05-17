package com.example.javacoursework.service.Impl;

import com.example.javacoursework.dao.Impl.StudentsDaoImpl;
import com.example.javacoursework.dao.StudentsDao;
import com.example.javacoursework.entity.Result;
import com.example.javacoursework.entity.Student;
import com.example.javacoursework.models.StudentModel;
import com.example.javacoursework.service.ResultService;
import com.example.javacoursework.service.StudentsService;

import java.util.*;

/**
 * Класс реализует интерфейс StudentsService и предоставляет
 * реализацию методов по работе со студентами
 *
 * @author Egor
 * @version 1.0
 */
public class StudentServiceImpl implements StudentsService {
    /**
     * Создаем объект DAO для доступа к студентам
     */
    private final StudentsDao studentsDao = new StudentsDaoImpl();
    /**
     * Создаем объект DAO для доступа к результатам
     */
    private ResultService resultService = new ResultServiceImpl();

    /**
     * метод аозвращает список студентов
     * @param groupId id группы
     * @param subjectId - id предмета
     * @param semester - носер семестра
     * @return список студентов
     */
    public List<StudentModel> getAllStudentsByGroupIdSemesterAndSubjectId(int groupId, int subjectId, int semester)
    {
        Comparator<Student> countryModelsComparator
                = Comparator.comparing(Student::getFullName);

        List<Student> students = studentsDao.getAllStudentsByGroupId(groupId);
        Collections.sort(students, countryModelsComparator);

        var newStudents = new ArrayList<StudentModel>();

        for (var stud : students) {
            var student = new StudentModel(
                    stud.getId(),
                    stud.getFullName(),
                    stud.getBookNumber(),
                    stud.getGroupId(),
                    "<пусто>"
            );
            var res = resultService.getResultByStudentAndSubjectIdAndSemester(
                    semester,
                    stud.getId(),
                    subjectId
            );
            if(res != null)
                student.setResult(res.getName());
            newStudents.add(student);
        }

        return newStudents;
    }

    /**
     * метод по добавлению студента
     * @param student - объект класса StudentModel
     * @param semester - номер семестра
     * @param subjectId - id предмета
     */
    @Override
    public void addStudent(StudentModel student, int semester, int subjectId) {
        if(studentsDao.getStudentByName(student.getFullName())==null){
            studentsDao.addStudent(new Student(student.getId(), student.getFullName(), student.getBookNumber(), student.getGroupId()));
            resultService.Add(new Result(0, student.getResult(), student.getId(), semester, subjectId));
        }
    }

    /**
     * метод для удаления студента
     * @param student
     */
    public void Delete(StudentModel student){
        studentsDao.Delete(new Student(student.getId(), student.getFullName(), student.getBookNumber(), student.getGroupId()));
    }

    /**
     * метод по обновлению данных у студента
     * @param student - объект класса StudentModel
     * @param semester - номер семестра
     * @param subjectId - id предмета
     */
    @Override
    public void Update(StudentModel student, int semester, int subjectId) {
        studentsDao.Update(new Student(student.getId(), student.getFullName(), student.getBookNumber(), student.getGroupId()));
        if(student.getResult() == "<пусто>"){
            resultService.Add(new Result(0, student.getResult(), student.getId(), semester, subjectId));
        } else {
            var res = resultService.getResultByStudentAndSubjectIdAndSemester(semester, student.getId(), subjectId);
            if(res == null){
                resultService.Add(new Result(0, student.getResult(), student.getId(), semester, subjectId));
            } else{
                res.setName(student.getResult());
                resultService.Update(res);
            }
        }
    }
}
