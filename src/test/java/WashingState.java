/**
 * @author Robin
 * @date 2021-09-04 18:00
 **/
public class WashingState extends State{
    @Override
    public void handle(StateContext context) {
        System.out.println("I'm washing now.");
    }
}