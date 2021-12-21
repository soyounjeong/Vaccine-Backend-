package com.project.third_project.service;

import com.project.third_project.entity.users.Users;
import com.project.third_project.entity.users.UsersRepository;
import com.project.third_project.dto.UsersRequest;
import com.project.third_project.dto.UsersResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    public UsersResponse findById(Long id){
        Users users = usersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저 없음"));
        return new UsersResponse(users);
    }

    @Transactional
    public Long save(UsersRequest usersRequest){
        return usersRepository.save(usersRequest.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, UsersRequest usersRequest){
        Users users = usersRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("계정 없음"));
        users.update(usersRequest.getEmail(), usersRequest.getName(), usersRequest.getPw(), usersRequest.getGender(), usersRequest.getAge(), usersRequest.getAddress(), usersRequest.getAddressDetail(), usersRequest.getHp(), usersRequest.getFirst(), usersRequest.getSecond());
        return id;
    }

    @Transactional
    public void delete(Long id){
        Users users = usersRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 유저 x"));
        usersRepository.delete(users);
    }


}
