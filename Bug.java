import java.util.ArrayList;

class Bug {
    private String title;
    private String description;
    private String status;

    public Bug(String title, String description) {
        this.title = title;
        this.description = description;
        this.status = "New";
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

class BugTracker {
    private ArrayList<Bug> bugs;

    public BugTracker() {
        bugs = new ArrayList<>();
    }

    public void addBug(String title, String description) {
        Bug bug = new Bug(title, description);
        bugs.add(bug);
        System.out.println("Bug added: " + bug.getTitle());
    }

    public void updateBugStatus(String title, String status) {
        Bug bug = findBug(title);
        if (bug != null) {
            bug.setStatus(status);
            System.out.println("Bug status updated: " + bug.getTitle() + " - " + bug.getStatus());
        } else {
            System.out.println("Bug not found: " + title);
        }
    }

    public void displayBugs() {
        System.out.println("Bug List:");
        for (Bug bug : bugs) {
            System.out.println("Title: " + bug.getTitle());
            System.out.println("Description: " + bug.getDescription());
            System.out.println("Status: " + bug.getStatus());
            System.out.println("------------------------");
        }
    }

    private Bug findBug(String title) {
        for (Bug bug : bugs) {
            if (bug.getTitle().equals(title)) {
                return bug;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        BugTracker bugTracker = new BugTracker();

        bugTracker.addBug("Bug 1", "This is a bug description.");
        bugTracker.addBug("Bug 2", "This is another bug description.");

        bugTracker.displayBugs();

        bugTracker.updateBugStatus("Bug 1", "In Progress");
        bugTracker.updateBugStatus("Bug 3", "Fixed");

        bugTracker.displayBugs();
    }
}





