class TaskManager {

    class Task implements Comparable<Task> {

        int userId;
        int taskId;
        int priority;

        public Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }

        @Override
        public int compareTo(Task other) {
            if (this.priority == other.priority) {
                return other.taskId - this.taskId;
            }
            return other.priority - this.priority;
        }

    }

    TreeSet<Task> tasksSorted;
    HashMap<Integer, Task> tasksMap;

    public TaskManager(List<List<Integer>> tasks) {
        this.tasksSorted = new TreeSet<>();
        this.tasksMap = new HashMap<>();

        for (int i = 0; i < tasks.size(); i++) {
            int userId = tasks.get(i).get(0);
            int taskId = tasks.get(i).get(1);
            int priority = tasks.get(i).get(2);

            add(userId, taskId, priority);
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        tasksSorted.add(task);
        tasksMap.put(taskId, task);
    }

    public void edit(int taskId, int newPriority) {
        Task task = tasksMap.get(taskId);
        if (task != null) {
            tasksSorted.remove(task);
            task.priority = newPriority;
            tasksSorted.add(task);
        }
    }

    public void rmv(int taskId) {
        Task task = tasksMap.get(taskId);
        tasksSorted.remove(task);
        tasksMap.remove(taskId);
    }

    public int execTop() {
        if (!tasksSorted.isEmpty()) {
            Task task = tasksSorted.first();
            tasksSorted.remove(task);
            tasksMap.remove(task.taskId);
            return task.userId;
        }
        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */