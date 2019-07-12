package org.aos.ddo.support;

/**
 * Created by adarr on 3/21/2017.
 */
public class AssertionStatus {
    /**
     * Convenience method used to determine assertion status.
     * Used internally to conditionally ignore assertion based unit tests.
     * @return true if assertions are enabled.
     */
    public static boolean isEnabled() { //    @org.jetbrains.annotations.Contract(pure = true)
        boolean assertOn = false;
        // *assigns* true if assertions are on.
        assert assertOn = true; // Intentional side effect!!!
        return assertOn;
    }
}
