package com.example.demo.Service;

import com.example.demo.Entity.Document;

public interface DocumentService {

    public Document findByDocumentId(int id);

    public Document saveDocument(Document document);
}
