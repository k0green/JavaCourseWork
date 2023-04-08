package com.example.javacoursework.service;

import com.example.javacoursework.entity.Faculty;
import com.example.javacoursework.models.DocModel;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileCreateService {
    public boolean CreateDocument(DocModel doc) throws IOException;
}
