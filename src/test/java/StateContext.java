import lombok.Getter;
import lombok.Setter;

/**
 * @author Robin
 * @date 2021-09-04 17:55
 **/
@Getter
@Setter
public class StateContext {
    private State state;
    private Data data;
    public void StateContext(State state, Data data) {
        this.state = state;
        this.data = data;
    }
    public void request() {
        state.handle(this);
    }
}