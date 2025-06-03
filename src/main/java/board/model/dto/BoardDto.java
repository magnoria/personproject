package board.model.dto;


import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class BoardDto {

    // 입력 번호
    private int bno;
    private String bname;
    private String bcheked;
    private String bphone;
    private String bnickname;


}
