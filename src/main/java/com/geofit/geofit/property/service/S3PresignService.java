package com.geofit.geofit.property.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest;

import java.net.URL;
import java.time.Duration;
import java.util.UUID;

import com.geofit.geofit.property.dto.response.DownloadPresignResponse;
import com.geofit.geofit.property.dto.response.UploadPresignResponse;

@Service
@RequiredArgsConstructor
public class S3PresignService {

    private final S3Presigner presigner;

    @Value("${aws.s3.bucket}")
    private String bucket;

    public UploadPresignResponse createUploadUrl(String filename, String contentType) {
        String safeName = filename.replaceAll("[^A-Za-z0-9._-]", "_");
        String key = "uploads/" + UUID.randomUUID() + "-" + safeName;

        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
            .bucket(bucket)
            .key(key)
            .contentType(contentType)
            .build();

        PutObjectPresignRequest presignRequest = PutObjectPresignRequest.builder()
            .signatureDuration(Duration.ofMinutes(15))
            .putObjectRequest(putObjectRequest)
            .build();

        URL url = presigner.presignPutObject(presignRequest).url();
        return new UploadPresignResponse(url.toString(), key);
    }

    public DownloadPresignResponse createDownloadUrl(String key) {
        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
            .bucket(bucket)
            .key(key)
            .build();

        GetObjectPresignRequest presignRequest = GetObjectPresignRequest.builder()
            .signatureDuration(Duration.ofMinutes(15))
            .getObjectRequest(getObjectRequest)
            .build();

        URL url = presigner.presignGetObject(presignRequest).url();
        return new DownloadPresignResponse(url.toString());
    }
}
