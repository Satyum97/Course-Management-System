package Model;

public class Course {
	private String course_id;
	private String course_name;
	private String term;
	private String status;
	private String mode;
	private int level;
	private int credit;
	private int cost;
	private String desc;
	
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	public Course(String term, String status, String mode, int level, String course_name, int credit, int cost,String course_id, String desc) {
		this.term = term;
		this.status = status;
		this.mode = mode;
		this.level = level;
		this.course_name = course_name;
		this.credit = credit;
		this.cost = cost; 	
		this.course_id = course_id;
		this.desc = desc;
	}
	
	public Course() {
		
	}
	
	
}
