package com.ohgiraffers.finalproject.login.kakao.repository;

import com.ohgiraffers.finalproject.login.kakao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<UserEntity, Integer> {


    UserEntity findByUserId(String id);

    UserEntity findByAccessToken(String accessToken);
}
