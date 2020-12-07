package com.springboot.pdf.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;

@RestController
public class AdvancedPdfWriterController {
    @GetMapping("/advancedpdf1")
    public Document creatingAdvancedPdf()throws Exception{
        Document document = new Document();
        PdfWriter.getInstance(document,new FileOutputStream("advancedPdf1.pdf"));

        //setting the author name
        document.addAuthor("ntwari egide - yombi");
        document.addCreationDate();
        document.addTitle("Advanced java pdf writer");



        return document;
    }
}
