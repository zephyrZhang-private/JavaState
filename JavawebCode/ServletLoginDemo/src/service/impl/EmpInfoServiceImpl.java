package service.impl;

import dao.EmpInfoDao;
import dao.impl.EmpInfoDaoImpl;
import entity.EmpInfo;
import entity.PageView;
import service.EmpInfoService;

import java.util.List;

public class EmpInfoServiceImpl implements EmpInfoService {
    private EmpInfoDao empInfoDao = new EmpInfoDaoImpl();
    public List<EmpInfo> getEmpInfo() {
        return empInfoDao.selectEmpInfo();
    }

    @Override
    public int deleteEmpById(int empNo) {
        return empInfoDao.deleteEmpById(empNo);
    }

    @Override
    public EmpInfo findOneById(int empNo) {
        return empInfoDao.findOneEmpById(empNo);
    }

    @Override
    public int updateEmp(EmpInfo empInfo) {
        return empInfoDao.updateEmp(empInfo);
    }

    @Override
    public int addEmp(EmpInfo empInfo) {
        return empInfoDao.addEmp(empInfo);
    }

    @Override
    public PageView selectByPage(String pageNum, String pageSize) {
        //默认值操作,如果没有传递pageNum和pageSize,那么默认现实第一页前五条
        int pNum=1;
        if (pageNum != null){
            pNum=Integer.parseInt(pageNum);
        }
        int pSize=5;
        if (pageSize != null){
            pSize=Integer.parseInt(pageSize);
        }

        //调用dao层分页查询数据
        List<EmpInfo> empInfoList=empInfoDao.selectByPage(pNum,pSize);

        //将数据封装到PageView模型中
        PageView pageView=new PageView();
        pageView.setPageNum(pNum);
        pageView.setPageSize(pSize);
        pageView.setData(empInfoList);

        //利用查询所有方法返回员工集合
        int totalSize = getEmpInfo().size();
        pageView.setTotalSize(totalSize);

        int totalPage = totalSize%pSize ==0 ? totalSize/pSize : totalSize/pSize+1;
        pageView.setTotalPage(totalPage);

        return pageView;
    }
}
