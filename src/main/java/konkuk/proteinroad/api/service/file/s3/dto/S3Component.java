package konkuk.proteinroad.api.service.file.s3.dto;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class S3Component {

    @Value("{cloud.aws.s3.bucket}")
    private String bucket;

    @Value("{cloud.aws.s3.base-file-name}")
    private String baseFileName;
}
