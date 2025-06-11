package board.service;

import board.model.repository.BoardRepository;
import board.model.dto.BoardDto;
import board.model.entity.BoardEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    //1. 등록

    public boolean regist(BoardDto boardDto){
        BoardEntity boardEntity = boardDto.toEntity();

        //영속화
        BoardEntity saveEntity = boardRepository.save(boardEntity);
        return true;
    }

    //2. 조회
    public List<BoardDto> read(){
        return boardRepository.findAll().stream().map(BoardEntity::todto).collect(Collectors.toList());

    }

    //3. 개별조회
    public BoardDto choicer(int bno){
        BoardEntity boardEntity = boardRepository.findByBno(bno);
        if (boardEntity == null){
            return null;
        }
        return boardEntity.todto();
    }

    //4 수정
    @Transactional
    //이 어노테이션이 가장 중요합니다. updateBoard 메서드가 실행되는 동안 JPA 영속성 컨텍스트가
    // 활성화되고, 메서드가 성공적으로 종료(커밋)되면 영속성 컨텍스트 내의 변경된 엔티티
    // (더티 상태의 엔티티)들을 자동으로 감지하여 데이터베이스에 반영합니다. (이것이 더티 체킹입니다.)
    // 즉 모든 작업이 성공하도록 하기위해서 transaction을사용 하나라도 안될시 모든작업이 롤백됨
    public boolean update(BoardDto boardDto){
        Optional<BoardEntity> boardEntityOptional = boardRepository.findById(boardDto.getBno());
        if (boardEntityOptional.isEmpty()) return false;

        BoardEntity boardEntity = boardEntityOptional.get();

        boardEntity.setBname(boardDto.getBname());
        boardEntity.setBnickname(boardDto.getBnickname());
        boardEntity.setBphone(boardDto.getBphone());
        boardEntity.setBprivateNum(boardDto.getBnickname());

        return true;
    }

    //5 삭제 // 나중에 비밀번호 입력시 dto 및 entity 추가
    @Transactional
    public boolean delete(BoardDto boardDto){
        //영속화
        Optional<BoardEntity> boardEntityOptional = boardRepository.findById(boardDto.getBno());
        if (boardEntityOptional.isEmpty()){
            return false;
        }
        BoardEntity boardEntity = boardEntityOptional.get();
        if (!boardEntity.getBname().equals(boardDto.getBname())){
            return false;
        }
        //Entity는 영속된 상태
        boardEntity.setState(1);

        return true;
    }
}
