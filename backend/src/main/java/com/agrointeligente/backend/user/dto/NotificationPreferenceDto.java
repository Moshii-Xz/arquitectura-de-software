package com.agrointeligente.backend.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationPreferenceDto {

    private Long id;

    private Boolean emailNotifications;

    private Boolean pushNotifications;

    private Boolean smsNotifications;
}
