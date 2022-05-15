package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.Document;
import com.example.demo.Repository.DocumentRepository;
import com.example.demo.Service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("documentServiceImpl")
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public Document saveDocument(Document document) {
        document = documentRepository.save(document);
        return document;
    }
}
