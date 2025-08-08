package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PageView<T> {
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalSize;
    private Integer totalPage;
    private List<T> data;
}
