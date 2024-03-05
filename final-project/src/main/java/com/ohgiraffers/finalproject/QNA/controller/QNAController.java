package com.ohgiraffers.finalproject.QNA.controller;


import com.ohgiraffers.finalproject.QNA.dto.QnADTO;
import com.ohgiraffers.finalproject.QNA.entity.Inquiry;
import com.ohgiraffers.finalproject.QNA.service.QnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/qna/*")
public class QNAController {

    @Autowired
    private QnaService qnaService;

    @PostMapping("/insertInquiry")
    public ResponseEntity insertInquiry(@RequestBody HashMap<String,String> insert){
        // 검증완료
         System.out.println(insert.get("userCode"));

        if (Objects.isNull(insert)){
            return ResponseEntity.status(404).body("내용이 없습니다.");
        }


        Inquiry insertInquiry = qnaService.insertInquiry(insert);

        if(Objects.isNull(insertInquiry)){
            return ResponseEntity.status(500).body("서버에서 오류 발생");
        }

        return ResponseEntity.ok(insertInquiry);

    }

    @GetMapping("/findInquiry/{userCode}")
    public List<QnADTO> selectInquiry(@PathVariable int userCode){

        List<QnADTO> userInquiry = qnaService.findUserInquiry(userCode);

        if(Objects.isNull(userInquiry)){
            return null;
        }

        return userInquiry;
    }
}
