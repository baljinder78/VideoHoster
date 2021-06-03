package com.Fileuploading.Fileuploading.Repository;

import com.Fileuploading.Fileuploading.Modle.Videopost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FileRepository extends JpaRepository<Videopost,Long> {




}
