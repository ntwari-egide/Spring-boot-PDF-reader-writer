package com.springboot.pdf.controller;

import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.BackgroundImage;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPage;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AdvancedPdfWriterController {
    @GetMapping("/advancedpdf1")
    public String creatingAdvancedPdf()throws Exception{
        Document document = new Document();
        PdfWriter.getInstance(document,new FileOutputStream("advancedPdf1.pdf"));

        //setting the author name
        document.addAuthor("ntwari egide - yombi");
        document.addCreationDate();
        document.addTitle("ADVANCED JAVA SPRING BOOT PDF WRITER");

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA,18, BaseColor.BLACK);
        document.setMargins(23f,23f,23f,23f);
        Chunk header = new Chunk("Advanced PDF creator",font);
        document.add(Chunk.NEWLINE);
        header.setBackground(BaseColor.YELLOW);

        // adding background image
        String contentParagraph = "\n\nA law firm is usually a partnership between lawyers who have come together to offer their expertise to clients under one name " +
                "These partners share the profits of the firm as well as the risks (liabilities), and engage other lawyers to work with them as associates."+
                "According to The Lawyer UK 200 2019, the below organisations make up the top 50 UK law firms based on annual turnover\n\n\n";

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

        //                                       ADDING THE HEADER PARAGRAPH
        Chunk header2 = new Chunk("\n\nTable of all required calculation\n\n",new Font(FontFactory.getFont(FontFactory.HELVETICA,16,new BaseColor(252, 140, 3))));

        //                                       ADDING THE TABLE
        PdfPTable table = new PdfPTable(4);
        table.addCell("industry");
        table.addCell("segment");
        table.addCell("sales");
        table.addCell("average industry");

        // inserting data into the table

        List<String> industries  = new ArrayList();
        industries.add("Magerwa");
        industries.add("Nyirangarama interprise");
        industries.add("Ikawa Industry");
        industries.add("Ibigori Industry");
        industries.add("Inyange Industry");
        industries.add("Mukamira daily industry");
        industries.add("Icyayi industry rw");

        List<String> segments  = new ArrayList();
        segments.add("Industry");
        segments.add("Enterprise");
        segments.add("Industry");
        segments.add("Enterprise");
        segments.add("Industry");
        segments.add("Enterprise");
        segments.add("Industry");


        List<Integer> sales  = new ArrayList();
        sales.add(123000);
        sales.add(133000);
        sales.add(323000);
        sales.add(12000);
        sales.add(1123000);
        sales.add(230000);
        sales.add(2123000);

        for(int i=0;i< 7;i ++){
            table.addCell(industries.get(i));
            table.addCell(segments.get(i));
            table.addCell(String.valueOf(sales.get(i)));
            int sum = sales.get(i) * 3;
            table.addCell(String.valueOf(sum));
        }
        // styling the table
        table.setHorizontalAlignment(0);

        //                                  ADDING THE LISTS
        Paragraph paragraph2 = new Paragraph("\nSuccessful law firms require effective finance, accounting and billing, but these critical functions involve a great deal of labor-intensive routine" +
                "\n\n\nOur services we provide : ");

        com.itextpdf.text.List listsOfServices = new com.itextpdf.text.List();
        listsOfServices.add("Arbitration");
        listsOfServices.add("Mediation");
        listsOfServices.add("Documenting");
        listsOfServices.add("Business Crimes, Fraud and Compliance");
        listsOfServices.add("Capital Markets and Regulations");

        document.add(header);
        document.add(paragraph1);
        document.add(imageToInsert);
        document.add(header2);
        document.add(table);
        document.add(paragraph2);
        document.add(listsOfServices);
        document.close();

        return "Document created";
    }
}
