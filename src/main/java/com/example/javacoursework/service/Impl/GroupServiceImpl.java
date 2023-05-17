package com.example.javacoursework.service.Impl;

import com.example.javacoursework.dao.GroupDao;
import com.example.javacoursework.dao.Impl.GroupDaoImpl;
import com.example.javacoursework.entity.StudyGroup;
import com.example.javacoursework.service.GroupService;

import java.util.List;

/**
 * Реализация интерфейса GroupService, предоставляющая доступ к группам
 *
 *  @author Egor
 *  @version 1.0
 */
public class GroupServiceImpl implements GroupService {

    private final GroupDao groupDao = new GroupDaoImpl();

    /**
     * Метод для получения списка всех групп
     * @return список групп
     */
    @Override
    public List<StudyGroup> getAllGroup() {
        return groupDao.getAllGroup();
    }

    /**
     * Метод для получения ID группы для добавления студента
     * @param bookNum номер зачетной книжки студента
     * @return ID группы
     */
    @Override
    public int getIdForAddStudent(String bookNum) {
        var groupNum = bookNum.substring(0, bookNum.length() - 2);
        var group = groupDao.getGroupByName(groupNum);
        if(group==null){
            groupDao.Add(new StudyGroup(0, groupNum));
            group = groupDao.getGroupByName(groupNum);
        }
        return group.getId();
    }
}
