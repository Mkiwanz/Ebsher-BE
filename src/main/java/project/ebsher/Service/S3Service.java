package project.ebsher.Service;

import com.amazonaws.services.s3.model.*;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface S3Service {

    void uploadProjectImages(long projectId, MultipartFile image) throws IOException;

//    void deleteFile(String key);
//
//    List<String> getKeysByProjectId(Long projectId);
//
//    List<byte[]> getImagesByProjectId(@PathVariable Long projectId);

}
