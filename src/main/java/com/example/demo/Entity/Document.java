package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name="document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "documentId")
    private int documentId;

    @Column(name = "url")
    private String url;

    public Document() {
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
