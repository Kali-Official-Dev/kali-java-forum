package pub.developers.forum.infrastructure.file;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pub.developers.forum.domain.service.FileService;

import java.io.*;

import java.io.IOException;


@Slf4j
@Data
@Component
public class LocalFileServiceImpl implements FileService {

    private static final String UPLOAD_DIR = "uploads/";

    @Override
    public String uploadImg(byte[] base64, String fileName) {
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        File file = new File(uploadDir, fileName);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(base64);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return UPLOAD_DIR + fileName;
    }
}
