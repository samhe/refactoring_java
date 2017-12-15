package com.refactor.system_permission;

public class SystemPermission {
    private SystemProfile profile;

    private SystemAdmin admin;


    private String state;

    private PermissionState permissionState;

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
        permissionState = new RequestedSate(this);
    }
    public void notifyAdminOfPermissionRequest() {

    }
    public void setPermissionState(PermissionState permissionState) {
        this.permissionState = permissionState;
    }

    public SystemProfile getProfile() {
        return profile;
    }

    public SystemAdmin getAdmin() {
        return admin;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setAdmin(SystemAdmin admin) {
        this.admin = admin;
    }

    public boolean isGranted() {
        return GRANTED.equals(this.state);
    }

    public void claimedBy(SystemAdmin admin) {
        if (state.equals(REQUESTED)) {
            setAdmin(admin);
            setState(CLAIMED);
        }
        else if (state.equals(UNIX_REQUESTED)) {
            setAdmin(admin);
            setState(UNIX_CLAIMED);
        }
        permissionState.claimBy(admin);
    }

    public boolean isClaimedBy(SystemAdmin admin) {
        return this.admin != null && this.admin.equals(admin);
    }

    public void deniedBy(SystemAdmin admin) {
        if(isClaimedBy(admin)) {
            if(state.equals(CLAIMED) || state.equals(UNIX_CLAIMED)) {
                setState(DENIED);
                notifyUserOfPermissionRequestResult();
            }
        }
        permissionState.denyBy(admin);
    }

    public void notifyUserOfPermissionRequestResult() {

    }

    public void grantedBy(SystemAdmin admin) {
        if(isClaimedBy(admin)) {
            if(state.equals(CLAIMED) && !profile.isUnixPermissionRequired()) {
                setState(GRANTED);
                notifyUserOfPermissionRequestResult();
            } else if (state.equals(CLAIMED) && profile.isUnixPermissionRequired()) {
                setState(UNIX_REQUESTED);
                profile.setUnixPermissionGranted(true);
                notifyUnixAdminsOfPermissionRequest();
            } if (state.equals(UNIX_CLAIMED) && profile.isUnixPermissionRequired()) {
                if(profile.isUnixPermissionGranted()) {
                    setState(GRANTED);
                    notifyUserOfPermissionRequestResult();
                }
            }
        }
        permissionState.grantBy(admin);
    }

    public void notifyUnixAdminsOfPermissionRequest() {

    }

    public String state() {
        return this.state;
    }

}
