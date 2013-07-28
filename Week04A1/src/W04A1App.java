/**
 * Produce a computer program, written in Java, which determines the distance travelled by a projectile
 * (launched from the ground) given:
 * 1.  The velocity at launch (u), and
 * 2.  The launch angle (angle of elevation) above the horizontal (A).
 * If the above text is not clear, the vector shown on the left side is (u) and is the Launch velocity,
 * the angle on the left side is A, and the text on the bottom reads Distance travelled.
 *
 * Assume the following:
 * 1.  The angle of elevation is given in degrees and is in the range of 0 to 90.
 * 2.  Start velocity is given as a positive number.
 * 3.  Gravity (g) is equivalent to 10m/s ^ 2.
 * 4.  Ignore air resistance.
 *
 * Note also that to solve the above we must carry out the following steps:
 * 1.  Calculate the vertical and horizontal components of u (the launch velocity) using the following trigonometric identities:
 * Vertical component of launch velocity  (Vu) = u x sinA Horizontal component of launch velocity (Hu) = u x cosA
 * 2.  Calculate the time (t) taken for the body to return to the ground using the identity:
 * t = (2 x Vu) / a
 * where a (deceleration due to gravity) is equivalent to g (10m/s ^ 2 in this case).
 * 3.  Calculate distance (s) travelled from the identity:
 * s = Hu x t
 *
 * EXAMPLE:
 * A body is projected with a velocity of u = 200 m/s at an angle of elevation A = 30 degrees above the horizontal.
 * Determine the distance travelled by the projectile.
 * Vu  = 200 x sin30 = 100 (m/s) Hu = 200 x cos30 = 173.2 (m/s) t = {2 x 100) / 10 = 20 (s) s = 20 x 173.2051 = 3464.1 (m) 
 *
 * Created by myltik
 * Created on 7/26/13 4:40 PM
 */
public class W04A1App implements Runnable {

    private static final Object[] askViewButtons = new String[] {"Proceed", "Exit"};

    /**
     * Implementation entry point
     */
    @Override
    public void run() {
        try {
            while (true) {
                askValues();
                displayResult();
            }
        } catch (CloseAppException e) {
            // do nothing, just exit app
        }
    }

    /**
     * Ask user for input
     * @throws CloseAppException
     */
    private void askValues() throws CloseAppException {
    }

    /**
     * Display calculation result
     */
    private void displayResult() {
    }
}
