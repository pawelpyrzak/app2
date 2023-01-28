package com.example.reviewapp.api.controller;

import com.example.reviewapp.api.dto.request.UserRequest;
import com.example.reviewapp.api.dto.responce.UserResponse;
import com.example.reviewapp.api.exception.AppExceptionHandler;
import com.example.reviewapp.domain.service.UserService;
import com.example.reviewapp.infrastructure.converter.DtoMapper;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final DtoMapper dtoMapper;
    @PostMapping
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation =
                            AppExceptionHandler.Error.class))),
                    @ApiResponse(responseCode = "500", content = @Content(schema = @Schema(implementation =
                            AppExceptionHandler.Error.class)))
            })
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest){

        return ResponseEntity.ok(dtoMapper.mapToUserResponse(userService.createUser(userRequest.getFirstName(),
                userRequest.getLastName(), userRequest.getEmail())));
    }
}
