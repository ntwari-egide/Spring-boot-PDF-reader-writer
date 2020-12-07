package com.springboot.pdf.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class PdfManagerController {

    @GetMapping("/make-text-pdf/itext")
    public String creatingPdfUsingIText()throws Exception{
        Document document = new Document();

        // creating the instance of the PdfWriter class
        PdfWriter.getInstance(document,new FileOutputStream("MyCreatedPdf.pdf"));

        // open document
        document.open();
        //Styling the document
        Font font = FontFactory.getFont(FontFactory.HELVETICA,16, BaseColor.BLACK);
        // Adding the content
        Chunk content = new Chunk("Hello spring boot pdf writer ",font);
        //inserting content into pdf writer
        document.add(content);
        //Closing the document
        document.close();

        return "Pdf generated ";
    }

    @GetMapping("/make-image-pdf/itext")
    public String creatingImagePdfUsingIText()throws Exception{
        Document document = new Document();
        PdfWriter.getInstance(document,new FileOutputStream("ImagePdf.pdf"));

        document.open();
        String imageFile = "C:\\Users\\user\\Documents\\ntwari egide documents\\spring boot\\Spring-boot-PDF-reader-writer\\src\\main\\java\\com\\springboot\\pdf\\controller\\shapes.png";

        Font font = FontFactory.getFont(FontFactory.HELVETICA,17,BaseColor.BLACK);
        Chunk header = new Chunk("Image inserted by spring booot",font);

        Image imageToInsert = Image.getInstance(imageFile);

        document.add(header);
        document.add(imageToInsert);

        document.close();

        return "spring pdf generated ";
    }
}
