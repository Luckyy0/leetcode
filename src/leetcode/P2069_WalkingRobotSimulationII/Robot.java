package leetcode.P2069_WalkingRobotSimulationII;

public class Robot {
    int w, h;
    int p;
    int pos;
    boolean moved;

    public Robot(int width, int height) {
        this.w = width;
        this.h = height;
        this.p = 2 * (w + h) - 4;
        this.pos = 0;
        this.moved = false;
    }

    public void step(int num) {
        moved = true;
        pos = (pos + num) % p;
    }

    public int[] getPos() {
        if (pos < w) {
            return new int[] { pos, 0 };
        } else if (pos < w + h - 1) {
            return new int[] { w - 1, pos - (w - 1) };
        } else if (pos < 2 * w + h - 2) {
            return new int[] { w - 1 - (pos - (w + h - 2)), h - 1 };
        } else {
            return new int[] { 0, h - 1 - (pos - (2 * w + h - 2)) };
        }
    }

    public String getDir() {
        if (!moved)
            return "East";
        // Special case: (0,0) after moving is South
        if (pos == 0)
            return "South";

        if (pos > 0 && pos < w)
            return "East";
        if (pos >= w && pos < w + h - 1)
            return "North";
        if (pos >= w + h - 1 && pos < 2 * w + h - 2)
            return "West";
        return "South";
    }
}
