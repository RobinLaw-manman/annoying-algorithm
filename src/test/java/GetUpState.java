/**
 * @author Robin
 * @date 2021-09-04 17:57
 **/
public class GetUpState extends State{
    @Override
    public void handle(StateContext stateContext) {
        System.out.println("I'm getting up.");
        stateContext.setState(new WashingState());
    }
}