package com.example.javacoursework.service.Impl;

import com.example.javacoursework.dao.GroupDao;
import com.example.javacoursework.dao.Impl.GroupDaoImpl;
import com.example.javacoursework.dao.Impl.StudentsDaoImpl;
import com.example.javacoursework.dao.StudentsDao;
import com.example.javacoursework.entity.Students;
import com.example.javacoursework.entity.StudyGroup;
import com.example.javacoursework.service.GroupService;
import com.example.javacoursework.service.StudentsService;

import java.util.List;

public class GroupServiceImpl implements GroupService {
    private final GroupDao groupDao = new GroupDaoImpl();

    @Override
    public List<StudyGroup> getAllGroup() {
        return groupDao.getAllGroup();
    }

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
