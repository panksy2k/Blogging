package com.pankaj.platform.service.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import com.pankaj.platform.constant.BloggingBusinessConstant;
import com.pankaj.platform.dto.APIOptions;
import com.pankaj.platform.service.DocumentStorageService;
import com.pankaj.platform.util.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
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
        Optional<GridFSDBFile> existingDocumentOptional = findContentByMetaInfo(BloggingBusinessConstant.DOCUMENTMETAINFO.get());

        if(existingDocumentOptional.isPresent()) {
            GridFSDBFile documentFile = existingDocumentOptional.get();
            gridFsTemplate.delete(new Query(Criteria.where("_id").is(documentFile.getId())));
        }

        DBObject metaData = new BasicDBObject();
        metaData.put(BloggingBusinessConstant.DOCUMENTMETAINFO.get().getKey(), BloggingBusinessConstant.DOCUMENTMETAINFO.get().getValue());

        return gridFsTemplate.store(options.getDocumentContent(), options.getDocumentName(), options.getDocumentType(), metaData)
                .getId().toString();
    }

    @Override
    public Optional<GridFSDBFile> findContentByMetaInfo(Map.Entry<String, String> options) {
        ObjectUtil.checkNotNull(options, "No meta info present before using for document retrival");

        GridFSDBFile documentFile = gridFsTemplate.findOne(new Query(Criteria.where("metadata."+options.getKey()).is(options.getValue())));
        return Optional.ofNullable(documentFile);
    }
}
