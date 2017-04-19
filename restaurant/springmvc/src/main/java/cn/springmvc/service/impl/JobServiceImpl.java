package cn.springmvc.service.impl;

import cn.springmvc.dao.JobDAO;
import cn.springmvc.model.Job;
import cn.springmvc.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobDAO jobDAO;

	public List<Job> getAllJob(){
		return jobDAO.getAllJob();
	}

	public Job getJobByJobno(String jobno){
		return jobDAO.getJobByJobno(jobno);
	}

	public Job getJobByJname(String jname){
		return jobDAO.getJobByJname(jname);
	}

	public void insertJob(Job job){
		jobDAO.insertJob(job);
	}

	public void deleteJobByJname(String jname){
		jobDAO.deleteJobByJname(jname);
	}

	public void deleteJobByJobno(String jobno){
		jobDAO.deleteJobByJobno(jobno);
	}

	public void updateJob(Job job){
		jobDAO.updateJob(job);
	}

	public void updateJobByJname(Job job){
		jobDAO.updateJobByJname(job);
	}


}
