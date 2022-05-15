package com.example.demo.Controller;

import com.example.demo.Entity.Admin;
import com.example.demo.Entity.Document;
import com.example.demo.Service.AdminService;
import com.example.demo.Service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/Document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @RequestMapping(value = "/saveDocument", method = RequestMethod.POST)
    @ResponseBody
    public Document saveDocument(@RequestBody Document document) {
        Document documentResponse = documentService.saveDocument(document);
        return documentResponse;
    }
}
