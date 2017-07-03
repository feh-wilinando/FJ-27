package br.com.caelum.fj27.loja.infra;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by nando on 02/07/17.
 */
@Component
public class FileSaver {
    public String write(String baseFolder, MultipartFile file) {

        String homeFolder = System.getProperty("user.home");

        String baseFolderPath = homeFolder + "/" + baseFolder;

        String filePath = baseFolderPath + "/" + file.getOriginalFilename();

        try {
            file.transferTo(new File(filePath));
            return filePath;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
