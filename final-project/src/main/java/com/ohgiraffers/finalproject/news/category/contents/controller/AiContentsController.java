package com.ohgiraffers.finalproject.news.category.contents.controller;


import com.ohgiraffers.finalproject.news.category.contents.dto.KeywordNewsDTO;
import com.ohgiraffers.finalproject.news.category.contents.dto.SummaryNewsDTO;
import com.ohgiraffers.finalproject.news.category.contents.service.NewsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

// DB에서 조회하는 ai 뉴스
@Tag(name = "AI뉴스 정보", description = "DB에 담긴 AI뉴스 데이터(요약뉴스, 키워드뉴스) api 입니다.")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/AINews")
public class AiContentsController {

    @Autowired
    private NewsService newsService;


    @Operation(summary = "뉴스 키워드 조회 메소드", description = "뉴스 키워드 데이터를 조회하는 메소드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "뉴스 키워드 불러 오기 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @GetMapping("/keywordNews/{num}")
    public KeywordNewsDTO selectKeywordNews(@PathVariable int num) {

        KeywordNewsDTO result = newsService.findKeywordNews(num);
        if (Objects.isNull(result)) {

            return null;
        }

        return result;

    }

    @Operation(summary = "요약 뉴스 조회 메소드", description = "요약 뉴스 데이터를 조회하는 메소드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요약 뉴스 불러 오기 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @GetMapping("/summaryNews/{num}")
    public SummaryNewsDTO findAllSummaryNews(@PathVariable int num) {

        SummaryNewsDTO result = newsService.findSummaryNews(num);
        if (Objects.isNull(result)) {

            return null;
        }
        return result;
    }
}