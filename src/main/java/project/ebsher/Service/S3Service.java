package project.ebsher.Service;

import com.amazonaws.services.s3.model.*;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface S3Service {

    String uploadFile(InputStream inputStream, String fileName, Long projectId) throws IOException;

    void deleteFile(String key);

    List<String> getKeysByProjectId(Long projectId);

    List<byte[]> getImagesByProjectId(@PathVariable Long projectId);

}
