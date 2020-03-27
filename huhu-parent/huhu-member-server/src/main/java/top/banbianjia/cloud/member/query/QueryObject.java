package top.banbianjia.cloud.member.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryObject implements Serializable {
    private Integer pageSize;
    private Integer pageNum;
    private String keyword;
}
