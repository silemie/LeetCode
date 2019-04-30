/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
/**
 * Time is not very good
 * Possible reason: while + for + for
 
class Solution {
    Queue<Employee> q = new LinkedList<Employee>();
    
    public int getImportance(List<Employee> employees, int id) {
        
        findEmployee(employees, id);
        
        int importance = 0;
        while(q.size() != 0) {
            Employee employee = q.poll();
            importance += employee.importance;
            
            for(Integer subordinate : employee.subordinates) {
                findEmployee(employees, subordinate);
            }
        }
        
        return importance;
    }
    
    public void findEmployee(List<Employee> employees, int id) {
        for (Employee e : employees) {
            if(e.id == id) {
                q.add(e);
            }
        }
    }
}
*/

/**
 * Faster solution by using hashtable + queue
 */
import java.util.*; 

class Solution {
    Queue<Employee> q = new LinkedList<Employee>();
    
    public int getImportance(List<Employee> employees, int id) {
        
        Map<Integer, Employee> table = new Hashtable<>();
        for(Employee e : employees) {
            table.put(e.id, e);
        }
        
        Employee keyEmployee = table.get(id);
        q.add(keyEmployee);
        
        int importance = 0;
        while(q.size() != 0) {
            Employee employee = q.poll();
            importance += employee.importance;
            
            for(Integer subordinate : employee.subordinates) {
                Employee sub = table.get(subordinate);
                q.add(sub);
            }
        }
        
        return importance;
    }
    
}