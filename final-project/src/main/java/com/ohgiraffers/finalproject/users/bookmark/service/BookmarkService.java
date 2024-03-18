package com.ohgiraffers.finalproject.users.bookmark.service;


import com.ohgiraffers.finalproject.news.category.contents.dto.NewsDTO;
import com.ohgiraffers.finalproject.users.bookmark.dto.BookmarkDTO;
import com.ohgiraffers.finalproject.users.bookmark.entity.Bookmark;
import com.ohgiraffers.finalproject.users.bookmark.repository.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookmarkService {

    @Autowired
    private BookmarkRepository bookmarkRepository;


    public Bookmark registBookmark(BookmarkDTO bookmarkDTO) {
        System.out.println("북마크="+bookmarkDTO.getUserId());

        List<Bookmark> existingBookmark = bookmarkRepository.findByNewsCode(bookmarkDTO.getNewsCode());

        if(bookmarkDTO.getUserId() == null || bookmarkDTO.getUserId().isEmpty()){
            throw new IllegalArgumentException("사용자 ID 필요함");
        }

//         만약 동일한 newsCode가 이미 등록되어 있다면 중복 등록을 막는다.
        if (!existingBookmark.isEmpty()) {
            throw new RuntimeException("이미 등록된 북마크입니다.");
        }



        Bookmark registBookmark = new Bookmark();
        registBookmark.setBookmarkCode(bookmarkDTO.getBookmarkCode());
        registBookmark.setUserId(bookmarkDTO.getUserId());
        registBookmark.setNewsCode(bookmarkDTO.getNewsCode());
        registBookmark.setTitle(bookmarkDTO.getTitle());
        registBookmark.setDescription(bookmarkDTO.getDescription());
        registBookmark.setImage(bookmarkDTO.getImage());
        registBookmark.setUrl(bookmarkDTO.getUrl());


        Bookmark resultResgistBookmark = bookmarkRepository.save(registBookmark);

        return resultResgistBookmark;
    }

    public List<BookmarkDTO> findByBookmark(String userId) {

        return bookmarkRepository.findByUserId(userId)
                .stream()
                .map(bookmark -> {
                    BookmarkDTO bookmarkDTO = new BookmarkDTO(); // newsDTO 생성 후 news의 내용을 newDTO에 저장
                    bookmarkDTO.setNewsCode(bookmark.getNewsCode());
                    bookmarkDTO.setUserId(bookmark.getUserId());
                    bookmarkDTO.setBookmarkCode(bookmark.getBookmarkCode());
                    bookmarkDTO.setTitle(bookmark.getTitle());
                    bookmarkDTO.setDescription(bookmark.getDescription());
                    bookmarkDTO.setImage(bookmark.getImage());
                    bookmarkDTO.setUrl(bookmark.getUrl());


                    return bookmarkDTO; // newsDTO 반환
                })
                .toList(); // bookmarkRepository를 통해 모든 book 찾아서 반환
    }

    public void deleteBookmark(String userId, Integer bookmarkCode) {

        Bookmark bookmark = bookmarkRepository.findByUserIdAndBookmarkCode(userId, bookmarkCode);

        if (bookmark != null) {
            bookmarkRepository.delete(bookmark);
        } else {
            throw new NoSuchElementException("사용자의 북마크를 찾을 수 없음: " + userId + ", " + bookmarkCode);
        }
    }

}