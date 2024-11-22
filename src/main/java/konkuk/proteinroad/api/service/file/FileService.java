package konkuk.proteinroad.api.service.file;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    String uploadFile(MultipartFile file);

    void deleteFile(String fileUrl);

    String getFileUrl(String fileName);
}
