package com.springboot.pdf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PdfManagerController {

    @GetMapping("/make-pdf/itext")
    public String creatingPdfUsingIText(){
        return "File pf is being created ";
    }
}
