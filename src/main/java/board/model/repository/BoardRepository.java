package board.model.repository;

import board.model.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

    // 추상메소드
    BoardEntity findByBno(int bno);
}
