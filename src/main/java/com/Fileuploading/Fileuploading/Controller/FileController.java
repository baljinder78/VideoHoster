package com.Fileuploading.Fileuploading.Controller;


import com.Fileuploading.Fileuploading.Modle.Videopost;
import com.Fileuploading.Fileuploading.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class FileController {

    @Autowired
    public FileService fileService;

    @GetMapping("/")
    public String mainpage()
    {
        return "Hello There";
    }

    @PostMapping("/upload")
    public String Uploadvideo(@RequestBody MultipartFile file) throws IOException {
        System.out.println("response aya");
        System.out.println(file);
        String name= StringUtils.cleanPath(file.getOriginalFilename());
        Videopost videopost=new Videopost();
        System.out.println("file recived:"+name);
        videopost.setName(name);
        videopost.setContent(file.getBytes());
        videopost.setSize(file.getSize());
        videopost.setUploadTime(new Date());

        if (fileService.uploadvideo(videopost))
        {
            return "DONE";
        }
        else{
            return "Sorry";
        }

    }
    @GetMapping("/getallfiles")
    public List<Videopost> allfiles()
    {
        return fileService.allpsots();
    }
}
