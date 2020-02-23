package com.xrf.http.bc.repository;


import com.xrf.http.bc.dataobject.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadFileRepository extends JpaRepository<UploadFile, String> {

    UploadFile findByFileMd5(String fileMd5);

    void deleteByFileMd5(String fileMd5);
}
