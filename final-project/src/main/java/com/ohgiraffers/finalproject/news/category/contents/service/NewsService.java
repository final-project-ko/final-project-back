package com.ohgiraffers.finalproject.news.category.contents.service;

import com.ohgiraffers.finalproject.news.category.contents.dto.KeywordNewsDTO;
import com.ohgiraffers.finalproject.news.category.contents.dto.NewsDTO;
import com.ohgiraffers.finalproject.news.category.contents.dto.SummaryNewsDTO;
import com.ohgiraffers.finalproject.news.category.contents.entity.News;
import com.ohgiraffers.finalproject.news.category.contents.repository.KeywordNewsRepository;
import com.ohgiraffers.finalproject.news.category.contents.repository.NewsRepository;
import com.ohgiraffers.finalproject.news.category.contents.repository.SummaryNewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private KeywordNewsRepository keywordNewsRepository;

    @Autowired
    private SummaryNewsRepository summaryNewsRepository;



    // 뉴스 DB정보 리스트로 작성
    public List<NewsDTO> findAllNews() {

        return newsRepository.findAll()
                .stream()
                .map(news -> {
                    NewsDTO newsDTO = new NewsDTO(); // newsDTO 생성 후 news의 내용을 newDTO에 저장
                    newsDTO.setCode(news.getCode());
                    newsDTO.setTitle(news.getTitle());
                    newsDTO.setCategory(news.getCategory());
                    newsDTO.setDescription(news.getDescription());
                    newsDTO.setUrl(news.getUrl());
                    newsDTO.setImage(news.getImage());
                    newsDTO.setAidescription(newsDTO.getAidescription()); // 03.12 ai컬럼 추가
                    newsDTO.setTransdescription(newsDTO.getTransdescription()); // 03.15 ai한글번역 컬럼 추가
                    newsDTO.setDate(news.getDate());

                    return newsDTO; // newsDTO 반환
                })
                .toList(); // newsRepository를 통해 모든 news를 찾아서 반환
    }

    // 카테고리 뉴스 DB정보 리스트로 작성
    public List<NewsDTO> categoryNews(String category, LocalDate date) {
        return newsRepository.findByCategoryAndDate(category, date)
                .stream()
                .map(news -> {
                    NewsDTO newsDTO = new NewsDTO();
                    newsDTO.setCode(news.getCode() != null ? news.getCode() : 0); // getCode()가 null이면 0으로 설정
                    newsDTO.setTitle(news.getTitle());
                    newsDTO.setCategory(news.getCategory());
                    newsDTO.setDescription(news.getAidescription());
                    newsDTO.setUrl(news.getUrl());
                    newsDTO.setImage(news.getImage());
                    newsDTO.setAidescription(newsDTO.getAidescription()); // 03.12 ai컬럼 추가
                    newsDTO.setTransdescription(newsDTO.getTransdescription()); // 03.15 ai한글번역 컬럼 추가
                    newsDTO.setDate(news.getDate());

                    return newsDTO;
                })
                .toList();
    }

    // Keyword 뉴스 DB정보 리스트로 작성
    public List<KeywordNewsDTO> findAllKeywordNews() {

        return keywordNewsRepository.findAll()
                .stream()
                .map(keywordNews -> {
                    KeywordNewsDTO keywordNewsDTO = new KeywordNewsDTO(); // keywordNewsDTO 생성 후 keywordNews의 내용을 keywordNewsDTO에 저장
                    keywordNewsDTO.setKeywordNewsCode(keywordNews.getKeywordNewsCode());
                    keywordNewsDTO.setKeyword1(keywordNews.getKeyword1());
                    keywordNewsDTO.setKeyword2(keywordNews.getKeyword2());
                    keywordNewsDTO.setKeyword3(keywordNews.getKeyword3());
                    keywordNewsDTO.setKeyword4(keywordNews.getKeyword4());
                    keywordNewsDTO.setKeyword5(keywordNews.getKeyword5());
                    keywordNewsDTO.setKeyword6(keywordNews.getKeyword6());
                    keywordNewsDTO.setKeyword7(keywordNews.getKeyword7());
                    keywordNewsDTO.setKeyword8(keywordNews.getKeyword8());
                    keywordNewsDTO.setKeyword9(keywordNews.getKeyword9());
                    keywordNewsDTO.setKeyword10(keywordNews.getKeyword10());
                    keywordNewsDTO.setKeyword11(keywordNews.getKeyword11());
                    keywordNewsDTO.setKeyword12(keywordNews.getKeyword12());
                    keywordNewsDTO.setKeyword13(keywordNews.getKeyword13());
                    keywordNewsDTO.setKeyword14(keywordNews.getKeyword14());
                    keywordNewsDTO.setKeyword15(keywordNews.getKeyword15());
                    keywordNewsDTO.setDate(keywordNews.getDate());

                    return keywordNewsDTO; // keywordNewsDTO 반환
                })
                .toList(); // keywordNewsRepository를 통해 모든 keywordNews를 찾아서 반환
    }

    public List<SummaryNewsDTO> findAllSummaryNews() {

        return summaryNewsRepository.findAll()
                .stream()
                .map(summaryNews -> {
                    SummaryNewsDTO summaryNewsDTO = new SummaryNewsDTO(); // summaryNewsDTO 생성 후 summaryNews의 내용을 summaryNewsDTO에 저장
                    summaryNewsDTO.setSummaryNewsCode(summaryNews.getSummaryNewsCode());
                    summaryNewsDTO.setSummaryNews1(summaryNews.getSummaryNews1());
                    summaryNewsDTO.setSummaryNews2(summaryNews.getSummaryNews2());
                    summaryNewsDTO.setSummaryNews3(summaryNews.getSummaryNews3());
                    summaryNewsDTO.setSummaryNews4(summaryNews.getSummaryNews4());
                    summaryNewsDTO.setSummaryNews5(summaryNews.getSummaryNews5());
                    summaryNewsDTO.setDate(summaryNews.getDate());

                    return summaryNewsDTO; // summaryNewsDTO 반환
                })
                .toList(); // summaryNewsRepository를 통해 모든 summaryNews를 찾아서 반환
    }


    public News modifyNews(HashMap<String, String> news) {
        News modifyNews = new News();
        modifyNews.setCode(Integer.parseInt(news.get("code")));
        modifyNews.setTitle(news.get("title"));
        modifyNews.setAidescription(news.get("description"));
        modifyNews.setUrl(news.get("url"));
        modifyNews.setImage(news.get("image"));
        modifyNews.setCategory(news.get("category"));

        // "date" 필드가 있는지 확인하고, 없으면 현재 날짜로 설정
        if (news.containsKey("date")) {
            try {
                modifyNews.setDate(LocalDate.parse(news.get("date")));
            } catch (DateTimeParseException e) {
                // 날짜 포맷이 잘못되었을 경우 예외 처리
                System.err.println("날짜 포맷이 잘못되었습니다. 기본값으로 현재 날짜를 설정합니다.");
                modifyNews.setDate(LocalDate.now());
            }
        } else {
            // "date" 필드가 없을 경우 현재 날짜로 설정
            modifyNews.setDate(LocalDate.now());
        }

        modifyNews.setAidescription(news.get("aidescription")); // 03.12 ai컬럼 추가
        modifyNews.setTransdescription(news.get("transdescription")); // 03.15 ai한글번역 컬럼 추가

        News modify = newsRepository.save(modifyNews);

        return modify;
    }


    public News deleteNews(HashMap<String, String> news) {

        News deleteNews = new News();
        deleteNews.setCode(Integer.parseInt(news.get("code")));
        deleteNews.setTitle(news.get("title"));

        News delete = newsRepository.save(deleteNews);

        return delete;
    }
}
