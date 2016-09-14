package com.pankaj.platform.service.impl;

import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
import com.pankaj.platform.dto.APIOptions;
import com.pankaj.platform.service.DocumentStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by pankajpardasani on 13/09/2016.
 */
@Service
public class DocumentStorageServiceImpl implements DocumentStorageService {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Override
    public String storeDocument(APIOptions options) {
        Optional<GridFSDBFile> existingDocumentOptional = findContentByFileName(options);

        if(existingDocumentOptional.isPresent()) {
            GridFSDBFile documentFile = existingDocumentOptional.get();
            gridFsTemplate.delete(new Query(Criteria.where("_id").is(documentFile.getId())));
        }

        return gridFsTemplate.store(options.getDocumentContent(), options.getDocumentName(), options.getDocumentName()).getId().toString();
    }

    @Override
    public Optional<GridFSDBFile> findContentByFileName(APIOptions options) {
        GridFSDBFile documentFile = gridFsTemplate.findOne(new Query(Criteria.where("filename").is(options.getDocumentName())));
        return Optional.ofNullable(documentFile);
    }

    @Override
    public Optional<GridFSFile> findContentByFileID(APIOptions options) {
        GridFSFile documentFile = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(options.getDocumentIdentifier())));
        return Optional.ofNullable(documentFile);
    }
}
