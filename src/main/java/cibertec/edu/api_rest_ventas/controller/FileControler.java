package cibertec.edu.api_rest_ventas.controller;

import cibertec.edu.api_rest_ventas.model.dto.MensajeArchivoDTo;
import cibertec.edu.api_rest_ventas.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/files")
public class FileControler {
    private FileService fileService;
    @PostMapping("")
    public ResponseEntity<MensajeArchivoDTo> subirArchivos(
            @RequestParam("files")List<MultipartFile> multipartFileList
            ) throws Exception{
        fileService.guardarArchivos(multipartFileList);
        return new ResponseEntity<>(MensajeArchivoDTo.builder()
                .mensaje("Archivos subidos correctamente").build(),
                HttpStatus.OK);
    }
}
