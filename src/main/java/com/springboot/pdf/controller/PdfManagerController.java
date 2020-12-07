package com.springboot.pdf.controller;

import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
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

        imageToInsert.setAlt("inserted image by spring boot");
        imageToInsert.setWidthPercentage(40);
        document.add(header);
        document.add(imageToInsert);

        document.close();

        return "spring pdf generated ";
    }

    @GetMapping("/make-table-pdf/itext")
    public String creatingPdfInsertingTables()throws Exception{
        Document document = new Document();
        PdfWriter.getInstance(document,new FileOutputStream("tableInsertedPdf.pdf"));
        document.open();
        float [] pointColumnWidths = {150F, 150F, 150F};

        Table table = new Table(pointColumnWidths);

        // Adding cells to the table
        table.addCell(new Cell().add("Name"));
        table.addCell(new Cell().add("Raju"));
        table.addCell(new Cell().add("Id"));
        table.addCell(new Cell().add("1001"));
        table.addCell(new Cell().add("Designation"));
        table.addCell(new Cell().add("Programmer"));


        document.close();
        return "pdf created ";
    }
}
