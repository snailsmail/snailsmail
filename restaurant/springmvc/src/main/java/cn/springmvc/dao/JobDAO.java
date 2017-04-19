package cn.springmvc.dao;

import cn.springmvc.model.Job;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chenye on 16-3-4.
 */
public interface JobDAO {


    /**
     * 获得所有职位
     *
     */
    public List<Job> getAllJob();

    /**
     * 通过用户jobno获得职位对象
     * @param jobno
     * @return
     */
    public Job getJobByJobno(@Param("jobno") String jobno);

    /**
     * 通过用户jname获得职位对象
     * @param jname
     * @return
     */
    public Job getJobByJname(@Param("jname") String jname);

    /**
     * 添加新职位
     * @param job
     * @return
     */
    public void insertJob(Job job);

    /**
     * 通过jname删除职位
     * @param jname
     * @return
     */
    public void deleteJobByJname(@Param("jname") String jname);


    /**
     * 通过jobno删除职位
     * @param jobno
     * @return
     */
    public void deleteJobByJobno(@Param("jobno") String jobno);


    /**
     * 更新职位
     * @param job
     * @return
     */
    public void updateJob(Job job);

    /**
     * 更新职位
     * @param job
     * @return
     */
    public void updateJobByJname(Job job);



}
