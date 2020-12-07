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
        // 1 - > Text center
        // 0 -> Text left
        // 2 -> Text right

        paragraph1.setAlignment(0);
        //paragraph1.setIndentationLeft(30);

        //                                                      ADDING THE IMAGE INTO THE CONTENT

        String imageFile = "C:\\Users\\user\\Documents\\ntwari egide documents\\spring boot\\Spring-boot-PDF-reader-writer\\src\\main\\resources\\apple.jpg";

        Image imageToInsert  = Image.getInstance(imageFile);
        imageToInsert.setAlt("apple logo image");
        imageToInsert.scaleToFit(400,400);

        //                                                      ADDING THE HEADER PARAGRAPH
        Chunk header2 = new Chunk("Table of all required calculation",new Font(FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE,16,new BaseColor(252, 140, 3))));

        document.add(header);
        document.add(paragraph1);
        document.add(imageToInsert);
        document.add(header2);
        document.close();

        return "Document created";
    }
}
