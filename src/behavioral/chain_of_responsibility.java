// Handler Interface
interface LeaveRequestHandler {
    void handleRequest(LeaveRequest request);
}

// Concrete Handlers
class HRHandler implements LeaveRequestHandler {
    private LeaveRequestHandler nextHandler;

    public HRHandler(LeaveRequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getDays() <= 5) {
            System.out.println("HRHandler: Leave request approved for " + request.getDays() + " days.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

class ManagerHandler implements LeaveRequestHandler {
    private LeaveRequestHandler nextHandler;

    public ManagerHandler(LeaveRequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getDays() > 5 && request.getDays() <= 10) {
            System.out.println("ManagerHandler: Leave request approved for " + request.getDays() + " days.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

class DirectorHandler implements LeaveRequestHandler {
    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getDays() > 10) {
            System.out.println("DirectorHandler: Leave request approved for " + request.getDays() + " days.");
        } else {
            System.out.println("DirectorHandler: Leave request rejected.");
        }
    }
}

// Leave Request Class
class LeaveRequest {
    private int days;

    public LeaveRequest(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }
}

// Client Code
public class Client {
    public static void main(String[] args) {
        LeaveRequestHandler director = new DirectorHandler();
        LeaveRequestHandler manager = new ManagerHandler(director);
        LeaveRequestHandler hr = new HRHandler(manager);

        // Leave Requests
        LeaveRequest request1 = new LeaveRequest(3);
        LeaveRequest request2 = new LeaveRequest(7);
        LeaveRequest request3 = new LeaveRequest(12);

        // Handling Leave Requests
        hr.handleRequest(request1);
        hr.handleRequest(request2);
        hr.handleRequest(request3);
    }
}