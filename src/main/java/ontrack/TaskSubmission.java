package ontrack;

import java.util.Arrays;
import java.util.List;

public class TaskSubmission {
    private static final long MAX_FILE_SIZE_BYTES = 10 * 1024 * 1024;
    private static final List<String> ALLOWED_EXTENSIONS =
        Arrays.asList("pdf", "docx", "zip", "png", "jpg");

    private String studentId;
    private String taskId;
    private String fileName;
    private long fileSizeBytes;
    private String status;

    public TaskSubmission(String studentId, String taskId,
                          String fileName, long fileSizeBytes) {
        this.studentId = studentId;
        this.taskId = taskId;
        this.fileName = fileName;
        this.fileSizeBytes = fileSizeBytes;
        this.status = "PENDING";
    }

    public boolean submit() {
        if (!isValid()) { this.status = "FAILED"; return false; }
        this.status = "SUBMITTED";
        return true;
    }

    public boolean isValid() {
        return isStudentIdValid() && isTaskIdValid()
            && isFileNameValid() && isFileSizeValid();
    }

    public boolean isStudentIdValid() {
        return studentId != null && !studentId.trim().isEmpty();
    }

    public boolean isTaskIdValid() {
        return taskId != null && !taskId.trim().isEmpty();
    }

    public boolean isFileNameValid() {
        if (fileName == null || fileName.trim().isEmpty()) return false;
        return ALLOWED_EXTENSIONS.contains(
            getFileExtension(fileName).toLowerCase());
    }

    public boolean isFileSizeValid() {
        return fileSizeBytes > 0 && fileSizeBytes <= MAX_FILE_SIZE_BYTES;
    }

    public String getFileExtension(String name) {
        int dot = name.lastIndexOf('.');
        if (dot < 0 || dot == name.length() - 1) return "";
        return name.substring(dot + 1);
    }

    public String getStatus() { return status; }
}
