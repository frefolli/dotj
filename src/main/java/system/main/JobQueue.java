package system.main;

import java.util.ArrayList;
import java.util.List;

public class JobQueue {
	private List<Job> jobs = null;
	
	public JobQueue() {
		this.jobs = new ArrayList<Job>();
	}
	
	public void addJob(Job job) {
		this.jobs.add(job);
	}
	
	public void run() {
		this.jobs.forEach(job -> job.run());
	}
}
