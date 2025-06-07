package board.model.entity;

import board.model.dto.BoardDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "board")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter@Builder
public class BoardEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bno;
    @Column(nullable = false)
    private String bname;
    @Column(nullable = false , unique = true)
    private String bprivateNum;
    @Column(nullable = false , unique = true)
    private String bphone;
    @Column
    private String bnickname;

    //나중에 테이블 연결

    public BoardDto dto(){
        return BoardDto.builder()
                .bno(bno)
                .bname(bname)
                .bphone(bphone)
                .bnickname(bnickname)
                .createAt(this.getCreateAt())
                .updateAt(this.getUpdateAt())
                .build();
    }

}
