package com.project.third_project.Controller;

import com.project.third_project.Entity.users.Users;
import com.project.third_project.Service.UsersService;
import com.project.third_project.dto.UsersRequest;
import com.project.third_project.dto.UsersResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;

@RestController
@RequiredArgsConstructor // service 클래스에 의존성 주입
public class UserApiController {
    private final UsersService usersService;

    @GetMapping("/api/users/{id}")
    public UsersResponse findById(@PathVariable Long id){
        return usersService.findById(id);
    }

    @PostMapping("/api/users/")
    public Long save(@RequestBody UsersRequest usersRequest){
        return usersService.save(usersRequest);
    }

    @PutMapping("api/users/{id}")
    public Long update(@PathVariable Long id, @RequestBody UsersRequest usersRequest){
        return usersService.update(id, usersRequest);
    }

    @DeleteMapping("/api/users/{id}")
    public void delete(@PathVariable Long id){
        usersService.delete(id);
    }
}
