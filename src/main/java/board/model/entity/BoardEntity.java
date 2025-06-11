package board.model.entity;

import board.model.dto.BoardDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

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
    @Column@ColumnDefault("0") //(0: 정상, 1: 삭제됨 등)
    private int state;

    //나중에 테이블 연결

    public BoardDto todto(){
        return BoardDto.builder()
                .bno(bno)
                .bname(bname)
                .bphone(bphone)
                .bnickname(bnickname)
                .createAt(this.getCreateAt())
                .updateAt(this.getUpdateAt())
                .state(state)
                .build();
    }

}
