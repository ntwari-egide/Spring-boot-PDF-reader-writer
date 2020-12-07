package com.springboot.pdf.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;

@RestController
public class PdfManagerController {

    @GetMapping("/make-pdf/itext")
    public void creatingPdfUsingIText()throws Exception{
        Document document = new Document();

        // creating the instance of the PdfWriter class
        PdfWriter.getInstance(document,new FileOutputStream("MycreatedPdf.pdf"));
//        return "File pf is being created ";
    }
}
