package org.example;


// a synthetic example to show what problem we can have with standard debugger
// try to find the bug only starting from a break point in main
// and stepping into functions
public class EmployeeCredentials {

    public static void main(String[] args) {
        Request request = requestCredentials("245999");

        if(!validateRequest(request))
            System.out.println("Problem request is invalid");
    }

    static class Request {
        String employeeId;
        int employeeAge;
        String employeeName;
        String pseudo;
        String query;

        public Request(String employeeId){
            this.employeeId = employeeId;
        }
    }

    public static boolean validateRequest(Request request){
        return request.employeeId != null && request.query!=null;
    }

    public static Request requestCredentials(String employeeId) {
        Request request = new Request(employeeId);

        return one(request, two(request), three(request));
    }

    private static Request one(Request request, String two, String three) {
        request.query = "query";
        return request;
    }

    private static String three(Request request) {
        return four(request, five(request), six(request));
    }

    private static String four(Request request, String five, String six) {
        return "";
    }

    private static String six(Request request) {
        return "";
    }

    private static String five(Request request) {
        return "";
    }

    private static String two(Request request) {
        return seven(request, eight(request), nine(request));
    }

    private static String seven(Request request, String eight, String nine) {
        return "";
    }

    private static String nine(Request request) {
        request.employeeId = null; // bug is here
        return "";
    }

    private static String eight(Request request) {
        return "";
    }

}
