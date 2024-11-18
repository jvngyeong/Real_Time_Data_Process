package springBootMVCShopping.domain;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("inquireDTO")
@Data
public class InquireDTO {
    public Integer inquireNum;
    public String memberNum;
    public String goodsNum;
    public String inquireSubject;
    public String inquireContents;
    public String inquireKind;
    public Date inquireDate;
    public String inquireAnswer;
    public Date inquireAnswerDate;
    public String empNum;
    
    public String memberId;
    public String goodsName;
}
