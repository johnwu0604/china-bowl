package category;

/**
 * Created by JohnWu on 2016-12-20.
 */
public class Noodle {

    private SoftNoodle softNoodle;
    private MixedNoodle mixedNoodle;
    private CrispyNoodle crispyNoodle;
    private RiceNoodle riceNoodle;

    public Noodle() {

    }

    public SoftNoodle getSoftNoodle() {
        return softNoodle;
    }

    public void setSoftNoodle(SoftNoodle softNoodle) {
        this.softNoodle = softNoodle;
    }

    public MixedNoodle getMixedNoodle() {
        return mixedNoodle;
    }

    public void setMixedNoodle(MixedNoodle mixedNoodle) {
        this.mixedNoodle = mixedNoodle;
    }

    public CrispyNoodle getCrispyNoodle() {
        return crispyNoodle;
    }

    public void setCrispyNoodle(CrispyNoodle crispyNoodle) {
        this.crispyNoodle = crispyNoodle;
    }

    public RiceNoodle getRiceNoodle() {
        return riceNoodle;
    }

    public void setRiceNoodle(RiceNoodle riceNoodle) {
        this.riceNoodle = riceNoodle;
    }
}
