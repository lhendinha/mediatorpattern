public class CanadianBuyer extends Buyer {

    public CanadianBuyer(Mediator mediator) {
        super(mediator, "cad");
        this.mediator.registerCanadianBuyer(this);
    }
}
