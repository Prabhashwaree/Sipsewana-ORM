package view.tm;

public class customTm {
    private String name;
    private String programId;
    private String program;
    private String duration;

    public customTm() {
    }

    public customTm(String name, String programId, String program, String duration) {
        this.setName(name);
        this.setProgramId(programId);
        this.setProgram(program);
        this.setDuration(duration);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "customTm{" +
                "name='" + name + '\'' +
                ", programId='" + programId + '\'' +
                ", program='" + program + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
