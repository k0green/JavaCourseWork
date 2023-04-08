module com.example.javacoursework {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;
    requires jbcrypt;
    requires org.apache.commons.lang3;
    requires java.naming;
    requires javafx.web;
    requires org.apache.poi.ooxml;


    opens com.example.javacoursework to javafx.fxml;
    exports com.example.javacoursework.Controller;
    opens com.example.javacoursework.Controller to javafx.fxml;
    opens com.example.javacoursework.entity;
    exports com.example.javacoursework;
}