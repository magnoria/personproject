package board.model.dto;


import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class BoardDto {

    // 입력 번호
    private int bno;
    private String bname;
    private String bprivateNum;
    private String bphone;
    private String bnickname;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

}
