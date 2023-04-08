package com.example.javacoursework.service.Impl;

import com.example.javacoursework.entity.*;
import com.example.javacoursework.models.DocModel;
import com.example.javacoursework.service.*;

import java.io.*;
import org.apache.poi.xwpf.usermodel.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileCreateImpl implements FileCreateService {

    private List<String> finalBlock = Arrays
            .asList("Количество обучающихся явихшихся на аттестацию:_________",
            "Количество обучающихся получивших оценки:",
            "10(десять):_____ 8(восемь):_____ 6(шесть):_____ 4(четыре):_____ 2(два):_____",
            "9(девять):_____ 7(семь):_____ 5(пять):_____ 3(три):_____ 1(один)_____",
            "Количество обучающихся не явихшихся на аттестацию (в том числе и недопущенные):_________");
    public FileCreateImpl() throws FileNotFoundException, IOException {
    }
    public boolean CreateDocument(DocModel doc) throws IOException {
        FileOutputStream stream = new FileOutputStream(doc.getPath()+"\\Ведомость"+doc.getGroupName()+".docx");
        XWPFDocument document = new XWPFDocument();

        createOneStingWithBreak("БЕЛАРУССКИЙ НАЦИОНАЛЬНЫЙ ТЕХНИЧЕСКИЙ УНИВЕРСИТЕТ", document);

        createOneBoldSting("ЗАЧЕТНО-ЭКЗАМЕНАЦИОННАЯ ВЕДОМОСТЬ №123456", document);

        createOneBoldSting("текущей аттестации учебной группы", document);

        createOneStingWith2Parts("Форма получения высшего образования: ", doc.getForm(), document);

        createOneStingWith2Parts("Ступень высшего образования: ", doc.getStep(), document);

        createOneStingWith2Parts("Форма текущей аттестации: ", doc.getAttestationType(), document);

        createOneStingWith2PartsOfData("Учебный год _", doc.getYear(), " Семестр ", doc.getSemester(), document);

        createOneStingWithOnlyData(doc.getFaculty(), document);

        createOneStingWith2PartsOfData("Курс ", doc.getCourse()+"                       ", "Группа ", doc.getGroupName(), document);

        createOneStingWithOneDataAndOneText("Дисциплина (название практики) ", doc.getSubject(), document);

        createOneStingWithOneDataAndOneText("Всего часов по дисциплине(практике) в семестре ", doc.getHours(), document);

        createOneStingWithOneDataAndOneText("Фамилия инициалы преподавателя ", doc.getProfessor(), document);

        createOneStingWithOneDataAndOneText("Дата проведения аттестации ", doc.getDate(), document);

        CreateTable(doc.getStudents(), document);

        createOneStingWithLowSubString("подпись     ", "Авсиевич А.М.", document);

        FinalBlock(finalBlock, document);

        document.write(stream);
        stream.close();
        return true;
    }

    private void CreateTable(List<Students> students, XWPFDocument document){
        XWPFTable table = document.createTable();

        XWPFTableRow tableRowOne = table.getRow(0);
        tableRowOne.getCell(0).setText("№ п/п");
        tableRowOne.addNewTableCell().setText("Фамилия имя");
        tableRowOne.addNewTableCell().setText("Номер зачетной книжки");
        tableRowOne.addNewTableCell().setText("Отметка о зачете(зачтено или не зачтено)");
        tableRowOne.addNewTableCell().setText("Отметка о баллах");
        tableRowOne.addNewTableCell().setText("Подпись преподавателя");

        XWPFTableRow tableRowNum = table.createRow();
        var cell = tableRowNum.getCell(0);
        cell.getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
        cell.setText("1");
        cell = tableRowNum.getCell(1);
        cell.getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
        cell.setText("2");
        cell = tableRowNum.getCell(2);
        cell.getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
        cell.setText("3");
        cell = tableRowNum.getCell(3);
        cell.getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
        cell.setText("4");
        cell = tableRowNum.getCell(4);
        cell.getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
        cell.setText("5");
        cell = tableRowNum.getCell(5);
        cell.getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
        cell.setText("6");

        int i = 0;
        for (Students st : students) {
            i++;
            XWPFTableRow tableRowTwo = table.createRow();
            tableRowTwo.getCell(0).setText(""+i);
            tableRowTwo.getCell(1).setText(st.getFullName());
            tableRowTwo.getCell(2).setText(st.getBookNumber());
            tableRowTwo.getCell(3).setText("");
            tableRowTwo.getCell(4).setText("");
            tableRowTwo.getCell(5).setText("");
        }
    }

    private void FinalBlock(List<String> finalBlock, XWPFDocument document) {
        for (String text : finalBlock) {
            XWPFParagraph paragraph = document.createParagraph();
            paragraph.setAlignment(ParagraphAlignment.BOTH);
            XWPFRun run = paragraph.createRun();
            run.setFontSize(14);
            run.setText(text);
        }
    }

    private void createOneStingWith2Parts(String text, String data, XWPFDocument document){
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run = paragraph.createRun();
        XWPFRun run1 = paragraph.createRun();
        run.setFontSize(14);
        run1.setBold(true);
        run1.setFontSize(14);
        run.setText(text);
        run1.setText(data);
    }

    private void createOneStingWith2PartsOfData(String text1, String data1, String text2, String data2, XWPFDocument document){
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        XWPFRun run0 = paragraph.createRun();
        XWPFRun run1 = paragraph.createRun();
        XWPFRun run2 = paragraph.createRun();
        run.setFontSize(14);
        run0.setFontSize(14);
        run1.setFontSize(14);
        run2.setFontSize(14);
        run0.setUnderline(UnderlinePatterns.SINGLE);
        run2.setUnderline(UnderlinePatterns.SINGLE);
        run.setText(text1);
        run0.setText(data1);
        run1.setText(text2);
        run2.setText(data2);
    }

    private void createOneStingWithOneDataAndOneText(String text, String data, XWPFDocument document){
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        XWPFRun run1 = paragraph.createRun();
        run.setFontSize(14);
        run1.setFontSize(14);
        run1.setUnderline(UnderlinePatterns.SINGLE);
        run.setText(text);
        run1.setText(data);
    }

    private void createOneStingWithOnlyData(String data, XWPFDocument document){
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setFontSize(14);
        run.setUnderline(UnderlinePatterns.SINGLE);
        run.setText(data);
    }

    private void createOneStingWithLowSubString(String text, String text1, XWPFDocument document){
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.createRun().addBreak();
        paragraph.setAlignment(ParagraphAlignment.RIGHT);
        XWPFRun run = paragraph.createRun();
        XWPFRun run2 = paragraph.createRun();
        run2.setFontSize(14);
        run.setSubscript(VerticalAlign.SUBSCRIPT);
        run.setText(text);
        run2.setText(text1);
    }

    private void createOneBoldSting(String text, XWPFDocument document){
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run = paragraph.createRun();
        run.setFontSize(14);
        run.setBold(true);
        run.setText(text);
    }

    private void createOneStingWithBreak(String text, XWPFDocument document){
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run = paragraph.createRun();
        run.setFontSize(14);
        run.setText(text);
    }
}
