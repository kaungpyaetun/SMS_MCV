package model;

public class Std {
    private int id;
    private String name;
    private String course;
	private String objective;

    public Std() {}

   //Insert & Select & Delete
    public Std(int id, String name, String course, String objective) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.objective = objective;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }			
    public void setName(String name) { this.name = name; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
    
	public String getObjective() {return objective;}
	public void setObjective(String objective) { this.objective = objective; }
	
	}
	 

