package ru.javastudy.springMVC.tools;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Александр on 14.10.2016.
 */
public class FileUploadForm {
    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }

    private List<MultipartFile> files;
}
