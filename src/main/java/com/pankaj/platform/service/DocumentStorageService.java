package com.pankaj.platform.service;

import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
import com.pankaj.platform.dto.APIOptions;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by pankajpardasani on 13/09/2016.
 */

@Service
public interface DocumentStorageService {
    String storeDocument(APIOptions options);
    Optional<GridFSDBFile> findContentByFileName(APIOptions options);
    Optional<GridFSFile> findContentByFileID(APIOptions options);
}
