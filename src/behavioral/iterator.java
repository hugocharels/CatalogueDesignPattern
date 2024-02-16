// Iterator Interface
interface Iterator<T> {
    boolean hasNext();
    T next();
}

// Concrete Iterator
class TaskListIterator implements Iterator<String> {
    private TaskList taskList;
    private int currentIndex = 0;

    public TaskListIterator(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < taskList.size();
    }

    @Override
    public String next() {
        if (hasNext()) {
            String task = taskList.get(currentIndex);
            currentIndex++;
            return task;
        }
        return null;
    }
}

// Aggregate Interface
interface TaskList {
    Iterator<String> createIterator();
}

// Concrete Aggregate
class TodoList implements TaskList {
    private List<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        tasks.add(task);
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public String get(int index) {
        return tasks.get(index);
    }

    public int size() {
        return tasks.size();
    }

    @Override
    public Iterator<String> createIterator() {
        return new TaskListIterator(this);
    }
}

// Client Code
public class Client {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        todoList.addTask("Task 1");
        todoList.addTask("Task 2");
        todoList.addTask("Task 3");

        Iterator<String> iterator = todoList.createIterator();
        while (iterator.hasNext()) {
            String task = iterator.next();
            System.out.println("Task: " + task);
        }
    }
}