package top.banbianjia.cloud.common.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseDomain implements Serializable {
    private static final long serialVersionUID = -5809782578272943999L;
    private Long id;
}
