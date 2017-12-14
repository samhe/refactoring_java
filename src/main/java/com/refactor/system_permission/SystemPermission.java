package com.refactor.system_permission;

public class SystemPermission {
    private SystemProfile profile;
    private SystemAdmin admin;


    private String state;
    public final static String REQUESTED = "REQUESTED";
    public final static String CLAIMED = "CLAIMED";
    public final static String GRANTED = "GRANTED";
    public final static String DENIED = "DENIED";
    public static final String UNIX_REQUESTED = "UNIX_REQUESTED";
    public static final String UNIX_CLAIMED = "UNIX_CLAIMED";

    public SystemPermission(SystemProfile profile) {
        this.profile = profile;
        state = REQUESTED;
        notifyAdminOfPermissionRequest();
    }

    private void notifyAdminOfPermissionRequest() {

    }

    public boolean isGranted() {
        return GRANTED.equals(this.state);
    }
    public void claimedBy(SystemAdmin admin) {
        if (state.equals(REQUESTED)) {
            willBeHandledBy(admin);
            state = CLAIMED;
        }
        else if (state.equals(UNIX_REQUESTED)) {
            willBeHandledBy(admin);
            state = UNIX_CLAIMED;
        }
    }

    private void willBeHandledBy(SystemAdmin admin) {
        this.admin = admin;
    }

    private boolean isClaimedBy(SystemAdmin admin) {
        return this.admin != null && this.admin.equals(admin);
    }

    public void deniedBy(SystemAdmin admin) {
        if(isClaimedBy(admin)) {
            if(state.equals(CLAIMED) || state.equals(UNIX_CLAIMED)) {
                state = DENIED;
                notifyUserOfPermissionRequestResult();
            }
        }
    }

    private void notifyUserOfPermissionRequestResult() {

    }

    public void grantedBy(SystemAdmin admin) {
        if(isClaimedBy(admin)) {
            if(state.equals(CLAIMED) && !profile.isUnixPermissionRequired()) {
                state = GRANTED;
                notifyUserOfPermissionRequestResult();
            } else if (state.equals(CLAIMED) && profile.isUnixPermissionRequired()) {
                state = UNIX_REQUESTED;
                profile.setUnixPermissionGranted(true);
                notifyUnixAdminsOfPermissionRequest();
            } if (state.equals(UNIX_CLAIMED) && profile.isUnixPermissionRequired()) {
                if(profile.isUnixPermissionGranted()) {
                    state = GRANTED;
                    notifyUserOfPermissionRequestResult();
                }
            }
        }
    }

    private void notifyUnixAdminsOfPermissionRequest() {

    }

    public String state() {
        return this.state;
    }

}
