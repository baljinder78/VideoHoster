package com.Fileuploading.Fileuploading.Service;

import com.Fileuploading.Fileuploading.Modle.Videopost;
import com.Fileuploading.Fileuploading.Repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    @Autowired
    public FileRepository fileRepository;

    public boolean uploadvideo(Videopost videopost)
    {
        try{
            fileRepository.save(videopost);
            return true;
        }
        catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    public List<Videopost> allpsots()
    {
        return fileRepository.findAll();
    }


}
