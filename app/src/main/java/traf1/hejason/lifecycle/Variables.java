package traf1.hejason.lifecycle;

public class Variables {
    private int[] onCreate, onStart, onResume, onPause, onStop, onDestroy;

    public Variables(){

    }

    public int[] getOnCreate() {
        return onCreate;
    }

    public void setOnCreate(int[] onCreate) {
        this.onCreate = onCreate;
    }

    public int[] getOnStart() {
        return onStart;
    }

    public void setOnStart(int[] onStart) {
        this.onStart = onStart;
    }

    public int[] getOnResume() {
        return onResume;
    }

    public void setOnResume(int[] onResume) {
        this.onResume = onResume;
    }

    public int[] getOnPause() {
        return onPause;
    }

    public void setOnPause(int[] onPause) {
        this.onPause = onPause;
    }

    public int[] getOnStop() {
        return onStop;
    }

    public void setOnStop(int[] onStop) {
        this.onStop = onStop;
    }

    public int[] getOnDestroy() {
        return onDestroy;
    }

    public void setOnDestroy(int[] onDestroy) {
        this.onDestroy = onDestroy;
    }


}
