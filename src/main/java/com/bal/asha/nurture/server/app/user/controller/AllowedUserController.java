package com.bal.asha.nurture.server.app.user.controller;

import com.bal.asha.nurture.server.app.user.domain.AllowedUserDto;
import com.bal.asha.nurture.server.app.user.domain.entity.AllowedUser;
import com.bal.asha.nurture.server.app.user.service.AllowedUserService;
import com.querydsl.core.types.Predicate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@Slf4j
@Validated
@RestController("admin/allow-user")
@AllArgsConstructor
public class AllowedUserController {

    private AllowedUserService allowedUserService;

    @PostMapping("/add")
    public AllowedUser add(@RequestBody AllowedUserDto allowedUserDto) {
        return allowedUserService.save(allowedUserDto);
    }

    @PostMapping("/update")
    public AllowedUser update(@RequestBody AllowedUser allowedUser) {
        return allowedUserService.update(allowedUser);
    }

    @PostMapping("/activate")
    public AllowedUser activate(@RequestParam("userId") UUID userId) {
        return allowedUserService.activateUser(userId);
    }

    /*
    In Swagger, sample value for spec: {"status": "ACTIVE"}
    sample value for pageable :
                {
                  "page": 0,
                  "size": 10,
                  "sort": [
                    "createdDate"
                  ]
                }
     */
    @PostMapping("/disable")
    public AllowedUser disable(@RequestParam("userId") UUID userId) {
        return allowedUserService.disableUser(userId);
    }

    @GetMapping("/search")
    public Page<AllowedUser> search(@QuerydslPredicate(root = AllowedUser.class) Predicate spec, @PageableDefault(sort = {"createdDate"}, direction = Sort.Direction.DESC, size = 50) Pageable pageable) {
        return allowedUserService.search(spec, pageable);
    }

    @GetMapping("/find")
    public AllowedUser find(@RequestParam("userId") UUID userId) {
        return allowedUserService.getUser(userId);
    }

}

