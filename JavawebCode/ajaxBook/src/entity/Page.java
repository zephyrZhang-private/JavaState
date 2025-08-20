package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {
    //页码
    private Integer pageNo;
    //页面容量
    private Integer pageSize;
    //总页数
    private Integer totalPage;
    //总记录数
    private Integer totalCount;
    //当前页面数据
    private List<T> items;

    public void setPageNo(Integer pageNo) {
        if (pageNo < 1) {
            pageNo = 1;
        }
        if (pageNo > totalPage) {
            pageNo = totalPage;
        }
        this.pageNo = pageNo;
    }
}
