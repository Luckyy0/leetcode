package leetcode.P262_TripsAndUsers;

public class Solution {

    /**
     * Problem 262: Trips and Users
     * Type: SQL
     * 
     * Solution (SQL Query):
     */
    public String getSolutionSQL() {
        return """
                SELECT
                    request_at AS Day,
                    ROUND(SUM(CASE WHEN status != 'completed' THEN 1 ELSE 0 END) / COUNT(*), 2) AS 'Cancellation Rate'
                FROM
                    Trips
                WHERE
                    request_at BETWEEN '2013-10-01' AND '2013-10-03'
                    AND client_id NOT IN (SELECT users_id FROM Users WHERE banned = 'Yes')
                    AND driver_id NOT IN (SELECT users_id FROM Users WHERE banned = 'Yes')
                GROUP BY
                    request_at;
                """;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("This is a SQL problem. The solution query is:");
        System.out.println(solution.getSolutionSQL());
    }
}
