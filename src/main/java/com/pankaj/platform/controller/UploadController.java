package com.pankaj.platform.controller;

import com.mongodb.gridfs.GridFSDBFile;
import static com.pankaj.platform.dto.APIOptions.APIOptionsBuilder;

import com.pankaj.platform.dto.APIOptions;
import com.pankaj.platform.exception.BloggingBusinessException;
import com.pankaj.platform.service.DocumentStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by pankajpardasani on 13/09/2016.
 */

@Controller
public class UploadController {
    @Autowired
    private DocumentStorageService documentStorageService;

    @RequestMapping(value = "/file/upload", method = RequestMethod.GET)
    public String getCVForm() {
        return "fileUpload";
    }

    @RequestMapping(value = "/file/upload", method= RequestMethod.POST)
    public String processUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {
        APIOptions options = new APIOptionsBuilder().withDocument(file.getInputStream())
                .withDocumentName(file.getOriginalFilename())
                .withDocumentType(file.getContentType()).build();

        String fileID = documentStorageService.storeDocument(options);

        redirectAttributes.addFlashAttribute("message", String.format("File %s is successfully uploaded with id %s",
                 options.getDocumentName(), fileID));

        return "redirect:/file/upload";
    }

    @RequestMapping(value = "/cv")
    public void getMyCV(HttpServletResponse response) throws IOException {
        APIOptions options = new APIOptionsBuilder()
                .withDocumentName("Pankaj_Pardasani_Resume.pdf")
                .build();


        Optional<GridFSDBFile> resumePPOptional = documentStorageService.findContentByFileName(options);
        GridFSDBFile resumePP = resumePPOptional.orElseThrow(() -> new BloggingBusinessException("CV not found"));

        response.setContentType(resumePP.getContentType());
        response.setContentLength((int) resumePP.getLength());
        response.setHeader("Content-Disposition","attachment; filename=\"" + resumePP.getFilename() +"\"");

        FileCopyUtils.copy(resumePP.getInputStream(), response.getOutputStream());
    }

    @ExceptionHandler(BloggingBusinessException.class)
    public ResponseEntity handleStorageFileNotFound(BloggingBusinessException exc) {
        return ResponseEntity.notFound().build();
    }
}
