package org.chat.api.model;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {
private LocalDateTime timestamp=LocalDateTime.now();
private HttpStatus error;
private String message;
}
