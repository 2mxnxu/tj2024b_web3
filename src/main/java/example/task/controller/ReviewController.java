package example.task.controller;

import example.task.model.dto.ReviewDto;
import example.task.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    // 리뷰 작성
    @PostMapping
    public ReviewDto reviewSave(@RequestBody ReviewDto reviewDto) {
        return reviewService.reviewSave(reviewDto);
    }

    // 리뷰 삭제
    @DeleteMapping
    public boolean reviewDelete(@RequestParam int rid) {
        return reviewService.reviewDelete(rid);
    }

    // 특정 책의 리뷰 전체 조회
    @GetMapping
    public List<ReviewDto> reviewListByBook(@RequestParam int bid) {
        return reviewService.reviewListByBook(bid);
    }
}
