package cn.springmvc.service;

import cn.springmvc.model.Job;

import java.util.List;


public interface JobService {

	public List<Job> getAllJob();

	public Job getJobByJobno(String jobno);

	public Job getJobByJname(String jname);

	public void insertJob(Job job);

	public void deleteJobByJname(String jname);

	public void deleteJobByJobno(String jobno);

	public void updateJob(Job job);

	public void updateJobByJname(Job job);


}
