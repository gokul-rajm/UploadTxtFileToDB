package uploadCsv.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import uploadCsv.CSVHelper.HelperClass;
import uploadCsv.Entity.EntityClass;
import uploadCsv.Repository.RepositoryClass;

@Service
public class ServiceClass {
  @Autowired
  RepositoryClass repository;

  public void save(MultipartFile file) {
    try {
      List<EntityClass> entityClass = HelperClass.csvToTable(file.getInputStream());
      repository.saveAll(entityClass);
    } catch (IOException e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }
  
  public List<EntityClass> getAllDetails() {
    return repository.findAll();
  }
}