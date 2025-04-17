package example.task.service;

import example.task.model.dto.ReviewDto;
import example.task.model.entity.BookEntity;
import example.task.model.entity.ReviewEntity;
import example.task.model.repository.BookRepository;
import example.task.model.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;

    public ReviewDto reviewSave(ReviewDto reviewDto) {
        BookEntity bookEntity = bookRepository.findById(reviewDto.getBid()).orElse(null);
        if (bookEntity == null) return null;

        ReviewEntity reviewEntity = reviewDto.toReviewEntity(bookEntity);

        ReviewEntity saved = reviewRepository.save(reviewEntity);
        return saved.toReviewDto();
    }
    public boolean reviewDelete(int rid){
        boolean result = reviewRepository.existsById(rid);
        if (result == true) {
            reviewRepository.deleteById(rid);
            return true;
        }
        return false;
    }
    public List<ReviewDto> reviewListByBook(int bid) {
        BookEntity bookEntity = bookRepository.findById(bid).orElse(null);
        if (bookEntity == null) return Collections.emptyList();

        List<ReviewEntity> reviewEntities = reviewRepository.findAllByBookEntity_Bid(bid);

        List<ReviewDto> reviewDtos = new ArrayList<>();
        for (ReviewEntity reviewEntity : reviewEntities) {
            reviewDtos.add(reviewEntity.toReviewDto());
        }
        return reviewDtos;
    }

}
