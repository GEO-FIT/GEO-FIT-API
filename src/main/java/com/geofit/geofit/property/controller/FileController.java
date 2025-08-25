package com.geofit.geofit.property.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geofit.geofit.property.dto.response.DownloadPresignResponse;
import com.geofit.geofit.property.dto.response.UploadPresignResponse;
import com.geofit.geofit.property.service.S3PresignService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class FileController {

    private final S3PresignService s3PresignService;

    @GetMapping("/presign-upload")
    public ResponseEntity<UploadPresignResponse> presignUpload(
        @RequestParam String filename,
        @RequestParam String contentType
    ) {
        UploadPresignResponse response = s3PresignService.createUploadUrl(filename, contentType);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/presign-download")
    public ResponseEntity<DownloadPresignResponse> presignDownload(@RequestParam String key) {
        DownloadPresignResponse response = s3PresignService.createDownloadUrl(key);
        return ResponseEntity.ok(response);
    }
}
