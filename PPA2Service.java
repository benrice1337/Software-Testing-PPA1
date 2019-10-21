import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

public class PPA2Service {
    @GET
    @Path("/bmi")
    @Produces(MediaType.TEXT_HTML)
    public String getBmiTable() {
        //TODO: Add functionality to query db and display table as HTML
    }

    //Path should be formatted /bmi/feet-inches-pounds, where those are valid args to the PPA1 function.
    @GET
    @Path("/bmi/{args}")
    @Produces(MediaType.TEXT_PLAIN)
    public String calcBmi(@PathParam(value="args") String args) {
        String[] splitArgs = args.split("-", 3);
        int[] nums = new int[3];
        for(int i = 0; i < 3; i++) {
            nums[i] = Integer.parseInt(splitArgs[i]);
        }

        return "Your BMI is " + PPA1.bmiCalculator(nums[0], nums[1], nums[2]) + ", making you" + PPA1.bodyMassIndex(nums[0], nums[1], nums[2]);
    }

    @GET
    @Path("/shortestdistance")
    @Produces(MediaType.TEXT_HTML)
    public String getSDTable() {
        //TODO: Add functionality to query db and display table as HTML
    }

    //Path should be formatted /shortestdistance/x1-y1-x2-y2, where those are valid args to the PPA1 function.
    @GET
    @Path("/shortestdistance/{args}")
    @Produces(MediaType.TEXT_PLAIN)
    public String calcSD(@PathParam(value="args") String args) {
        String[] splitArgs = args.split("-", 4);
        int[] nums = new int[4];
        for(int i = 0; i < 4; i++) {
            nums[i] = Integer.parseInt(splitArgs[i]);
        }

        return PPA1.shortestDistance(nums[0], nums[1], nums[2], nums[3]);
    }
}