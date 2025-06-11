package board.model.dto;


import board.model.entity.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter@ToString
public class BoardDto {

    // 입력 번호
    private int bno;
    private String bname;
    private String bprivateNum;
    private String bphone;
    private String bnickname;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private int state;

    public BoardEntity toEntity(){
        return BoardEntity.builder()
                .bno(bno)
                .bname(bname)
                .bprivateNum(bprivateNum)
                .bphone(bphone)
                .bnickname(bnickname)
                .state(state)
                .build();
    }
}
