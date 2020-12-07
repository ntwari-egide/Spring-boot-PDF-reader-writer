package com.springboot.pdf.controller;

import com.itextpdf.text.*;
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

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA,18, BaseColor.BLACK);
        Chunk header = new Chunk("Advanced PDF creator",font);

        document.add(header);
        document.close();
        return document;
    }
}
