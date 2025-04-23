package com.birds.Birds.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileDto {

    private String profileId;
    private String email;
    private String name;
    private String password;
    private Timestamp createdAt;
    private Timestamp updatedAt;

}

