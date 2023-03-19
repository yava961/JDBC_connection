package queryConstant;

public final class Queries {
    public static final String NUMBER_OF_SEATS = "SELECT SUM(seats) FROM planes WHERE model IN ('Boeing 747', 'Airbus A320')";
    public static final String ADD_NEW_PILOT = "INSERT INTO pilots (name, age, planes)" +
            "VALUES (?, ?, ?);";
    public static final String ALL_PILOTS = "SELECT * FROM pilots";
    public static final String UPDATE_PILOT = "UPDATE pilots SET name=?, age=?, planes=? WHERE id=?";
    public static final String DELETE_PILOT = "DELETE FROM pilots WHERE id=?";
    public static final String PILOT_BY_ID = "SELECT * FROM pilots WHERE id = ?";


}
