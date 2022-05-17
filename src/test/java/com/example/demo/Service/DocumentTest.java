package com.example.demo.Service;

import com.example.demo.Entity.Document;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DocumentTest {

    @Autowired
    private DocumentService documentService;

    private Document document;

    @BeforeEach
    public void setUp() {
        Document document1 = new Document();
        document1.setUrl("document1.com");
        document = documentService.saveDocument(document1);
    }

    @Test
    public void saveDocumentTest() {
        Document document2 = new Document();
        document2.setUrl("document2.com");
        Document saveDoc = documentService.saveDocument(document2);
        Assertions.assertEquals(saveDoc.getUrl(), document2.getUrl());
    }

    @Test
    public void findByDocumentIdTest() {
        Document getDoc = documentService.findByDocumentId(document.getDocumentId());
        Assertions.assertEquals(document.getDocumentId(), getDoc.getDocumentId());
    }
}
