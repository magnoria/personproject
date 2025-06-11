package board.controller;

import board.model.dto.BoardDto;
import board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/history")
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    //1. 등록
    @PostMapping("/regist")
    public ResponseEntity<Boolean> regist(@RequestBody BoardDto boardDto){
        log.info("보드 dto 정보 : {}" , boardDto );
        log.info("boardController.regist 진입");

        boolean result = boardService.regist(boardDto);
        if (result){
            return ResponseEntity.status(201).body(true);
        } else {
            return ResponseEntity.status(401).body(false);
        }
    }

    //2. 조회
    @GetMapping("/read")
    public ResponseEntity<List<BoardDto>> read(){
        log.info("boardController.read 진입");
        List<BoardDto> result = boardService.read();
        if (result != null){
            return ResponseEntity.status(201).body(result);
        } else {
            return ResponseEntity.status(401).body(null);
        }
    }

    //3. 개별조회
    @GetMapping("/choicer")
    public ResponseEntity<BoardDto> choicer(@RequestParam int bno){
        log.info("보드 dto 정보 : {}" , bno );
        log.info("boardController.choicer 진입");

        BoardDto result = boardService.choicer(bno);

        if (result != null){
            return ResponseEntity.status(201).body(result);
        } else {
            return ResponseEntity.status(401).body(null);
        }
    }

    //4 수정
    @PutMapping("/update")
    public ResponseEntity<Boolean> update(@RequestBody BoardDto boardDto){
        log.info("보드 dto 정보 : {}" , boardDto );
        log.info("boardController.update 진입");

        boolean result = boardService.update(boardDto);

        if (result){
            return ResponseEntity.status(201).body(true);
        } else {
            return ResponseEntity.status(401).body(false);
        }
    }

    //5 삭제 // 나중에 비밀번호 입력시 dto 및 entity 추가
    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> delete(@RequestBody BoardDto boardDto){
        log.info("보드 dto 정보 : {}" , boardDto );
        log.info("boardController.delete 진입");

        boolean result = boardService.delete(boardDto);

        if (result){
            return ResponseEntity.status(201).body(true);
        } else {
            return ResponseEntity.status(401).body(false);
        }
    }

    //6 개별삭제 필요시 추가


}
