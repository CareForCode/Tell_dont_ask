package super_mario;

public class Mario {
    private Status status;
    private int lifeCount;

    public Mario() {
        status = Status.BIG;
        lifeCount = 3;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getLifeCount() {
        return lifeCount;
    }

    public void setLifeCount(int lifeCount) {
        this.lifeCount = lifeCount;
    }
}
