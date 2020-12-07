package com.springboot.pdf.controller;

import com.itextpdf.layout.property.BackgroundImage;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPage;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;

@RestController
public class AdvancedPdfWriterController {
    @GetMapping("/advancedpdf1")
    public String creatingAdvancedPdf()throws Exception{
        Document document = new Document();
        PdfWriter.getInstance(document,new FileOutputStream("advancedPdf1.pdf"));

        //setting the author name
        document.addAuthor("ntwari egide - yombi");
        document.addCreationDate();
        document.addTitle("Advanced java pdf writer");

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA,18, BaseColor.BLACK);
        document.setMargins(23f,23f,23f,23f);
        Chunk header = new Chunk("Advanced PDF creator",font);
        document.add(Chunk.NEWLINE);
        header.setBackground(BaseColor.YELLOW);

        // adding background image
        String contentParagraph = "A law firm is usually a partnership between lawyers who have come together to offer their expertise to clients under one name " +
                "These partners share the profits of the firm as well as the risks (liabilities), and engage other lawyers to work with them as associates."+
                "According to The Lawyer UK 200 2019, the below organisations make up the top 50 UK law firms based on annual turnover";

        Paragraph paragraph1 = new Paragraph(contentParagraph);
        paragraph1.setAlignment(4);
        paragraph1.setPaddingTop(40);
        paragraph1.setIndentationLeft(30);

        document.add(header);A
        document.add(paragraph1);
        document.close();

        return "Document created";
    }
}
